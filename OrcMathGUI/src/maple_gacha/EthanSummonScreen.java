package maple_gacha;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class EthanSummonScreen extends FullFunctionScreen implements Runnable {

	private ArrayList<BannerScreen> test;

	private int bannerNum;
	

	public EthanSummonScreen(int width, int height) {
		super(width, height);
		bannerNum = 1;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		try {
			File fontFile = new File("resources//PermanentMarker.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont = font.deriveFont(16f);
			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/abc.png");
//		background.loadImages("resources/mario.png", getWidth(), getHeight()); This line changes the image file
		viewObjects.add(background);

		Button rightarrow = new Button((int) (getWidth() / 10 * 7.75), (int) (getHeight() / 2 * .80), 178, 179, " ",
				new Action() {

					@Override
					public void act() {

					}
				});

		Button leftarrow = new Button((int) (getWidth() / 10 * .75), (int) (getHeight() / 2 * .80), 178, 179, " ",
				new Action() {

					@Override
					public void act() {

					}
				});

		viewObjects.add(rightarrow);
		viewObjects.add(leftarrow);

		StyledComponent.setButtonOutline(true);

		// somehow have it so not all buttons have the outline

		Graphic arrow = new Graphic((int) (getWidth() / 10 * .75), (int) (getHeight() / 2 * .80), 178, 179,
				"resources/picture1.png");
		viewObjects.add(arrow);

		Graphic arrow1 = new Graphic((int) ((getWidth() / 10) * 7.75), (int) (getHeight() / 2 * .80), 178, 179,
				"resources/picture2.png");
		viewObjects.add(arrow1);

		Graphic banner = new Graphic((int) (getWidth() / 10 * 2.5), (int) (getHeight() / 2 * .65), 650, 350,
				"resources/banner.jpg");
		viewObjects.add(banner);

		Graphic banner1 = new Graphic(getWidth() / 2, getHeight() / 2, 650, 350, "resources/banner1.jpg");
		banner1.setVisible(false);
		// viewObjects.add(banner1);

		Button single = new Button(500, 725, 50, 50, "x1", Color.yellow, new Action() {

			@Override
			public void act() {

				MainScreen.main.setScreen(MainScreen.single);

			}
		});

		single.setActiveBorderColor(null);

		Button multi = new Button(700, 725, 50, 50, "x5", Color.yellow, new Action() {

			@Override
			public void act() {
				// multi summon button
			}
		});

		Button feature = new Button(865, 290, 100, 75, "feature", Color.yellow, new Action() {

			@Override
			public void act() {
				// feature summon button
			}
		});

		viewObjects.add(single);
		viewObjects.add(multi);
		viewObjects.add(feature);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
