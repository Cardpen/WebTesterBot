package Drivers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Maps.MapVertex;

public class Access {
	static WebDriverWait wait;
	public static MapVertex Aera = new MapVertex("Aera", "location-link-5629499534213120");
	public static MapVertex MyHouse = new MapVertex("My House", "location-link-2137131111");
	public static MapVertex MyHouse2 = new MapVertex("My House 2", "location-link-2247720073");
	public static MapVertex MyHouse3 = new MapVertex("My House 3", "location-link-2268800079");
	public static MapVertex MyHouse4 = new MapVertex("My House 4", "location-link-2270530988");
	public static MapVertex AeraCountrySide = new MapVertex("Aera Countryside", "location-link-5649391675244544");
	public static MapVertex AeraInn = new MapVertex("Aera Inn", "location-link-6655219060441088");
	public static MapVertex NorthernHills = new MapVertex("Northern Hills", "location-link-6616739106258944");
	public static MapVertex GreatNorthernValley = new MapVertex("Great Northern Valley",
			"location-link-4514173299982336");
	public static MapVertex Death = new MapVertex("Death", "42 Hell street");
	public static MapVertex CastleGrounds = new MapVertex("Castle Grounds", "location-link-5232868968103936");
	public static MapVertex CastleCourtyard = new MapVertex("Castle Courtyard", "location-link-6563390277287936");
	public static MapVertex OuterGate = new MapVertex("Outer Gate", "location-link-4750757815386112");
	public static MapVertex OvergrownPath = new MapVertex("Overgrown Path", "location-link-5490839199416320");
	public static MapVertex NorthWestHills = new MapVertex("North West Hills", "location-link-5757649010294784");
	public static MapVertex TheFork = new MapVertex("The Fork", "location-link-4662743332290560");
	public static MapVertex HighRoad = new MapVertex("High Road", "location-link-5437912854298624");
	public static MapVertex HighRoadSwampland = new MapVertex("High Road: Swampland", "location-link-6010500529782784");
	public static MapVertex DenseJungle = new MapVertex("Dense Jungle", "location-link-6430890083221504");
	public static MapVertex DenseJungle2 = new MapVertex("Dense Jungle", "location-link-5319127061233664");
	public static MapVertex DenseJungle5 = new MapVertex("Dense Jungle", "location-link-4948836791353344");
	public static MapVertex DenseJungle6 = new MapVertex("Dense Jungle", "location-link-6652731058028544");
	public static MapVertex DenseJungle3 = new MapVertex("Dense Jungle", "location-link-4538703854698496");
	public static MapVertex DenseJungle4 = new MapVertex("Dense Jungle", "location-link-5710106524123136");

	public static MapVertex TempleRuins = new MapVertex("Temple Ruins", "location-link-4742541412925440");
	public static MapVertex HighRoadDenseForest = new MapVertex("High Road: Dense Forest",
			"location-link-6708023485530112");
	public static MapVertex HighRoadForest = new MapVertex("High Road: Forest", "location-link-6664887786799104");
	public static MapVertex HighRoadWaterfall = new MapVertex("High Road: Waterfall", "location-link-5014172941156352");
	public static MapVertex HighRoadWaterfallClearing = new MapVertex("High Road: Waterfall Clearing",
			"location-link-6248509229498368");
	public static MapVertex HighRoadOgrePass = new MapVertex("High Road: Ogre Pass", "location-link-6231380530823168");
	public static MapVertex HighRoadForestLookout = new MapVertex("High Road: Forest Lookout",
			"location-link-4834678305456128");
	public static MapVertex HighRoadLake = new MapVertex("High Road: Lake", "location-link-5704313116557312");
	public static MapVertex VolantisRiver = new MapVertex("Volantis River", "location-link-5390881838333952");
	public static MapVertex VolantisCountryside = new MapVertex("Volantis Countryside",
			"location-link-6247590374932480");
	public static MapVertex Volantis = new MapVertex("Volantis", "location-link-5546617318932480");
	public static MapVertex SouthVolantisBeach = new MapVertex("South Volantis Beach",
			"location-link-4958687969935360");
	public static MapVertex SeasideLanding = new MapVertex("Seaside Landing", "location-link-6096717938163712");
	public static MapVertex CliffsideCoast = new MapVertex("Cliffside Coast", "location-link-4861326027390976");
	public static MapVertex WindingRiver = new MapVertex("Winding River", "location-link-5709261556416512");
	public static MapVertex WindingRiver2 = new MapVertex("Winding River", "location-link-5694096832200704");
	public static MapVertex WindingRiver3 = new MapVertex("Winding River", "location-link-5147963085029376");
	public static MapVertex WindingRiver7 = new MapVertex("Winding River", "location-link-6653464683741184");
	public static MapVertex WindingRiver4 = new MapVertex("Winding River", "location-link-6483513767362560");
	public static MapVertex WindingRiver5 = new MapVertex("Winding River", "location-link-4925241851641856");
	public static MapVertex WindingRiver6 = new MapVertex("Winding River", "location-link-5842926911356928");
	public static MapVertex ShadowySteppe = new MapVertex("Shadowy Steppe", "location-link-5560262966902784");
	public static MapVertex SelenePlateau = new MapVertex("Selene Plateau", "location-link-6015068596600832");
	public static MapVertex UmbraAbode = new MapVertex("Umbra Abode", "location-link-6553688768249856");
	public static MapVertex PerigeePeak = new MapVertex("Perigee Peak", "location-link-4607732636188672");
	public static MapVertex AphelionShrine = new MapVertex("Aphelion Shrine", "location-link-6276748270370816");
	public static MapVertex TrollCamp = new MapVertex("Troll Camp", "location-link-4765507982983168");
	public static MapVertex SuspiciousCombatsiteGiantTurtle = new MapVertex("Suspicious Combat site: Giant Turtle",
			"location-link-4509974331916288");
	public static MapVertex WildeburnForest = new MapVertex("Wildeburn Forest", "location-link-5155067514585088");
	public static MapVertex TaelhollowSwamp = new MapVertex("Taelhollow Swamp", "location-link-6044610405072896");
	public static MapVertex TaelhollowHut = new MapVertex("Taelhollow Hut", "location-link-5843284484161536");

	public static MapVertex HiddenTrail = new MapVertex("Hidden Trail", "location-link-5262209627717632");
	public static MapVertex BanditsLairEntrance = new MapVertex("Bandit's Lair Entrance",
			"location-link-6200435167199232");
	public static MapVertex AeraSwamplands = new MapVertex("Aera Swamplands", "location-link-5639445604728832");
	public static MapVertex GrandMountain = new MapVertex("Grand Mountain", "location-link-5659313586569216");
	public static MapVertex Desert = new MapVertex("Desert", "location-link-5654313976201216");
	public static MapVertex NorthMountainRange = new MapVertex("North Mountain Range",
			"location-link-5323223134633984");
	public static MapVertex BlackMountain = new MapVertex("Black Mountain", "location-link-5965801278406656");
	public static MapVertex HiddenPass = new MapVertex("Hidden Pass", "location-link-6571210251960320");
	public static MapVertex EasternDesert = new MapVertex("Eastern Desert", "location-link-5196041382002688");
	public static MapVertex EasternDesert2 = new MapVertex("Eastern Desert", "location-link-6000580091707392");
	public static MapVertex EasternDesert3 = new MapVertex("Eastern Desert", "location-link-6295812922408960");
	public static MapVertex EasternDesert4 = new MapVertex("Eastern Desert", "location-link-5312945761288192");
	public static MapVertex DeathValley = new MapVertex("Death Valley", "location-link-5942116728438784");
	public static MapVertex Oasis = new MapVertex("Oasis", "location-link-5286485966192640");
	public static MapVertex Spargus = new MapVertex("Spargus", "location-link-6306125748109312");
	public static MapVertex RestStop = new MapVertex("Rest Stop", "location-link-4792555382243328");
	public static MapVertex NorthernSpargusGate = new MapVertex("Northern Spargus Gate",
			"location-link-5205846171582464");
	public static MapVertex CityOutskirts = new MapVertex("City Outskirts", "location-link-5857622832971776");
	public static MapVertex SandyDesertPass = new MapVertex("Sandy Desert Pass", "location-link-6236159440060416");
	public static MapVertex RollingDunes = new MapVertex("Rolling Dunes", "location-link-4590542854815744");
	public static MapVertex RollingDunes2 = new MapVertex("Rolling Dunes", "location-link-5570836760100864");
	public static MapVertex RollingDunes3 = new MapVertex("Rolling Dunes", "location-link-5777231648391168");
	public static MapVertex RollingDunes4 = new MapVertex("Rolling Dunes", "location-link-5840939502272512");
	public static MapVertex RollingDunes5 = new MapVertex("Rolling Dunes", "location-link-5443293981704192");
	public static MapVertex RollingDunes6 = new MapVertex("Rolling Dunes", "location-link-5279071746392064");
	public static MapVertex RollingDunes7 = new MapVertex("Rolling Dunes", "location-link-6319154247237632");
	public static MapVertex RollingDunes8 = new MapVertex("Rolling Dunes", "location-link-6456087334092800");
	public static MapVertex SerpentPit = new MapVertex("Serpent Pit", "location-link-4597336033460224");
	public static MapVertex StrangeRockFormation = new MapVertex("Strange Rock Formation",
			"location-link-4618088644345856");
	public static MapVertex CalmCave = new MapVertex("Calm Cave", "location-link-6259323893186560");

