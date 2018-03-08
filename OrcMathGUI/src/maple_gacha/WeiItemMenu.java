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

public class WeiItemMenu extends ScrollablePane {

	private static final long serialVersionUID = -8249216153895539555L;
	private static final int WIDTH = 250;
	private static final int HEIGHT = 600;
	public static Button cancel;
	public ArrayList<Items> itemlist;

	public WeiItemMenu(FocusController focusController, int x, int y, int width, int height) {
		super(focusController, x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public WeiItemMenu(FocusController focusController, int x, int y) {
		super(focusController, x, y, WIDTH, HEIGHT);
	}
	
	public void useItem(JohnsonHero caller, Items item, List<Visible> viewObjects) {
		MainGame.game.battle.game.interrupt();
		MainGame.game.battle.userui.updateLog(caller + " used " + item.getName() + "!");
		MainGame.game.battle.backend.useItem(item);//uses the item
		MainGame.game.battle.updateHp();
		MainGame.battle.userui.hideItemMenu();
		MainGame.game.battle.backend.checkChanges();
		MainGame.battle.backend.disableButtons();
		MainGame.battle.itemui.initAllObjects(viewObjects);
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
						useItem(MainGame.game.battle.backend.getCurrentPlayer(),itemlist.get(j),viewObjects);
					}
				});
			}else {
				item = new Button(x, y, 190, 60, itemlist.get(j).getName(), Color.ORANGE, new Action() {
					@Override
					public void act() {
						useItem(MainGame.game.battle.backend.getCurrentPlayer(),itemlist.get(j),viewObjects);
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
