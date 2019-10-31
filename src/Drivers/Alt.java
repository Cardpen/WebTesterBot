package Drivers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Maps.MapVertex;
//System.out.println("");

public class Alt {
	// fixed initializations
	public int swingCount = 0;
	WebDriver driver;
	Actions builder;
	WebDriverWait wait;
	String name;
	String str = "5";
	String dex = "5";
	String inte = "5";
	long lastRefresh = 0;

	String match = "Perfect!";
	DisplayBox controlPanel;
	boolean willToLive = true;
	MapVertex curLocation = Access.Aera;
	Map<Integer, List<String>> statChecker = new HashMap<Integer, List<String>>();
	MapVertex navLoca = Access.Aera;
	Set<String> mobs;
	Set<String> forget;

	public String newAltName = "";

	public static String mainHitterID;
	public static String muleID;
	public static String runnerID;
	public static String currentAlt;

	// initial stats
	int health = 49;
	int minHealth = 40;

	// states
	boolean doExplore = false;
	boolean doNav = false;
	boolean cancelAction = false;
	boolean bossFight = false;
	boolean goHeal = false;
	boolean regear = true;
	boolean search = false;
	boolean useLog = false;
	String oldSites = "true";

	// modes
	boolean epicHunting = false;
	boolean altFarming = false;
	boolean healing = false;
	boolean targetHunting = false;
	boolean updateInv = false;
	boolean bouttaBreak = false;
	int doubleCheckBroken = 0;
	int lost = 0;
	
	Inventory inv;
	HouseInventory house;

	public Alt(DisplayBox controlPanel, Account act) {
		this.controlPanel = controlPanel;
		this.currentAlt = Access.js.executeScript("return characterId").toString();
		this.runnerID = act.runnerID;
		this.mainHitterID = act.hitterID;
		this.muleID = act.muleID;
		Access.act = act;
		lastRefresh = System.currentTimeMillis();
		this.driver = Access.driver;
		wait = new WebDriverWait(driver, 5);
		Access.wait = wait;
		mobs = new HashSet<String>(Access.mobs);
		forget = new HashSet<String>(Access.forget);
		controlPanel.setScreenGame(this);
		controlPanel.setup(new ArrayList<String>(Arrays.asList("Swing Count = " + swingCount, "Match = " + match)));

		if (useLog) {
			createLog();
		}

		update();
		Access.mute();
		statCheckerSetup();
		// checkEpic();
		update();

		inv = new Inventory();
		house = new HouseInventory(this);

		gameLoop();
	}

	public void createLog() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date = new Date();
		String fileName = formatter.format(date);
		System.out.println(fileName);
		File log = new File("log\\Log_" + fileName + ".txt");

