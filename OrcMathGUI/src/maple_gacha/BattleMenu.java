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
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 175;
	public static TextLabel playerHP;
	public static TextArea log;
	public static ItemMenu itemmenu;
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
		itemmenu = new ItemMenu(MainGame.game.battle, 25, 800);
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