	public static MapVertex NorthernVolantisCoastline = new MapVertex("Northern Volantis Coastline",
			"location-link-5963670924296192");
	public static MapVertex NorsMountain = new MapVertex("Nors Mountain", "location-link-4701732827299840");
	public static MapVertex GapingCave = new MapVertex("Gaping Cave", "location-link-6699801475284992");
	public static MapVertex SandSweptPlains = new MapVertex("Sand-Swept Plains", "location-link-6607074943303680");
	public static MapVertex NorsPlains = new MapVertex("Nors Plains", "location-link-6696628299759616");
	public static MapVertex KoboldSettlement = new MapVertex("Kobold Settlement", "location-link-6144503274536960");
	public static MapVertex VolantisDocks = new MapVertex("Volantis Docks", "location-link-6029236821295104");
	public static MapVertex FishermansSeasideCottage = new MapVertex("Fisherman's Seaside Cottage",
			"location-link-4969103341649920");
	public static MapVertex FishermansFerry = new MapVertex("Fisherman's Ferry", "location-link-4691376327884800");
	public static MapVertex FishermansFerry2 = new MapVertex("Fisherman's Ferry", "location-link-5683997762387968");
	public static MapVertex Maelstrom = new MapVertex("Maelstrom", "location-link-4557967676932096");
	public static MapVertex FishermansFerry3 = new MapVertex("Fisherman's Ferry", "location-link-6298913263321088");
	public static MapVertex AseridithIslandDocks = new MapVertex("Aseridith Island Docks",
			"location-link-4844226355396608");
	public static MapVertex AseridithFortNorthBeach = new MapVertex("Aseridith Fort North Beach",
			"location-link-6174236932571136");
	public static MapVertex AseridithFortWestBeach = new MapVertex("Aseridith Fort West Beach",
			"location-link-4736790432841728");
	public static MapVertex AseridithVillage = new MapVertex("Aseridith Village", "location-link-5882643281346560");
	public static MapVertex AseridithFortOuterWesternWalls = new MapVertex("Aseridith Fort Outer Western Walls",
			"location-link-6401380170334208");
	public static MapVertex AseridithFortSouthBeach = new MapVertex("Aseridith Fort South Beach",
			"location-link-6206475493965824");
	public static MapVertex AseridithFortOuterSouthernWalls = new MapVertex("Aseridith Fort Outer Southern Walls",
			"location-link-5688387279257600");
	public static MapVertex AseridithFortGates = new MapVertex("Aseridith Fort Gates",
			"location-link-4794925902200832");
	public static MapVertex AseridithFortOuterEasternWalls = new MapVertex("Aseridith Fort Outer Eastern Walls",
			"location-link-6211039030935552");
	public static MapVertex AseridithFortCourtyard = new MapVertex("Aseridith Fort Courtyard",
			"location-link-4942707271139328");
	public static MapVertex AseridithFortEastBeach = new MapVertex("Aseridith Fort East Beach",
			"location-link-6719807435046912");
	public static MapVertex AseridithFarmland = new MapVertex("Aseridith Farmland", "location-link-5227660768706560");
	public static MapVertex AseridithFortGuardtower = new MapVertex("Aseridith Fort Guardtower",
			"location-link-5974674766823424");
	public static MapVertex AseridithFortGuardtower2 = new MapVertex("Aseridith Fort Guardtower",
			"location-link-5484053941714944");
	public static MapVertex AseridithFortGuardtower3 = new MapVertex("Aseridith Fort Guardtower",
			"location-link-4622080312082432");
	public static MapVertex AseridithFortGuardtowerTop = new MapVertex("Aseridith Fort Guardtower Top",
			"location-link-4662926659026944");
	public static MapVertex ConcealedCavern = new MapVertex("Concealed Cavern", "location-link-4588220878946304");
	public static MapVertex ClawMarkedCavern = new MapVertex("Claw Marked Cavern", "location-link-5131795429588992");
	public static MapVertex TaelhollowSwampShrine = new MapVertex("Taelhollow Swamp Shrine",
			"location-link-4641884412575744");
	public static MapVertex CliffsideLookout = new MapVertex("Cliffside Lookout", "location-link-4752576599818240");
	public static MapVertex RockyPath = new MapVertex("Rocky Path", "location-link-4615707669037056");
	public static MapVertex MountainPlains = new MapVertex("Mountain Plains", "location-link-6530427779022848");
	public static MapVertex HermitCottage = new MapVertex("Hermit's Cottage", "location-link-5552457551708160");
	public static MapVertex HobgoblinTribeCampsite = new MapVertex("Hobgoblin Tribe Campsite",
			"location-link-6063976345501696");
	public static MapVertex ElvenGrove = new MapVertex("Elven Grove", "location-link-5954978829041664");
	public static MapVertex CricketonCaveEntrance = new MapVertex("Cricketon Cave Entrance", "location-link-6010831181971456");
	public static MapVertex CricketonCave = new MapVertex("Cricketon Cave", "location-link-5670665024176128");
	public static MapVertex UndergroundStream = new MapVertex("Underground Stream", "location-link-5848363793121280");
	public static MapVertex InfestedTunnel = new MapVertex("Infested Tunnel", "location-link-5668612348575744");
	public static MapVertex BaronCricketonsLair = new MapVertex("Baron Cricketon's Lair", "location-link-5313707255529472");
	public static MapVertex KujirMarshEntrance = new MapVertex("Kujir Marsh Entrance", "location-link-5179062473457664");
	public static MapVertex KujirMarsh = new MapVertex("Kujir Marsh", "location-link-5157785138364416");
	public static MapVertex KujirMarsh2 = new MapVertex("Kujir Marsh", "location-link-5262537041903616");
	public static MapVertex KujirMarsh3 = new MapVertex("Kujir Marsh", "location-link-5634233376702464");
	public static MapVertex KujirMarsh4 = new MapVertex("Kujir Marsh", "location-link-6608541406199808");
	public static MapVertex LizardfolkMarshland = new MapVertex("Lizardfolk Marshland", "location-link-4675290055835648");
	public static MapVertex LizardfolkMarshland2 = new MapVertex("Lizardfolk Marshland", "location-link-5369435355348992");
	public static MapVertex LizardfolkMarshland3 = new MapVertex("Lizardfolk Marshland", "location-link-6503793394974720");
	public static MapVertex HiddenPath = new MapVertex("Hidden Path", "location-link-6304554086039552");
	public static MapVertex CalmPond = new MapVertex("Calm Pond", "location-link-4574231350476800");
	public static MapVertex LizardkingHideout = new MapVertex("Lizardking Hideout", "location-link-5662987243225088");
	public static MapVertex LizardkingDen = new MapVertex("Lizardking Den", "location-link-5732417268613120");
	public static MapVertex AphelionShrineInterior = new MapVertex("Aphelion Shrine Interior", "location-link-6280283730477056");
	public static MapVertex AphelionShrineSanctum = new MapVertex("Aphelion Shrine Sanctum", "location-link-5855864457527296");
	public static MapVertex AphelionShrineInnerSanctum = new MapVertex("Aphelion Shrine Inner Sanctum", "location-link-5332609262944256");
	public static MapVertex AphelionShrineRepository = new MapVertex("Aphelion Shrine Repository", "location-link-4639225850363904");
	public static MapVertex AphelionShrineArchives = new MapVertex("Aphelion Shrine Archives", "location-link-5656414564909056");
	public static MapVertex ArtiusRiver = new MapVertex("Artius River", "location-link-6521777110908928");
	public static MapVertex ArtiusLane = new MapVertex("Artius Lane", "location-link-4891495303741440");
	public static MapVertex MistyForest = new MapVertex("Misty Forest", "location-link-5164584575172608");
	public static MapVertex MistyMountainsBasin = new MapVertex("Misty Mountains Basin", "location-link-5234434534277120");
	public static MapVertex MistyMountainPass = new MapVertex("Misty Mountain Pass", "location-link-6451896701419520");
	public static MapVertex SteepMountainPath = new MapVertex("Steep Mountain Path", "location-link-5191466372825088");
	public static MapVertex LookoutPoint = new MapVertex("Lookout Point", "location-link-5656451226009600");
	public static MapVertex XarukForest = new MapVertex("Xaruk Forest", "location-link-5412534060580864");
	public static MapVertex XarukForest2 = new MapVertex("Xaruk Forest", "location-link-5557842132336640");
	public static MapVertex XarukForest3 = new MapVertex("Xaruk Forest", "location-link-4535180153061376");
	public static MapVertex XarukForest4 = new MapVertex("Xaruk Forest", "location-link-6373434477248512");
	public static MapVertex XarukForest5 = new MapVertex("Xaruk Forest", "location-link-5854320235118592");
	public static MapVertex XarukForest6 = new MapVertex("Xaruk Forest", "location-link-5174341147033600");
	public static MapVertex Xaruk = new MapVertex("Xaruk", "location-link-4905123335897088");
	public static MapVertex GreatGoblinFortressofXaruk = new MapVertex("Great Goblin Fortress of Xaruk", "location-link-4939142698106880");
	public static MapVertex FortressEntrance = new MapVertex("Fortress Entrance", "location-link-5978911666339840");
	public static MapVertex MainCorridor = new MapVertex("Main Corridor", "location-link-6426849307787264");
	public static MapVertex GuardTower = new MapVertex("Guard Tower", "location-link-5266136275091456");
	public static MapVertex Barracks = new MapVertex("Barracks", "location-link-4993749247852544");
	public static MapVertex Armory = new MapVertex("Armory", "location-link-6154168545050624");
	public static MapVertex GeneralsQuarters = new MapVertex("General's Quarters", "location-link-5820272351641600");
	public static MapVertex MessHall = new MapVertex("Mess Hall", "location-link-5350034434686976");
	public static MapVertex Pantry = new MapVertex("Pantry", "location-link-4790552935792640");
	public static MapVertex HiddenStaircase = new MapVertex("Hidden Staircase", "location-link-6192307049332736");
	public static MapVertex MassiveCavern = new MapVertex("Massive Cavern", "location-link-5911244389482496");
	public static MapVertex TranquilChamber = new MapVertex("Tranquil Chamber", "location-link-5032945924702208");
	public static MapVertex CinderPlains = new MapVertex("Cinder Plains", "location-link-5175898320928768");
	public static MapVertex DriedLakebed = new MapVertex("Dried Lakebed", "location-link-6415179777572864");
	public static MapVertex WindyExpanse = new MapVertex("Windy Expanse", "location-link-6078391494115328");
	public static MapVertex CinderMountainRange = new MapVertex("Cinder Mountain Range", "location-link-4692368319053824");
	public static MapVertex SmolderingMountain = new MapVertex("Smoldering Mountain", "location-link-5549152453787648");
	public static MapVertex CoreofSmolderingMountain = new MapVertex("Core of Smoldering Mountain", "location-link-5822375170932736");
	public static MapVertex GuardianoftheCore = new MapVertex("Guardian of the Core", "location-link-5325435842330624");
	public static MapVertex SmolderingMountainAscent = new MapVertex("Smoldering Mountain Ascent", "location-link-6166816767344640");
	public static MapVertex SmolderingMountainPeak = new MapVertex("Smoldering Mountain Peak", "location-link-5115476184137728");
	public static MapVertex CrumblingTemple = new MapVertex("Crumbling Temple", "location-link-5489507564781568");
	//public static MapVertex AtlasTrailEntrance = new MapVertex("Atlas Trail Entrance", "location-link-6742305497677824");
	public static MapVertex AseridithFortCourtyard2 = new MapVertex("Aseridith Fort Courtyard", "location-link-4682133618556928");
	public static MapVertex AseridithFortInnerGate = new MapVertex("Aseridith Fort Inner Gate", "location-link-5471573840494592");
	public static MapVertex AseridithFortBarracks = new MapVertex("Aseridith Fort Barracks", "location-link-4682816811958272");
	public static MapVertex AseridithFortTower = new MapVertex("Aseridith Fort Tower", "location-link-4767886398717952");
	public static MapVertex AseridithFortTower2 = new MapVertex("Aseridith Fort Tower", "location-link-5437646551646208");
	public static MapVertex AseridithKeepGates = new MapVertex("Aseridith Keep Gates", "location-link-6356537624756224");
	public static MapVertex AseridithCommandersQuarters = new MapVertex("Aseridith Commander's Quarters", "location-link-6638873742409728");
	public static MapVertex AseridithFortLibrary = new MapVertex("Aseridith Fort Library", "location-link-6374066191597568");
	public static MapVertex AseridithKeepHallway = new MapVertex("Aseridith Keep Hallway", "location-link-5755749009457152");
	public static MapVertex AseridithKeepGrandHall = new MapVertex("Aseridith Keep Grand Hall", "location-link-5664073469394944");
	public static MapVertex AseridithKnightsQuarters = new MapVertex("Aseridith Knights' Quarters", "location-link-5638699607916544");
	public static MapVertex AseridithKeepKitchen = new MapVertex("Aseridith Keep Kitchen", "location-link-5091279719366656");
	public static MapVertex TowerEntrance = new MapVertex("Tower Entrance", "location-link-5343021269778432");
	public static MapVertex DarkCorridor = new MapVertex("Dark Corridor", "location-link-6128325270437888");
	public static MapVertex LongHallway = new MapVertex("Long Hallway", "location-link-6555136169082880");
	public static MapVertex SlumberChambers = new MapVertex("Slumber Chambers", "location-link-6546560360906752");
	public static MapVertex ApprenticeTrainingRoom = new MapVertex("Apprentice Training Room", "location-link-5345871483895808");
	public static MapVertex FirstFloorStaircase = new MapVertex("First Floor Staircase", "location-link-6633339873132544");
	public static MapVertex SecondFloorLanding = new MapVertex("Second Floor Landing", "location-link-5909134097514496");
	public static MapVertex CommonArea = new MapVertex("Common Area", "location-link-5966873809125376");
	public static MapVertex EastLibrary = new MapVertex("East Library", "location-link-6571276102533120");
	public static MapVertex PotionsLaboratory = new MapVertex("Potions Laboratory", "location-link-4611092757086208");
	public static MapVertex WestLibrary = new MapVertex("West Library", "location-link-4571571273334784");
	public static MapVertex SummoningChamber = new MapVertex("Summoning Chamber", "location-link-6293882619822080");
	public static MapVertex NarrowPassageway = new MapVertex("Narrow Passageway", "location-link-5033469437542400");
	public static MapVertex SecondFloorStaircase = new MapVertex("Second Floor Staircase", "location-link-5120374762110976");
	public static MapVertex HerbGarden = new MapVertex("Herb Garden", "location-link-4898631959183360");
	public static MapVertex ThirdFloorLanding = new MapVertex("Third Floor Landing", "location-link-4514844928638976");
	public static MapVertex Observatory = new MapVertex("Observatory", "location-link-6320860490104832");
	public static MapVertex AstronomyAlcove = new MapVertex("Astronomy Alcove", "location-link-5056795243446272");
	public static MapVertex SecretPassage = new MapVertex("Secret Passage", "location-link-6018852616929280");
	public static MapVertex GrandStudy = new MapVertex("Grand Study", "location-link-4686268414820352");
	public static MapVertex AlchemistQuarters = new MapVertex("Alchemist Quarters", "location-link-4967743391531008");
	public static MapVertex ThirdFloorStaircase = new MapVertex("Third Floor Staircase", "location-link-5444270617001984");
	public static MapVertex FourthFloorLanding = new MapVertex("Fourth Floor Landing", "location-link-4942150822264832");
	public static MapVertex StrangeEmptyRoom = new MapVertex("Strange Empty Room", "location-link-4732909075300352");
	public static MapVertex StrangeEmptyRoom2 = new MapVertex("Strange Empty Room", "location-link-5423123405996032");
	public static MapVertex StrangeEmptyRoom3 = new MapVertex("Strange Empty Room", "location-link-5052322102116352");
	public static MapVertex ArchmagesQuarters = new MapVertex("Archmage's Quarters", "location-link-4579063346757632");
	public static MapVertex Armory2 = new MapVertex("Armory", "location-link-6343937617821696");
	public static MapVertex PortalRoom = new MapVertex("Portal Room", "location-link-6646234595983360");
	public static MapVertex DeepHallway = new MapVertex("Deep Hallway", "location-link-4570683332100096");
	public static MapVertex SmolderingCave = new MapVertex("Smoldering Cave", "location-link-4653878727671808");
	public static MapVertex DescendingPath = new MapVertex("Descending Path", "location-link-5401323833131008");
	public static MapVertex StoneGateway = new MapVertex("Stone Gateway", "location-link-5988606386896896");
	public static MapVertex Inferno = new MapVertex("Inferno", "location-link-6296544267730944");
	public static MapVertex SacredEarthTemple = new MapVertex("Sacred Earth Temple", "location-link-5737697887125504");
	public static MapVertex EchoingScream = new MapVertex("Echoing Scream", "location-link-4713471130468352");
	public static MapVertex FortEntrance = new MapVertex("Fort Entrance", "location-link-5641414744735744");
	public static MapVertex PlaceofWorship = new MapVertex("Place of Worship", "location-link-5643282518638592");
	public static MapVertex OldFortLanding = new MapVertex("Old Fort Landing", "location-link-6479514865762304");
	public static MapVertex FortJunction = new MapVertex("Fort Junction", "location-link-5502093454737408");
	public static MapVertex SacredAirTemple = new MapVertex("Sacred Air Temple", "location-link-6374377128198144");
	public static MapVertex OuterStairs = new MapVertex("Outer Stairs", "location-link-5554385595924480");
	public static MapVertex CrumblingStoneStairs = new MapVertex("Crumbling Stone Stairs", "location-link-5412955141439488");
	public static MapVertex ColumnedRoom = new MapVertex("Columned Room", "location-link-6409023085871104");
	public static MapVertex Aviary = new MapVertex("Aviary", "location-link-6374199491035136");
	public static MapVertex WesternCarvedHallway = new MapVertex("Western Carved Hallway", "location-link-4846510158381056");
	public static MapVertex MoonRoom = new MapVertex("Moon Room", "location-link-6633080255414272");
	public static MapVertex RedCliffs = new MapVertex("Red Cliffs", "location-link-5130593837776896");
	public static MapVertex RedCliffsEdge = new MapVertex("Red Cliff's Edge", "location-link-5005307494268928");
	public static MapVertex LostSeaShore = new MapVertex("Lost Sea Shore", "location-link-5940601584353280");
	public static MapVertex LostSea = new MapVertex("Lost Sea", "location-link-6412108060164096");
	public static MapVertex LostSea2 = new MapVertex("Lost Sea", "location-link-5934960010592256");
	public static MapVertex LostSea3 = new MapVertex("Lost Sea", "location-link-6061716843528192");
	public static MapVertex LostSea4 = new MapVertex("Lost Sea", "location-link-5498766890106880");
	public static MapVertex EmeraldIsle = new MapVertex("Emerald Isle", "location-link-4722354780372992");
	public static MapVertex EmeraldIsleShores = new MapVertex("Emerald Isle Shores", "location-link-5563011707174912");
	public static MapVertex AirTempleEntrance = new MapVertex("Air Temple Entrance", "location-link-5207734087843840");
	public static MapVertex EastSingedCorridor = new MapVertex("East Singed Corridor", "location-link-4820048596434944");
	public static MapVertex MainCorridor2 = new MapVertex("Main Corridor", "location-link-6293571680600064");
	public static MapVertex WestSingedCorridor = new MapVertex("West Singed Corridor", "location-link-6548218144096256");
	public static MapVertex SmokyAntechamber = new MapVertex("Smoky Antechamber", "location-link-6369300745289728");
	public static MapVertex DarkStairway = new MapVertex("Dark Stairway", "location-link-5538510524383232");
	public static MapVertex RedCrypt = new MapVertex("Red Crypt", "location-link-5766967015505920");
	public static MapVertex HeatFilledAscent = new MapVertex("Heat Filled Ascent", "location-link-6330365524574208");
	public static MapVertex VolcanicAntechamber = new MapVertex("Volcanic Antechamber", "location-link-6307657495609344");
	public static MapVertex SacredFireTemple = new MapVertex("Sacred Fire Temple", "location-link-5383160684871680");
	public static MapVertex LavaTube = new MapVertex("Lava Tube", "location-link-5253281410711552");
	public static MapVertex Savannah = new MapVertex("Savannah", "location-link-4749318969884672");
	public static MapVertex Perch = new MapVertex("Perch", "location-link-5346745116786688");
	public static MapVertex AbandonedHut = new MapVertex("Abandoned Hut", "location-link-5287898427686912");
	public static MapVertex AbandonedHutInterior = new MapVertex("Abandoned Hut Interior", "location-link-5051020109676544");
	public static MapVertex PerchStairwell = new MapVertex("Perch Stairwell", "location-link-5696214291185664");
	public static MapVertex ArchersPerch = new MapVertex("Archer's Perch", "location-link-5091225701187584");
	public static MapVertex WastelandOverlook = new MapVertex("Wasteland Overlook", "location-link-6062193298636800");
	public static MapVertex AbandondedTribalCamp = new MapVertex("Abandonded Tribal Camp", "location-link-5760751882993664");
	public static MapVertex HutInterior = new MapVertex("Hut Interior", "location-link-5192207395192832");
	public static MapVertex HuntersChamber = new MapVertex("Hunter's Chamber", "location-link-5283392637894656");
	public static MapVertex ThatchedShelter = new MapVertex("Thatched Shelter", "location-link-5193938233458688");
	public static MapVertex VallAVillage = new MapVertex("Vall'A Village", "location-link-4867564377210880");
	public static MapVertex StoreRoom = new MapVertex("Store Room", "location-link-6365055958646784");
	public static MapVertex TanningHut = new MapVertex("Tanning Hut", "location-link-6414020062216192");
	public static MapVertex Ziggurat = new MapVertex("Ziggurat", "location-link-5985509765808128");
	public static MapVertex RootCellar = new MapVertex("Root Cellar", "location-link-6672569510133760");
	public static MapVertex KeeperOfTheFlame = new MapVertex("Keeper Of The Flame", "location-link-5476955841626112");
	public static MapVertex AromaticChamber = new MapVertex("Aromatic Chamber", "location-link-5824814302625792");
	public static MapVertex PriestessChamber = new MapVertex("Priestess Chamber", "location-link-4878355516096512");
	public static MapVertex StoneAlcove = new MapVertex("Stone Alcove", "location-link-5264397440385024");
	public static MapVertex ForbiddenForest = new MapVertex("Forbidden Forest", "location-link-6041514953146368");
	public static MapVertex AbandonedHut2 = new MapVertex("Abandoned Hut", "location-link-5429680583737344");
	public static MapVertex DeadJungles = new MapVertex("Dead Jungles", "location-link-4703217505009664");
	public static MapVertex TomboftheFallen = new MapVertex("Tomb of the Fallen", "location-link-4516897327415296");
	public static MapVertex Stairwell = new MapVertex("Stairwell", "location-link-4922705701765120");
	public static MapVertex TombEntrance = new MapVertex("Tomb Entrance", "location-link-4765966608105472");
	public static MapVertex TombCenter = new MapVertex("Tomb Center", "location-link-5612169386262528");
	public static MapVertex EmbalmingRoom = new MapVertex("Embalming Room", "location-link-4558049120354304");
	public static MapVertex BurialHall = new MapVertex("Burial Hall", "location-link-5077797692243968");
	public static MapVertex LongHallway2 = new MapVertex("Long Hallway", "location-link-5037373275504640");
	public static MapVertex ShrineofNaKareth = new MapVertex("Shrine of Na'Kareth", "location-link-5817171396526080");
	public static MapVertex SpiderCaveCavern = new MapVertex("Spider Cave Cavern", "location-link-5967326629330944");
	public static MapVertex DeathlyForest = new MapVertex("Deathly Forest", "location-link-5005335471325184");
	public static MapVertex Camp = new MapVertex("Camp", "Default");
	public static MapVertex DescendingPit = new MapVertex("Descending Pit", "location-link-4710088709505024");
	public static MapVertex GlowingAscent = new MapVertex("Glowing Ascent", "location-link-6700276025393152");
	public static MapVertex BriefRespite = new MapVertex("Brief Respite", "location-link-5639120737271808");
	public static MapVertex ShadowTempleEntrance = new MapVertex("Shadow Temple Entrance", "location-link-5466145492828160");
	public static MapVertex Labyrinth = new MapVertex("Labyrinth", "location-link-6716521873408000");
	public static MapVertex Labyrinth2 = new MapVertex("Labyrinth", "location-link-5396784992223232");
	public static MapVertex Labyrinth3 = new MapVertex("Labyrinth", "location-link-6338009626836992");
	public static MapVertex Labyrinth4 = new MapVertex("Labyrinth", "location-link-6582000813342720");
	public static MapVertex Labyrinth5 = new MapVertex("Labyrinth", "location-link-6517358736965632");
	public static MapVertex Labyrinth6 = new MapVertex("Labyrinth", "location-link-4570275175989248");
	
	
	public static MapVertex AtlasTrailEntrance = new MapVertex("Atlas Trail Entrance", "location-link-5124605528768512");
	public static MapVertex JachumsSteps = new MapVertex("Jachum's Steps", "location-link-4713648428154880");
	public static MapVertex GrandTreeArch = new MapVertex("Grand Tree Arch", "location-link-5169038100004864");
	public static MapVertex RiverRockRoad = new MapVertex("River Rock Road", "location-link-6689992051523584");
	public static MapVertex TrailHead = new MapVertex("Trail Head", "location-link-6491840832864256");
	public static MapVertex SapphireWay = new MapVertex("Sapphire Way", "location-link-6479938689957888");
	public static MapVertex RasheekPlains = new MapVertex("Rasheek Plains", "location-link-5130714677248000");
	public static MapVertex EvergreenTrail = new MapVertex("Evergreen Trail", "location-link-4634198741090304");
	public static MapVertex DarkWoodPass = new MapVertex("Dark Wood Pass", "location-link-5493588075479040");
	public static MapVertex BloodForest = new MapVertex("Blood Forest", "location-link-6255519904301056");
	public static MapVertex HollowForestWalk = new MapVertex("Hollow Forest Walk", "location-link-6111182702772224");
	public static MapVertex CrystalLake = new MapVertex("Crystal Lake", "location-link-6519651913170944");
	public static MapVertex Ferry = new MapVertex("Ferry", "location-link-5895074189672448");
	public static MapVertex Ferry2 = new MapVertex("Ferry", "location-link-5512146850938880");
	public static MapVertex Ferry3 = new MapVertex("Ferry", "location-link-6730044487499776");
	public static MapVertex Ferry4 = new MapVertex("Ferry", "location-link-4543108142333952");
	public static MapVertex EridisIsland = new MapVertex("Eridis Island", "location-link-5151329668300800");
	public static MapVertex EridisShores = new MapVertex("Eridis Shores", "location-link-5343295379079168");
	public static MapVertex TheBay = new MapVertex("The Bay", "location-link-6684012370198528");
	public static MapVertex EridisForest = new MapVertex("Eridis Forest", "location-link-5709056673054720");
	public static MapVertex EridisForest2 = new MapVertex("Eridis Forest", "location-link-5687441444831232");
	public static MapVertex EridisClimb = new MapVertex("Eridis Climb", "location-link-6495208090894336");
	public static MapVertex EridisPeak = new MapVertex("Eridis Peak", "location-link-5558112463355904");
	public static MapVertex EridisLake = new MapVertex("Eridis Lake", "location-link-4725749210677248");
	public static MapVertex SunkenTemple = new MapVertex("Sunken Temple", "location-link-5675991555112960");
	public static MapVertex WaterLoggedTunnel = new MapVertex("Water Logged Tunnel", "location-link-5003775217762304");
	public static MapVertex TunnelDescent = new MapVertex("Tunnel Descent", "location-link-4917842116083712");
	public static MapVertex UnderwaterPit = new MapVertex("Underwater Pit", "location-link-6335629946519552");
	public static MapVertex Sludge = new MapVertex("Sludge", "location-link-5762160947101696");
	public static MapVertex UnderwaterChapel = new MapVertex("Underwater Chapel", "location-link-6517666900869120");
	public static MapVertex HolySanctum = new MapVertex("Holy Sanctum", "location-link-5184155254259712");
	public static MapVertex HolyRefuge = new MapVertex("Holy Refuge", "location-link-6689286277824512");
	public static MapVertex PillaredGrotto = new MapVertex("Pillared Grotto", "location-link-6568383753748480");
	public static MapVertex SacredWaterTemple = new MapVertex("Sacred Water Temple", "location-link-4718704816553984");
	public static MapVertex BlackForest = new MapVertex("Black Forest", "location-link-5806063024603136");
	public static MapVertex FortBlack = new MapVertex("Fort Black", "location-link-5381036013780992");
	public static MapVertex FortBlackThroneRoom = new MapVertex("Fort Black - Throne Room", "location-link-6477065496821760");
	public static MapVertex FortBlackPanicRoom = new MapVertex("Fort Black - Panic Room", "location-link-6139491171434496");
	public static MapVertex MilitaryArchives = new MapVertex("Military Archives", "location-link-5828971201822720");
	public static MapVertex CrumblingWall = new MapVertex("Crumbling Wall", "location-link-5788644327817216");
	public static MapVertex HallowedForestWalk = new MapVertex("Hallowed Forest Walk", "location-link-5790973206724608");
	public static MapVertex HallowedForestWalk2 = new MapVertex("Hallowed Forest Walk", "location-link-5645550445920256");
	public static MapVertex RangerOutpostSoutheast = new MapVertex("Ranger Outpost Southeast", "location-link-4879798847668224");
	public static MapVertex RangerOutpostSouthwest = new MapVertex("Ranger Outpost Southwest", "location-link-4784388028235776");
	public static MapVertex RangerOutpostNorthwest = new MapVertex("Ranger Outpost Northwest", "location-link-4946723363618816");
	public static MapVertex RangerOutpostNortheast = new MapVertex("Ranger Outpost Northeast", "location-link-6303568225370112");
	public static MapVertex ForestBunkhouse = new MapVertex("Forest Bunkhouse", "location-link-6116163232989184");
	public static MapVertex WatersEdge = new MapVertex("Water's Edge", "location-link-5702427355643904");
	public static MapVertex ConcealedFortApproach = new MapVertex("Concealed Fort Approach", "location-link-5041895812366336");
	public static MapVertex FortWall = new MapVertex("Fort Wall", "location-link-6026338488287232");
	public static MapVertex FortBridge = new MapVertex("Fort Bridge", "location-link-5650353628643328");
	public static MapVertex ConcealedFortGate = new MapVertex("Concealed Fort Gate", "location-link-4817775493382144");
	public static MapVertex ConcealedFortCourtyard = new MapVertex("Concealed Fort Courtyard", "location-link-5225694374395904");
	public static MapVertex ValorsRise = new MapVertex("Valor's Rise", "location-link-6743136049299456");
	public static MapVertex ValorsRise2 = new MapVertex("Valor's Rise", "location-link-5332349418209280");
	public static MapVertex ValorsPeak = new MapVertex("Valor's Peak", "location-link-6674550068871168");
	public static MapVertex GoldenHall = new MapVertex("Golden Hall", "location-link-6067571910770688");
	public static MapVertex HallofDeities = new MapVertex("Hall of Deities", "location-link-6229788530573312");
	public static MapVertex DeitiesStretch = new MapVertex("Deities Stretch", "location-link-5698364442411008");
	
