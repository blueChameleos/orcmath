package maple_gacha;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPlayer.CustomPane;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.Pane;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;

public class BattleMenu extends Pane implements Runnable{

	private static final long serialVersionUID = 6116383819049095100L;
	private static final int WIDTH = 1180;
	private static final int HEIGHT = 175;
	public static TextLabel playerHP;
	public static Thread printer;
	public static boolean printingText;
	public static TextArea log;
	public static Graphic playerPortrait;
	public static Button attackbutton;
	public static Button defbutton;
	public static Button skillbutton;
	public static Button itembutton;
	public static Button[] buttons = new Button[4];

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
		this.setAlpha((float) 0.75);
		this.setBackground(Color.BLUE);
		buttons[0] = attackbutton;
		buttons[1] = defbutton;
		buttons[2] = skillbutton;
		buttons[3] = itembutton;
		log = new TextArea(250, 15, 630, 145, "");
		log.setBackgroundColor(Color.WHITE);
		playerPortrait = new Graphic(100,20,150,150,"resources/char.jpg");
		viewObjects.add(playerPortrait);
		attackbutton = new Button(900, 10, 120, 65, "Attack", Color.YELLOW, new Action() {
			@Override
			public void act() {
				MainGame.game.battle.backend.getCurrentEnemy().setHP(MainGame.game.battle.backend.getCurrentEnemy().getHP() - MainGame.game.battle.backend.getCurrentPlayer().getAttack());
				updateLog(MainGame.game.battle.backend.getCurrentPlayer() + " attacked " + MainGame.game.battle.backend.getCurrentEnemy() + "!");
				MainGame.game.battle.backend.checkChanges();
				MainGame.game.battle.backend.setWaiting(false);
				MainGame.game.battle.game.interrupt();
			}
		});
		defbutton = new Button(1030, 85, 120, 65, "Guard", Color.YELLOW, new Action() {
			@Override
			public void act() {
				MainGame.game.battle.backend.getCurrentPlayer().setGuard(true);
				updateLog(MainGame.game.battle.backend.getCurrentPlayer() + " guarded!");
				MainGame.game.battle.backend.setWaiting(false);
				MainGame.game.battle.game.interrupt();
			}
		});
		skillbutton = new Button(900, 85, 120, 65, "Skill", Color.YELLOW, new Action() {
			@Override
			public void act() {
				MainGame.game.battle.backend.getCurrentPlayer().special();
				updateLog(MainGame.game.battle.backend.getCurrentPlayer() + " used a special skill!");
				MainGame.game.battle.backend.checkChanges();
				MainGame.game.battle.backend.setWaiting(false);
				MainGame.game.battle.game.interrupt();
			}
		});
		itembutton = new Button(1030, 10, 120, 65, "Item", Color.YELLOW, new Action() {
			@Override
			public void act() {
				showItemMenu();
			}
		});

		viewObjects.add(attackbutton);
		viewObjects.add(defbutton);;
		viewObjects.add(skillbutton);
		viewObjects.add(itembutton);
		viewObjects.add(log);
	}
	
	public void showItemMenu() {
		Thread animator = new Thread(new Runnable() {
			
			@Override
			public void run() {
				attackbutton.setEnabled(false);
				defbutton.setEnabled(false);
				skillbutton.setEnabled(false);
				itembutton.setEnabled(false);
				while(MainGame.game.battle.itemui.getAlpha() < 0.99) {
					MainGame.game.battle.itemui.setAlpha((float)(MainGame.game.battle.itemui.getAlpha() + 0.01));
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				MainGame.game.battle.itemui.setAlpha(1);
			}
		});
		MainGame.game.battle.itemui.setAlpha(0);
		MainGame.game.battle.itemui.setVisible(true);
		animator.start();
	}
	
	public void hideItemMenu() {
		Thread animator = new Thread(new Runnable() {
			@Override
			public void run() {
				attackbutton.setEnabled(true);
				defbutton.setEnabled(true);
				skillbutton.setEnabled(true);
				itembutton.setEnabled(true);
				MainGame.game.battle.backend.setWaiting(false);
				MainGame.game.battle.itemui.setAlpha(1);
				while(MainGame.game.battle.itemui.getAlpha() > 0) {
					MainGame.game.battle.itemui.setAlpha((float)(MainGame.game.battle.itemui.getAlpha() - 0.01));
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		MainGame.game.battle.itemui.setAlpha(1);
		MainGame.game.battle.itemui.setVisible(false);
		animator.start();
	}

	public void updateLog(String text) {
		printer = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				log.setText("");
				for(int i = 0; i < text.length(); i++) {
					log.setText(log.getText()+ text.substring(i, i+1));
					BattleMenu.this.update();
					try {
						Thread.sleep(1000/60);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		printer.start();
	}

	public void updateHPBars() {
		//updates both hp bars not sure how to do it rn
	}

	public void updateImgs() {
		//updates the current player img
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
