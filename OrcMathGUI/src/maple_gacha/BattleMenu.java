package maple_gacha;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ComponentContainer;

public class BattleMenu extends ComponentContainer implements Visible{
	
	private static final long serialVersionUID = 4341767717950425222L;
	private ArrayList<Items> listOfItems;
	
	public BattleMenu(int width, int height, ArrayList<Visible> initWithObjects, ArrayList<Items> currentItems) {
		super(width, height, initWithObjects);
		listOfItems = currentItems;
	}
	
	public BattleMenu(ArrayList<Visible> initWithObjects, ArrayList<Items> currentItems) {
		super(400,650,initWithObjects);
		listOfItems = currentItems;
	}

	@Override
	public void initObjects(List<Visible> viewObjects) {
		for(int i = 0; i<listOfItems.size(); i++){
			int j = i;
			Button newButton = new Button(getX()-10, getY()-20, 30, 30, "" , new Action() {
				public void act() {
					MainGame.game.battle.backend.useItem(listOfItems.get(j)); //inside method, the quantity will be decreased + progress with the turn.
				}
			});
			viewObjects.add(newButton);
		}
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unhoverAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hoverAction() {
		// TODO Auto-generated method stub
		
	}

}
