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

	private ArrayList<Graphic> banners;	
	private int index;

	public EthanSummonScreen(int width, int height) {
		super(width, height);
	}
	
	
	public void add(Graphic bannerImg) {
		banners.add(bannerImg);
	}
	public void changeBanner(String position) {
		if(position.equals("right")) {
			if(index >= 2) {
				index = 0;
			}else {
				index++;
			}
			Graphic temp = banners.get(0);
			banners.add(temp);
			banners.remove(0);
		}else {
			//can only be left now
			if(index <= 0) {
				index = 2;
				System.out.println(index);
			}else {
				index--;
				System.out.println(index);
			}
			Graphic temp = banners.get(2);
			banners.add(0, temp);
			banners.remove(3);
		}
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		index = 0;
		banners = new ArrayList<Graphic>();
		StyledComponent.setButtonOutline(false);
		try {
			File fontFile = new File("resources//PermanentMarker.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont = font.deriveFont(16f);
			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/abc.png");
		viewObjects.add(background);
		

		Graphic banner = new Graphic((int) (getWidth() / 10 * 2.5), (int) (getHeight() / 2 * .65), 650, 350,
				"resources/banner.jpg");
		add(banner);

		//This should probably be part of the arraylist somehow?
		Graphic banner1 = new Graphic((int) (getWidth() / 10 * 2.5), (int) (getHeight() / 2 * .65), 650, 350,
				"resources/banner1.jpg");
		add(banner1);
		
		Graphic banner2 = new Graphic((int) (getWidth() / 10 * 2.5), (int) (getHeight() / 2 * .65), 650, 350, "resources/banner2.jpeg");
		add(banner2);
		
		viewObjects.add(banners.get(0));

		Button rightarrow = new Button((int) (getWidth() / 10 * 7.75), (int) (getHeight() / 2 * .80), 178, 179, " ",
				new Action() {

					@Override
					public void act() {
						changeBanner("right");
						viewObjects.add(banners.get(0));
					}
				});

		Button leftarrow = new Button((int) (getWidth() / 10 * .75), (int) (getHeight() / 2 * .80), 178, 179, " ",
				new Action() {

					@Override
					public void act() {
						changeBanner("left");
						viewObjects.add(banners.get(0));
					}
				});

		viewObjects.add(rightarrow);
		viewObjects.add(leftarrow);

		StyledComponent.setButtonOutline(true);

		Graphic arrow = new Graphic((int) (getWidth() / 10 * .75), (int) (getHeight() / 2 * .80), 178, 179,
				"resources/picture1.png");
		viewObjects.add(arrow);

		Graphic arrow1 = new Graphic((int) ((getWidth() / 10) * 7.75), (int) (getHeight() / 2 * .80), 178, 179,
				"resources/picture2.png");
		viewObjects.add(arrow1);
		
		Button single = new Button((int) (getWidth() / 10 * 3.75), (int) (getHeight() / 2 * 1.4), 50, 50, "x1", Color.yellow, new Action() {

			@Override
			public void act() {

				MainGame.game.setScreen(MainGame.single);

			}
		});

		single.setActiveBorderColor(null);

		Button multi = new Button((int) (getWidth() / 10 * 6), (int) (getHeight() / 2 * 1.4), 50, 50, "x5", Color.yellow, new Action() {

			@Override
			public void act() {
				MainGame.game.setScreen(MainGame.multi);			}
		});

		Button feature = new Button((int) (getWidth()/2 * 1.36) , (int)(getHeight()/2 * .51), 100, 75, "featured", Color.yellow, new Action() {

			@Override
			public void act() {
				//arraylist of featured characters?
			}
		});
		
		Button mainMenu = new Button((int) (getWidth() / 10 * 4.75), (int) (getHeight() / 2 * 1.5), 100, 75, "Main Menu", Color.yellow, new Action() {

			@Override
			public void act() {
				MainGame.game.setScreen(MainGame.main);
			}
		});

		viewObjects.add(single);
		viewObjects.add(multi);
		viewObjects.add(mainMenu);
		viewObjects.add(feature);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
