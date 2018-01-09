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
		ui = new SimonScreen();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
