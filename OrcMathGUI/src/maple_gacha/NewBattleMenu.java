package maple_gacha;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPlayer.CustomPane;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Pane;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;

public class NewBattleMenu extends Pane {
	
	private static final long serialVersionUID = 6116383819049095100L;
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 175;
	public static Button attackbutton;
	public static Button defbutton;
	public static Button skillbutton;
	public static Button itembutton;

	public NewBattleMenu(FocusController focusController, int x, int y, int width, int height) {
		super(focusController, x, y, WIDTH, HEIGHT);
		// TODO Auto-generated constructor stub
	}

	public NewBattleMenu(FocusController focusController, int x, int y, int width, int height,
			ArrayList<Visible> initWithObjects) {
		super(focusController, x, y, width, height, initWithObjects);
		// TODO Auto-generated constructor stub
	}

	public void initAllObjects(List<Visible> viewObjects){
		
	}
}
