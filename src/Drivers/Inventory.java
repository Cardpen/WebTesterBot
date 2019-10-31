package Drivers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Inventory extends ItemStorage{

	
	public Inventory() {
		
		
		try {
			invString = new String(Files.readAllBytes(Paths.get("libraries/inventory_" + Access.act.getUserName() +".txt")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		List<Item> storedInventory = gson.fromJson(invString, new TypeToken<List<Item>>(){}.getType());
		for (Item i : storedInventory) {
			add(i);
		}
		
		Access.switchTo(Alt.runnerID, Alt.mainHitterID);
		Access.findBroken();
		Access.run("inventory(event)");
		Access.sleep(.5);

		// checks what you're wearing
		WebElement equippedBox = Access.driver.findElement(By.id("equipment"));
		List<WebElement> equippedElement = equippedBox.findElements(By.className("main-item-container"));
		for (WebElement m : equippedElement) {
			System.out.println("Run x");
			Item i = new Item(m, "Inventory");
			if (equipped.contains(i)) { continue;}
			equipped.add(i);
			System.out.println("Equipped" + i);
		}
		
		Access.closePopup();
		Access.sleep(.2);
		Access.switchTo(Alt.mainHitterID, Alt.runnerID);

	}
	
	public void updateInventory() {
		
		clear();
		Access.switchTo(Alt.runnerID, Alt.muleID);
		Access.sleep(.5);
		Access.run("inventory(event)");
		Access.sleep(.5);

		// does an inventory of the inventory
		WebElement itemBox = Access.wait.until(ExpectedConditions.presenceOfElementLocated(By.id("invItems")));
		List<WebElement> itemElements = itemBox.findElements(By.className("invItem"));
		
		int numDashes = 0;
		System.out.print("Progress Bar --> [:--------------------]\r");
		for (int i = 0; i < itemElements.size(); i++) {
			
			if (numDashes != (i * 20) / itemElements.size()) {
				String bar = "Progress Bar --> [:";
				numDashes = (i * 20) / itemElements.size();
				for (int j = 0; j < 20; j++) {
					if (j < numDashes) {
						bar += "=";
					} else {
						bar += "-";
					}
				}
				bar += "]\r";
				System.out.print(bar);
			}
			
			Item item = new Item(itemElements.get(i), "Inventory");
			add(item);
		}
		
		Access.closePopup();
		Access.switchTo(Alt.muleID, Alt.mainHitterID);
		Access.switchTo(Alt.muleID, Alt.mainHitterID);
		Access.run("inventory(event)");
		Access.sleep(.5);

		// checks what you're wearing
		WebElement equippedBox = Access.driver.findElement(By.id("equipment"));
		List<WebElement> equippedElement = equippedBox.findElements(By.className("main-item-container"));
		for (WebElement m : equippedElement) {
			Item i = new Item(m, "Inventory");
			if (equipped.contains(i)) { continue;}
			equipped.add(i);
		}
		
		
		
		Access.closePopup();
		Access.sleep(.2);
		Access.switchTo(Alt.mainHitterID, Alt.runnerID);
		recompile();
		
	}

	public void clear() {
		brokenItems.clear();
		items.clear();
		equipped.clear();
		weapon.clear();
		bludge.clear();
		pierce.clear();
		slash.clear();
		helm.clear();
		armor.clear();
		chest.clear();
		pants.clear();
		boots.clear();
		shield.clear();
		arm.clear();
		shirt.clear();
		misc.clear();
	}
	
	public void add(Item i) {
		items.add(i);
		if (i.tag.equals("Weapon")) {
			weapon.add(i);
			if (i.damageType.contains("Slash")) {
				slash.add(i);
			}
			if (i.damageType.contains("Piercing")) {
				pierce.add(i);
			}
			if (i.damageType.contains("Bludgeoning")) {
				bludge.add(i);
			}
		} else if (i.tag.equals("Helmet Armor")) {
			helm.add(i);
		} else if (i.tag.equals("Gloves Armor")) {
			arm.add(i);
		} else if (i.tag.equals("Shirt Armor")) {
			shirt.add(i);
		} else if (i.tag.equals("Boots Armor")) {
			boots.add(i);
		} else if (i.tag.equals("Chest and Legs Armor")) {
			armor.add(i);
		} else if (i.tag.equals("Chest Armor")) {
			chest.add(i);
		} else if (i.tag.equals("Legs Armor")) {
			pants.add(i);
		} else if (i.tag.contains("Shield")) {
			shield.add(i);
		} else if (i.tag.equals("Misc")) {
			misc.add(i);
		}
	}

	public void remove(Item i ) {
		items.remove(i);
		if (i.tag.equals("Weapon")) {
			weapon.remove(i);
			if (i.damageType.contains("Slash")) {
				slash.remove(i);
			}
			if (i.damageType.contains("Piercing")) {
				pierce.remove(i);
			}
			if (i.damageType.contains("Bludgeoning")) {
				bludge.remove(i);
			}
		} else if (i.tag.equals("Helmet Armor")) {
			helm.remove(i);
		} else if (i.tag.equals("Gloves Armor")) {
			arm.remove(i);
		} else if (i.tag.equals("Shirt Armor")) {
			shirt.remove(i);
		} else if (i.tag.equals("Boots Armor")) {
			boots.remove(i);
		} else if (i.tag.equals("Chest and Legs Armor")) {
			armor.remove(i);
		} else if (i.tag.equals("Chest Armor")) {
			chest.remove(i);
		} else if (i.tag.equals("Legs Armor")) {
			pants.remove(i);
		} else if (i.tag.contains("Shield")) {
			shield.remove(i);
		} else if (i.tag.equals("Misc")) {
			misc.remove(i);
		}
	}

	public void equip(Item i) {
		try {
			Access.js.executeAsyncScript("characterEquipItem(event, " + i.ref + ")");
		} catch (Exception nothing) {
		}
	}

	public boolean updateEquippedDura() {

		boolean broken = false;
		for (Item i : equipped) {
			try {
				i.updateDura();
			} catch (Exception e) {
				if (brokenItems.contains(i)) {
					continue;
				}
				brokenItems.add(i);
				broken = true;
			}
		}

		for (Item bro : brokenItems) {
			try {
				equipped.remove(bro);
				remove(bro);
			} catch (Exception e) {

			}
		}
		return broken;
	}
/*
	public void replaceBroken() {
		System.out.println("Running Replace Broken");
		for (Item i : brokenItems) {
			System.out.println("Checking " + i);
			String s = i.tag;
			Set<Item> managingList = slash;
			
			if (s.equals("Weapon")) {
				if (i.damageType.contains("Slash")) {
					managingList = slash;
				}
				if (i.damageType.contains("Piercing")) {
					managingList = pierce;
				}
				if (i.damageType.contains("Bludgeoning")) {
					managingList = bludge;
				}
			} else if (s.equals("Helmet Armor")) {
				managingList = helm;
			} else if (s.equals("Gloves Armor")) {
				managingList = arm;
			} else if (s.equals("Shirt Armor")) {
				managingList = shirt;
			} else if (s.equals("Boots Armor")) {
				managingList = boots;
			} else if (s.equals("Chest and Legs Armor")) {
				managingList = armor;
			} else if (s.equals("Chest Armor")) {
				managingList = chest;
			} else if (s.equals("Legs Armor")) {
				managingList = pants;
			} else if (s.contains("Shield")) {
				managingList = shield;
			} else if (s.equals("Misc")) {
				managingList = misc;
			} else {
				System.out.println("Something went wrong");
				managingList = misc;
			}

			if (managingList.isEmpty()) {
				System.out.println("\n\n\n\n There are no more " + s + " left in the inventory \n\n\n");
			}
			managingList.sort(new itemScorer(i));
			System.out.println("managingList is " + managingList.size());
			Item equipping = null;
			for (Item check: managingList) {
				if (check.tier == i.tier) {
					equipping = check;
					break;
				}
			}
			if (equipping == null) { 
				System.out.println("There are no " + i.tag + " of " + i.tier + " tier found.");
				continue;
			}
			
			Access.switchTo(Alt.runnerID, Alt.muleID);
			Access.sleep(.5);
			System.out.println("equipping " + equipping);
			transferItem(new ArrayList<Item>(Arrays.asList(equipping)), Alt.mainHitterID);
			System.out.println("Transfer complete");
			Access.switchTo(Alt.muleID, Alt.mainHitterID);
			Access.sleep(.5);
			System.out.println("equipping");
			Access.sleep(.5);
			equipped.add(equipping);
			equip(equipping);
			Access.sleep(.5);
			System.out.println("equiped");
			Access.switchTo(Alt.mainHitterID, Alt.runnerID);
			Access.sleep(.5);
			System.out.println("remove from managing list");
			managingList.remove(equipping);
			items.remove(equipping);
		}
		brokenItems.clear();
	}
*/	
	
	public void transferItem(Set<Item> items, String to) {
		
		//start trade with hitter
		
		Access.sleep(.5);
		System.out.println(Alt.currentAlt);
		System.out.println(to);
		while (true) {
			Access.run("tradeStartTradeNew(event, "+ to +")");
			Access.sleep(.55);
			Access.run("closepopupMessage()");
			try {
			Access.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[onclick = 'tradeReadyNew(event)']")));
			} catch(Exception e) {continue;}
			break;
		}
		System.out.println("trade window opened");
		
		for (Item i: items) {
			System.out.println("Adding a " + i.tier + " " + i.name);
			Access.run("tradeAddItemNew(event,"+i.ref+")");
			Access.sleep(.5);
		}
		System.out.println("trade item added");
		Access.sleep(.25);
		Access.run("tradeReadyNew(event)");
		Access.sleep(.25);
		System.out.println("trade redied");
		Access.closePopup();
	}

	public void recompile() {
		
		try  {
			PrintWriter out = new PrintWriter("libraries/inventory_" + Access.act.getUserName() +".txt");
			out.println(gson.toJson(items));
		    out.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}

class itemScorer implements Comparator<Item> {
	Item i;
	
	public itemScorer(Item i ) {
		super();
		this.i = i;
	}
	
	@Override
	public int compare(Item a, Item b) {
		return (int) (Math.abs(a.score() - i.score()) - Math.abs(b.score() - i.score()));
	}
}
