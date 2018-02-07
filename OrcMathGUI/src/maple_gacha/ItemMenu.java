package maple_gacha;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Pane;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;

public class ItemMenu extends Pane {

	private static final long serialVersionUID = -8249216153895539555L;
	private static final int WIDTH = 250;
	private static final int HEIGHT = 600;
	public ArrayList<Items> itemlist;
	

	public ItemMenu(FocusController focusController, int x, int y, int width, int height) {
		super(focusController, x, y, width, height);
		addItems();
		// TODO Auto-generated constructor stub
	}

	public ItemMenu(FocusController focusController, int x, int y, int width, int height, ArrayList<Visible> initWithObjects) {
		super(focusController, x, y, width, height, initWithObjects);
		addItems();
		// TODO Auto-generated constructor stub
	}

	public ItemMenu(FocusController focusController, int x, int y) {
		super(focusController, x, y, WIDTH, HEIGHT);
		addItems();
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		int x = getWidth() + 30;
		int y = 30;
		addItems();
		for(int i = 0; i < itemlist.size(); i++) {
			int j = i;
			Button item = new Button(x, y, 190, 80, itemlist.get(i).getName(), new Action() {
				@Override
				public void act() {
					MainGame.game.battle.backend.useItem(itemlist.get(j)); //uses the item
				}
			});
			/*
			 * add designs later
			 */
			viewObjects.add(item);
			y += 90;
		}
		Button item = new Button(x, y, 190, 80, "Return", new Action() {
			
			@Override
			public void act() {
				MainGame.game.battle.userui.itemmenu.setVisible(false);
			}
		});
	}

	public void addItems() {
		itemlist = new ArrayList<Items>();
		for(int i = 0; i < 10; i++) {
			itemlist.add(new IHealingItem(20, "Small Heal Potion"));
		}
		System.out.println(itemlist.get(0));
	}
}
