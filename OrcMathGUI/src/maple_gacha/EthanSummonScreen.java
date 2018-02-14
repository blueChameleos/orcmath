package maple_gacha;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class EthanSummonScreen extends FullFunctionScreen implements Runnable, BannerInterface {

	private ArrayList<Graphic> banners;	
	private ArrayList<Hero> heroes;
	private int[] bannerName;
	private int index;
	private int nx;
	private TextArea error;
	private TextArea count;
	private static DavidGetCharacterSingle singleScreen;
	private int BANNER_WIDTH;
	private int BANNER_HEIGHT;
	private CustomCursor customCursor;
	private EthanSummonScreen hi;


	public EthanSummonScreen(int width, int height) {
		super(width, height);
	}
	
	
	public void add(Graphic bannerImg) {
		banners.add(bannerImg);
	}
	
	public TextArea getCount() {
		return count;
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
			}else {
				index--;
			}
			Graphic temp = banners.get(2);
			banners.add(0, temp);
			banners.remove(3);
		}
		
	}
	
	public int getNx() {
		return nx;
	}


	public void setNx(int nx) {
		this.nx = nx;
	}


	private boolean canSummon(int type) {
		//type 0 is single type 1 is multi
		if(nx >= 5 && type == 0) {
			setNx(getNx()-5);
			return true;
		}else {
			if(nx >= 25 && type == 1) {
				setNx(getNx()-25);
				return true;
			}
		}
		return false;
	}

	private void cantSummon() {
		error.setVisible(true);
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		customCursor = new CustomCursor(this); //for some odd reason the cursor doesn't update unless you minimize the GUI and come back
		BANNER_WIDTH = (int) (getWidth() / 10 * 2.5);
		BANNER_HEIGHT = (int) (getHeight() / 2 * .65);
		index = 0;
//		System.out.println(getNx());
		setNx(999999);
//		setNx(getNx());//for some reason I can't make this actually change on featuredchar thing.
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
		
		Graphic currency = new Graphic((int) (getWidth() / 10 * 2.5), (int) (getHeight() / 2 * .5), 75, 75,
				"resources/nx1.jpg");
		viewObjects.add(currency);
		
		count = new TextArea((int) (getWidth() / 10 * 2.5), (int) (getHeight() / 2 * .525), 500, 500, "  " + getNx()
		+ " NX");
		count.setText("  " + nx + " NX");
		viewObjects.add(count);
		
		error = new TextArea(BANNER_WIDTH, BANNER_HEIGHT, 150, 150, "You do not have enough nx!");
		viewObjects.add(error);
		error.setVisible(false);
		
		Graphic banner = new Graphic(BANNER_WIDTH, BANNER_HEIGHT, 650, 350,
				"resources/banner.jpg");
		add(banner);

		Graphic banner1 = new Graphic(BANNER_WIDTH, BANNER_HEIGHT, 650, 350,
				"resources/banner1.jpg");
		add(banner1);
		
		Graphic banner2 = new Graphic(BANNER_WIDTH, BANNER_HEIGHT, 650, 350, "resources/banner2.jpeg");
		add(banner2);
		
		viewObjects.add(banners.get(0));

		ClickableGraphic leftArrow = new ClickableGraphic((int) (getWidth() / 10 * .75), (int) (getHeight() / 2 * .80), 178, 179,
				"resources/picture1.png");
		
		leftArrow.setAction(new Action() {
			
			@Override
			public void act() {
				changeBanner("left");
				viewObjects.add(banners.get(0));
				setNx(1000);
				getCount().setText("  " + getNx() + " NX");
			}
		});
		viewObjects.add(leftArrow);
		
		ClickableGraphic rightArrow = new ClickableGraphic((int) (getWidth() / 10 * 7.75), (int) (getHeight() / 2 * .80), 178, 179,
				"resources/picture2.png");
		
		rightArrow.setAction(new Action() {
			
			@Override
			public void act() {
				changeBanner("right");
				viewObjects.add(banners.get(0));	
			}
		});
		viewObjects.add(rightArrow);

		
		Button single = new Button((int) (getWidth() / 10 * 3.75), (int) (getHeight() / 2 * 1.4), 50, 50, "x1", Color.yellow, new Action() {
			public void act() {
				if(canSummon(0)) {
					//0 = single summon
					setPotentialChars();
					count.setText("  " + getNx() + " NX");
					MainGame.game.setScreen(new DavidGetCharacterSingle(getWidth(), getHeight()));
				}else {
					cantSummon();
				}
			}
		});

		single.setActiveBorderColor(null);

		Button multi = new Button((int) (getWidth() / 10 * 6), (int) (getHeight() / 2 * 1.4), 50, 50, "x5", Color.yellow, new Action() {

			@Override
			public void act() {
				//0 = singlesummon
				if(canSummon(1)) {
					count.setText("  " + getNx() + " NX");
					MainGame.game.setScreen(new DavidGetCharacterMulti(getWidth(), getHeight()));
				}else {
					cantSummon();
				}
			}
		});

		Button feature = new Button((int) (getWidth()/2 * 1.36) , (int)(getHeight()/2 * .51), 100, 75, "featured", Color.yellow, new Action() {

			@Override
			public void act() {
				setPotentialChars();
				FeaturedChar newFScreen = new FeaturedChar(getWidth(), getHeight());
				newFScreen.setReady(true);
				newFScreen.setIndex(bannerType());
				MainGame.game.setScreen(newFScreen);
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


	@Override
	public void summonBanner(int idx) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setPotentialChars() {
		ArrayList<Hero> hero = new ArrayList<Hero>();
		if(bannerType() == 0) {
			hero.add(MainGame.highPrincess);
			hero.add(MainGame.beginnerSword);
			hero.add(MainGame.mediumAxe);
			hero.add(MainGame.highTank);
			hero.add(MainGame.bCoolGuys);
			
			setThings(hero);
		}
		if(bannerType() == 1) {
			hero.add(MainGame.highAssassin);
			hero.add(MainGame.beginnerArcher);
			hero.add(MainGame.mediumWitch);
			hero.add(MainGame.mediumHighSchoolGirl);
			hero.add(MainGame.bFanWoman);
			
			setThings(hero);
		}
		if(bannerType() == 2) {
			hero.add(MainGame.highSirandHorse);
			hero.add(MainGame.beginnerWizard);
			hero.add(MainGame.mediumWitch);
			hero.add(MainGame.mediumWizard);
			hero.add(MainGame.mediumWolfGirl);
			setThings(hero);
		}
	}

	public void setThings(ArrayList<Hero> thing){
		heroes = thing;
	}
	
	public ArrayList<Hero> getThings() {
		return heroes;
	}

	@Override
	public int bannerType() {
		return getIndex();
		
	}


	public int getIndex() {
		return index;
	}

}
