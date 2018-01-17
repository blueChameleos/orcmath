package maple_gacha;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class SummonScreen extends FullFunctionScreen implements Runnable{

	public SummonScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(false);

		
		
		// TODO Auto-generated method stub

		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/abc.png");
		viewObjects.add(background);

		Graphic banner = new Graphic((1280-650)/2 , 1024/2-350, 650, 350, "resources/banner.jpg");
		viewObjects.add(banner);

		Graphic banner1 = new Graphic(getWidth() / 2, getHeight() / 2, 650, 350, "resources/banner1.jpg");
		banner1.setVisible(false);
		//viewObjects.add(banner1);

		Button single = new Button(getWidth() / 2 + 50, getHeight() / 2 + 50, 75, 75, "x1", new Action() {

			@Override
			public void act() {
				// single summon button
			}
		});

		Button multi = new Button(500, 500, 50, 50, "x5", new Action() {

			@Override
			public void act() {
				// multi summon button
			}
		});
		
		multi.setBackground(Color.black);

		Button feature = new Button(getWidth() / 2 + 125, getHeight() / 2 + 125, 500, 75, "feature", new Action() {

			@Override
			public void act() {
				// feature summon button
			}
		});
		
		Button rightarrow = new Button(getWidth() / 2 + 125, getHeight() / 2 + 125, 300, 75, "feathgfjghjgure", new Action() {

			@Override
			public void act() {
				// feature summon button
			}
		});
		
		Button leftarrow = new Button(getWidth() / 2 + 125, getHeight() / 2 + 125, 25, 75, "awsfsdgsdasg", new Action() {

			@Override
			public void act() {
				// feature summon button
			}
		});
		viewObjects.add(single);
		viewObjects.add(multi);
		viewObjects.add(feature);
		viewObjects.add(rightarrow);
		viewObjects.add(leftarrow);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
