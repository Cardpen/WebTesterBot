package Drivers;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.gson.Gson;

public class Item implements Comparable<Item> {
	public String ref = "Default";
	public String tag = "Default";
	public String name = "Default";
	public int tier = -1;
	public String effectiveness = "Default";
	public String damageType = "Default";
	public int maxDamage = 0;
	public double avgDamage = 0;
	String houseTag = "Default";

	public int dp = 0;
	public int bc = 0;
	public int dr = 0;
	public int dura = 0;
	public int score = 0;
	public boolean twoHanded = false;

	public static final String SLASHING = "Slashing";
	public static final String PIERCING = "Piercing";
	public static final String BLUDGEONING = "Bludgeoning";
	public static final int TRASH = 0;
	public static final int TRAINING = 1;
	public static final int BRONZE = 2;
	public static final int SILVER = 3;
	public static final int GOLD = 4;
	public static final int DIAMOND = 5;

	public Item(WebElement invItem, String houseTag) {
		this.houseTag = houseTag;
		WebElement statElement = invItem.findElement(By.cssSelector("a[rel]"));
		ref = statElement.getAttribute("rel").split("=")[1];
		name = invItem.findElement(By.className("main-item-name")).getText();
		//System.out.println(name);
		// Access.mainWindow = Access.driver.getWindowHandle();
		try {
			String[] stats;
			String statLine = statElement.getAttribute("minitip");
			if (statLine.contains("D")) {
				// 2D8x2 9% (32/9.81) <br></a> 5/33/8 A/A/E
				tag = "Weapon";
				String[] statList = statLine.split(" ");
				String[] dmg = statList[2].substring(1, statList[2].length() - 1).split("/");
				maxDamage = Integer.parseInt(dmg[0]);
				avgDamage = Double.parseDouble(dmg[1]);
				stats = statList[4].split("/");
				effectiveness = statList[5];
				
				String specificName = name.split("\n")[0];
				if (Access.itemTags.containsKey(specificName)) {
					Item i = Access.itemTags.get(specificName);
					twoHanded = i.twoHanded;
					damageType = i.damageType;
					
				} else {
					Access.itemDriver.get("https://www.playinitium.com/odp/viewitemmini?itemId=" + ref);
					damageType = Access.itemDriver.findElement(By.cssSelector("div[name = 'weaponDamageType']"))
							.findElement(By.className("main-item-subnote")).getText();
					String hands = Access.itemDriver.findElement(By.xpath("/html/body/div/div[1]/div[2]/p")).getText();
					if (!hands.contains("Left")) {
						twoHanded = true;
					}
				}
				
			} else {
				// It's a defense
				String[] s = statLine.split("<")[0].split(" ");
				stats = s[0].split("/");

				effectiveness = s[1];
				String specificName = name.split("\n")[0];
				if (Access.itemTags.containsKey(specificName)) {
					Item i = Access.itemTags.get(specificName);
					tag = i.tag;
				} else {
					Access.itemDriver.get("https://www.playinitium.com/odp/viewitemmini?itemId=" + ref);
					tag = Access.itemDriver.findElement(By.xpath("/html/body/div/div[1]/div[2]/p")).getText();
				}
			}
			
			
			dp = Integer.parseInt(stats[0]);
			bc = Integer.parseInt(stats[1]);
			dr = Integer.parseInt(stats[2]);

			setTier();
			score = (int) overAllScore();
			
			String specificName = name.split("\n")[0];
			if (!Access.itemTags.containsKey(specificName)) {
				Access.itemTags.put(specificName, this);
				String dura = Access.itemDriver.findElement(By.cssSelector("div[name = 'durability']"))
						.findElement(By.className("main-item-subnote")).getText();
				this.dura = Integer.parseInt(dura.split("/")[0]);
				createNewLog();
			}
			// Access.driver.switchTo().window(Access.mainWindow);

		} catch (Exception e) {
			// That means its not an equipment
			tag = "Misc";
		}
	}

