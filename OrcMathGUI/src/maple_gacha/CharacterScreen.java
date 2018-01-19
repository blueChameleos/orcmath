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

	public CharacterScreen(int width, int height) {
		super(width, height);
		setVisible(true);
		isOccupied = false;
		isOccupied2 = false;
		isClicked = false;
		isClicked2 = false;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/screenPics/cardSystem.png");
		background.setVisible(true);
		viewObjects.add(background);
		
		ArrayList<Hero> team = MainGame.game.team;
		team.add(MainGame.game.beginnerArcher);
		team.add(MainGame.game.beginnerSword);
		team.add(MainGame.game.beginnerWizard);
		for(int i = 0; i < team.size(); i++) {
				ClickableGraphic character = new ClickableGraphic(131 +208*i,144,400,200, team.get(i).getImage());
				character.setVisible(true);
				ClickableGraphic character2 = new ClickableGraphic(1280,1024,400,200,team.get(i).getImage());
				character2.setVisible(true);
				character.setAction(new Action() {

					@Override
					public void act() {
						if(!isOccupied) {
							character2.setX(76);
							character2.setY(601);
							isOccupied = true;
						}else if(isOccupied && !isOccupied2) {
							character2.setX(296);
							character2.setY(601);
							isOccupied2 = true;
						}else if(isOccupied & isOccupied2) {
							character2.setX(516);
							character2.setY(601);
						}
						character.setVisible(false);
					}
					
				});
				viewObjects.add(character);
				viewObjects.add(character2);
				character2.setAction(new Action() {

					@Override
					public void act() {
						
						if(!isClicked) {
							character2.setX(131);
							character2.setY(144);
							isClicked = true;
						}else if(isClicked && !isClicked2) {
							character2.setX(131+206);
							character2.setY(144);
							isClicked2 = true;
						}else if(isClicked && isClicked2) {
							character2.setX(131+206+206);
							character2.setY(144);
						}
						
					}
					
				});
			}
		
	}
}
	
	
