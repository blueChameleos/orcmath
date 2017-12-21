package myStuff;

import java.util.List;

import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class OpeningScreen extends FullFunctionScreen {
	
	public static CatalogMakerGUI catalog;

	public OpeningScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
	}

	public static void main(String[] args) {
		catalog = new CatalogMakerGUI(800, 550);
		Thread go = new Thread(catalog);
		go.start();
	}

}
