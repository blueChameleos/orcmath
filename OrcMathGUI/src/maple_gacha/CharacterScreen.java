package maple_gacha;


import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CharacterScreen extends FullFunctionScreen {
	
	
	private static final long serialVersionUID = 6339468790728949736L;
	
	private boolean isOccupied;
	private boolean isOccupied2;
	private boolean isClicked;
	private boolean isClicked2;
	private boolean isFull;
	
	
	public CharacterScreen(int width, int height) {
		super(width, height);
		setVisible(true);
		isOccupied = false;
		isOccupied2 = false;
		isClicked = false;
		isClicked2 = false;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) { // this runs before beginnerselection updates the team class. 
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/screenPics/cardSystem.png");
		background.setVisible(true);
		viewObjects.add(background);
		
		ArrayList<Hero> team = MainGame.game.team; 
		ArrayList<Hero> tempDisplay  = new ArrayList<Hero>();
		for (Hero i:team) {
			tempDisplay.add(i);
		}
		for(int i = 0; i < tempDisplay.size(); i++) {
				ClickableGraphic character = new ClickableGraphic(131 +208*i,144,400,200, tempDisplay.get(i).getImage());
				Hero hero = tempDisplay.get(i);
				character.setVisible(true);
				character.setAction(new Action() {
					boolean enable = false;
					public void act() {
						int arrSize = MainGame.game.currentTeam.size();
					
						if(enable) {
							System.out.println(enable);
							tempDisplay.add(hero);
							MainGame.game.currentTeam.remove(hero);
							character.setX(12);
							character.setY(12);
							enable = false;
						}
						else if(arrSize == 0 && !enable ) {
							character.setX(76);
							character.setY(601);
							tempDisplay.remove(hero);
							enable = true;
						}else if(arrSize == 1 && !enable) {
							character.setX(296);
							character.setY(601);
							tempDisplay.remove(hero);
							enable = true;
						}else if(arrSize == 2 && !enable) {
							character.setX(516);
							character.setY(601);
							tempDisplay.remove(hero);
							enable = true;
						}
						MainGame.game.currentTeam.add(hero);
					}
						
					
				});
				viewObjects.add(character);
			}
		
	}
}
	
	
