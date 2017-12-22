package myStuff;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class NextScreen extends FullFunctionScreen {

	Graphic background;
	
	public NextScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		background = new Graphic(0, 0, 800, 550, "resources/opened.jpg");
		Button close = new Button((getWidth())/4, getHeight() - 100, 250, 30, "Click to close the card.", new Action() {
			@Override
			public void act() {
				CatalogMakerGUI.catalog.setScreen(CatalogMakerGUI.opener);
			}
		});
		viewObjects.add(background);
		viewObjects.add(close);
		

	}
	
	public void startFader() {
		background.setAlpha(0f);
		Thread fader = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(background.getAlpha() + 0.01 < 1.0) {
					background.setAlpha((float)(background.getAlpha() + 0.01));
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				background.setAlpha(1f);
			}
		});
		fader.start();
	}

}