		try {
			log.createNewFile();
			PrintStream print = new PrintStream(log);
			System.setOut(print);
			System.out.println("Start of Log run " + fileName);
			System.out.println("Using Account " + Access.act.userName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void gameLoop() {

		while (true) {
			Access.sleep(.2);
			if (updateInv) {
				inv.updateInventory();
				updateInv = false;
			}

			if (epicHunting) {
				navTo(Access.HighRoad);
				navTo(Access.HighRoadLake);
			}

			if (doExplore) {
				curLocation = Access.getCur();
				if (targetHunting) {
					while (!cancelAction) {
						for (MapVertex m : Access.targetLocations) {

							if (cancelAction) {
								break;
							}
							exploreFight(m);

						}
						if (cancelAction) {
							break;
						}
					}

				} else {
					while (!cancelAction) {
						exploreFight(curLocation);
						if (cancelAction) {
							break;
						}

					}

				}
				doExplore = false;
			}

			if (doNav) {
				navTo(navLoca);
				doNav = false;
			}
		}
	}

	void statCheckerSetup() {
		System.out.println("Running statCheckerSetup()");
		statChecker.put(2, Arrays.asList("5.01", "5.01", "5"));
		statChecker.put(6, Arrays.asList("5.04", "5.02", "5"));
		statChecker.put(8, Arrays.asList("5.05", "5.02", "5.01"));
		statChecker.put(9, Arrays.asList("5.05", "5.03", "5.01"));
		statChecker.put(11, Arrays.asList("5.07", "5.03", "5.01"));
		statChecker.put(13, Arrays.asList("5.08", "5.04", "5.01"));
		statChecker.put(16, Arrays.asList("5.08", "5.05", "5.01"));
		statChecker.put(18, Arrays.asList("5.11", "5.05", "5.01"));
		statChecker.put(20, Arrays.asList("5.12", "5.06", "5.01"));
		statChecker.put(22, Arrays.asList("5.12", "5.06", "5.02"));
		statChecker.put(23, Arrays.asList("5.14", "5.06", "5.02"));
		statChecker.put(31, Arrays.asList("5.18", "5.09", "5.02"));

		// statChecker.put(30, Arrays.asList("5.18", "5.09", "5.02"));
		// statChecker.put(36, Arrays.asList("5.18", "5.09", "5.02"));
	}

	public void update() {
		WebElement profile;
		if (altFarming) {
			profile = Access.getProfile(wait);
			String values;
			while (true) {
				try {
					values = profile.getAttribute("minitip");
					break;
				} catch (Exception a) {
					profile = Access.getProfile(wait);
				}
			}

			String[] first = values.split("<");
			String[] stats = first[0].split("/");
			str = stats[0];
			dex = stats[1];
			inte = stats[2];
		}

		WebElement healthBar;
		while (true) {
			try {
				profile = Access.getProfile(wait);
				healthBar = profile.findElement(By.xpath("//*[@id='hitpointsBar']/p"));
				if (healthBar.getText().isEmpty()) {
					System.out.println("it was empty boi");
				} else {
					health = Integer.parseInt(healthBar.getText().split("/")[0]);
				}
				break;
			} catch (Exception a) {
			}
		}

		controlPanel.update(new ArrayList<String>(Arrays.asList("Swing Count = " + swingCount, "Match = " + match)));
	}

	public void exploreFight(MapVertex location) {
		navTo(location);
		int missedExplore = 0;
		while (true) {
			if (cancelAction) {
				return;
			}
			System.out.println("Running exploreFight()");
			Access.run("cancelLongOperations(event)");
			refresh();
			if (bouttaBreak && doubleCheckBroken > 1) {
				bouttaBreak = false;
				doubleCheckBroken = 0;
				/*
				 * if (!regear) { cancelAction = true; return; }
				 */
				reGear();
			}

			/*
			 * if (!inv.brokenItems.isEmpty()) { inv.replaceBroken(); }
			 */
			if (altFarming) {
				if (health <= minHealth && willToLive && swingCount > 9) {
					try {
						WebElement cancelButton = driver
								.findElement(By.cssSelector("a[onclick = 'cancelLongOperations(event)']"));
						click(cancelButton);
					} catch (Exception e) {
					}
					goHeal = false;
					goHeal(location);
				} else if (health <= minHealth && willToLive) {
					recreateAlt();
				}
			} else {
				if ((health <= minHealth && willToLive) || goHeal) {
					try {
						WebElement cancelButton = driver
								.findElement(By.cssSelector("a[onclick = 'cancelLongOperations(event)']"));
						click(cancelButton);
					} catch (Exception e) {
					}
					goHeal = false;
					goHeal(location);

				}
			}

			if (!willToLive) {
				recreateAlt();
			}

			Access.sleep(.3);
			curLocation = Access.getCur();
			String s = (Access.getCount());
			// s.contains("low") || s.contains("minimal") ||
			if (checkOld()) {
				continue;
			}

			if (s.contains("none") || missedExplore > 3 ) {
				return;
			}

			if (location.campable) {
				while (true) {
					List<WebElement> paths = Access.getPath(wait);
					if (paths == null) {
						Access.debug(this, "Heal");
						continue;
					}
					try {
						String path = paths.get(0).findElement(By.className("v3-main-button")).getText();
						if (path.contains("Camp")) {
							break;
						} else {
							createCamp();
							if (altFarming) {
								return;
							}
							break;
						}
					} catch (Exception e) {
						System.out.println("Heal : Stale path");
					}
				}
			}

			System.out.println("Running exploreFight() part 2");

			Access.js.executeScript("doExplore(event, " + oldSites + ")");

			int i = 0;
			while (curLocation.equals(Access.getCur())) {
				Access.sleep(1);
				i++;
				if (cancelAction) {
					Access.js.executeScript("cancelLongOperations(event)");
					return;
				}
				if (i > 25) {
					break;
				}
			}

			try {
				Access.js.executeScript("cancelLongOperations(event)");
			} catch (Exception e) {
			}

			curLocation = Access.getCur();
			if (curLocation.name.contains("Combat") && !curLocation.name.contains("Turtle")) {
				combat();
				missedExplore = 0;
			} else if (!curLocation.equals(location)) {
				goTo(location);
				missedExplore = 0;
			} else {
				missedExplore++;
				continue;

			}
		}
	}

	public boolean checkOld() {
		System.out.println("Running checkOld()");
		if (search) {
			return false;
		}
		curLocation = Access.getCur();
		if (curLocation.name.contains("Combat site:")) {
			combat();
			return true;
		}
		List<WebElement> paths = Access.getPath(wait);

		if (paths == null) {
			Access.debug(this, "Heal");
			return true;
		}

		if (curLocation.name.contains("Combat site:")) {
			combat();
			return true;
		}

		for (WebElement path : paths) {

			if (bossBattle(path)) {return true;}

			String loc = "";
			try {
				loc = path.findElement(By.className("v3-main-button")).getText();
			} catch (Exception e) {
				return false;
			}

			if (!loc.contains(": ") || loc.contains("Camp")) {
				continue;
			}

			String mobName = loc.split(": ")[1];
			if (mobs.contains(mobName)) {
				MapVertex combatSite = new MapVertex("Combat site: " + mobName, path.getAttribute("class"));
				Access.map.addVertex(combatSite);
				goTo(combatSite);
				combat();
				Access.map.removeVertex(combatSite);
				return true;
			} else if (forget.contains(mobName)) {
				Access.run("doForgetCombatSite(event," + path.getAttribute("class").split("-")[2] + ")");
				continue;
			}
		}
		return false;
	}

	public boolean checkFightable(String name) {
		if (mobs.contains(curLocation.name.substring(13))) {
			return true;
		} else {
			if (Access.fightAll) {
				return true;
			}
			return false;
		}
	}

	public boolean combat() {
		System.out.println("Running combat()");
		boolean combatCondition = true;
		boolean first = true;
		checkEpic();
		findDead();
		curLocation = Access.getCur();
		MapVertex start = curLocation;
		if (!curLocation.name.contains("Combat") || curLocation.name.contains("Suspicious")) {
			return true;
		}
		while (combatCondition) {
			if (health <= minHealth || cancelAction || goHeal || healing || !willToLive
					|| !mobs.contains(curLocation.name.substring(13))) {
				if ((altFarming && swingCount <= 9) && health <= minHealth) {
					willToLive = false;
					break;
				} else {
					combatCondition = false;
					if (health <= minHealth) {
						goHeal = true;
					}
					break;
				}
			}

			if (Access.inCombat() && Access.alive()) {
				if (!curLocation.name.contains("Combat")) {
					return true;
				}
				Access.switchTo(runnerID, mainHitterID);
				if (first) {
					update();
					first = false;
				}
				hpStop();
				Access.js.executeScript("doCombatAttackRightHand(event)");
				Access.sleep(.1);

				if (!bouttaBreak) {
					if (checkBroken()) {
						bouttaBreak = true;
					} else {
						doubleCheckBroken = 0;
					}
				} else {
					if (!checkBroken()) {
						doubleCheckBroken++;
						Access.sleep(1);
						System.out.println("An item just broke");
						if (!checkBroken()) {
							doubleCheckBroken++;
							combatCondition = false;
						} else {
							doubleCheckBroken = 0;
						}
					} else if (Access.findBroken()) {
						System.out.println("An item just broke");
						doubleCheckBroken = 2;
						combatCondition = false;
					}
				}

				Access.closePopup();
				swingCount++;
				update();
				if (curLocation.name.substring(13).equals("Troll") && altFarming) {
					checkSwing();
				}
			}
			if (!Access.inCombat() && Access.alive()) {

				if (health < minHealth && health > 0) {
					goHeal = true;
				}
				Access.sleep(.5);
				Access.closePopup();
				update();
				if (health < 1) {
					revive();
					return true;
				}
				looting();
				return true;
			} else if (!Access.alive()) {
				revive();
				return true;
			}
		}

		while (true) {
			Access.switchTo(mainHitterID, runnerID);
			Access.sleep(.1);
			update();
			if (health < minHealth && health > 0) {
				goHeal = true;
			}
			if (health < 1) {
				revive();
			}
			hpStop();
			Access.js.executeScript("doCombatEscape(event)");
			for (int i = 0; i < 10; i++) {
				if (!Access.inCombat()) {
					break;
				}
				Access.sleep(.1);
			}
			Access.closePopup();
			try {
				Access.driver.findElement(
						By.cssSelector("a[onclick = 'clearMakeIntoPopup();window.btnLeaveAndForget.click()']"));
				if (health < minHealth && health > 0) {
					goHeal = true;
				}
				Access.sleep(.5);
				Access.closePopup();
				looting();
				return true;
			} catch (Exception e) {

			}

			curLocation = Access.getCur();
			if (!curLocation.equals(start) || !curLocation.name.contains("Combat")) {
				return false;
			}
		}
	}

	public void revive() {
		if (!altFarming) {
			System.exit(1);
		} else {
			if (!Access.alive()) {
				Access.run("newCharacterFromDead()");
				Access.sleep(1);
			}
			Access.run("viewCharacterSwitcher()");
			Access.sleep(3);
			List<WebElement> l = Access.wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("characterswitcher")))
					.findElements(By.cssSelector("div[class = 'selectable']"));
			for (WebElement character : l) {
				try {
					String s = character.findElement(By.cssSelector("a[id = 'character-switcher']")).getText();
					if (s.equals(newAltName)) {
						Access.run(character
								.findElement(
										By.cssSelector("a[class = 'character-display-box-overlay selected-character']"))
								.getAttribute("onclick"));
					}
				} catch (Exception e) {
				}
			}
			Access.closePopup();
			swingCount = 0;
			match = "Perfect";
			willToLive = true;
			healing = false;
			goHeal = false;
			update();
			navTo(Access.AeraCountrySide);
			return;
		}
	}

