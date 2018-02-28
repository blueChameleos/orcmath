package simonalt;

import guiTeacher.GUIApplication;

public class SimonGame extends GUIApplication {

	private static final long serialVersionUID = -112107476455341055L;
	public static SimonGame game;
	public static SimonScreen screen;

	public SimonGame(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		screen = new SimonScreen(800, 800);
		setScreen(screen);
	}

	public static void main(String[] args) {
		game = new SimonGame(800, 800);
		Thread program = new Thread(game);
		program.start();
	}

}
