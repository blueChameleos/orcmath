package maple_gacha;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class FeaturedChar extends FullFunctionScreen implements BannerInterface {
	private ArrayList<Hero> chars;

	public FeaturedChar(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/abc.png");
		viewObjects.add(background);
		
		StyledComponent.setButtonOutline(false);
		try {
			File fontFile = new File("resources//PermanentMarker.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont = font.deriveFont(16f);
			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Hero featuredChar1 = new Hero("resources/characterPics/Hero_HighTank.png","B", 10, 10, 10, 10, 100);
		Graphic begArcher = new Graphic(getWidth()/2, (int) (getHeight()/2 * .9) , 200, 200, featuredChar1.getImage());
//		System.out.println("went past statement");
		viewObjects.add(begArcher);
		
		Button goBack = new Button(50, 50, 150, 150, "Return", Color.yellow, new Action() {
			
			@Override
			public void act() {
				MainGame.game.setScreen(MainGame.summon);
			}
		});
		viewObjects.add(goBack);
	}

	@Override
	public void summonBanner(int idx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPotentialChars(ArrayList<Hero> chars, int type) {
		if(checkFeatured()) {
			//change for only featured chars.
		}
		//else it does this.
		
	}

	private boolean checkFeatured() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void bannerType(int idx) {
		// TODO Auto-generated method stub
		
	}

}
