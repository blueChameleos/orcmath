package maple_gacha;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Pane;
import guiTeacher.components.ScrollablePane;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;

public class ItemMenu extends ScrollablePane {

	private static final long serialVersionUID = -8249216153895539555L;
	private static final int WIDTH = 250;
	private static final int HEIGHT = 600;
	public static Button cancel;
	public ArrayList<Items> itemlist;

	public ItemMenu(FocusController focusController, int x, int y, int width, int height) {
		super(focusController, x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public ItemMenu(FocusController focusController, int x, int y) {
		super(focusController, x, y, WIDTH, HEIGHT);
	}

	public void initAllObjects(List<Visible> viewObjects) {

		if(viewObjects.size() > 0)
		{
			for(int i =(viewObjects.size()-1); i >=0; i--)
			{
				viewObjects.remove(i);
			}
		}
		
		this.setBackground(Color.BLUE);
		this.itemlist = new ArrayList<Items>();
		this.itemlist = MainGame.battle.backend.getInventory();
		int x = 30;
		int y = 30;
		for(int i = 0; i < itemlist.size(); i++) {
			int j = i;
			Button item;
			if(itemlist.get(j) instanceof IHealingItem) {
				item = new Button(x, y, 190, 60, itemlist.get(j).getName(), Color.GREEN, new Action() {
					@Override
					public void act() {
						MainGame.game.battle.userui.updateLog(MainGame.game.battle.backend.getCurrentPlayer() + " used " + itemlist.get(j).getName() + "!");
						MainGame.game.battle.backend.useItem(itemlist.get(j));//uses the item
						MainGame.battle.userui.hideItemMenu();
						MainGame.game.battle.backend.checkChanges();
						MainGame.battle.itemui.initAllObjects(viewObjects);
					}
				});
			}else {
				item = new Button(x, y, 190, 60, itemlist.get(j).getName(), Color.ORANGE, new Action() {
					@Override
					public void act() {
						MainGame.game.battle.userui.updateLog(MainGame.game.battle.backend.getCurrentPlayer() + " used " + itemlist.get(j).getName() + "!");
						MainGame.game.battle.backend.useItem(itemlist.get(j));//uses the item
						MainGame.battle.userui.hideItemMenu();
						MainGame.game.battle.backend.checkChanges();
						MainGame.battle.itemui.initAllObjects(viewObjects);
					}
				});
			}
			viewObjects.add(item);
			y += 90;
		}
		cancel = new Button(x, y, 190, 60, "Return", Color.RED, new Action() {
			@Override
			public void act() {
				MainGame.battle.userui.hideItemMenu();
			}
		});
		viewObjects.add(cancel);
	}
}
