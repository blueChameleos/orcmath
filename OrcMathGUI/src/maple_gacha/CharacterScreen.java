package maple_gacha;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.ClickableCharacter;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CharacterScreen extends FullFunctionScreen {
	
	
	private static final long serialVersionUID = 6339468790728949736L;
	
	private boolean isOccupied;
	private boolean isOccupied2;
	private boolean isClicked;
	private boolean isClicked2;
	private boolean isFull;
	private ClickableCharacter g1;
	private ClickableCharacter g2;
	private ClickableCharacter g3;
	private ClickableCharacter g4;
	private ClickableCharacter g5;
	
	private ClickableCharacter c1;
	private ClickableCharacter c2;
	private ClickableCharacter c3;
	
	ArrayList<ClickableCharacter> clickList;
	ArrayList<ClickableCharacter> clickG;
	
	public CharacterScreen(int width, int height) {
		super(width, height);
		setVisible(true);
		isOccupied = false;
		isOccupied2 = false;
		isClicked = false;
		isClicked2 = false;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) { // this runs before beginnerselection updates the team class. 
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/screenPics/cardSystem.png");
		background.setVisible(true);
		viewObjects.add(background);

		clickList = new ArrayList<ClickableCharacter>();
		clickG = new ArrayList<ClickableCharacter>();
		
		clickList.add(g1);
		clickList.add(g2);
		clickList.add(g3);
		clickList.add(g4);
		clickList.add(g5);
		clickG.add(c1);
		clickG.add(c2);
		clickG.add(c3);
		for (int i=0;i<clickG.size();i++) {
			clickG.set(i,new ClickableCharacter(63+225*i,586,206,319,"resources/Empty.png",null));
			int number = i;
			clickG.get(i).setAction(new Action() {
				@Override
				public void act() {
					System.out.println(clickG.get(number).getHero());
					if(clickG.get(number).getHero() != null) {
						clickList.get(findEquality(clickG.get(number).getHero())).changebool();
						MainGame.game.currentTeam.remove(clickG.get(number).getHero());
						clickG.get(number).loadImages("resources/Empty.png", 206, 319);
					}
				}
			});
			viewObjects.add(clickG.get(i));
		}
		
		for(int i=0;i<clickList.size();i++) {
				int number = i;
				clickList.set(i, new ClickableCharacter(133+205*i,142,206,319,"resources/Empty2.png",null));
				System.out.println(i);
				clickList.get(i).setAction(new Action() {
					boolean enable = false; 
					@Override
					public void act() { 
						int arrSize = MainGame.game.currentTeam.size();
						if(arrSize == 0 && !clickList.get(number).returnbool()) {
							if(clickList.get(number).getHero() != null) {
								MainGame.game.currentTeam.add(clickList.get(number).getHero());
								System.out.println(clickList.get(number).getHero().getImage());
								clickG.get(0).loadImages(clickList.get(number).getHero().getImage(), 206, 319);
								System.out.println(clickG.get(0).getImageLocation());
								clickG.get(0).changeHero(clickList.get(number).getHero());
								clickList.get(number).changebool();
							}
						}else if(arrSize == 1 && !clickList.get(number).returnbool()) {
							if(clickList.get(number).getHero() != null) {
								MainGame.game.currentTeam.add(clickList.get(number).getHero());
								clickG.get(1).loadImages(clickList.get(number).getHero().getImage(), 206, 319);
								clickG.get(1).changeHero(clickList.get(number).getHero());
								clickList.get(number).changebool();
							}
						}else if(arrSize == 2
								&& !clickList.get(number).returnbool()) {
							if(clickList.get(number).getHero() != null) {
								MainGame.game.currentTeam.add(clickList.get(number).getHero());
								clickG.get(2).loadImages(clickList.get(number).getHero().getImage(), 206, 319);
								clickG.get(2).changeHero(clickList.get(number).getHero());
								clickList.get(number).changebool();
							}
						}
						
					}
				});
				viewObjects.add(clickList.get(number));

		}
	}
	
	public void reloadScreen() {
		int teamSize = MainGame.game.team.size();
		for(int i=0;i<teamSize;i++) {
			clickList.get(i).changeHero(MainGame.game.team.get(i));
			clickList.get(i).loadImages(MainGame.game.team.get(i).getImage(), 206, 319);
		}
	}
	
	public int findEquality(Hero hero) {
		for (int i=0;i<clickList.size();i++) {
			if(clickList.get(i).getHero()  == hero) {
				return i;
			}
		}
		return 0;
	}
}
	
	
