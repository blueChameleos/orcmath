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
	
	private int roundNum;
	public static GBattleSystem backend;
	private static final long serialVersionUID = 2809999782648181302L;

	public BattleScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic background = getRandomBackground();
		viewObjects.add(background);
		
		
		BattleMenu itemMenu = new BattleMenu(roundNum, roundNum, null, null);
		itemMenu.setVisible(false);
		Button attackbttn = new Button(getWidth() - 300, getHeight() - 400, 250, 200, "Attack", new Action() {
			public void act() {
				backend.getCharacters().get(backend.getRound()).attack(currentEnemy, value);
			}
		});
		Button skillbttn = new Button(getWidth() - 275, getHeight() - 350, 275, 200, "Skill", new Action() {
			public void act() {
				backend.getCharacters().get(backend.getRound()).special();
			}
		});
		Button defbttn = new Button(getWidth() - 300, getHeight() - 350, 275, 200, "Guard", new Action() {
			public void act() {
				backend.getCharacters().get(backend.getRound()).guard();
			}
		});
		Button itembttn = new Button(getWidth() - 275, getHeight() - 350, 275, 200, "Items", new Action() {
			public void act() {
				itemMenu.setVisible(true);
			}
		});
		//
		
		
		//create menus for skills and items.
		
		
		//viewObjects.add(attackbttn);
		//viewObjects.add(skillbttn);
		//viewObjects.add(defbttn);
		viewObjects.add(itembttn);
		viewObjects.add(itemMenu);
		
	}

	private Graphic getRandomBackground() {
		return new Graphic(0,0, getWidth(), getHeight(), "resources/b_background"+0+".jpg");
	}

	@Override
	public void run() {
		
	}

}
