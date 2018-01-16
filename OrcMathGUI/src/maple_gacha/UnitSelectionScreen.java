package maple_gacha;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
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
		Button startBattle = new Button(640,512, 200, 200, "Start Battle", new Action() {
			public void act() {
				MainGame.game.setScreen(MainGame.battle);
			}
		});
		viewObjects.add(startBattle);
	}

}
