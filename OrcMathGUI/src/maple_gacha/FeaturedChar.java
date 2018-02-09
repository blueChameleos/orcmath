package maple_gacha;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Component;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class FeaturedChar extends FullFunctionScreen{
	private ArrayList<Hero> chars;
	private int index;
	private Graphic begArcher;
	private ArrayList<Hero> thing;
	private boolean ready;


	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}

	public FeaturedChar(int width, int height) {
		super(width, height);
//		setReady(false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		setReady(true);
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
		
//		TextArea title = new TextArea((int)(getWidth()/2 * .3), (int)(getHeight()/2 * .5), 150, 150, "Click the Character to check stats!");
//		viewObjects.add(title);
		//NOT READY TO SHOW YET.
		
		if(isReady()) {
//			System.out.println(MainGame.summon.getThings().get(0));
			
			TextArea descrip = new TextArea((int)(getWidth()/2 * .75), (int)(getHeight()/2 * .9), 150, 150, MainGame.summon.getThings().get(0).getRank() + " Rank");
			viewObjects.add(descrip);
			ClickableGraphic beg1 = new ClickableGraphic((int)(getWidth()/2 * .65), (int) (getHeight()/2) , 200, 200, MainGame.summon.getThings().get(0).getImage());
			beg1.setAction(new Action() {
				
				@Override
				public void act() {
					//Display Stats.
					TextArea stats = new TextArea((int)(getWidth()/2 * .65), (int) (getHeight()/2) , 200, 200, MainGame.summon.getThings().get(0).getImage());
					
				}
			});
			viewObjects.add(beg1);
		}
		
		Button goBack = new Button(50, 50, 150, 150, "Return", Color.yellow, new Action() {

			@Override
			public void act() {
//				begArcher.setVisible(false);
				MainGame.game.setScreen(MainGame.summon);
			}
		});
		viewObjects.add(goBack);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
