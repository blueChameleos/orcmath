package myStuff;

import guiTeacher.GUIApplication;

public class CatalogMakerGUI extends GUIApplication {
	
	public static CatalogMakerGUI catalog;
	public static OpeningScreen opener;
	public static NextScreen transition;

	public CatalogMakerGUI(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		opener = new OpeningScreen(getWidth(), getHeight());
		transition = new NextScreen(getWidth(), getHeight());
		setScreen(opener);
		//setScreen(transition);
	}
	
	public static void main(String[] args) {
		catalog = new CatalogMakerGUI(800, 550);
		Thread go = new Thread(catalog);
		go.start();
	}

}
