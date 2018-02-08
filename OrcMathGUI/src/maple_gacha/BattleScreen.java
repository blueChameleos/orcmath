package maple_gacha;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableCharacter;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ComponentContainer;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class BattleScreen extends FullFunctionScreen implements Runnable{
	
	private static final long serialVersionUID = 2809999782648181302L;
	private int roundNum;
	public static GBattleSystem backend;
	public static BattleMenu userui;
	public static ItemMenu itemui;
	
	public static ClickableGraphic heroPos1;
	public static ClickableGraphic heroPos2;
	public static ClickableGraphic heroPos3;
	
	public static ClickableGraphic monsterPos1;
	public static ClickableGraphic monsterPos2;
	public static ClickableGraphic monsterPos3;
	
	ArrayList<ClickableGraphic> clickHero;
	ArrayList<ClickableGraphic> clickMonster;
	
	public BattleScreen(int width, int height) {
		super(width, height);
		Hero[] currentTeam = new Hero[MainGame.currentTeam.size()];
		for(int i=0;i<currentTeam.length;i++) {
			currentTeam[i] = MainGame.currentTeam.get(i);
		}
		
		
		backend = new GBattleSystem(1,currentTeam);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		int playerSizeH = 100;
		int playerSizeW = 100;
		Graphic background = getRandomBackground();
		viewObjects.add(background);
		clickHero = new ArrayList<ClickableGraphic>(); 
		clickHero.add(heroPos1);
		clickHero.add(heroPos2);
		clickHero.add(heroPos3);
		userui = new BattleMenu(this,30,800);
		userui.update();
		itemui = new ItemMenu(this, 1000, 400);
		itemui.setVisible(false);
		viewObjects.add(userui);
		viewObjects.add(itemui);
		for(int i=0;i<MainGame.currentTeam.size();i++) {
			int number = i;
			clickHero.set(i, new ClickableGraphic(700+(i*100),600,playerSizeW,playerSizeH,MainGame.currentTeam.get(i).getImage()));
			clickHero.get(i).setAction(new Action() {
				@Override
				public void act() {
					userui.playerPortrait.loadImages(MainGame.currentTeam.get(number).getImage(), 150, 150);
					userui.update();
				}
			});
			viewObjects.add(clickHero.get(i));
		}
	} 

	private Graphic getRandomBackground() {
		return new Graphic(0,0, getWidth(), getHeight(), "resources/b_background"+0+".jpg");
	}
	
	@Override
	public void run() {

	}

	public void SwitchUIAI() {
		
	}

	public void SwitchAIUI() {
		
	}
 
}
 