	public void reviveNew() {
		if (health <= 0) {
			if (!altFarming) {
				System.exit(0);
			}
			Access.run("newCharacterFromDead()");
			Access.sleep(.5);
			Access.run("viewCharacterSwitcher()");
			Access.wait.until(ExpectedConditions
					.presenceOfElementLocated(By.cssSelector("div[id = 'characterswitcher-container']")));
			WebElement parent = Access.driver.findElement(By.id("characterswitcher"));
			List<WebElement> charList = Access.driver.findElements(By.cssSelector("div[class = 'selectable']"));
			for (WebElement character : charList) {
				try {
					WebElement charOfChoice = Access.driver.findElement(
							By.cssSelector("a[class = 'character-display-box-overlay selected-character']"));
					Access.run(charOfChoice.getAttribute("onclick"));
				} catch (Exception e) {
				}
			}
			Access.sleep(1);
			System.out.println("New character has been created");
		}

	}

	public void recreateAlt() {
		if (!altFarming) {
			System.out.println("GET ME OUT");
			System.exit(0);
		}
		try {
			/*
			 * if (i == 0) { revive = driver.findElement(By.
			 * cssSelector("a[onclick = 'newCharacterFromUnconscious()']")); } else { revive
			 * =
			 * driver.findElement(By.cssSelector("a[onclick = 'newCharacterFromDead()']"));
			 * } click(revive); Access.sleep(1);
			 */
			try {
				Access.js.executeAsyncScript("deleteAndRecreateCharacter(event, '" + newAltName + "')");
			} catch (Exception nothing) {
			}
			Access.sleep(1);
			click(wait.until(ExpectedConditions.elementToBeClickable(By.className("confirm_yes"))));
			Access.sleep(1);
			click(wait.until(ExpectedConditions.elementToBeClickable(By.className("confirm_okay"))));
			Access.sleep(1);
			Access.closePopup();

			swingCount = 0;
			match = "Perfect";
			willToLive = true;
			healing = false;
			goHeal = false;
			update();
			navTo(Access.AeraCountrySide);
			return;

		} catch (Exception a) {
			System.out.println("Not supposed to be here, Check Combat/Alt 2");
			System.out.println(a.getMessage());
		}
	}

