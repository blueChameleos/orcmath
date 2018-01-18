package test_prep;

import guiTeacher.GUIApplication;

public class MainGame extends GUIApplication {
	
	private static final long serialVersionUID = 2354615133488087049L;
	public static MainGame game;
	public static GameScreen screen;

	public MainGame(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		screen = new GameScreen(getWidth(), getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		game = new MainGame(800, 800);
		Thread runner = new Thread(game);
		runner.start();
	}

}
