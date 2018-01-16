package maple_gacha;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class UnitSelectionScreen extends FullFunctionScreen {
	
	public Object[] characters;

	public UnitSelectionScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic background = new Graphic(0,0,getWidth(), getHeight(), "resources/mainguiscreen.jpg");
		viewObjects.add(background);
		Button startBattle = new Button(540,512, 200, 200, "Start Battle", new Action() {
			public void act() {
				MainGame.game.setScreen(MainGame.battle);
			}
		});
		viewObjects.add(startBattle);
	}

}