	public void createNewLog() {
		Gson gson = new Gson();
		try (
			PrintWriter out = new PrintWriter("libraries/itemTags.txt")) {
		    out.println(gson.toJson(Access.itemTags));
		    out.close();
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
	}
	
	public String toString() {
		String s;
		if (tag.equals("Weapon")) {
			s = "Name is " + name + "\nTag is " + tag + "\nTier is " + tier + "\nDamage Type is " + damageType
					+ "\nTwo Handed is " + twoHanded + "\nMax damage is " + maxDamage + "\nAvg damage is " + avgDamage
					+ "\nDex Pen is " + dp + "\nBlock Chance is " + bc + "\nDmg Reduc is " + dr + "\nDurability is "
					+ dura;
		} else if (tag.equals("Misc")) {
			s = "Name is " + name;
		} else {
			s = "Name is " + name + "\nTag is " + tag + "\nTier is " + tier + "\nDex Pen is " + dp
					+ "\nBlock Chance is " + bc + "\nDmg Reduc is " + dr + "\nDurability is " + dura;
		}
		return s;
	}
	
	public void updateDura() {
		/*
		 * Access.mainWindow = Access.driver.getWindowHandle();
		 * Access.driver.switchTo().window(Access.itemWindow)
		 * .get("https://www.playinitium.com/odp/viewitemmini?itemId=" + ref);
		 */
		Access.itemDriver.get("https://www.playinitium.com/odp/viewitemmini?itemId=" + ref);
		String dura = Access.itemDriver.findElement(By.cssSelector("div[name = 'durability']"))
				.findElement(By.className("main-item-subnote")).getText();
		this.dura = Integer.parseInt(dura.split("/")[0]);
		// Access.driver.switchTo().window(Access.mainWindow);
	}
	
	public void setTier() {
		
		if (tag.equals("Weapon")) {
			if ((maxDamage < 36 || avgDamage < 7) && avgDamage < 10.5) {
				tier = TRASH;
				return;
			} else if (maxDamage < 40 ) {
				tier = BRONZE;
				return;
			} else if (maxDamage < 54) {
				tier = SILVER;
				return;
			} else if (maxDamage < 66) {
				tier = GOLD;
				return;
			} else {
				tier = DIAMOND;
				return;
			}
		} else if (tag.equals("Misc")) {
			return;
		} else {
			int dexScore = 0;
			int bcScore = 0;
			int drScore = 0;

			if (tag.contains("Shield")) {
				if (bc < 45) {
					tier = TRASH;
					return;
				} else if (bc < 47) {
					bcScore = 1;
				} else if (bc < 51) {
					bcScore = 2;
				} else if (bc < 55) {
					bcScore = 3;
				} else {
					bcScore = 4;
				}
			} else {
				if (bc < 87) {
					tier = TRASH;
					return;
				} else if (bc < 91) {
					bcScore = 1;
				} else if (bc < 94) {
					bcScore = 2;
				} else if (bc < 97) {
					bcScore = 3;
				} else {
					bcScore = 4;
				}
			}
			if (tag.contains("Shirt")) {
				if (dr < 12) {
					tier = TRASH;
					return;
				} else if (dr < 14) {
					drScore = 1;
				} else if (dr < 17) {
					drScore = 2;
				} else if (dr < 20) {
					drScore = 3;
				} else {
					drScore = 4;
				}
			}else {
				if (dr < 15) {
					tier = TRASH;
					return;
				} else if (dr < 18) {
					drScore = 1;
				} else if (dr < 22) {
					drScore = 2;
				} else if (dr < 25) {
					drScore = 3;
				} else {
					drScore = 4;
				}
			}
			

			if (tag.contains("Chest") || tag.contains("Leg")) {
				if (dp > 12) {
					if (drScore > 1 && bcScore > 1) {
						tier = TRAINING;
					} else {
						tier = TRASH;
					}
					return;
				} else if (dp > 9) {
					dexScore = 1;
				} else if (dp > 6) {
					dexScore = 2;
				} else if (dp > 3) {
					dexScore = 3;
				} else {
					dexScore = 4;
				}
			} else {
				if (dp > 6) {
					if (drScore > 2 && bcScore > 2) {
						tier = TRAINING;
					} else {
						tier = TRASH;
					}
					return;
				} else if (dp > 4) {
					dexScore = 1;
				} else if (dp > 2) {
					dexScore = 2;
				} else if (dp > 0) {
					dexScore = 3;
				} else {
					dexScore = 4;
				}
			}
			float tierSpecific = (dexScore + drScore + bcScore) / 3.0f;
			if (tierSpecific < 1) {
				tier = TRASH;
				return;
			}
			int tierNum = (int) Math.floor(tierSpecific);
			switch (tierNum) {
			case 1:
				tier = BRONZE;
				break;
			case 2:
				tier = SILVER;
				break;
			case 3:
				tier = GOLD;
				break;
			case 4:
				tier = DIAMOND;
				break;
			}
		}
	}
	
	public double score() {

		if (tag.equals("Weapon")) {
			if (damageType.contains(Access.damageType)) {
				return maxDamage;
			} else {
				return -1;
			}
		} else if (tag.equals("Misc")) {
			return 0;
		} else {
			double multiplier = 1;
			String def;
			String armorType = Access.armorType;
			if (armorType.contains(BLUDGEONING)) {
				def = effectiveness.split("/")[0];
			} else if (armorType.contains(PIERCING)) {
				def = effectiveness.split("/")[1];
			} else {
				def = effectiveness.split("/")[2];
			}

			if (def.equals("E")) {
				multiplier = 2;
			} else if (def.equals("G")) {
				multiplier = 1.5;
			} else if (def.equals("A")) {
				multiplier = 1;
			} else if (def.equals("P")) {
				multiplier = .75;
			} else if (def.equals("M")) {
				multiplier = .5;
			}

			double score = ((double) (bc - dp) / 100.0) * dr * multiplier;
			return score;

		}
	}
	
	public double overAllScore() {
		if (tag.equals("Weapon")) {
			return maxDamage;
		} else if (tag.equals("Misc")) {
			return 0;
		} else {
			double dexScore = (8 - dp) * (Math.abs((8 - dp)) * 0.9);
			double blockScore = ((bc - 80) * (1 / 2)) * Math.abs((bc - 80) * (.70));
			double resistScore = ((bc - 8) / 2) * (Math.abs(((bc - 8) / 2)) * 0.75);

			if (dp > 10) {
				dexScore *= 1.5;
			}

			return dexScore + blockScore + resistScore;
		}
	}
	
	@Override
	public int compareTo(Item other) {
		return this.score - other.score;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avgDamage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + bc;
		result = prime * result + ((damageType == null) ? 0 : damageType.hashCode());
		result = prime * result + dp;
		result = prime * result + dr;
		result = prime * result + dura;
		result = prime * result + ((effectiveness == null) ? 0 : effectiveness.hashCode());
		result = prime * result + maxDamage;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((ref == null) ? 0 : ref.hashCode());
		result = prime * result + score;
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		result = prime * result + tier;
		result = prime * result + (twoHanded ? 1231 : 1237);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (Double.doubleToLongBits(avgDamage) != Double.doubleToLongBits(other.avgDamage))
			return false;
		if (bc != other.bc)
			return false;
		if (damageType == null) {
			if (other.damageType != null)
				return false;
		} else if (!damageType.equals(other.damageType))
			return false;
		if (dp != other.dp)
			return false;
		if (dr != other.dr)
			return false;
		if (dura != other.dura)
			return false;
		if (effectiveness == null) {
			if (other.effectiveness != null)
				return false;
		} else if (!effectiveness.equals(other.effectiveness))
			return false;
		if (maxDamage != other.maxDamage)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ref == null) {
			if (other.ref != null)
				return false;
		} else if (!ref.equals(other.ref))
			return false;
		if (score != other.score)
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		if (tier != other.tier)
			return false;
		if (twoHanded != other.twoHanded)
			return false;
		return true;
	}

}
