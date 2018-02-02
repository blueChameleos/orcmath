package maple_gacha;

import java.util.ArrayList;

import guiTeacher.GUIApplication;

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
	public static CharacterScreen cScreen;
	public static BeginnerSelectionScreen bScreen;
	public static DavidGetCharacterSingle single;
	public static DavidGetCharacterMulti multi;
	public static Hero beginnerArcher;
	public static Hero beginnerSword;
	public static Hero beginnerWizard;
	private static Hero mediumWizard;
	private static Hero mediumAxe;
	private static Hero mediumWitch;
	private static Hero mediumWolfGirl;
	private static Hero mediumCannonMan;
	private static Hero highTank;
	private static Hero highPrincess;

	
	public MainGame(int width, int height) {
		super(width, height);
		setVisible(true);
	} 

	public void initScreen() {
		//NOTE ADD MAIN SCREEN LATER GUYS				
		createCharacters();		
		team = new ArrayList<Hero>();
		currentTeam = new ArrayList<Hero>();
		setLocationRelativeTo(null);
		bScreen = new BeginnerSelectionScreen(getWidth(), getHeight());		
		summon = new EthanSummonScreen(getWidth(),getHeight());
		unitsel = new UnitSelectionScreen(getWidth(), getHeight());
//		battle = new BattleScreen(getWidth(), getHeight());				
		main = new MainScreen(getWidth(), getHeight());	
		cScreen = new CharacterScreen(getWidth(), getHeight());	
		load = new LoadingScreen(getWidth(), getHeight());			
		setScreen(load);
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
		
		mediumWizard = new Hero("resources/characterPics/Hero_MediumLilWizard.png", "A", 20, 20 ,20 ,20 , 150);
		mediumAxe = new Hero("resources/characterPics/Hero_MediumAxeBoy.png", "A", 20, 20, 20, 20, 150);
		mediumWitch = new Hero("resources/characterPics/Hero_MediumWitch.png", "A", 20, 20, 20, 20, 150);
		mediumWolfGirl = new Hero("resources/characterPics/Hero_MediumWolfandGirl.png", "A", 20, 20, 20, 20, 150);
		mediumCannonMan = new Hero("resources/characterPics/Hero_MediumCannonMan.png", "A", 20, 20, 20, 20, 150);
		
		highTank = new Hero("resources/characterPics/Hero_HighTank.png", "S", 30, 30, 30, 30, 200);
		highPrincess = new Hero("resources/charcterPics/Hero_HighPrincess.png", "S", 30, 30, 30, 30, 200);
		
		
		
		
		
		
		System.out.println(beginnerSword.getImage());
		System.out.println(beginnerArcher);
	}
	
	public static void addHero(Hero hero) {
		Hero newHero = new Hero(hero.getImage(),hero.getRank(),hero.getStrength(),hero.getSpeed(),hero.getAttack(),hero.getDefense(),hero.getHP());
		team.add(newHero);
	}
}