package maple_gacha;

import java.util.ArrayList;

import guiTeacher.GUIApplication;

public class MainGame extends GUIApplication {

	private static final long serialVersionUID = 6853186922252287821L;
	private static BattleScreen battle;
	public static ArrayList<Hero> team;
	public static ArrayList<Hero> currentTeam;
	public static Hero beginnerArcher;
	public static Hero beginnerSword;
	public static Hero beginnerWizard;
	public static CharacterScreen cScreen;

	public static MainGame game;

	public MainGame(int width, int height) {
		super(width, height);
		setVisible(true);
	} 

	@Override
	public void initScreen() {
		// NOTE ADD MAIN SCREEN LATER GUYS
		// MainScreen main = new MainScreen(getWidth(), getHeight());
		// BattleScreen battle = new BattleScreen(getWidth(), getHeight());
		createCharacters();
		team = new ArrayList<Hero>();
		currentTeam = new ArrayList<Hero>();
		BeginnerSelectionScreen bScreen = new BeginnerSelectionScreen(getWidth(), getHeight());
		setScreen(bScreen);
		setLocationRelativeTo(null);
		cScreen = new CharacterScreen(getWidth(), getHeight());
//		setScreen(cScreen);
	}

	public static void main(String[] args) {
		game = new MainGame(1280, 1024);
		Thread runner = new Thread(game);

		runner.start();
	}

	public static void createCharacters() {
		beginnerArcher = new Hero("resources/characterPics/Beginner_Archer_Character.png", "B", 10, 10, 10, 10, 100);
		beginnerSword = new Hero("resources/characterPics/Hero_BeginnerSword.png", "B", 10, 10, 10, 10, 100);
		beginnerWizard = new Hero("resources/characterPics/Hero_BeginnerWizard.png", "B", 10, 10, 10, 10, 100);
		System.out.println(beginnerSword.getImage());
		System.out.println(beginnerArcher);
	}
	
	public static void addHero(Hero hero) {
		Hero newHero = new Hero(hero.getImage(),hero.getRank(),hero.getStrength(),hero.getSpeed(),hero.getAttack(),hero.getDefense(),hero.getHP());
		team.add(newHero);
	}

}