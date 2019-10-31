package Drivers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Maps.MapVertex;

public class HouseInventory extends ItemStorage {

	Map<String, Set<Item>> itemMap = new HashMap<String, Set<Item>>();

	Gson gson;
	String invString;
	Alt game;
	
	public HouseInventory(Alt game) {
		this.game = game;
		gson = new Gson();

		try {
			invString = new String(Files.readAllBytes(Paths.get("libraries/house.txt")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		itemMap = gson.fromJson(invString, new TypeToken<Map<String, Set<Item>>>() {
		}.getType());
		
		for (String key : itemMap.keySet()) {
			for (Item i : itemMap.get(key)) {
				add(i);
			}
		}
	}

	public void updateInventory() {
		List<WebElement> itemElements;
		clear();
		
		game.navTo(Access.MyHouse);
		loadNearByItems();
		WebElement itemBox = Access.wait.until(ExpectedConditions.presenceOfElementLocated(By.id("right")));
		itemElements = itemBox.findElements(By.className("main-item"));
		addAll(itemElements, "House1");
		
		game.navTo(Access.MyHouse2);
		loadNearByItems();
		itemBox = Access.wait.until(ExpectedConditions.presenceOfElementLocated(By.id("right")));
		itemElements = itemBox.findElements(By.className("main-item"));
		addAll(itemElements, "House2");
		
		game.navTo(Access.MyHouse3);
		loadNearByItems();
		itemBox = Access.wait.until(ExpectedConditions.presenceOfElementLocated(By.id("right")));
		itemElements = itemBox.findElements(By.className("main-item"));
		addAll(itemElements, "House3");
		
		game.navTo(Access.MyHouse4);
		loadNearByItems();
		itemBox = Access.wait.until(ExpectedConditions.presenceOfElementLocated(By.id("right")));
		itemElements = itemBox.findElements(By.className("main-item"));
		addAll(itemElements, "House4");
		
		Access.closePopup();
		recompile();

	}

	public void loadNearByItems() {
		while (true) {
			Access.run("loadLocationItems()");
			Access.sleep(.55);
			try {
				Access.wait.until(ExpectedConditions.presenceOfElementLocated(By.id("right")));
			} catch (Exception e) {
				Access.closePopup();
				continue;
			}
			break;
		}
	}

	public void addAll(List<WebElement> itemElements, String tag) {
		int numDashes = 0;
		System.out.print("Progress Bar --> [:--------------------]\r");
		for (int i = 0; i < itemElements.size(); i++) {

			if (numDashes != (i * 20) / itemElements.size() - 1) {
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

			Item item = new Item(itemElements.get(i), tag);
			add(item);
		}
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

		for (String key : itemMap.keySet()) {
			itemMap.get(key).clear();
		}

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

		if (itemMap.containsKey(i.houseTag)) {
			itemMap.get(i.houseTag).add(i);
		}
	}

	public void remove(Item i) {
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

		if (itemMap.containsKey(i.houseTag)) {
			itemMap.get(i.houseTag).remove(i);
		}

	}

	public void pickupItems(List<Item> pickups) {
		Set<Item> house1 = new HashSet<Item>();
		Set<Item> house2 = new HashSet<Item>();
		Set<Item> house3 = new HashSet<Item>();
		List<Set<Item>> houses = Arrays.asList(house1, house2, house3);
		for (Item i: pickups) {
			if (i.houseTag.equals("House1")) {
				house1.add(i);
			} else if (i.houseTag.equals("House2")) {
				house2.add(i);
			} else if (i.houseTag.equals("House3")) {
				house3.add(i);
			} else {
				System.out.println("Item " + i.name + " is not in a house I can find.\nIt's house tag is " + i.houseTag);
				return;
			}
		}
		
		for (int i = 0; i < houses.size(); i++) {
			if (houses.get(i).isEmpty()) { continue;}
			
			switch (i) {
			case 0:
				game.navTo(Access.MyHouse);
				break;
			case 1:
				game.navTo(Access.MyHouse);
				break;
			case 2:
				game.navTo(Access.MyHouse);
				break;
			}
			
			loadNearByItems();
			
			for (Item item : houses.get(i)) {
				Access.run("moveItem(event, "+item.ref+", \"Character\", "+game.currentAlt+")");
				Access.sleep(.5);
				item.houseTag = "Inventory";
			}
		}
		
		Access.closePopup();
	}

	public void dropAll(Inventory inv) {
		int dropNum = inv.items.size();
		MapVertex house;
		String tag = "Default";
		if (dropNum + itemMap.get("House1").size() < 950) {
			house = Access.MyHouse;
			tag = "House1";
		} else if (dropNum + itemMap.get("House2").size() < 950) {
			house = Access.MyHouse2;
			tag = "House2";
		} else if (dropNum + itemMap.get("House3").size() < 950) {
			house = Access.MyHouse3;
			tag = "House3";
		} else if (dropNum + itemMap.get("House4").size() < 950) {
			house = Access.MyHouse4;
			tag = "House4";
		} else {
			System.out.println("No room found for items");
			return;
		}
		
		game.navTo(house);
		Access.switchTo(game.runnerID, game.muleID);
		Access.run("dropAllInventory(event)");
		Access.sleep(.25);
		try{
			Access.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[class = 'popup_confirm_option confirm_yes']"))).click();
		} catch (Exception e) {
			System.out.println("Confirm button not found");
			return;
		}
		for (Item i: inv.items) {
			i.houseTag = tag;
			add(i);
		}
		
		inv.clear();
		recompile();
	}
	
	public void recompile() {

		try (PrintWriter out = new PrintWriter("libraries/house.txt")) {
			out.println(gson.toJson(itemMap));
			out.close();
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
	}

}
