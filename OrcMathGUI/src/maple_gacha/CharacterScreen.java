package maple_gacha;


import java.awt.Color;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableCharacter;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.CustomImageButton;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CharacterScreen extends FullFunctionScreen {
	
	
	private static final long serialVersionUID = 6339468790728949736L;
	
	public int startPos;
	public int endPos;
	
	private int idx;
	private ClickableGraphic arrow1;
	private ClickableGraphic arrow2;
	private CardPane g1;
	private CardPane g2;
	private CardPane g3;
	private CardPane g4;
	private CardPane g5;
	
	private CardPane c1;
	private CardPane c2;
	private CardPane c3;
	
	private TextArea confirmation;
	
	private Button next;
	//m
	ArrayList<CardPane> clickList;
	ArrayList<CardPane> clickG;
	
	public CharacterScreen(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) { // this runs before beginnerselection updates the team class. 
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/screenPics/cardSystem.png");
		background.setVisible(true);
		viewObjects.add(background);
		
		clickList = new ArrayList<CardPane>();
		clickG = new ArrayList<CardPane>();
		
		clickList.add(g1);
		clickList.add(g2);
		clickList.add(g3);
		clickList.add(g4);
		clickList.add(g5);
		clickG.add(c1);
		clickG.add(c2);
		clickG.add(c3);
		for(int i = 0;i<3;i++) {
			clickG.set(i, new CardPane(this,63+225*i,586,206,319,null));
		}
		
		for(int i = 0;i<MainGame.team.size();i++) {
			clickList.set(i, new CardPane(this,133+205*i,142,206,319,MainGame.team.get(i)));
			clickList.get(i).setHero(MainGame.team.get(i));
			clickList.get(i).run();
			clickList.get(i).update();
			clickList.get(i).setAction(new Action() {
				
				@Override
				public void act() {
					// TODO Auto-generated method stub
					
				}
			});
			viewObjects.add(clickList.get(i));
		}
		
	}
	public int findEquality(Hero hero) {
		for (int i=0;i<MainGame.team.size();i++) { 
			if(MainGame.team.get(i).getID() == hero.getID()) {
				return i;
			}
		}
		return 0;
	}
}
	
	