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
	public static ArrayList<Hero> team;

	public CharacterScreen(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/screenPics/cardSystem.png");
		background.setVisible(true);
		viewObjects.add(background);
		team = new ArrayList<Hero>();
		team.add(MainGame.game.beginnerArcher);
		for(int i = 0; i < team.size(); i++) {
				ClickableGraphic character = new ClickableGraphic(131,144,400,200, team.get(i).getImage());
				character.setVisible(true);
				character.setAction(new Action() {

					@Override
					public void act() {
						character.setX(76);
						character.setY(601);
					}
					
				});
				viewObjects.add(character);
			}
		
	}
}
	
	
