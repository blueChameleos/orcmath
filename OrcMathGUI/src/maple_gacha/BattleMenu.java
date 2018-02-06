package maple_gacha;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPlayer.CustomPane;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Pane;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;

public class BattleMenu extends Pane {
	
	private static final long serialVersionUID = 6116383819049095100L;
	private static final int WIDTH = 1180;
	private static final int HEIGHT = 175;
	public static TextLabel playerHP;
	public static TextArea log;
//	public static ItemMenu itemmenu;
	public static Button attackbutton;
	public static Button defbutton;
	public static Button skillbutton;
	public static Button itembutton;
	
	public BattleMenu(FocusController focusController, int x, int y) {
		super(focusController, x, y, WIDTH, HEIGHT);
	}

	public BattleMenu(FocusController focusController, int x, int y, int width, int height) {
		super(focusController, x, y, WIDTH, HEIGHT);
		// TODO Auto-generated constructor stub
	}

	public BattleMenu(FocusController focusController, int x, int y, int width, int height, ArrayList<Visible> initWithObjects) {
		super(focusController, x, y, width, height, initWithObjects);
		// TODO Auto-generated constructor stub
	}

	public void initAllObjects(List<Visible> viewObjects){
		this.setAlpha((float) 0.5);
		this.setBackground(Color.BLUE);
//		itemmenu = new ItemMenu(MainGame.game.battle, 25, 800);
		attackbutton = new Button(900, 10, 120, 75, "Attack", new Action() {
			@Override
			public void act() {
				System.out.println(MainGame.game.battle.backend.getCurrentEnemy());
				System.out.println(MainGame.game.battle.backend.getCurrentEnemy().getHp());
				MainGame.game.battle.backend.getCurrentEnemy().setHP(MainGame.game.battle.backend.getCurrentEnemy().getHP() - MainGame.game.battle.backend.getCurrentPlayer().getAttack());
				System.out.println(MainGame.game.battle.backend.getCurrentEnemy().getHp());
			}
		});
		attackbutton.setBackgroundColor(Color.YELLOW);
		defbutton = new Button(1030, 85, 120, 75, "Guard", new Action() {
			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
		});
		defbutton.setBackgroundColor(Color.YELLOW);
		skillbutton = new Button(900, 85, 120, 75, "Skill", new Action() {
			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
		});
		skillbutton.setBackgroundColor(Color.YELLOW);
		itembutton = new Button(1030, 10, 120, 75, "Item", new Action() {
			@Override
			public void act() {
//				itemmenu.setVisible(true);
			}
		});
		itembutton.setBackgroundColor(Color.YELLOW);
		
		viewObjects.add(attackbutton);
		viewObjects.add(defbutton);
		viewObjects.add(skillbutton);
		viewObjects.add(itembutton);
		//viewObjects.add(log);
	}
	
	public void playText(String text) {
		int i = 1;
		while(log.getText().length() < text.length()) {
			log.setText(text.substring(0, i));
		}
	}
	
	public void updateHPBars() {
		//updates both hp bars not sure how to do it rn
	}
	
	public void updateImgs() {
		//updates the current player img
	}
}