	//public static MapVertex Spargus = new MapVertex("Spargus", "");
	
	
	static String GraceOfLLKalet = "https://initium-resources.appspot.com/images/small/Pixel_Art-Armor-Helms-Metal12.png";
	static String ReallyGreatClub = "https://initium-resources.appspot.com/images/small/Pixel_Art-Weapons-Clubs-Clubs2.png";
	static String Thorn = "https://initium-resources.appspot.com/images/small/Pixel_Art-Weapons-Daggers-Ornate-Ornate6.png";
	static String PythonScale = "https://initium-resources.appspot.com/images/small/Pixel_Art-Clothing-Vest01a.png";
	static String Crusader = "https://initium-resources.appspot.com/images/small2/Pixel_Art-Armor-Chest-Crusader.png";
	static String SufferingsEnd = "https://initium-resources.appspot.com/images/small/Pixel_Art-Armor-Gloves-Ac_Gloves07.png";
	static String SevenLeagueBoots = "https://initium-resources.appspot.com/images/small2/Pixel_Art-Armor-Boots-Black-Leather-01.png";
	static String ShieldOfEvalach = "https://initium-resources.appspot.com/images/small2/Pixel_Art-Armor-Red-White-Kite-Shield.png"; 
	static String FinalFavor = "https://initium-resources.appspot.com/images/small/Pixel_Art-Shields-Tower-Tower3.png";
	static String SledgeandSlaughter = "https://initium-resources.appspot.com/images/small3/Pixel_Art_Weapon_Siege_Slaughter.gif";
	static String MoltenBlade = "https://initium-resources.appspot.com/images/small2/Pixel_Art-Weapon-Moltenblade.png";
	static String FuryOfX = "https://initium-resources.appspot.com/images/small2/Pixel_Art-Weapons-Macuahuitl.png";
	static String Malediction = "https://initium-resources.appspot.com/images/small2/Pixel_Art-Weapons-Epic_Bow_Alternate.png";
	static String FatesCall = "https://initium-resources.appspot.com/images/small2/Pixel_Art-Weapon-Fates-Call-New.png";
	static String Retribution = "https://initium-resources.appspot.com/images/small/Pixel_Art-Weapons-Hammers-W_Gold_Mace.png";
	static String BlackBlade = "https://initium-resources.appspot.com/images/small/Pixel_Art-Weapons-Swords-Ornate-Ornate9.png";
	static String FnF = "https://initium-resources.appspot.com/images/small2/Pixel-Art-Weapon-Epic-Dual-Swords.png";
	static String BloodWand = "https://initium-resources.appspot.com/images/small2/Pixel_Art-Weapon-KiirtoSLoTH.png";
	static String TeraMund = "https://initium-resources.appspot.com/images/small3/Pixel_Art-Weapon-Epic-TerraMunda.png";
	static String MagnaClava = "https://initium-resources.appspot.com/images/small2/Pixel-Art-Weapon-Epic-Small-Wooden-Club.png";
	static String Instrament = "https://initium-resources.appspot.com/images/small3/Pixel-Art-Weapon-Instruments-Epic.png";
	static String Hailstorm = "https://initium-resources.appspot.com/images/small2/Pixel_Art-Weapon-Hailstorm_Epic_Battleaxe.png";
	static String Gundir = "https://initium-resources.appspot.com/images/small2/Pixel_Art-Weapon-Epic-Gungnir001.png";
	static String BearHands = "https://initium-resources.appspot.com/images/small/Pixel_Art-Weapons-Other-Natural-Natural6.png";
	static String Aurora = "https://initium-resources.appspot.com/images/small3/Pixel_Art-Weapon-Epic-Aurora.png";
	static String Anemos = "https://initium-resources.appspot.com/images/small3/Pixel_Art-Weapon-Epic-AnemosAlt.png";
	static String GraveAxe = "https://initium-resources.appspot.com/images/small2/Pixel_Art-Weapons-Axes-GKA.png";

