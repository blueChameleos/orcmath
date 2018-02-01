package maple_gacha;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableCharacter;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.CustomImageButton;
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
	
	public int startPos;
	public int endPos;
	
	private ClickableGraphic arrow1;
	private ClickableGraphic arrow2;
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
		
		arrow1 = new ClickableGraphic(40,220,75,100,"resources/screenPics/arrow.jpg");
		arrow1.setAction(new Action() {
			
			@Override
			public void act() {
				if (startPos > 0) {
					startPos--;
					endPos--;
					changeScreen(startPos,endPos);
				}
				
			}
		});
		viewObjects.add(arrow1);
		arrow2 = new ClickableGraphic(1172,220,75,100,"resources/screenPics/arrow2"+ ".jpg");
		
		arrow2.setAction(new Action() {
			
			@Override
			public void act() {
				if (endPos < MainGame.team.size()) {
					startPos++;
					endPos++;
					System.out.println(startPos +"  "+ endPos);
					changeScreen(startPos,endPos);
				}
				
			}
		});
		viewObjects.add(arrow2);
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
					if(clickG.get(number).getHero() != null) {
						MainGame.game.currentTeam.remove(clickG.get(number).getHero());
						clickG.get(number).loadImages("resources/Empty.png", 206, 319);
						MainGame.team.get(findEquality(clickG.get(number).getHero())).setClickE();
						reloadC1();
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
						System.out.println(!MainGame.team.get(findEquality(clickList.get(number).getHero())).isClickE());
						if(arrSize == 0 ) {
							if(clickList.get(number).getHero() != null && !MainGame.team.get(findEquality(clickList.get(number).getHero())).isClickE()){
								System.out.println(!MainGame.team.get(findEquality(clickList.get(number).getHero())).isClickE());
								MainGame.game.currentTeam.add(clickList.get(number).getHero());
								clickG.get(0).loadImages(clickList.get(number).getHero().getImage(), 206, 319);			
								clickG.get(0).changeHero(clickList.get(number).getHero());
								MainGame.team.get(findEquality(clickList.get(number).getHero())).setClickE();
							}
						}else if(arrSize == 1 ) {
							if(clickList.get(number).getHero() != null && !MainGame.team.get(findEquality(clickList.get(number).getHero())).isClickE()) {
								MainGame.game.currentTeam.add(clickList.get(number).getHero());
								clickG.get(1).loadImages(clickList.get(number).getHero().getImage(), 206, 319);
								clickG.get(1).changeHero(clickList.get(number).getHero());
								MainGame.team.get(findEquality(clickList.get(number).getHero())).setClickE();

							}
						}else if(arrSize == 2 ) {
							if(clickList.get(number).getHero() != null ) {
								MainGame.game.currentTeam.add(clickList.get(number).getHero());
								clickG.get(2).loadImages(clickList.get(number).getHero().getImage(), 207, 313);
								clickG.get(2).changeHero(clickList.get(number).getHero());
								MainGame.team.get(findEquality(clickList.get(number).getHero())).setClickE();
								
							}
						}
						
					}
				});
				viewObjects.add(clickList.get(number));

		}
	}
	
	public void reloadScreen() {
		startPos = 0;
		endPos =  MainGame.team.size();
		if (MainGame.team.size() >= 5) {
			endPos = 5;
		}
		int teamSize = MainGame.team.size();
		if (teamSize > 5) {
			teamSize = 5;
		}
		for(int i=0;i<teamSize;i++) {
			MainGame.team.get(i).reloadID();
			clickList.get(i).changeHero(MainGame.team.get(i));
			clickList.get(i).loadImages(MainGame.team.get(i).getImage(), 206, 319);
		}
	}
	
	public void changeScreen(int start,int end) {
		System.out.println("xd");
		for(int i=start;i<end;i++) {//ss
			MainGame.team.get(i).reloadID();
			clickList.get(i).changeHero(MainGame.team.get(i));
			clickList.get(i).loadImages(MainGame.team.get(i).getImage(), 206, 319);
		}
	}
	
	public void reloadC1() {
		int teamSize = MainGame.currentTeam.size();
		clearC1();
		for(int i=0;i<teamSize;i++) {
			MainGame.currentTeam.get(i).reloadID();
			clickG.get(i).changeHero( MainGame.currentTeam.get(i));
			clickG.get(i).loadImages( MainGame.currentTeam.get(i).getImage(), 206, 319);
		}
	}
	
	public void clearC1() {
		for(int i=0;i<3;i++) {
			clickG.get(i).changeHero(null);
			clickG.get(i).loadImages("resources/Empty.png", 206, 319);
		}
	}
	public int findEquality(Hero hero) {
		for (int i=0;i<MainGame.game.team.size();i++) { 
			if(clickList.get(i).getHero()  == hero) {
				return i;
			}
		}
		return 0;
	}
}
	
	