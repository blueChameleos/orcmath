package maple_gacha;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ComponentContainer;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class BattleScreen extends FullFunctionScreen implements Runnable{
	
	private static final long serialVersionUID = 2809999782648181302L;
	private int roundNum;
	public static GBattleSystem backend;
	public static Button attackbttn;
	public static Button skillbttn;
	public static Button defbttn;
	public static Button itembttn;
	public static NewBattleMenu userui;
	
	public BattleScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic background = getRandomBackground();
		userui = new NewBattleMenu(this,30, 800);
		
//		BattleMenu itemMenu = new BattleMenu(roundNum, roundNum, null, null);
//		itemMenu.setVisible(false);
		attackbttn = new Button(getWidth() - 300, getHeight() - 400, 250, 200, "Attack", new Action() {
			public void act() {
				backend.getCharacters().get(backend.getRound()).attack(currentEnemy, value);
			}
		});
		skillbttn = new Button(getWidth() - 275, getHeight() - 350, 275, 200, "Skill", new Action() {
			public void act() {
				backend.getCharacters().get(backend.getRound()).special();
			}
		});
		defbttn = new Button(getWidth() - 300, getHeight() - 350, 275, 200, "Guard", new Action() {
			public void act() {
				backend.getCharacters().get(backend.getRound()).guard();
			}
		});
		itembttn = new Button(getWidth() - 275, getHeight() - 350, 275, 200, "Items", new Action() {
			public void act() {
				
//				itemMenu.setVisible(true);
			}
		});
		//
		
		
		//create menus for skills and items.
		
		viewObjects.add(background);
		//viewObjects.add(attackbttn);
		//viewObjects.add(skillbttn);
		//viewObjects.add(defbttn);
		viewObjects.add(itembttn);
//		viewObjects.add(itemMenu);
		
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
 