	public static String[] epicList = {GraveAxe, GraceOfLLKalet, ReallyGreatClub, Thorn, PythonScale, Crusader
			, SufferingsEnd,SevenLeagueBoots,ShieldOfEvalach,SledgeandSlaughter, MoltenBlade, FuryOfX, Malediction, FatesCall,
			Retribution,BlackBlade,FnF,BloodWand,TeraMund ,MagnaClava ,Instrament,
			Hailstorm,Gundir ,BearHands,Aurora ,Anemos, FinalFavor};
	
/*	public static List<MapVertex> thornLocations = new ArrayList<MapVertex>(
			Arrays.asList(HighRoadDenseForest, HighRoadForest, HighRoadWaterfallClearing, HighRoadWaterfall));

	public static List<MapVertex> swampProtLocations = new ArrayList<MapVertex>(
			Arrays.asList(TaelhollowSwamp, WildeburnForest));*/
	public static int viableGear = 0;
	public static List<MapVertex> targetLocations = null;
	public static Map<String, Item> itemTags = new HashMap<String, Item>();
	
	public static WebDriver driver;
	public static WebDriver itemDriver;
	public static JavascriptExecutor js;
	public static String mainWindow;
	public static String itemWindow;
	public static DefaultDirectedGraph<MapVertex, DefaultEdge> map;
	public static DijkstraShortestPath<MapVertex, DefaultEdge> pathFinder;
	public static Set<MapVertex> restStops;
	public static Set<String> mobs = new HashSet<String>(Arrays.asList("Lunar Magistrate"
			, "Desert Python", "Skeletal Duelist", "Kobold Archer", "Juvenile Turtlespawn"
			, "Aseridith Shieldbearer", "Aseridith Squire", "Kobold", "Sahuagin Captain"
			, "Lizardfolk Soldier", "Xarukian Captain", "Thaumaturge", "Skeletal Commander"
			, "Spectre"));
	
