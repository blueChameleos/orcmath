package maple_gacha;

import guiTeacher.GUIApplication;

public class MainGame extends GUIApplication {
	
	private static final long serialVersionUID = 6853186922252287821L;

	public static MainGame game;
	public static LoadingScreen load;
	public static MainScreen main;
	
	public MainGame(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		//NOTE ADD MAIN SCREEN LATER GUYS
		load = new LoadingScreen(getWidth(), getHeight());
		main = new MainScreen(getWidth(), getHeight());
		setScreen(load);
	}

	public static void main(String[] args) {
		game = new MainGame(1280, 1024);
		Thread runner = new Thread(game);
		runner.start();
	}

}
