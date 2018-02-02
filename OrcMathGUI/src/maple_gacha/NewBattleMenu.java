package maple_gacha;

import java.util.ArrayList;

import guiTeacher.components.Pane;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;

public class NewBattleMenu extends Pane {
	
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 175;

	public NewBattleMenu(FocusController focusController, int x, int y, int width, int height) {
		super(focusController, x, y, WIDTH, HEIGHT);
		// TODO Auto-generated constructor stub
	}

	public NewBattleMenu(FocusController focusController, int x, int y, int width, int height,
			ArrayList<Visible> initWithObjects) {
		super(focusController, x, y, width, height, initWithObjects);
		// TODO Auto-generated constructor stub
	}

}
