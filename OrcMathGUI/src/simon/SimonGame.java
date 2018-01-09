package simon;

import guiTeacher.GUIApplication;

public class SimonGame extends GUIApplication {
	
	private static SimonGame game;
	public SimonScreen ui;
	

	public SimonGame(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		ui = new SimonScreen(getWidth(), getHeight());
		setScreen(ui);
	}

	public static void main(String[] args) {
		game = new SimonGame(800,800);
		Thread go = new Thread(game);
		go.start();
	}

}