	public boolean checkEpic() {
		System.out.println("checking epic");
		for (String url : Access.epicList) {
			try {
				Access.driver.findElement(By.cssSelector("div[style = 'background-image:url(\"" + url + "\")'"));
				System.out.println("We found an epic!!");
				inv.recompile();
				System.exit(0);
			} catch (Exception e) {
			}
		}
		return false;
	}

	public void looting() {

		System.out.println("running Lootings ");
		Access.run("showLootPopup()");
		Access.sleep(.25);
		List<WebElement> loots = Access.getLoot(wait);
		Set<Item> collectedItems = new HashSet<Item>();
		for (WebElement loot : loots) {
			Item collect = Access.keepLoot(loot);
			if (collect != null) {
				Access.run("doCollectItem(event, " + collect.ref + ")");
				System.out.println("Collecting " + collect);
				if (regear) {
					inv.add(collect);
				}
				collectedItems.add(collect);
				Access.sleep(.3);
			}
		}

		Access.send("g");
		Access.sleep(.25);
		if (!collectedItems.isEmpty() && regear) {
			inv.transferItem(collectedItems, muleID);
		}

		Access.sleep(.2);
		Access.switchTo(mainHitterID, runnerID);
		curLocation = Access.getCur();
		Access.run("window.btnLeaveAndForget.click()");
		int count = 0;
		while (curLocation.equals(Access.getCur())) {
			Access.sleep(1);
			count++;
			if (count > 20) {
				try {
					Access.js.executeAsyncScript("doShowHiddenSites(event)");
				} catch (Exception e) {
					Access.sleep(.25);
				}
				try {
					Access.js.executeAsyncScript("clearMakeIntoPopup()");
				} catch (Exception e) {
					Access.sleep(.25);
				}
				Alt.currentAlt = Access.js.executeScript("return characterId").toString();
				Access.switchTo(mainHitterID, runnerID);
				Access.run("window.btnLeaveAndForget.click()");
				Access.closePopup();
				count = 0;
				System.out.println("Debugged looting");

			}
		}
	}

	// from start, go heal somewhere closest to you and then return to start
	public void goHeal(MapVertex start) {
		System.out.println("Running goHeal()");
		// alg and found a mapvertex
		healing = true;
		cancelAction = false;
		int shortest = 500;
		MapVertex goal = Access.AeraInn;
		for (MapVertex m : Access.restStops) {
			int length = 10000;
			try {
				length = Access.pathFinder.getPath(start, m).getLength();
			} catch (Exception e) {
			}
			if (length < shortest) {
				goal = m;
				shortest = length;
			}
		}

		navTo(goal);
		if (goal.campable) {
			String campID = "";
			while (true) {
				List<WebElement> paths = Access.getPath(wait);
				if (paths == null) {
					Access.debug(this, "Heal");
					continue;
				}
				try {
					String s = paths.get(0).findElement(By.className("v3-main-button")).getText();
					if (s.contains("Camp")) {
						campID = paths.get(0).getAttribute("class");
						break;
					} else {
						navTo(goal);
						createCamp();
						if (cancelAction) {
							healing = false;
							update();
							return;
						}
					}
				} catch (Exception e) {
					System.out.println("Heal : Stale path");
				}
			}
			MapVertex camp = new MapVertex("Camp", campID);
			Access.Camp = camp;
			Access.map.addVertex(camp);
			Access.addTwoWayEdge(camp, goal);
			goTo(camp);
			Access.sleep(.5);
			Access.send("r");
			Access.sleep(.5);
			Access.closePopup();
			Access.switchTo(runnerID, mainHitterID);
			Access.sleep(.5);
			Access.closePopup();
			Access.send("r");
			Access.sleep(.5);
			Access.closePopup();
			Access.sleep(53);
			Access.switchTo(mainHitterID, runnerID);
			Access.sleep(.5);
			Access.send("r");
			Access.sleep(.5);
			Access.closePopup();
			update();
			healing = false;
			goHeal = false;
			navTo(start);
			Access.map.removeVertex(camp);

		} else if (goal.rest) {
			Access.sleep(.5);
			Access.send("r");
			Access.sleep(.5);
			Access.closePopup();
			Access.switchTo(runnerID, mainHitterID);
			Access.sleep(.5);
			Access.closePopup();
			Access.send("r");
			Access.sleep(.5);
			Access.closePopup();
			Access.sleep(53);
			Access.switchTo(mainHitterID, runnerID);
			Access.sleep(.5);
			Access.send("r");
			Access.sleep(.5);
			Access.closePopup();
			update();
			healing = false;
			goHeal = false;
			navTo(start);
		} else {
			System.out.println("Not supposed to be here, healing broke");
		}

	}

	// find a path to the goal node and take each step of that path by running goTo
	public void navTo(MapVertex goal) {
		System.out.println("Running navTo " + goal);
		refresh();
		if (!Access.map.containsVertex(goal)) {
			System.out.println("Not a valid location to travel to ");
			return;
		}
		Access.sleep(1);
		curLocation = Access.getCur();
		if (curLocation.equals(goal)) {
			return;
		}

		if (!Access.map.containsVertex(curLocation)) {
			System.out.println("Not in a valid location to travel");
			return;
		}
		List<MapVertex> path = null;
		try {
			path = Access.pathFinder.getPath(curLocation, goal).getVertexList();
		} catch (Exception e) {
			System.out.println("no path found between " + curLocation.name + " and " + goal.name);
			return;
		}

		for (int i = 0; i < path.size() - 1; i++) {
			goTo(path.get(i + 1));
			Access.sleep(.2);
			Access.run("cancelLongOperations(event)");
			if (!Access.getCur().equals(path.get(i + 1))) {
				navTo(path.get(i + 1));
			}
			if (cancelAction) {
				return;
			}
			Access.sleep(.5);
		}

		if (curLocation.equals(goal)) {
			System.out.println("Successfully arrived at " + goal.name);
			lost = 0;
		}
	}

