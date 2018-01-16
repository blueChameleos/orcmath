package maple_gacha;

import guiTeacher.GUIApplication;

public class MainGame extends GUIApplication {
	
	private static final long serialVersionUID = 6853186922252287821L;
	public static MainGame game;
	public static BattleScreen battle;
	public static MainScreen main;
	public static UnitSelectionScreen unitsel;

	public MainGame(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		//NOTE ADD MAIN SCREEN LATER GUYS
		main = new MainScreen(getWidth(), getHeight());
		unitsel = new UnitSelectionScreen(getWidth(), getHeight());
		battle = new BattleScreen(getWidth(), getHeight());
		setScreen(unitsel);
	}

	public static void main(String[] args) {
		game = new MainGame(1280, 1024);
		Thread runner = new Thread(game);
		runner.start();
	}

}