	public static Set<String> forget = new HashSet<String>(Arrays.asList("Lizardfolk Hunter", "Bronze Dragon", "Black Dragon"
			, "Aseridith Guard", "Aseridith Soldier", "Aseridith Archer", "Panther", "Thief", "Brigand", "Skeletal Scout"
			, "Nomad Scout", "Hobgoblin Hunter", "Pit Viper", "Virulent Scorpion", "Giant Scorpion", "Made in China"
			, "Tarantula", "Giant Tarantula", "Desert Bandit", "Cyclops", "Burrowing Monster", "Cockatrice"
			, "Vengeful Wraith", "Earth Elemental", "Drow Scout", "Xarukian Soldier", "Xarukian Guard", "Xarukian Archer"
			, "Lunar Guard", "Lunar Fanatic", "Lunar Worshipper", "Crazed Lunar Worshipper", "Rattlesnake", "Aseridith Sorcerer"
			, "Aseridith Elder Sorcerer", "Skeletal Warrior", "Acolyte", "Aseridian Valkyrie", "Aseridian Monk", "Insane Adventurer"
			, "Ogre", "Shell Troll", "Troll", "Spear Troll", "Kappa", "Crocodile", "Giant Frog", "Giant Mutant Eel", "Orc Captain"));
	
	public static String damageType = Item.BLUDGEONING;
	public static String armorType = Item.PIERCING;
	public static boolean twoHanded = false;
	public static boolean fightAll = false;
	public static Account act = null;
	public static Set<String> brokenNotices = new HashSet<String>();
	
	public static String keepItems = "Diamond and Arena and Emerald and Ruby and Sapphire"
			+ " and Key and Carrot and Strawberry and Ornate Reliquary and Topaz and Raw Meat"
			+ " and Unicorn Meat and Raw Fish and Fire Crystal and Wind Crystal and Water Crystal"
			+ " and Earth Crystal";
	
	public static void sleep(double seconds) {
		try {
			Thread.sleep((long) (seconds * 1000));
		} catch (Exception e) {
			System.out.println("Sleep function threw an exception");
		}
	}
	
