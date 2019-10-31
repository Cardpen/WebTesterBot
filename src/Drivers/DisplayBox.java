package Drivers;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Maps.MapVertex;

public class DisplayBox extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2328769349363387315L;
	
	List<JLabel> informations;
	Alt alt;
	MapVertex navGoal;
	JComboBox accountPicker;
	JButton login;
	Set<JComponent> activeWidgets = new HashSet<JComponent>();
	String command = "Default";
	
	public DisplayBox () {
		this.setTitle("Initium Bot General Purpose");
		setSize(400, 400);
		setLayout(null);
		setVisible(true);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void setScreenLogin(MainDriver driver) {
		String[] accounts = {"Card Main","Card Race","Card Boss", "Fake Name UNO"};
		accountPicker = new JComboBox(accounts);
		accountPicker.setBounds(new Rectangle(20, 50, 200, 20));
		accountPicker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox cb = (JComboBox)e.getSource();
				String selected = (String) cb.getSelectedItem();
				if (selected.equals("Card Main")) {
					setTitle("Card's Main Account");
					driver.setAccount(0);
				} else if (selected.equals("Card Race")) {
					setTitle("Monsters of Card");
					driver.setAccount(1);
				} else if (selected.equals("Card Boss")) {
					setTitle("Bosses of Card");
					driver.setAccount(2);
				} else if (selected.equals("Fake Name UNO")) {
					setTitle("Fake Account UNO");
					driver.setAccount(3);
				}
				
				
			}
		});
		addWidget(accountPicker);
		revalidate();
		repaint();
	}
	
	public void canLogIn(MainDriver driver) {
		login = new JButton("Login");
		login.setBounds(230, 50, 100, 20);
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				driver.loginWait = false;
			}
			
		});
		addWidget(login);
		
		revalidate();
		repaint();
	}
	
	public void setScreenGame(Alt alt) {
		clearWidgets();
		this.alt = alt;
		navGoal = Access.Aera;
		
		JLabel goToTag = new JLabel("Navigate to...");
		goToTag.setBounds(20, 20, 100, 20);
		addWidget(goToTag);
		MapVertex[] locations  = Access.map.vertexSet().toArray(new MapVertex[Access.map.vertexSet().size()]);
		Arrays.sort(locations);
		
		JComboBox goTo = new JComboBox(locations);
		goTo.setBounds(new Rectangle(20, 50, 200, 20));
		goTo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox cb = (JComboBox)e.getSource();
				MapVertex goal = (MapVertex) cb.getSelectedItem();
				navGoal = goal;
			}
		});
		addWidget(goTo);
		
		JLabel setAction = new JLabel("setAction");
		setAction.setBounds(20, 75, 100, 10);
		addWidget(setAction);
		String[] commands = {"Target Hunting Off","Alt Farming","Farm Kobolds", "Farm Pythons",
				"Farm Rapier", "Farm Marksman", "Farm Dunes", "Farm Plains", "Farm Baron",
				"Farm Lunar", "Farm Xaruk", "Farm Dragon", "Farm River", "Farm Commie", "Farm Archmage",
				"Farm Jungle", "Farm Thorn", "Farm Crusader", "Farm NaKareth", "Farm Water", "Farm Unicorn", "Farm Elementals", "Farm Leviathan","Farm Hat prot", "Farm HuntFirePriest", "Farm SimbaFae", "Farm Swamp","Farm Overlord", "Farm Lizard", "Farm Priest", "Farm Abby", "Search Paths - On", "Search Paths - Off",
				"Regear - Disable", "Regear - Enable", "Two Hand On", "Two Hand Off"};
		Arrays.sort(commands);
		JComboBox setCommand = new JComboBox(commands);
		setCommand.setBounds(new Rectangle(20, 90, 200, 20));
		setCommand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox cb = (JComboBox)e.getSource();
				command = (String) cb.getSelectedItem();
				
			}
		});
		addWidget(setCommand);
		
		JButton engageCommand = new JButton("Execute");
		engageCommand.setBounds(230, 90, 100, 20);
		engageCommand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (command.equals("Target Hunting Off")) {
					alt.mobs.addAll(Access.mobs);
					alt.targetHunting = false;
					System.out.println("Target Hunting Off");
				} else if (command.equals("Alt Farming")) {
					setNewAltName();
					System.out.println("Alt farming engaged");
				} else if (command.equals("Search Paths - On")) {
					alt.mobs.clear();
					alt.search = true;
					System.out.println("Search only mode engaged");
				} else if (command.equals("Search Paths - Off")) {
					alt.mobs.addAll(Access.mobs);
					alt.search = false;
					System.out.println("Search only mode disengaged");
				} else if (command.equals("Two Hand On")) {
					Access.twoHanded = true;
					System.out.println("Two Handed mode engaged");
				} else if (command.equals("Two Hand Off")) {
					Access.twoHanded = false;
					System.out.println("Two Handed mode disengaged");
				} else if (command.equals("Regear - Disable")) {
					alt.regear =false;
					System.out.println("Regear diabled");
				} else if (command.equals("Regear - Enable")) {
					alt.regear = true;
					System.out.println("Regear enabled");
				} else if (command.contains("Farm")){
					alt.targetHunting = true;
					alt.mobs.addAll(Access.mobs);
					if (command.equals("Farm Kobolds")) {
						Access.setUpKobolds();
					} else if (command.equals("Farm Pythons")) {
						Access.setUpSnake();
					} else if (command.equals("Farm Water")) {
						Access.setUpWater();
					} else if (command.equals("Farm Crusader")) {
						alt.mobs.add("Protector of The Swamps");
						Access.setUpCrusader();
					} else if (command.equals("Farm Rapier")) {
						Access.setUpRapiers();
					} else if (command.equals("Farm Elementals")) {
						Access.setUpElements();
					} else if (command.equals("Farm Marksman")) {
						Access.setUpMarksman();
					} else if (command.equals("Farm Dunes")) {
						Access.setUpDunes();
					} else if (command.equals("Farm Plains")) {
						Access.setUpPlains();
					} else if (command.equals("Farm Baron")) {
						Access.setUpThorn();
					} else if (command.equals("Farm Lunar")) {
						Access.setUpLunar();
					} else if (command.equals("Farm Xaruk")) {
						Access.setUpXaruk();
					} else if (command.equals("Farm Dragon")) {
						Access.setUpDragon();
					} else if (command.equals("Farm Commie")) {
						Access.setUpCommie();
					} else if (command.equals("Farm Archmage")) {
						Access.setUpArch();
					} else if (command.equals("Farm Jungle")) {
						Access.setUpJungle();
					} else if (command.equals("Farm Thorn")) {
						Access.setUpThorn();
						alt.minHealth = 30;
						alt.mobs.add("Thief");
						alt.mobs.add("Brigand");
						alt.mobs.add("Bear");
					} else if (command.equals("Farm Abby")) {
						Access.setUpAbby();
					} else if (command.equals("Farm Lizard")) {
						Access.setUpLizardKing();
					} else if (command.equals("Farm Priest")) {
						Access.setUpPriest();
					} else if (command.equals("Farm Overlord")) {
						Access.setUpOverlord();
					} else if (command.equals("Farm River")) {
						alt.mobs.add("Protector of The River");
						Access.setUpRiver();
					} else if (command.equals("Farm Swamp")) {
						Access.setUpSwamp();
					} else if (command.equals("Farm SimbaFae")) {
						Access.setUpSimbaFae();
					} else if (command.equals("Farm HuntFirePriest")) {
						Access.setUpHuntsPriestessFire();
					} else if (command.equals("Farm Leviathan")) {
						Access.setUpLevi();
					} else if (command.equals("Farm Hat prot")) {
						Access.setUpProtHat();
					} else if (command.equals("Farm NaKareth")) {
						Access.setUpNaKareth();
					} else if (command.equals("Farm Unicorn")) {
						Access.setUpUnicorn();
					}
					System.out.println("Executing " + command);
				}
			}
			
		});
		addWidget(engageCommand);
		
		JButton reGearCommand = new JButton("ReGear");
		reGearCommand.setBounds(20, 130, 160, 20);
		reGearCommand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setScreenRegear();
			}
			
		});
		addWidget(reGearCommand);
		
		JButton testButton = new JButton("Test");
		testButton.setBounds(200, 130, 160, 20);
		testButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				alt.testMethod();
			}
			
		});
		addWidget(testButton);
		
		JButton sendGoToCommand = new JButton("Go");
		sendGoToCommand.setBounds(230, 50, 50, 20);
		sendGoToCommand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				alt.cancelAction = false;
				alt.navLoca = navGoal;
				alt.doNav = true;
				
			}
			
		});
		addWidget(sendGoToCommand);
		
		JButton sendExploreCommand = new JButton("Explore");
		sendExploreCommand.setBounds(290, 50, 80, 20);
		sendExploreCommand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				alt.cancelAction = false;
				alt.doExplore = true;
			}
			
		});
		addWidget(sendExploreCommand);
		
		//bottom bar
		JButton reInv = new JButton("reInv");
		reInv.setBounds(140, 310, 70, 20);
		reInv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				alt.updateInv = true;
			}
			
		});
		addWidget(reInv);
		
		JButton updateInv = new JButton("save");
		updateInv.setBounds(60, 310, 70, 20);
		updateInv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				alt.inv.recompile();
			}
			
		});
		addWidget(updateInv);
		
		JButton cancelAction = new JButton("Cancel");
		cancelAction.setBounds(220, 310, 70, 20);
		cancelAction.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				alt.cancelAction = true;
			}
			
		});
		addWidget(cancelAction);
		
		JButton closeAndExit = new JButton("Exit");
		closeAndExit.setBounds(300, 310, 70, 20);
		closeAndExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				alt.inv.recompile();
				Access.driver.close();
				Access.itemDriver.close();
				System.exit(0);
			}
			
		});
		addWidget(closeAndExit);
		
		revalidate();
		repaint();
	}
	
	public void setScreenRegear() {
		clearWidgets();
		JLabel regearPage = new JLabel("Regear Mode");
		regearPage.setFont(new Font("SansSerif", Font.BOLD, 20));
		regearPage.setBounds(120, 30, 400, 20);
		addWidget(regearPage);
		
		String[] types = {Item.BLUDGEONING, Item.PIERCING, Item.SLASHING, Item.BLUDGEONING + " " + Item.SLASHING,
				Item.BLUDGEONING + " " + Item.PIERCING, Item.PIERCING + " " + Item.SLASHING,};
		
		JLabel dmgTypeTag = new JLabel("Damage Type");
		dmgTypeTag.setBounds(20, 65, 100, 10);
		addWidget(dmgTypeTag);
		JComboBox dmgType = new JComboBox(types);
		dmgType.setBounds(new Rectangle(20, 80, 200, 20));
		dmgType.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox cb = (JComboBox)e.getSource();
				String type = (String) cb.getSelectedItem();
				Access.damageType = type;
			}
		});
		addWidget(dmgType);
		
		JLabel armorTypeTag = new JLabel("Armor Type");
		armorTypeTag.setBounds(20, 105, 100, 10);
		addWidget(armorTypeTag);
		JComboBox armorType = new JComboBox(types);
		armorType.setBounds(new Rectangle(20, 120, 200, 20));
		armorType.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox cb = (JComboBox)e.getSource();
				String type = (String) cb.getSelectedItem();
				Access.armorType = type;
			}
		});
		addWidget(armorType);
		
		JLabel tierTag = new JLabel("Tier");
		tierTag.setBounds(20, 145, 100, 10);
		addWidget(tierTag);
		String[] tiers = {"Trash", "Training", "Bronze", "Silver", "Gold", "Diamond"};
		JComboBox tier = new JComboBox(tiers);
		tier.setBounds(new Rectangle(20, 160, 200, 20));
		tier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox cb = (JComboBox)e.getSource();
				String type = (String) cb.getSelectedItem();
				int i = 0;
				if (type.equals("Trash")) {
					i = 0;
				} else if (type.equals("Training")) {
					i = 1;
				} else if (type.equals("Bronze")) {
					i = 2;
				} else if (type.equals("Silver")) {
					i = 3;
				} else if (type.equals("Gold")) {
					i = 4;
				} else if (type.equals("Diamond")) {
					i = 5;
				} else {
					i = 3;
				}
				Access.viableGear = i;
			}
		});
		addWidget(tier);
		
		
		JButton reGearCommand = new JButton("ReGear");
		reGearCommand.setBounds(230, 160, 100, 20);
		reGearCommand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				alt.reGear();
			}
			
		});
		addWidget(reGearCommand);
		
		JButton cancelAction = new JButton("Cancel");
		cancelAction.setBounds(300, 310, 70, 20);
		cancelAction.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				setScreenGame(alt);
			}
			
		});
		addWidget(cancelAction);
		revalidate();
		repaint();
	}
	
	public void setNewAltName() {
		JTextField altName = new JTextField();
		altName.setBounds(new Rectangle(20, 170, 200, 20));
		altName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = altName.getText();
				alt.targetHunting = true;
				alt.altFarming = true;
				alt.minHealth = 20;
				alt.mobs.clear();
				alt.mobs.add("Troll");
				alt.forget.remove("Troll");
				alt.newAltName = name;
				Access.targetLocations = Arrays.asList(Access.AeraCountrySide);
				System.out.println("New alt name set to " + name);
				remove(altName);
				revalidate();
				repaint();
			}
		});
		add(altName);

		revalidate();
		repaint();
	}
	
	public void clearWidgets() {
		for (JComponent widget: activeWidgets) {
			remove(widget);
		}
		activeWidgets.clear();
		
	}
	
	public void addWidget(JComponent widget) {
		add(widget);
		activeWidgets.add(widget);
	}
	
	public void setup(List<String> stats) {
		informations = new ArrayList<JLabel>();
		for (String s: stats) {
			informations.add(new JLabel(s));
		}
		int y = 250;
		for (JLabel t: informations) {
			t.setBounds(20, y, 150, 20);
			y += 35;
			this.add(t);
		}
	}
	
	public void update(List<String> stats) {
		
		for (int i = 0; i < stats.size(); i++) {
			informations.get(i).setText("<html><p style=\"width:120px\">"+stats.get(i)+"</p></html>");
		}
	}
	
}