	// From start go to adj location goal
	// if ambushed on the way to location, run combat. and rerun goTo
	// if going to monster and goto another monster same name just keep; it
	public void goTo(MapVertex goal) {

		System.out.println("Running goTo(" + goal.name + ")");
		// make sure we are in a valid location to travel
		curLocation = Access.getCur();
		MapVertex start = curLocation;
		refresh();
		// Maybe we are already there
		if (start.equals(goal)) {
			return;
		}

		// if the current location isn't a main location included in the map
		// if its a camp continue normal function
		if (!Access.map.vertexSet().contains(start) && !start.name.contains("Camp")) {
			// if we're already at a battle location, run combat at the mob
			// after leaving combat, retry goto
			if (start.name.contains("Combat site:")) {
				System.out.println("Attempting to run goTo from a combat site");
				combat();
				goTo(goal);
				return;
			}
		}
		// check for health and items
		if (bouttaBreak && doubleCheckBroken > 1) {
			bouttaBreak = false;
			doubleCheckBroken = 0;
			/*
			 * if (!regear) { cancelAction = true; return; }
			 */
			reGear();
		}

		/*
		 * if (!inv.brokenItems.isEmpty()) { inv.replaceBroken(); }
		 */

		if (!altFarming) {
			if (!healing && (health < minHealth || goHeal)) {
				goHeal = false;
				goHeal(curLocation);
			}
		} else {
			if (!healing && health <= minHealth && swingCount > 10) {
				goHeal = false;
				goHeal(curLocation);
			} else if (!healing && health <= minHealth) {
				recreateAlt();
			}
		}
		
		boolean preCaught = false;
		
		if (goal.equals(Access.PerigeePeak) && start.equals(Access.AphelionShrine)) {
			preCaught = true;
			Access.run("doGoto(event, 5788605599449088)");
		}
		// head to targeted location

		// get event path for goal and attempt to head to it
		// if fails, recheck starting conditions
		int numberOfTries = 0;
		
		while (!preCaught) {
			try {
				if (numberOfTries == 1) {
					Access.sleep(1);
				} else if (numberOfTries == 2) {
					driver.findElement(By.cssSelector("a[onclick = 'doShowHiddenSites(event)'")).click();
					Access.sleep(.50);
					driver.findElement(By.cssSelector("div[onclick = 'clearMakeIntoPopup()'")).click();
					Access.sleep(.50);
				} else if (numberOfTries > 3) {
					// Go reconsider the starting conditions
					lost++;
					if (lost > 3) {
						Access.js.executeScript("doExplore(event, " + oldSites + ")");

						int i = 0;
						while (curLocation.equals(Access.getCur())) {
							Access.sleep(1);
							i++;
							if (cancelAction) {
								Access.js.executeScript("cancelLongOperations(event)");
								return;
							}
							if (i > 25) {
								break;
							}
						}
						lost = 0;
					}
					navTo(goal);
					return;
				}
				WebElement pathBox = Access.driver.findElement(By.cssSelector("div[class = '" + goal.id + "'"));
				Access.run(pathBox.findElement(By.cssSelector("a[class='v3-main-button']")).getAttribute("onclick"));
				break;
			} catch (Exception e) {
				numberOfTries++;
				System.out.println("Try #" + numberOfTries);
				if (Access.inCombat()) {
					combat();
					goTo(goal);
					return;
				}
				switch (numberOfTries) {
				case 1:
					System.out.println("Path not found, will wait 1 second and try again.");
					break;
				case 2:
					System.out.println("Path not found, waiting didn't work. Trying hidden paths");
					break;
				case 3:
					System.out.println("Path not found, hidden paths failed. Reinitiating goTo");
					break;
				default:
					System.out.println("Not supposed to be here, check goTo");
				}
			}
		}

		// Getting to here means we've clicked the path already. now going to the goal
		System.out.println("Heading to " + goal.name + "...");

		// if it takes more than 20 seconds, something is wrong. It's probably not
		// walking to the site
		int counter = 0;
		while (Access.getCur().equals(start)) {
			counter++;
			if (counter > 20) {
				goTo(goal);
				return;
			}
			Access.sleep(1);
		}

		curLocation = Access.getCur();
		System.out.println("Arrived at " + curLocation.name);

		if (curLocation.name.contains(goal.name)) {
			// We're at the right place. Combat sites are complicated
			return;
		} else {
			// We got ambushed by something
			combat();
			goTo(goal);
		}
	}

	// click on a web element
	public void click(WebElement e) {
		int count = 0;
		while (true) {
			try {
				e.click();
				break;
			} catch (Exception a) {
				System.out.println("Click intercepted by something");
				count++;
				Access.sleep(2);
				if (count > 7) {
					return;
				} else if (count > 5) {
					Access.closePopup();
				}
			}
		}
	}

	public void kill() {
		System.out.println("Running kill()");
		willToLive = false;
	}

