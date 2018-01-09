package myStuff;

import guiTeacher.GUIApplication;

public class SimonGameWei extends GUIApplication {
	
	private static SimonGameWei game;
	private SimonScreenWei screen;

	public SimonGameWei(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		screen = new SimonScreenWei(getWidth(), getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		game = new SimonGameWei(800, 1200);
		Thread go = new Thread(game);
		go.start();
	}

}
