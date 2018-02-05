package maple_gacha;

import java.util.ArrayList;

import guiTeacher.components.Pane;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;

public class ItemMenu extends Pane {

	private static final long serialVersionUID = -8249216153895539555L;
	public ArrayList<Items> itemlist;
	

	public ItemMenu(FocusController focusController, int x, int y, int width, int height) {
		super(focusController, x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public ItemMenu(FocusController focusController, int x, int y, int width, int height,
			ArrayList<Visible> initWithObjects) {
		super(focusController, x, y, width, height, initWithObjects);
		// TODO Auto-generated constructor stub
	}

}
