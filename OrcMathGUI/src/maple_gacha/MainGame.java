package maple_gacha;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.sound.sampled.Clip;

import guiTeacher.GUIApplication;

public class MainGame extends GUIApplication {

	private static final long serialVersionUID = 6853186922252287821L;
	
	public static MainGame game;
	public static BattleScreen battle;
	public static MainScreen main;	 
	public static LoadingScreen load;
	public static EthanSummonScreen summon;
//	public static FeaturedChar featured;
	public static int width;
	public static int height;
	public static UnitSelectionScreen unitsel;
	public static ArrayList<Hero> team;
	public static ArrayList<Monster> boss;
	public static ArrayList<Hero> currentTeam;
	public static CharacterScreen cScreen;
	public static BeginnerSelectionScreen bScreen;
	public static Monster[] mobs;
	public static Hero beginnerArcher;
	public static Hero beginnerSword;
	public static Hero beginnerWizard;
	public static DavidGetCharacterSingle single;
	public static DavidGetCharacterMulti multi;
	public static Hero temp;
	public static Hero temp1;
	public static Hero temp2;
	private static Clip g;
	private static Hero mediumWizard;
	private static Hero mediumAxe;
	private static Hero mediumWitch;
	private static Hero mediumWolfGirl;
	private static Hero mediumCannonMan;
	private static Hero highTank;
	private static Hero highPrincess;

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
		createMobs();
		team = new ArrayList<Hero>();
		currentTeam = new ArrayList<Hero>();
		addHero(beginnerSword);
		addHero(beginnerWizard);
		addHero(highTank);
		setLocationRelativeTo(null);
		bScreen = new BeginnerSelectionScreen(getWidth(), getHeight());		
		summon = new EthanSummonScreen(getWidth(),getHeight());
//		featured = new FeaturedChar(getWidth(),getHeight());
		unitsel = new UnitSelectionScreen(getWidth(), getHeight());
		main = new MainScreen(getWidth(), getHeight());	
		cScreen = new CharacterScreen(getWidth(), getHeight());	
		load = new LoadingScreen(getWidth(), getHeight());					
		setResizable(false);	
		setScreen(load);	
	
//		JFrame frame = new JFrame();
//		frame.setSize(200, 200);
//		frame.setLocationRelativeTo(null);
//		JButton button = new JButton("Click me");
//		frame.add(button);
//		button.addActionListener(new AL());
//		frame.setVisible(true);
//			 
		load = new LoadingScreen(getWidth(), getHeight());
		//battle = new BattleScreen(getWidth(), getHeight());
		setScreen(load);
	}

	public static void main(String[] args) {
		game = new MainGame(1280, 1024);
		Thread runner = new Thread(game);
		runner.start();
		playMusic("resources/maplestory music.wav");
	}

	public static void playMusic(String musicPos) {
		if (g!= null) {
			g.stop();
	
	
	public static void createMobs() {
		mobs = new Monster[200];
		for(int i = 0; i < mobs.length; i++) {
			mobs[i] = new Monster(1,500,30,1,500);
		}
		try {
	          File soundFile = new File(musicPos);
	          AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
	          g = AudioSystem.getClip();
	         g.open(audioIn);
	         g.start();
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	}
	
	
	public static void createCharacters() {
		beginnerArcher = new Hero("resources/characterPics/HeroBArcher.png", "B", 10, 10, 10, 10, 100);
		beginnerSword = new Hero("resources/characterPics/HeroBSwordMan.png", "B", 10, 10, 10, 10, 100);
		beginnerWizard = new Hero("resources/characterPics/HeroBWizard.png", "B", 10, 10, 10, 10, 100);
		
		temp = new Hero("resources/characterPics/Hero_BeginnerArcher.png", "B", 10, 10, 10, 10, 100);
		temp1 = new Hero("resources/characterPics/Hero_BeginnerSword.png", "B", 10, 10, 10, 10, 100);
		temp2 = new Hero("resources/characterPics/Hero_BeginnerWizard.png", "B", 10, 10, 10, 10, 100);
		
		mediumWizard = new Hero("resources/characterPics/HeroALilWizard.png", "A", 20, 20 ,20 ,20 , 150);
		mediumAxe = new Hero("resources/characterPics/HeroAAxeBoy.png", "A", 20, 20, 20, 20, 150);
		mediumWitch = new Hero("resources/characterPics/HeroAitch.png", "A", 20, 20, 20, 20, 150);
		mediumWolfGirl = new Hero("resources/characterPics/HeroAWolfandGirl.png", "A", 20, 20, 20, 20, 150);
		mediumCannonMan = new Hero("resources/characterPics/HeroACannonMan.png", "A", 20, 20, 20, 20, 150);
		
		highTank = new Hero("resources/characterPics/HeroSTank.png", "S", 30, 30, 30, 30, 200);
		highPrincess = new Hero("resources/charcterPics/HeroSPrincess.png", "S", 30, 30, 30, 30, 200);
		
		
		 
		
		 
		
//		System.out.println(beginnerSword.getImage());
//		System.out.println(beginnerArcher);
	}
	
	public static void createMobs1() {
		minionBlowfish = new Monster("resources/characterPics/MinionBlowfish.png", "B", 10, 10, 10, 10, 20);
		minionDemon = new Monster("resources/characterPics/MinionDemonMors.png", "B", 10, 10, 10, 10, 20);
		minionDevil = new Monster("resources/characterPics/MinionDevilMaz.png", "B", 10, 10, 10, 10, 20);
		minionInvidia = new Monster("resources/characterPics/MinionInvidia.png", "B", 10, 10, 10, 10, 20);
		minionYeti = new Monster("resoruces/characterPics/MinionInvidia.png", "B", 10, 10, 10, 10, 20);
		minionPsy = new Monster("resources/characterPics/MinionPSY.png", "B", 10, 10, 10, 10, 20);
		minionDragon = new Monster("resources/characterPics/MinionStormDragon.png", "B", 10, 10, 10, 10, 20);
		minionAlien = new Monster("resources/characterPics/WeirdAlien.png", "B", 10, 10, 10, 10, 20);
	}

	public void setBattle(BattleScreen battle) {
		this.battle = battle;
	}

	public static void addHero(Hero hero) {
		Hero newHero = new Hero(hero.getImage(),hero.getRank(),hero.getStrength(),hero.getSpeed(),hero.getAttack(),hero.getDefense(),hero.getHP());
		team.add(newHero);
	}
}