	public void checkSwing() {
		boolean checking = true;
		if (swingCount > 22) {
			System.out.println("Good enough for me eh?");
			checking = false;
		}
		update();
		if (statChecker.containsKey(swingCount)) {
			List<String> statList = statChecker.get(swingCount);
			if (Double.parseDouble(statList.get(0)) <= Double.parseDouble(str)
					&& Double.parseDouble(statList.get(1)) <= Double.parseDouble(dex)
					&& Double.parseDouble(statList.get(2)) <= Double.parseDouble(inte)) {
				System.out.println("Swing Count is " + swingCount + "Expected stats are " + statList.get(0) + "/"
						+ statList.get(1) + "/" + statList.get(2) + "Our stats are " + str + "/" + dex + "/" + inte);
			} else {
				System.out.println("Swing Count is " + swingCount + "Expected stats are " + statList.get(0) + "/"
						+ statList.get(1) + "/" + statList.get(2) + "Our stats are " + str + "/" + dex + "/" + inte);
				match = "Poor";
				if (checking) {

					kill();
					System.out.println("just got killed");
					update();
				}
			}

		}

	}

	public void createCamp() {
		System.out.println("Running createCamp()");
		curLocation = Access.getCur();
		MapVertex start = curLocation;
		if (!curLocation.campable) {
			System.out.println("Cant camp in " + curLocation);
			return;
		}
		while (!curLocation.name.contains("Camp")) {
			refresh();
			if (cancelAction) {
				return;
			}
			if (altFarming) {
				if (!willToLive) {
					recreateAlt();
					return;
				}
				if (!healing && health <= minHealth && swingCount >= 9) {
					goHeal = false;
					goHeal(curLocation);
				} else if (swingCount < 9 && health < 15) {
					recreateAlt();
					return;
				}
			} else {
				if (!healing && (health <= minHealth || goHeal)) {
					goHeal = false;
					goHeal(curLocation);
				}
			}

			Access.send("r");
			Access.sleep(.5);
			WebElement campName = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.className("popup_prompt_input")));
			campName.clear();
			campName.sendKeys("Made in China");
			WebElement campConfirmer = wait
					.until(ExpectedConditions.elementToBeClickable(By.className("confirm_okay")));
			click(campConfirmer);
			int counter = 0;
			while (Access.getCur().equals(start)) {
				Access.sleep(1);
				counter++;
				if (counter > 15) {
					Access.closePopup();
					Access.send("l");
					Access.sleep(3);
					return;
				}
			}

