package myStuff;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
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
		Button open = new Button((getWidth() - 100)/2, getHeight() - 100, 250, 30, "Click to go to next screen", new Action() {
			@Override
			public void act() {
				CatalogMakerGUI.catalog.setScreen(CatalogMakerGUI.transition);
			}
		});
		viewObjects.add(open);
	}

}
