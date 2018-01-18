package maple_gacha;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class EthanSummonScreen extends FullFunctionScreen implements Runnable {

	public EthanSummonScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(true);

		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/abc.png");
		viewObjects.add(background);

		Graphic arrow = new Graphic(100, 250, 178, 179, "resources/picture1.png");
		viewObjects.add(arrow);

		Graphic arrow1 = new Graphic(1000, 250, 178, 179, "resources/picture2.png");
		viewObjects.add(arrow1);

		Graphic banner = new Graphic((1280 - 650) / 2, 1024 / 2 - 350, 650, 350, "resources/banner.jpg");
		viewObjects.add(banner);

		Graphic banner1 = new Graphic(getWidth() / 2, getHeight() / 2, 650, 350, "resources/banner1.jpg");
		banner1.setVisible(false);
		// viewObjects.add(banner1);

		Button single = new Button(500, 525, 50, 50, "x1", Color.yellow, new Action() {

			@Override
			public void act() {
				// single summon button
			}
		});

		Button multi = new Button(700, 525, 50, 50, "x5", Color.yellow, new Action() {

			@Override
			public void act() {
				// multi summon button
			}
		});

		Button feature = new Button(875, 125, 100, 75, "feature", Color.yellow, new Action() {

			@Override
			public void act() {
				// feature summon button
			}
		});

		Button rightarrow = new Button(1000, 250, 178, 179, " ", new Action() {

			@Override
			public void act() {
			}
		});

		Button leftarrow = new Button(100, 250, 178, 179, " ", new Action() {

			@Override
			public void act() {

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
