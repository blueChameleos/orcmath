package maple_gacha;

import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
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
	private boolean ready;
	private TextArea stats;
	private int toggle;
	private CustomCursor customCursor;


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
		customCursor = new CustomCursor(this);
		toggle = 0;
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
		
		stats = new TextArea(getWidth()/2, (int) (getHeight()/2 * .9), 250, 250, "");
		stats.setVisible(false);
		viewObjects.add(stats);
		
		if(isReady()) {
			
			Button displayStats = new Button(getWidth()/2, (int) (getHeight()/2 * .65), 125, 100, "Show/hide stats", Color.YELLOW, new Action() {
				
				@Override
				public void act() {
					if(toggle == 0) {
						stats.setVisible(true);
						stats.setText("RANK: " + MainGame.summon.getThings().get(0).getRank() + "\n"
						+ "STR: " + MainGame.summon.getThings().get(0).getStrength() + "\n"
						+ "SPD: "  + MainGame.summon.getThings().get(0).getSpeed() + "\n"
						+ "ATK: " + MainGame.summon.getThings().get(0).getStrength() + "\n"
						+ "DEF: "+ MainGame.summon.getThings().get(0).getDefense()+ "\n"
						+ "HP: " + MainGame.summon.getThings().get(0).getHP() + "\n"
						+ "ID: " + MainGame.summon.getThings().get(0).getID()
								);
						toggle = 1;
					}else {
						stats.setVisible(false);
						toggle = 0;
					}
					
				}
			});
			viewObjects.add(displayStats);
			
			TextArea descrip = new TextArea((int)(getWidth()/2 * .65), (int)(getHeight()/2 * .9), 150, 150, "Rank: " + MainGame.summon.getThings()
					.get(0).getRank());
			viewObjects.add(descrip);
			ClickableGraphic beg1 = new ClickableGraphic((int)(getWidth()/2 * .7), (int) (getHeight()/2) , 200, 200, MainGame.summon.getThings()
					.get(0).getImage());
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
