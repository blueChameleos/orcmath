package maple_gacha;

import java.util.ArrayList;

import guiTeacher.GUIApplication;
import guiTeacher.userInterfaces.Screen;

public class MainGame extends GUIApplication {

	private static final long serialVersionUID = 6853186922252287821L;
	
	public static MainGame game;
	public static BattleScreen battle;
	public static MainScreen main;	 
	public static LoadingScreen load;
	public static EthanSummonScreen summon;
	public static int width;
	public static int height;
	public static UnitSelectionScreen unitsel;
	public static ArrayList<Hero> team;
	public static ArrayList<Hero> currentTeam;
	public static Monster[] mobs;
	public static Hero beginnerArcher;
	public static Hero beginnerSword;
	public static Hero beginnerWizard;
	
	public static CharacterScreen cScreen;
	public static BeginnerSelectionScreen bScreen;
	public static DavidGetCharacterSingle single;
	public static DavidGetCharacterMulti multi;

	public static ArrayList<Monster> avaliableMonster;
	private static Monster minionBlowfish;

	private static Monster minionDemon;

	private static Monster minionDevil;

	private static Monster minionInvidia;

	private static Monster minionYeti;

	private static Monster minionPsy;

	private static Monster minionDragon;

	private static Monster minionAlien;

	
	public MainGame(int width, int height) {
		super(width, height);
		setVisible(true);
	} 
 
	public void initScreen() {
		//NOTE ADD MAIN SCREEN LATER GUYS				
		createCharacters();
		createMobChar();
		createMobs();
		team = new ArrayList<Hero>();
		currentTeam = new ArrayList<Hero>();
		currentTeam.add(beginnerArcher);
		currentTeam.add(beginnerSword);
		setLocationRelativeTo(null);
		bScreen = new BeginnerSelectionScreen(getWidth(), getHeight());		
		summon = new EthanSummonScreen(getWidth(),getHeight());
		unitsel = new UnitSelectionScreen(getWidth(), getHeight());
		main = new MainScreen(getWidth(), getHeight());	
		cScreen = new CharacterScreen(getWidth(), getHeight());	
		load = new LoadingScreen(getWidth(), getHeight());
		battle = new BattleScreen(getWidth(), getHeight());
		setScreen(battle);
	}

	public static void main(String[] args) {
		game = new MainGame(1280, 1024);
		Thread runner = new Thread(game); 
		runner.start();
	}

	public static void createCharacters() {
		beginnerArcher = new Hero("resources/characterPics/Hero_BeginnerArcher.png", "B", 10, 10, 10, 10, 100);
		beginnerSword = new Hero("resources/characterPics/Hero_BeginnerSword.png", "B", 10, 10, 10, 10, 100);
		beginnerWizard = new Hero("resources/characterPics/Hero_BeginnerWizard.png", "B", 10, 10, 10, 10, 100);
	}
	
	public void setBattle(BattleScreen battle) {
		this.battle = battle;
	}
	
	public static void createMobs() {
		mobs = new Monster[200];
		for(int i = 0; i < mobs.length; i++) {
			addMonster(avaliableMonster.get((int)(Math.random()*avaliableMonster.size())),i);
		}
	}
	
	public static void createMobChar() {
		avaliableMonster = new  ArrayList<Monster>();
		minionBlowfish = new Monster("resources/characterPics/MinionBlowfish.png", "B", 10, 10, 10, 10, 20);
		avaliableMonster.add(minionBlowfish);
		minionDemon = new Monster("resources/characterPics/MinionDemonMors.png", "B", 10, 10, 10, 10, 20);
		avaliableMonster.add(minionDemon);
		minionDevil = new Monster("resources/characterPics/MinionDevilMaz.png", "B", 10, 10, 10, 10, 20);
		avaliableMonster.add(minionDevil);
		minionInvidia = new Monster("resources/characterPics/MinionInvidia.png", "B", 10, 10, 10, 10, 20);
		avaliableMonster.add(minionInvidia);
		minionYeti = new Monster("resoruces/characterPics/MinionInvidia.png", "B", 10, 10, 10, 10, 20);
		avaliableMonster.add(minionYeti);
		minionPsy = new Monster("resources/characterPics/MinionPSY.png", "B", 10, 10, 10, 10, 20);
		avaliableMonster.add(minionPsy);
		minionDragon = new Monster("resources/characterPics/MinionStormDragon.png", "B", 10, 10, 10, 10, 20);
		avaliableMonster.add(minionDragon);
		minionAlien = new Monster("resources/characterPics/WeirdAlien.png", "B", 10, 10, 10, 10, 20);
		avaliableMonster.add(minionAlien);
	}
	
	public static void addHero(Hero hero) {
		Hero newHero = new Hero(hero.getImage(),hero.getRank(),hero.getStrength(),hero.getSpeed(),hero.getAttack(),hero.getDefense(),hero.getHP());
		team.add(newHero);
	}
	
	public static void addMonster(Monster monster,int i) {
		Monster newMonster = new Monster(monster.getImage(),monster.getRank(),monster.getStrength(),monster.getSpeed(),monster.getAttack(),monster.getDefense(),monster.getHP());
		mobs[i] = newMonster;
	}
}