	public static void clickCharacterSwitcher() {
		wait = new WebDriverWait(driver, 10);
		WebElement charButton;
		while (true) {
			try {
				charButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("character-switcher")));
				charButton.click();
				break;
			} catch (Exception e) {
				System.out.println("Character Switcher could not locate element");
				System.out.println(e.getMessage());
				System.out.println(" \n End of Error message \n \n \n ");
				sleep(.5);
			}
		}
	}
	
	public static MapVertex getCur() {
		MapVertex curLocation;
		wait = new WebDriverWait(driver, 10);
		while (true) {
			try {
				if (!alive()) {
					return Death;
				}
				String curLocationName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("locationName")))
						.getText();
				if (curLocationName.equals("Dense Jungle")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(0).getAttribute("class");
					String id2;
					
					try {id2 = path.get(1).getAttribute("class");
					} catch (Exception e) {id2 = "Farts";}
					
					if (id2.equals(Access.HighRoadSwampland.id)) {
						curLocation = DenseJungle;
					} else if (id.equals(DenseJungle.id)) {
						curLocation = DenseJungle2;
					} else if (id.equals(DenseJungle4.id)) {
						curLocation = DenseJungle3;
					} else if (id2.equals(DenseJungle5.id)) {
						curLocation = DenseJungle4;
					} else if (id.equals(DenseJungle2.id)) {
						curLocation = DenseJungle5;
					} else if (id.equals(DenseJungle5.id)) {
						curLocation = DenseJungle6;
					} else {
						System.out.println("Where the heck am i ");
						curLocation = DenseJungle;
					}
					return curLocation;
				} else if (curLocationName.equals("Winding River")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(0).getAttribute("class");
					
					String id2;
					try {id2 = path.get(1).getAttribute("class");}
					catch (Exception e) {id2 = "Farts";}
					
					String id3;
					try {id3 = path.get(2).getAttribute("class");}
					catch (Exception e) {id3 = "Farts";}
					List<String> ids = Arrays.asList(id, id2, id3);
					
					if (ids.contains(CliffsideCoast.id)) {
						curLocation = WindingRiver;
					} else if (ids.contains(WindingRiver.id)) {
						curLocation = WindingRiver2;
					} else if (ids.contains(WindingRiver2.id)) {
						curLocation = WindingRiver3;
					} else if (ids.contains(WindingRiver3.id) && !ids.contains(ShadowySteppe.id)) {
						curLocation = WindingRiver4;
					} else if (ids.contains(WindingRiver4.id)) {
						curLocation = WindingRiver5;
					} else if (ids.contains(WindingRiver5.id)) {
						curLocation = WindingRiver6;
					} else if (ids.contains(WindingRiver3.id)) {
						curLocation = WindingRiver7;
					} else {
						System.out.println("Winding river not found");
						curLocation = WindingRiver;
					}
					
					return curLocation;
				} else if (curLocationName.equals("Eastern Desert")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(1).getAttribute("class");
					if (id.equals(EasternDesert.id)) {
						curLocation = EasternDesert2;
					} else if (id.equals(DeathValley.id)) {
						curLocation = EasternDesert3;
					} else if (id.equals(EasternDesert2.id)) {
						curLocation = EasternDesert4;
					} else {
						curLocation = EasternDesert;
					}
					return curLocation;
				} else if (curLocationName.equals("Lost Sea")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(0).getAttribute("class");
					if (id.equals(LostSeaShore.id)) {
						curLocation = LostSea;
					} else if (id.equals(LostSea.id)) {
						curLocation = LostSea2;
					} else if (id.equals(LostSea2.id)) {
						curLocation = LostSea3;
					} else {
						curLocation = LostSea4;
					}
					return curLocation;
				} else if (curLocationName.equals("Main Corridor")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(0).getAttribute("class");
					if (id.equals(SmokyAntechamber.id)) {
						curLocation = MainCorridor2;
					} else {
						curLocation = MainCorridor;
					}
					return curLocation;
				} else if (curLocationName.equals("Long Hallway")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(0).getAttribute("class");
					if (id.equals(BurialHall.id)) {
						curLocation = LongHallway2;
					} else {
						curLocation = LongHallway;
					}
					return curLocation;
				} else if (curLocationName.equals("Abandoned Hut")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(0).getAttribute("class");
					if (id.equals(DeadJungles.id)) {
						curLocation = AbandonedHut2;
					} else {
						curLocation = AbandonedHut;
					}
					return curLocation;
				} else if (curLocationName.equals("Fisherman's Ferry")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(0).getAttribute("class");
					if (id.equals(FishermansSeasideCottage.id)) {
						curLocation = FishermansFerry;
					} else if (id.equals(FishermansFerry.id)) {
						curLocation = FishermansFerry2;
					} else {
						curLocation = FishermansFerry3;
					}
					return curLocation;
				} else if (curLocationName.equals("Aseridith Fort Guardtower")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(0).getAttribute("class");
					if (id.equals(AseridithFarmland.id)) {
						curLocation = AseridithFortGuardtower;
					} else if (id.equals(AseridithFortGuardtower.id)) {
						curLocation = AseridithFortGuardtower2;
					} else {
						curLocation = AseridithFortGuardtower3;
					}
					return curLocation;
				} else if (curLocationName.equals("Rolling Dunes")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(0).getAttribute("class");
					
					String id2;
					try {id2 = path.get(1).getAttribute("class");}
					catch (Exception e) {id2 = "Farts";}
					
					String id3;
					try {id3 = path.get(2).getAttribute("class");}
					catch (Exception e) {id3 = "Farts";}
					
					List<String> ids = Arrays.asList(id, id2, id3);
					if (ids.contains(SandyDesertPass.id) || ids.contains(SandyDesertPass.id)) {
						curLocation = RollingDunes;
					} else if (ids.contains(RollingDunes3.id) || ids.contains(RollingDunes3.id)) {
						curLocation = RollingDunes2;
					} else if (ids.contains(StrangeRockFormation.id) || ids.contains(RollingDunes4.id)) {
						curLocation = RollingDunes3;
					} else if (ids.contains(RollingDunes5.id) || ids.contains(CalmCave.id)) {
						curLocation = RollingDunes4;
					} else if (ids.contains(RollingDunes6.id)) {
						curLocation = RollingDunes5;
					} else if (ids.contains(RollingDunes7.id) || ids.contains(RollingDunes7.id)) {
						curLocation = RollingDunes6;
					} else if (ids.contains(RollingDunes8.id) || ids.contains(SerpentPit.id)) {
						curLocation = RollingDunes7;
					} else if (ids.contains(RollingDunes.id) || ids.contains(RollingDunes.id)) {
						curLocation = RollingDunes8;
					} else {
						curLocation = Death;
						System.out.println("Shit why am i here");
					}
					return curLocation;
				} else if (curLocationName.equals("Lizardfolk Marshland")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(0).getAttribute("class");
					String id2;
					String id3;
					try {id2 = path.get(1).getAttribute("class");
					} catch (Exception e) {id2 = "Farts";}
					
					try {id3 = path.get(2).getAttribute("class");
					} catch (Exception e) {id3 = "Farts";}
					List<String> ids = Arrays.asList(id, id2, id3);
					if (ids.contains(HiddenPath.id) && ids.contains(LizardfolkMarshland2.id)) {
						curLocation = LizardfolkMarshland;
					} else if (ids.contains(LizardfolkMarshland.id) && ids.contains(LizardfolkMarshland3.id)) {
						curLocation = LizardfolkMarshland2;
					} else if (id2.equals(LizardkingHideout.id) || id3.equals(LizardkingHideout.id)) {
						curLocation = LizardfolkMarshland3;
					} else {
						curLocation = Death;
						System.out.println("LK Marsh getCur is bugged, rerunning getCur after 3 seconds");
						Access.sleep(3);
						curLocation = getCur();
					}
					return curLocation;
				} else if (curLocationName.equals("Ferry")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(0).getAttribute("class");
					String id2;
					String id3;
					try {id2 = path.get(1).getAttribute("class");
					} catch (Exception e) {id2 = "Farts";}
					List<String> ids = Arrays.asList(id, id2);
					
					if (ids.contains(VolantisDocks.id) && ids.contains(Ferry2.id)) {
						curLocation = Ferry;
					} else if (ids.contains(Ferry.id) && ids.contains(Ferry3.id)) {
						curLocation = Ferry2;
					} else if (ids.contains(Ferry2.id) && ids.contains(Ferry4.id)) {
						curLocation = Ferry3;
					} else if (ids.contains(Ferry3.id) && ids.contains(EridisIsland.id)) {
						curLocation = Ferry4;
					} else {
						curLocation = Death;
						System.out.println("Ferry getCur is bugged, rerunning getCur after 3 seconds");
						Access.sleep(3);
						curLocation = getCur();
					}
					return curLocation;
				} else if (curLocationName.equals("Eridis Forest")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(0).getAttribute("class");
					String id2;
					String id3;
					try {id2 = path.get(1).getAttribute("class");
					} catch (Exception e) {id2 = "Farts";}
					try {id3 = path.get(2).getAttribute("class");
					} catch (Exception e) {id3 = "Farts";}
					List<String> ids = Arrays.asList(id, id2, id3);
					if (ids.contains(TheBay.id) || ids.contains(EridisForest2.id)) {
						curLocation = EridisForest;
					} else if (ids.contains(EridisClimb.id) && ids.contains(EridisForest.id)) {
						curLocation = EridisForest2;
					} else {
						curLocation = Death;
						System.out.println("Eridis Forest getCur is bugged, rerunning getCur after 3 seconds");
						Access.sleep(3);
						curLocation = getCur();
					}
					return curLocation;
				} else if (curLocationName.equals("Hallowed Forest Walk")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(0).getAttribute("class");
					String id2;
					String id3;
					try {id2 = path.get(1).getAttribute("class");
					} catch (Exception e) {id2 = "Farts";}
					try {id3 = path.get(2).getAttribute("class");
					} catch (Exception e) {id3 = "Farts";}
					List<String> ids = Arrays.asList(id, id2, id3);
					if (ids.contains(CrumblingWall.id) || ids.contains(HallowedForestWalk2.id)) {
						curLocation = HallowedForestWalk;
					} else if (ids.contains(ConcealedFortApproach.id) && ids.contains(HallowedForestWalk.id)) {
						curLocation = HallowedForestWalk2;
					} else {
						curLocation = Death;
						System.out.println("Hallowed walk monkey getCur is bugged, rerunning getCur after 3 seconds");
						Access.sleep(3);
						curLocation = getCur();
					}
					return curLocation;
				} else if (curLocationName.equals("Valor's Rise")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(0).getAttribute("class");
					String id2;
					String id3;
					try {id2 = path.get(1).getAttribute("class");
					} catch (Exception e) {id2 = "Farts";}
					try {id3 = path.get(2).getAttribute("class");
					} catch (Exception e) {id3 = "Farts";}
					List<String> ids = Arrays.asList(id, id2, id3);
					if (ids.contains(ConcealedFortCourtyard.id) || ids.contains(ValorsRise2.id)) {
						curLocation = ValorsRise;
					} else if (ids.contains(ValorsPeak.id) && ids.contains(ValorsRise.id)) {
						curLocation = ValorsRise2;
					} else {
						curLocation = Death;
						System.out.println("Valor's Rise getCur is bugged, rerunning getCur after 3 seconds");
						Access.sleep(3);
						curLocation = getCur();
					}
					return curLocation;
				} else if (curLocationName.equals("Kujir Marsh")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(0).getAttribute("class");
					if (id.equals(KujirMarshEntrance.id)) {
						curLocation = KujirMarsh;
					} else if (id.equals(KujirMarsh.id)) {
						curLocation = KujirMarsh2;
					} else if (id.equals(KujirMarsh2.id)) {
						curLocation = KujirMarsh3;
					} else if (id.equals(KujirMarsh3.id)) {
						curLocation = KujirMarsh4;
					} else {
						curLocation = Death;
						System.out.println("Kujir broke getcur");
					}
					return curLocation;
				} else if (curLocationName.equals("Xaruk Forest")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(0).getAttribute("class");
					String id2;
					String id3;
					try {id2 = path.get(1).getAttribute("class");
					} catch (Exception e) {id2 = "Farts";}
					
					try {id3 = path.get(2).getAttribute("class");
					} catch (Exception e) {id3 = "Farts";}
					
					if (id.equals(LookoutPoint.id) || id2.equals(LookoutPoint.id)) {
						curLocation = XarukForest;
					} else if (id.equals(XarukForest.id)) {
						curLocation = XarukForest2;
					} else if (id.equals(XarukForest2.id) && id2.equals(XarukForest4.id)) {
						curLocation = XarukForest3;
					} else if (id.equals(XarukForest6.id)) {
						curLocation = XarukForest4;
					} else if (id2.equals(Xaruk.id)) {
						curLocation = XarukForest5;
					} else if (id.equals(XarukForest2.id) && !id2.equals(XarukForest4.id)) {
						curLocation = XarukForest6;
					} else {
						curLocation = Death;
						System.out.println("Xaruk forest getCur is bugged, rerunning getCur after 3 seconds");
						Access.sleep(3);
						curLocation = getCur();
					}
					return curLocation;
				} else if (curLocationName.equals("Aseridith Fort Tower")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(0).getAttribute("class");
					if (id.equals(AseridithFortInnerGate.id)) {
						curLocation = AseridithFortTower;
					} else if (id.equals(AseridithFortTower.id)) {
						curLocation = AseridithFortTower2;
					} else {
						curLocation = Death;
						System.out.println("Fort Tower getcur");
					}
					return curLocation;
				} else if (curLocationName.equals("Aseridith Fort Courtyard")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(0).getAttribute("class");
					if (id.equals(AseridithFortCourtyard.id)) {
						curLocation = AseridithFortCourtyard2;
					} else if (id.equals(AseridithFortGates.id)) {
						curLocation = AseridithFortCourtyard;
					} else {
						curLocation = Death;
						System.out.println("Fort Courtyard getcur");
					}
					return curLocation;
				} else if (curLocationName.equals("Armory")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(0).getAttribute("class");
					if (id.equals(ThirdFloorStaircase.id)) {
						curLocation = Armory2;
					} else {
						curLocation = Armory;
					}
					return curLocation;
				} else if (curLocationName.contains("Camp:")) {
					return Camp;
				} else if (curLocationName.equals("Strange Empty Room")) {
					List<WebElement> path = getPath(wait);
					String id6;
					String id3;
					String id2;
					try {id2 = path.get(1).getAttribute("class");
					} catch (Exception e) {id2 = "Farts";}
					try {id3 = path.get(2).getAttribute("class");
					} catch (Exception e) {id3 = "Farts";}
					try {id6 = path.get(5).getAttribute("class");
					} catch (Exception e) {id6 = "Farts";}
					
					
					if (id6.equals(StrangeEmptyRoom2.id)) {
						curLocation = StrangeEmptyRoom;
					} else if (id3.equals(StrangeEmptyRoom3.id)) {
						curLocation = StrangeEmptyRoom2;
					} else if (id2.equals(ArchmagesQuarters.id)) {
						curLocation = StrangeEmptyRoom3;
					} else {
						curLocation = Death;
						System.out.println("Strange Empty Room getcur");
					}
					return curLocation;
				}else if (curLocationName.equals("Labyrinth")) {
					List<WebElement> path = getPath(wait);
					String id = path.get(0).getAttribute("class");
					String id2;
					String id3;
					String id4;
					String id5;
					try {id2 = path.get(1).getAttribute("class");
					} catch (Exception e) {id2 = "Farts";}
					try {id3 = path.get(2).getAttribute("class");
					} catch (Exception e) {id3 = "Farts";}
					try {id4 = path.get(3).getAttribute("class");
					} catch (Exception e) {id4 = "Farts";}
					try {id5 = path.get(4).getAttribute("class");
					} catch (Exception e) {id5 = "Farts";}
					List<String> ids = Arrays.asList(id, id2, id3, id4, id5);
					
					if (ids.contains(Labyrinth2.id) && ids.contains(ShadowTempleEntrance.id)) {
						curLocation = Labyrinth;
					} else if (ids.contains(Labyrinth3.id)) {
						curLocation = Labyrinth2;
					} else if (ids.contains(Labyrinth2.id) && ids.contains(Labyrinth5.id)) {
						curLocation = Labyrinth3;
					} else if (ids.contains(Labyrinth5.id) && ids.contains(Labyrinth6.id)) {
						curLocation = Labyrinth4;
					} else if (ids.contains(DescendingPit.id)) {
						curLocation = Labyrinth5;
					} else if (ids.contains(Labyrinth4.id) && ids.contains(ShadowTempleEntrance.id)) {
						curLocation = Labyrinth6;
					} else {
						curLocation = Death;
						System.out.println("Labyrinth getCur is bugged, rerunning getCur after 3 seconds");
						Access.sleep(3);
						curLocation = getCur();
					}
					return curLocation;
				}  else if (curLocationName.equals("Labyrinth")) {
					List<WebElement> path = getPath(wait);

					String id;
					String id3;
					String id2;
					try {id2 = path.get(1).getAttribute("class");
					} catch (Exception e) {id2 = "Farts";}
					try {id3 = path.get(2).getAttribute("class");
					} catch (Exception e) {id3 = "Farts";}
					try {id = path.get(0).getAttribute("class");
					} catch (Exception e) {id = "Farts";}
					
					Set<String> ids = new HashSet(Arrays.asList(id, id2, id3));
					
					if (ids.contains(Access.DescendingPit.id)) {
						curLocation = Labyrinth5;
					} else if (ids.contains(Access.Labyrinth5.id)) {
						curLocation = Labyrinth4;
					} else if (ids.contains(Access.ShadowTempleEntrance.id)) {
						curLocation = Labyrinth;
					} else if (ids.contains(Access.Labyrinth.id)) {
						curLocation = Labyrinth2;
					} else {
						System.out.println("getcur went wrong laby");
						curLocation = Death;
					}
					
					return curLocation;
				}

				for (MapVertex m : map.vertexSet()) {
					if (m.name.equals(curLocationName)) {
						curLocation = m;
						return curLocation;
					}
				}
				curLocation = new MapVertex(curLocationName, "Default");
				break;
			} catch (Exception e) {
				System.out.println("CurLocation could not locate element");
				System.out.println(e.getMessage());
				System.out.println(" \n End of Error message \n \n \n ");
				sleep(.5);
			}
		}

		return curLocation;
	}
	
	public static WebElement getProfile(WebDriverWait wait) {
		WebElement profile;
		while (true) {
			try {
				profile = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inBannerCharacterWidget")))
						.findElement(By.xpath("//*[@id=\"newui\"]/a"));
				break;
			} catch (Exception e) {
				System.out.println("Profile getter threw an exception");
				System.out.println(e.getMessage());
				System.out.println(" \n End of Error message \n \n \n ");
				sleep(.5);
			}
		}
		return profile;
	}
	
	public static boolean inCombat() {
		try {
			driver.findElement(By.cssSelector("a[onclick = 'doCombatAttackRightHand(event)']"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean alive() {
		for (int i = 0; i < 2; i++) {
			try {
				if (i == 0) {
					driver.findElement(By.cssSelector("a[onclick = 'newCharacterFromUnconscious()']"));
				} else {
					driver.findElement(By.cssSelector("a[onclick = 'newCharacterFromDead()']"));
				}
				return false;
			} catch (Exception e) {
				if (i == 0) {
					continue;
				}
				return true;
			}
		}
		System.out.println("there is no way you'd get here but hey");
		return true;
	}
	
	public static void send(String command) {
		try {
			driver.findElement(By.tagName("body")).sendKeys(command);
		} catch (Exception e) {
			System.out.println("send key recieved an exception");
			System.out.println(e.getMessage());
			System.out.println(" \n End of Error message \n \n \n ");
			sleep(.5);
		}
	}

	public static boolean goToID(String id) {
		wait = new WebDriverWait(driver, 3);
		WebElement locButton;
		int count = 0;
		while (true) {
			try {
				if (count > 4) {
					return false;
				}
				if (count > 2) {
					driver.findElement(By.cssSelector("a[onclick = 'doShowHiddenSites(event)'")).click();
					sleep(1);
					driver.findElement(By.cssSelector("div[onclick = 'clearMakeIntoPopup()'")).click();
					sleep(1);
					// clickNav();
					continue;
				}
				closePopup();
				locButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(id)))
						.findElement(By.className("v3-main-button"));
				locButton.click();
				break;
			} catch (Exception e) {
				System.out.println("location button could not locate element");
				System.out.println(e.getMessage());
				System.out.println(" \n End of Error message \n \n \n ");
				count++;
				sleep(.5);
			}
		}
		return true;
	}

	public static List<WebElement> getLoot(WebDriverWait wait) {
		List<WebElement> loot;
		while (true) {
			try {
				loot = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inline-items")))
						.findElements(By.className("main-item"));
				break;
			} catch (Exception e) {
				System.out.println("Loot getter threw an exception");
				System.out.println(e.getMessage());
				System.out.println(" \n End of Error message \n \n \n ");
				sleep(.5);
				run("showLootPopup()");
			}
		}
		return loot;
	}

	public static List<WebElement> getPath(WebDriverWait wait) {
		List<WebElement> path;
		int count = 0;
		while (true) {
			try {
				if (count > 1) {
					return null;
				}
				path = wait
						.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath("//*[@id=\"main-button-list\"]/div[2]")))
						.findElements(By.tagName("div"));

				break;
			} catch (Exception e) {
				count++;
				System.out.println("path getter threw an exception");
				System.out.println(e.getMessage());
				System.out.println(" \n End of Error message \n \n \n ");
				sleep(.15);
			}
		}
		return path;
	}

	public static String getCount() {
		WebElement mcount;
		String count = "";

		try {
			mcount = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("monsterCountPanel")))
					.findElement(By.tagName("div"));
			count = mcount.getText();
		} catch (Exception e) {
			System.out.println("monster count getter threw an exception");
			System.out.println(e.getMessage());
			System.out.println("\n End of Error message \n \n \n ");
			sleep(.5);
		}

		return count;
	}

	public static void closePopup() {

		/*
		 * try { Access.js.executeAsyncScript("closepopupMessage()"); }catch(Exception
		 * e) {} try { Access.js.executeAsyncScript("closePagePopup()");
		 * }catch(Exception e) {}
		 */

		try {
			js.executeAsyncScript("closeAllPopupsTooltips()");

		} catch (Exception e) {
			System.out.println("closing popup");
		}
	}

	public static void mute() {
		try {
			driver.findElement(By.cssSelector("a[onclick = 'toggleEnvironmentSoundEffects()']")).click();
		} catch (Exception e) {
		}
	}

	public static Item keepLoot(WebElement loot) {
		String rare = "";
		Item collect = null;
		try {
			WebElement itemBox = loot.findElement(By.cssSelector("div[class = 'main-item-name']"));
			String itemName = itemBox.getText();
			System.out.println("Checking " + itemName);
		} catch (Exception  e) {}
		for (int i = 0; i < 3; i++) {
			switch (i) {
			case 0:
				rare = "epic";
				break;
			case 1:
				rare = "unique";
				break;
			case 2:
				rare = "rare";
				break;
			default:
				System.out.println("Never should've come here");
			}
			try {
				WebElement itemBox = loot.findElement(By.cssSelector("div[class = 'main-item-name']"));
				String itemName = itemBox.getText();
				
				String[] keepList = keepItems.split(" and ");
				if (itemName.contains("Linen")) {
					return null;
				}

				for (String keep : keepList) {
					if (itemName.contains(keep)) {
						collect = new Item(loot, "Inventory");
						System.out.println(rare + " " + collect.name);
						return collect;
					}
				}
				
				
				loot.findElement(By.cssSelector("a[class = 'clue item-" + rare + "']"));
				collect = new Item(loot, "Inventory");
				if (rare.equals("rare")) {
					if (collect.tier < Item.SILVER) {
						collect = null;
					}
				}
				return collect;
			} catch (Exception e) {
		
			}
		}

		return collect;
	}

	public static Item statCheck(Item collect) {
		int[] preferedStats = { 0, 0, 0 };
		double score = 0;

		if (collect.tag.equals("Weapon")) {
			if (collect.maxDamage > 35) {
				return collect;
			} else {
				return null;
			}
		}
		System.out.println(collect);
		String lootName = collect.name;
		if (lootName.contains("ull Plate") || lootName.contains("Studded Leather")) {
			preferedStats[0] = 9;
			preferedStats[1] = 89;
			preferedStats[2] = 15;
			// 5/61/11 A/M/E
		} else if (lootName.contains("Scale")) {
			preferedStats[0] = 8;
			preferedStats[1] = 88;
			preferedStats[2] = 17;
		} else if (lootName.contains("Steel") && !lootName.contains("Shield")) {
			preferedStats[0] = 4;
			preferedStats[1] = 85;
			preferedStats[2] = 17;
		} else if (lootName.contains("Light Steel Shield")) {
			preferedStats[0] = 4;
			preferedStats[1] = 85;
			preferedStats[2] = 17;
		} else if (lootName.contains("Snakeskin")) {
			preferedStats[0] = 1;
			preferedStats[1] = 87;
			preferedStats[2] = 12;
		} else if (lootName.contains("Leather Glove")) {
			preferedStats[0] = 0;
			preferedStats[1] = 92;
			preferedStats[2] = 15;
		} else if (lootName.contains("Banded Mail Boots")) {
			preferedStats[0] = 1;
			preferedStats[1] = 87;
			preferedStats[2] = 15;
		} else if (lootName.contains("Leather Boots")  || lootName.contains("Cloth Robe")) {
			preferedStats[0] = 1;
			preferedStats[1] = 87;
			preferedStats[2] = 15;
		} else if (lootName.contains("Padded Platemail")) {
			preferedStats[0] = 9;
			preferedStats[1] = 90;
			preferedStats[2] = 19;
		} else if (lootName.contains("Nomad")) {
			preferedStats[0] = 8;
			preferedStats[1] = 86;
			preferedStats[2] = 15;
		} else {
			return collect;
		}

		score += 1.5 * (double) (preferedStats[0] - collect.dp);
		System.out.println("score is " + score);
		score += (collect.bc - preferedStats[1]);
		System.out.println("score is " + score);
		score += (double) (collect.dr - preferedStats[2]);
		System.out.println("Final score is " + score);
		if (score >= 0) {
			return collect;
		} else {
			return null;
		}

	}

	public static void addTwoWayEdge(MapVertex start, MapVertex end) {
		map.addEdge(start, end);
		map.addEdge(end, start);
	}

	public static String getMessage() {
		try {
			String message = Access.driver
					.findElement(By.xpath("//*[@id=\"chat_messages_GameMessages\"]/div[1]/span[2]")).getText();
			return message;
		} catch (Exception e) {
			return "Default";
		}
	}

	public static void switchTo(String from, String to) {
		if (Alt.currentAlt.equals(from)) {
			
			
			Access.run("switchCharacter(event, " + to + ")");
			
			int count = 0;
			while (Access.js.executeScript("return characterId").toString().equals(from)) {
				Access.sleep(.1);
				count++;
				if (count > 15) {
					switchTo(from, to);
					return;
				}
			}
			Alt.currentAlt = to;
		}
		
	}

	public static void run(String command) {
		try {
			js.executeAsyncScript(command);
		} catch (Exception e) {
		}
	}
	
	public static void setUpMarksman() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(AseridithFortGuardtowerTop, AseridithFortGuardtower3, AseridithFortOuterWesternWalls,
						AseridithFortOuterSouthernWalls, AseridithFortOuterEasternWalls));
		Access.viableGear = Item.SILVER;
		damageType = Item.BLUDGEONING;
		armorType = Item.PIERCING;
	}

	public static void setUpTurtle() {
		Access.targetLocations = new ArrayList<MapVertex>(Arrays.asList(ClawMarkedCavern, ConcealedCavern));
		Access.viableGear = Item.BRONZE;
		damageType = Item.BLUDGEONING;
		armorType = Item.PIERCING;
	}

	public static void setUpDunes() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(RollingDunes3, RollingDunes4, RollingDunes5, RollingDunes7, RollingDunes8, RollingDunes, RollingDunes2));
		Access.viableGear = Item.SILVER;
		damageType = Item.BLUDGEONING;
		armorType = Item.SLASHING;
	}

	public static void setUpPlains() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.MountainPlains, Access.RockyPath, Access.CliffsideLookout));
		Access.viableGear = Item.SILVER;
		damageType = Item.SLASHING;
		armorType = Item.SLASHING + " and " + Item.BLUDGEONING;
	}

	public static void setUpBaron() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.UndergroundStream, Access.BaronCricketonsLair, Access.InfestedTunnel, Access.CricketonCave));
		Access.viableGear = Item.BRONZE;
		damageType = Item.SLASHING;
		armorType = Item.SLASHING;
	}
	
	public static void setUpLizardKing() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.LizardkingHideout, Access.LizardkingDen, 
						Access.LizardfolkMarshland2, Access.LizardfolkMarshland));
		Access.viableGear = Item.BRONZE;
		damageType = Item.SLASHING + " and " + Item.BLUDGEONING;
		armorType = Item.BLUDGEONING;
	}
	
	public static void setUpKobolds() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.KoboldSettlement));
		Access.viableGear = Item.BRONZE;
		damageType = Item.SLASHING;
		armorType = Item.SLASHING + " and " + Item.BLUDGEONING;
	}

	public static void setUpLunar() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.AphelionShrineArchives, Access.AphelionShrine,  Access.AphelionShrineRepository));
		Access.viableGear = Item.BRONZE;
		damageType = Item.PIERCING;
		armorType = Item.SLASHING + Item.BLUDGEONING;
		Access.twoHanded = true;
	}
	
	public static void setUpXaruk() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.GeneralsQuarters, Access.MessHall,
						Access.Barracks, Access.Armory));
		Access.viableGear = Item.SILVER;
		damageType = Item.PIERCING;
		armorType = Item.SLASHING;
	}
	
	public static void setUpDragon() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.CoreofSmolderingMountain, Access.SmolderingMountainPeak, 
						Access.SmolderingMountainAscent, Access.SmolderingMountain, Access.CinderMountainRange));
		Access.viableGear = Item.GOLD;
		damageType = Item.BLUDGEONING;
		armorType = Item.PIERCING + " " + Item.BLUDGEONING;
	}
	
	public static void setUpCommie() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.AseridithCommandersQuarters, Access.AseridithFortTower,
						Access.AseridithFortInnerGate, Access.AseridithFortBarracks, Access.AseridithFortTower2,
						Access.AseridithKeepGates, Access.AseridithKeepHallway));
		Access.viableGear = Item.BRONZE;
		damageType = Item.PIERCING;
		armorType = Item.SLASHING + " " + Item.BLUDGEONING;
		twoHanded = true;
	}
	
	public static void setUpArch() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.ArchmagesQuarters, Access.Armory2,
						Access.GrandStudy, Access.Observatory, Access.PotionsLaboratory,
						Access.HerbGarden, Access.WestLibrary));
		Access.viableGear = Item.BRONZE;
		damageType = Item.PIERCING;
		armorType = Item.SLASHING;
		twoHanded = true;
	}
	
	public static void setUpJungle() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.TempleRuins, Access.DeathlyForest, Access.DenseJungle, Access.DenseJungle2, Access.DenseJungle3
						,Access.DenseJungle4, Access.DenseJungle5, Access.DenseJungle6));
		Access.viableGear = Item.BRONZE;
		damageType = Item.SLASHING;
		armorType = Item.BLUDGEONING + " " + Item.PIERCING;
		twoHanded = false;
	}
	
	public static void setUpThorn() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.HighRoad, Access.HighRoadSwampland, Access.HighRoadDenseForest,
						Access.HighRoadForest, Access.HighRoadWaterfall, Access.HighRoadWaterfallClearing));
		Access.viableGear = Item.BRONZE;
		damageType = Item.BLUDGEONING + " " + Item.SLASHING;
		armorType = Item.BLUDGEONING;
		twoHanded = false;
	}
	
	public static void setUpRapiers() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.CastleGrounds, Access.CastleCourtyard,
						Access.OvergrownPath));
		Access.viableGear = Item.BRONZE;
		damageType = Item.BLUDGEONING;
		armorType = Item.PIERCING;
		twoHanded = true;
	}
	
	public static void setUpSnake() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.SerpentPit));
		Access.viableGear = Item.BRONZE;
		damageType = Item.PIERCING;
		armorType = Item.BLUDGEONING;
		twoHanded = true;
	}
	
	public static void setUpAbby() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.Inferno, Access.SacredEarthTemple, Access.EchoingScream));
		Access.viableGear = Item.BRONZE;
		damageType = Item.PIERCING;
		armorType = Item.PIERCING + " " + Item.BLUDGEONING;
		twoHanded = false;
		
	}
	
	public static void setUpPriest() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.OldFortLanding, Access.FortJunction, Access.FortEntrance, Access.MilitaryArchives));
		Access.viableGear = Item.BRONZE;
		damageType = Item.PIERCING;
		armorType = Item.PIERCING + " " + Item.BLUDGEONING;
		twoHanded = false;
	}
	
	public static void setUpAirLich() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.SacredAirTemple, Access.Aviary));
		Access.viableGear = Item.BRONZE;
		damageType = Item.PIERCING;
		armorType = Item.PIERCING + " " + Item.BLUDGEONING;
		twoHanded = false;
	}
	
	public static void setUpOverlord() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.SacredFireTemple, Access.LavaTube, Access.RedCrypt));
		Access.viableGear = Item.SILVER;
		damageType = Item.PIERCING;
		armorType = Item.PIERCING + " " + Item.BLUDGEONING;
		twoHanded = false;
	}
	
	public static void setUpRiver() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.WindingRiver6, Access.WindingRiver5,
						Access.WindingRiver4, Access.WindingRiver3, Access.WindingRiver2, 
						Access.WindingRiver, Access.WindingRiver7));
		Access.viableGear = Item.BRONZE;
		damageType = Item.SLASHING;
		armorType = Item.SLASHING;
		twoHanded = true;
	}
	
	public static void setUpSwamp() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.TaelhollowSwamp, Access.WildeburnForest));
		Access.viableGear = Item.SILVER;
		damageType = Item.PIERCING;
		armorType = Item.PIERCING + " " + Item.BLUDGEONING;
		twoHanded = false;
	}
	
	public static void setUpLevi() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.Maelstrom, Access.FishermansFerry, Access.FishermansFerry2, Access.FishermansFerry3));
		Access.viableGear = Item.SILVER;
		damageType = Item.PIERCING;
		armorType = Item.PIERCING + " " + Item.BLUDGEONING;
		twoHanded = false;
	}
	
	public static void setUpProtHat() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.GapingCave, Access.NorsPlains, Access.NorsMountain,
						Access.SandSweptPlains));
		Access.viableGear = Item.SILVER;
		damageType = Item.SLASHING;
		armorType = Item.SLASHING;
		twoHanded = false;
	}
	
	public static void setUpNaKareth() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.ShrineofNaKareth, Access.LongHallway2,
						Access.BurialHall, Access.EmbalmingRoom));
		Access.viableGear = Item.SILVER;
		damageType = Item.SLASHING;
		armorType = Item.SLASHING + Item.BLUDGEONING;
		twoHanded = false;
	}
	
	public static void setUpSimbaFae() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.ArchersPerch, Access.WastelandOverlook, Access.Perch));
		Access.viableGear = Item.SILVER;
		damageType = Item.PIERCING;
		armorType = Item.PIERCING + " " + Item.BLUDGEONING;
		twoHanded = false;
	}
	
	public static void setUpHuntsPriestessFire() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.PriestessChamber, Access.HuntersChamber, Access.KeeperOfTheFlame, 
						Access.HutInterior, Access.ThatchedShelter, Access.Ziggurat, Access.AromaticChamber));
		Access.viableGear = Item.SILVER;
		damageType = Item.PIERCING;
		armorType = Item.PIERCING + " " + Item.BLUDGEONING;
		twoHanded = false;
	}
	
	public static void setUpCrusader() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.DeathlyForest, Access.DeathlyForest, Access.DeathlyForest, Access.EvergreenTrail
						,TaelhollowSwamp, Access.WildeburnForest, Access.TempleRuins ));
		Access.viableGear = Item.BRONZE;
		damageType = Item.PIERCING;
		armorType = Item.SLASHING;
		twoHanded = true;
	}
	
	public static void setUpUnicorn() { 
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.SapphireWay, Access.RasheekPlains, Access.EvergreenTrail,
						Access.JachumsSteps, Access.DeathlyForest, Access.DenseJungle, Access.DenseJungle2, Access.DenseJungle3
						,Access.DenseJungle4, Access.DenseJungle5, Access.DenseJungle6));
		Access.viableGear = Item.BRONZE;
		damageType = Item.PIERCING;
		armorType = Item.SLASHING;
		twoHanded = true;
	}
	
	public static void setUpWater() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.EridisClimb, Access.SacredWaterTemple, Access.Sludge, Access.HolySanctum, Access.TunnelDescent));
		Access.viableGear = Item.BRONZE;
		damageType = Item.PIERCING;
		armorType = Item.PIERCING ;
		twoHanded = true;
	}
	
	public static String getChatMessage(String type) {
		if (type.equals("System")) {
			try {
				WebElement parent = Access.driver.findElement(By.cssSelector("div[id = 'chat_messages_GameMessages']"))
						.findElement(By.cssSelector("div[class = 'chatMessage-main']"));
				String text = parent.findElement(By.cssSelector("span[class = 'gameMessage-text']")).getAttribute("innerHTML");
				WebElement dateTime = parent.findElement(By.cssSelector("span[class = 'gameMessage-time']"));
				String time = dateTime.getAttribute("Title") + " " + dateTime.getAttribute("innerHTML");
				return time + text;
			} catch (Exception e) {return "Exception in System get text";}
			
		} else if (type.equals("Global")) {
			try {
				WebElement parent = Access.driver.findElement(By.cssSelector("div[id = 'chat_messages_GlobalChat']"))
						.findElement(By.cssSelector("div[class = 'chatMessage-main']"));
				String text = parent.findElement(By.cssSelector("span[class = 'chatMessage-text']")).getAttribute("innerHTML");
				WebElement dateTime = parent.findElement(By.cssSelector("span[class = 'chatMessage-time']"));
				String time = dateTime.getAttribute("Title") + " " + dateTime.getAttribute("innerHTML");
				return time + text;
			} catch (Exception e) {return "Exception in Global get text";}
		} else if (type.equals("Location")) {
			try {
				WebElement parent = Access.driver.findElement(By.cssSelector("div[id = 'chat_messages_LocationChat']"))
						.findElement(By.cssSelector("span[class = 'chatMessage-time']")).findElement(By.xpath("./.."));
				String text = parent.findElement(By.cssSelector("span[class = 'chatMessage-text']")).findElement(By.cssSelector("a[rel]")).getText();
				String text2 = parent.findElement(By.cssSelector("span[class = 'chatMessage-message']")).getAttribute("innerHTML");
				WebElement dateTime = parent.findElement(By.cssSelector("span[class = 'chatMessage-time']"));
				String time = dateTime.getAttribute("Title") + " " + dateTime.getAttribute("innerHTML");
				return time + text + ":" + text2;
			} catch (Exception e) {return "No text found";}
		}
		
		return "No Message found by type " + type;
	}
	
	public static boolean findBroken() {
		
		try {
			WebElement e = Access.driver.findElement(By.cssSelector("div[class = 'equipment-destroyed-notice']"));
			WebElement parent = e.findElement(By.xpath("./.."));
			String id = parent.getAttribute("id");
			if (Access.brokenNotices.contains(id)) {
				return false;
			} else {
				brokenNotices.add(id);
				return true;
			}
		} catch (Exception e) {}
		return false;
	}
	
	public static void setUpElements() {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.DeitiesStretch, Access.HallofDeities, Access.GoldenHall, Access.GlowingAscent,
						Access.DescendingPit, Access.Labyrinth5, Access.Labyrinth4));
		Access.viableGear = Item.BRONZE;
		damageType = Item.PIERCING;
		armorType = Item.SLASHING;
	}
	
	public static void debug(Alt alt , String circumstance) {
		if (circumstance.contains("GoTo")) {
			if (inCombat()) {
				alt.combat();
				return;
			} else {
				alt.gameLoop();
			}
		} else if (circumstance.contains("Heal")){
			if (inCombat()) {
				alt.combat();
				return;
			}
			send("r");
			Access.sleep(.1);
			closePopup();
		}
	}
	
	public static void teachTheNewRunnerWhatsup(Alt alt) {
		Access.targetLocations = new ArrayList<MapVertex>(
				Arrays.asList(Access.AseridithFortGuardtowerTop, Access.AseridithFortSouthBeach, Access.AseridithFortEastBeach,
						Access.AseridithFortOuterEasternWalls, Access.AseridithFortOuterSouthernWalls, Access.AseridithFortOuterWesternWalls,
						Access.AseridithFortCourtyard, Access.LizardkingDen, Access.CalmPond, Access.AphelionShrineArchives,
						Access.StrangeRockFormation, Access.CalmCave, Access.SerpentPit, Access.GeneralsQuarters
						,Access.Armory, Access.Pantry, Access.TaelhollowHut, Access.ClawMarkedCavern, Access.TempleRuins,
						Access.CrumblingTemple, Access.HobgoblinTribeCampsite, Access.WindyExpanse, Access.CastleCourtyard));
		for (MapVertex m: Access.targetLocations) {
			alt.navTo(m);
		}
	}

}