			curLocation = Access.getCur();
			if (curLocation.name.contains("Camp")) {
				break;
			} else {
				combat();
			}
		}

		Access.sleep(1);
		goTo(start);
	}

	public boolean bossBattle(WebElement path) {

		String bossName;
		MapVertex combatSite;
		int oldViableGear = Access.viableGear;
		String oldDmgType = Access.damageType;
		String oldArmorType = Access.armorType;
		int oldMinHealth = minHealth;
		boolean foundBoss = false;
		MapVertex start = curLocation;
		String locLink = "";
		try {
			bossName = path.findElement(By.className("v3-main-button")).getText();
			locLink = path.getAttribute("class");
		} catch (Exception e) {
			return false;
		}
		if (!bossName.contains("Combat site")) {
			return false;
		}

		if (bossName.contains("dddLizard King")) {
			Access.viableGear = Item.SILVER;
			Access.damageType = Item.BLUDGEONING + " and " + Item.SLASHING;
			Access.armorType = Item.SLASHING;
			minHealth = 42;
			foundBoss = true;
			bossName = "Lizard King";
			mobs.add(bossName);

		} else if (bossName.contains("dddBaron Cricketon")) {
			Access.viableGear = Item.SILVER;
			Access.damageType = Item.PIERCING;
			Access.armorType = Item.BLUDGEONING + " and " + Item.PIERCING;
			minHealth = 40;
			foundBoss = true;
			bossName = "Baron Cricketon";
			mobs.add(bossName);
		} else if (bossName.contains("dddAseridith Marksman")) {
			Access.viableGear = Item.GOLD;
			Access.damageType = Item.BLUDGEONING;
			Access.armorType = Item.PIERCING;
			minHealth = 42;
			foundBoss = true;
			bossName = "Aseridith Marksman";
			mobs.add(bossName);
		} else if (bossName.contains("dddRock Golem")) {
			Access.viableGear = Item.BRONZE;
			Access.damageType = Item.BLUDGEONING;
			Access.armorType = Item.BLUDGEONING;
			minHealth = 40;
			foundBoss = true;
			bossName = "Rock Golem";
			mobs.add(bossName);
		} else if (bossName.contains("Unicorn")) {
			Access.viableGear = Item.BRONZE;
			Access.damageType = Item.SLASHING;
			Access.armorType = Item.PIERCING;
			minHealth = 40;
			foundBoss = true;
			bossName = "Unicorn";
			mobs.add(bossName);
		}

		if (foundBoss) {
			combatSite = new MapVertex("Combat site: " + bossName, locLink);
			Access.map.addVertex(combatSite);
			Access.switchTo(runnerID, mainHitterID);
			Access.switchTo(mainHitterID, runnerID);
			Access.sleep(.3);
			if (bouttaBreak) {
				bouttaBreak = false;
				doubleCheckBroken = 0;
			}
			reGear();
			goTo(combatSite);
			while (true) {
				if (combat()) {
					break;
				}

				if (bouttaBreak && doubleCheckBroken > 1) {
					reGear();
					bouttaBreak = false;
					doubleCheckBroken = 0;
					goTo(combatSite);
				}

				/*
				 * if (!inv.brokenItems.isEmpty()) { inv.replaceBroken(); goTo(combatSite); }
				 */

				if (goHeal) {
					curLocation = Access.getCur();
					goHeal(start);
					goTo(combatSite);
				} else {
					System.out.println("Why am i here check bossBattle");
				}
			}
			System.out.print("Boss is ded");
			Access.map.removeVertex(combatSite);
			curLocation = Access.getCur();
			mobs.remove(bossName);
			Access.viableGear = oldViableGear;
			Access.damageType = oldDmgType;
			Access.armorType = oldArmorType;
			minHealth = oldMinHealth;
			if (bouttaBreak) {
				bouttaBreak = false;
				doubleCheckBroken = 0;
			}
			reGear();
			return true;
		}
		return false;
	}

	public void testMethod() {
		mobs.remove("Orc Captain");
		forget.add("Orc Captain");
	}

	public void doTrolls() {
		mobs.add("Troll");
		mobs.add("Trifelinikis");
		mobs.add("Orc Scout");
		minHealth = 30;
	}

	public void dumpTrash() {
		for (Item i : inv.items) {
			System.out.println("Analyzing " + i.name);
			if (i.tier == Item.TRASH) {
				System.out.println("Item is trashed");
				Access.run("");
				Access.sleep(.2);
			}
		}
	}

	public boolean checkBroken() {
		try {
			WebElement ourProfile = Access.driver.findElement(By.id("inBannerCharacterWidget"));
			ourProfile
					.findElement(By.cssSelector("div[class = 'very-low-durability avatar-equip-backing v3-window3']"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void reGear() {

		String armorType = Access.armorType;

		Access.switchTo(Alt.runnerID, Alt.mainHitterID);

		// Take off all equipments
		Access.run("characterUnequipAll()");
		Access.sleep(.75);
		Access.run("characterUnequipAll()");
		Access.sleep(.75);

		Access.run("inventory(event)");
		Access.sleep(.5);

		// does an inventory of the inventory
		WebElement itemBox = Access.driver.findElement(By.id("invItems"));
		List<WebElement> itemElements = itemBox.findElements(By.className("invItem"));
		Set<Item> itemTrans = new HashSet<Item>();

		for (WebElement m : itemElements) {
			Item i = new Item(m, "Inventory");
			itemTrans.add(i);
		}

		// Give all items from the hitter inventory to the mule

		if (regear) {
			inv.transferItem(itemTrans, Alt.muleID);
		}

		for (Item i : itemTrans) {
			inv.add(i);
		}

		inv.equipped.clear();

		// Get the list of items we're gonna equip
		// set number for armorType
		boolean bludge = false;
		boolean pierce = false;
		boolean slash = false;
		int typeNum = 0;
		if (armorType.contains("Bludgeoning")) {
			bludge = true;
			typeNum++;
		}
		if (armorType.contains("Piercing")) {
			pierce = true;
			typeNum++;
		}
		if (armorType.contains("Slashing")) {
			slash = true;
			typeNum++;
		}

		// temp arraylist for storing things
		List<Item> temp = new ArrayList<Item>();
		boolean usingArmor = false;
		// okay setup for equipping the general pieces
		for (Set<Item> itemSet : new ArrayList<Set<Item>>( // (inv.shield)
				Arrays.asList(inv.helm, inv.arm, inv.shirt, inv.boots, inv.armor, inv.chest, inv.pants))) {
			if (Access.twoHanded && itemSet.equals(inv.shield)) {
				continue;
			}
			Item equipping = null;
			List<Item> l = new ArrayList<Item>(itemSet);
			Collections.sort(l);
			temp.clear();
			int poorCount = 0;
			boolean poorTypes = false;
			if (usingArmor) {
				continue;
			}
			for (Item piece : l) {
				poorTypes = false;
				if (piece.tier == Access.viableGear) {
					String[] stat = piece.effectiveness.split("/");
					if (bludge) {
						if (!stat[0].equals("E") && !stat[0].equals("G") && !stat[0].equals("A")) {
							continue;
						}

						if (typeNum == 1 && (stat[0].equals("A") || stat[0].equals("G"))) {
							continue;
						} else if (typeNum > 1 && stat[0].equals("A")) {
							poorTypes = true;
						}
					}
					if (pierce) {
						if (!stat[1].equals("E") && !stat[1].equals("G") && !stat[1].equals("A")) {
							continue;
						}

						if (typeNum == 1 && (stat[1].equals("A") || stat[1].equals("G"))) {
							continue;
						} else if (typeNum > 1 && stat[1].equals("A")) {
							poorTypes = true;
						}

					}
					if (slash) {
						if (!stat[2].equals("E") && !stat[2].equals("G") && !stat[2].equals("A")) {
							continue;
						}

						if (typeNum == 1 && (stat[2].equals("A") || stat[2].equals("G"))) {
							continue;
						} else if (typeNum > 1 && stat[2].equals("A")) {
							poorTypes = true;
						}
					}

					if (poorTypes) {
						temp.add(piece);
						poorCount++;
					} else {
						temp.add(0, piece);
					}
					continue;
				}
			}

			if (!temp.isEmpty() && temp.size() > poorCount) {
				equipping = temp.get(0);
			} else {
				boolean down = false;
				for (Item piece : l) {
					if (piece.tier == Access.viableGear - 1) {
						String[] stat = piece.effectiveness.split("/");
						if (bludge) {
							if (!stat[0].equals("E") && !stat[0].equals("G") && !stat[0].equals("A")) {
								continue;
							}

							if (typeNum == 1 && stat[0].equals("A")) {
								continue;
							} else if (typeNum > 1 && stat[0].equals("A")) {
								poorTypes = true;
							}
						}
						if (pierce) {
							if (!stat[1].equals("E") && !stat[1].equals("G") && !stat[1].equals("A")) {
								continue;
							}

							if (typeNum == 1 && stat[1].equals("A")) {
								continue;
							} else if (typeNum > 1 && stat[1].equals("A")) {
								poorTypes = true;
							}

						}
						if (slash) {
							if (!stat[2].equals("E") && !stat[2].equals("G") && !stat[2].equals("A")) {
								continue;
							}

							if (typeNum == 1 && stat[2].equals("A")) {
								continue;
							} else if (typeNum > 1 && stat[2].equals("A")) {
								poorTypes = true;
							}
						}

						if (poorTypes) {
							temp.add(piece);
							poorCount++;
						} else {
							temp.add(0, piece);
						}
						down = true;
						continue;
					}
				}

				if (!down) {
					for (int j = l.size() - 1; j > -1; j--) {
						Item piece = l.get(j);
						if (piece.tier == Access.viableGear + 1) {
							String[] stat = piece.effectiveness.split("/");
							if (bludge) {
								if (!stat[0].equals("E") && !stat[0].equals("G") && !stat[0].equals("A")) {
									continue;
								}

								if (typeNum == 1 && stat[0].equals("A")) {
									continue;
								} else if (typeNum > 1 && stat[0].equals("A")) {
									poorTypes = true;
								}
							}
							if (pierce) {
								if (!stat[1].equals("E") && !stat[1].equals("G") && !stat[1].equals("A")) {
									continue;
								}

								if (typeNum == 1 && stat[1].equals("A")) {
									continue;
								} else if (typeNum > 1 && stat[1].equals("A")) {
									poorTypes = true;
								}

							}
							if (slash) {
								if (!stat[2].equals("E") && !stat[2].equals("G") && !stat[2].equals("A")) {
									continue;
								}

								if (typeNum == 1 && stat[2].equals("A")) {
									continue;
								} else if (typeNum > 1 && stat[2].equals("A")) {
									poorTypes = true;
								}
							}

							if (poorTypes) {
								temp.add(piece);
								poorCount++;
							} else {
								temp.add(0, piece);
							}
							continue;
						}
					}
				}
				if (!temp.isEmpty()) {
					equipping = temp.get(0);
				}
			}

			if (equipping == null && !usingArmor) {
				continue;
			}
			if (equipping.tag.equals("Chest and Legs Armor")) {
				usingArmor = true;
			}

			inv.equipped.add(equipping);
			inv.remove(equipping);
		}

		// now its time to get a good wep wep
		bludge = false;
		pierce = false;
		slash = false;

		if (Access.damageType.contains(Item.BLUDGEONING)) {
			bludge = true;
		}
		if (Access.damageType.contains(Item.PIERCING)) {
			pierce = true;
		}
		if (Access.damageType.contains(Item.SLASHING)) {
			slash = true;
		}

		boolean wepEquipped = false;

		for (int i = 1; i < 3; i++) {
			for (Item piece : inv.weapon) {
				if (piece.tier == (Access.viableGear + ((i / 2) * (Math.pow(-1, i))))
						&& ((piece.twoHanded && Access.twoHanded) || (!piece.twoHanded && !Access.twoHanded))) {
					if (bludge) {
						if (!inv.bludge.contains(piece)) {
							continue;
						}
					}
					if (pierce) {
						if (!inv.pierce.contains(piece)) {
							continue;
						}
					}
					if (slash) {
						if (!inv.slash.contains(piece)) {
							continue;
						}
					}
					inv.equipped.add(piece);
					inv.weapon.remove(piece);
					inv.brokenItems.remove(piece);
					if (bludge) {
						inv.bludge.remove(piece);
					}
					if (pierce) {
						inv.pierce.remove(piece);
					}
					if (slash) {
						inv.slash.remove(piece);
					}
					wepEquipped = true;
					break;
				}
			}

			if (wepEquipped) {
				break;
			}
		}

		if (!wepEquipped) {
			cancelAction = true;
		}

		// alright so now all the required items are in the thing
		Access.run("closepopupMessage()");

		if (regear) {
			Access.switchTo(Alt.mainHitterID, Alt.muleID);

			// give all the required items to the required people
			inv.transferItem(inv.equipped, Alt.mainHitterID);
			Access.sleep(.25);
			Access.closePopup();

			// switch back to the hitter
			Access.switchTo(Alt.muleID, Alt.mainHitterID);
			Access.sleep(.55);
		}

		// Have the hitter equip all the items
		for (Item equipping : inv.equipped) {
			inv.equip(equipping);
			Access.sleep(.35);
		}
		Access.closePopup();

		try {
			WebElement charUI = Access.driver.findElement(By.cssSelector("div[id = 'inBannerCharacterWidget']"));
			charUI.findElement(By.cssSelector("div[class = 'avatar-equip-chest']"));
			charUI.findElement(By.cssSelector("div[class = 'avatar-equip-legs']"));
			try {
				charUI.findElement(By.cssSelector("div[class = 'avatar-equip-rightHand']"));
			} catch (Exception f) {
				charUI.findElement(By.cssSelector("div[class = 'avatar-equip-2hands']"));
			}
			
		} catch (Exception e) {
			System.out.println("Didn't have something equipped, cancelling action");
		}
		

		// switch back to the runner
		Access.switchTo(Alt.mainHitterID, Alt.runnerID);
		Access.sleep(.25);

	}

	public void findDead() {
		String text = Access.getChatMessage("Location");
		System.out.println("Check!");
		if (!text.equals("No text found")) {
			System.out.println("Gonna have a breakpoint here");
			cancelAction = true;
		}
	}

	public void hpStop() {
		if (health < 10) {
			System.exit(0);
		}
	}
	
	public void refresh() {
		if (System.currentTimeMillis() - lastRefresh > 600000) {
			lastRefresh = System.currentTimeMillis();
			Access.driver.navigate().refresh();
		}
	}
}
