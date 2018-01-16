package maple_gacha;

import guiTeacher.GUIApplication;

public class MainGame extends GUIApplication {
	
	private static final long serialVersionUID = 6853186922252287821L;
	private static BattleScreen battle;

	public MainGame(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		//NOTE ADD MAIN SCREEN LATER GUYS
		MainScreen main = new MainScreen(getWidth(), getHeight());
		BattleScreen battle = new BattleScreen(getWidth(), getHeight());
		setScreen(main);
	}

	
	public static void main(String[] args) {
		createCharacters();
		MainGame game = new MainGame(1280, 1024);
		Thread runner = new Thread(game);
		runner.start();
	}

	
	
	private static void createCharacters() {
		
		
	}

}
