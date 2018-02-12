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
		idx = -1;
		startPos = 0;
		endPos =  MainGame.team.size();
		if (MainGame.team.size() >= 5) {
			endPos = 5;
		}
		
		arrow1 = new ClickableGraphic(40,220,75,100,"resources/screenPics/arrow.jpg");
		arrow1.setAction(new Action() {
			
			@Override
			public void act() {
				if (startPos > 0) {
					System.out.println("aah");
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
					changeScreen(startPos,endPos);
				}
				
			}
		});
		viewObjects.add(arrow2);
		
		confirmation = new TextArea(745,580,475,320,"");
		viewObjects.add(confirmation);
		
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
			int number = i;
			clickG.get(i).setAction(new Action() {
			
				@Override
				public void act() {
					if(clickG.get(number).getHero() != null) {
						MainGame.currentTeam.remove(clickG.get(number).getHero());
						MainGame.team.get(findEquality(clickG.get(number).getHero())).setClickE();
						reloadC1();
					}
					
				}
			});
			clickG.get(i).setHoverAction(new Action() {
				public void act() {
					if(idx != number && (clickG.get(number).getHero() != null)) {
						System.out.println(number);
						idx = number;
					confirmation.setText("Rank = " + clickG.get(number).getHero().getRank() + "\n" +
							"Strength = " + clickG.get(number).getHero().getStrength() + "\n" + 
							"Speed = " + clickG.get(number).getHero().getSpeed() + "\n" + 
							"Attack = " + clickG.get(number).getHero().getAttack() + "\n" + 
							"Defense = " + clickG.get(number).getHero().getDefense() + "\n" +
							"HP = " + clickG.get(number).getHero().getHP() + "\n" +
							"Unique ID = " + clickG.get(number).getHero().getUniqueID() + "\n");
					}
				}
			});
			
			viewObjects.add(clickG.get(i));
		}
		for (int i =0;i<MainGame.currentTeam.size();i++) {
			clickG.get(i).setHero((MainGame.currentTeam.get(i)));
			clickG.get(i).run();
		}
		for(int i = 0;i<5;i++) {
			if (MainGame.team.size() > i) {
				clickList.set(i, new CardPane(this,133+205*i,142,206,319,MainGame.team.get(i)));
				clickList.get(i).setHero(MainGame.team.get(i));
				clickList.get(i).run();
				clickList.get(i).update();
			} else {
				clickList.set(i, new CardPane(this,133+205*i,142,206,319,null));
			}
			int number = i;
			clickList.get(i).setAction(new Action() {
				@Override
				public void act() {
					System.out.println(clickList.get(number).getHero().isClickE());
					int arrSize = MainGame.currentTeam.size();
					if(arrSize == 0 ) {
						if(clickList.get(number).getHero() != null && !MainGame.team.get(findEquality(clickList.get(number).getHero())).isClickE()){
							MainGame.currentTeam.add(clickList.get(number).getHero());
							clickG.get(0).setHero(clickList.get(number).getHero());
							clickG.get(0).run();
							clickG.get(0).update();
							MainGame.team.get(findEquality(clickList.get(number).getHero())).setClickE();
						}
					}else if(arrSize == 1 ) {
						if(clickList.get(number).getHero() != null && !MainGame.team.get(findEquality(clickList.get(number).getHero())).isClickE()){
							MainGame.currentTeam.add(clickList.get(number).getHero());
							clickG.get(1).setHero(clickList.get(number).getHero());
							clickG.get(1).run();
							clickG.get(1).update();
							MainGame.team.get(findEquality(clickList.get(number).getHero())).setClickE();
						}
					}else if(arrSize == 2 ) {
						if(clickList.get(number).getHero() != null && !MainGame.team.get(findEquality(clickList.get(number).getHero())).isClickE()){
							MainGame.currentTeam.add(clickList.get(number).getHero());
							clickG.get(2).setHero(clickList.get(number).getHero());
							clickG.get(2).run();
							clickG.get(2).update();
							MainGame.team.get(findEquality(clickList.get(number).getHero())).setClickE();
						}
					}
				}
			});
			viewObjects.add(clickList.get(i));
			next = new Button(1100,925,140,80,"MENU",Color.yellow,new Action() {
				@Override
				public void act() {
					MainGame.main.reload();
					MainGame.game.setScreen(MainGame.main);
					
				}
				
			});
			viewObjects.add(next);
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
	
	public void changeScreen(int start,int end) {
		System.out.println("xd");
		int checker = end - start;
		int count = start;
		for(int i=0;i<checker;i++) {//ss
			clickList.get(i).setHero((MainGame.team.get(count)));
			clickList.get(i).run();
			count++;
		}
	}
	public void reloadC1() {
		int teamSize = MainGame.currentTeam.size();
		clearC1();
		for(int i=0;i<teamSize;i++) {
			clickG.get(i).setHero((MainGame.currentTeam.get(i)));
			clickG.get(i).run();
		}
	}
	
	public void clearC1() {
		for(int i=0;i<3;i++) {
			clickG.get(i).setHero(null);
			clickG.get(i).hide();
		}
	}
}
	
	