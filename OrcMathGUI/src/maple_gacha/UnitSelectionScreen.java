package maple_gacha;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class UnitSelectionScreen extends FullFunctionScreen {
	
	private static final long serialVersionUID = -3382887540173863903L;
	public static ArrayList<Object> characters;
	private static TextLabel errorlog;

	public UnitSelectionScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/mainguiscreen.jpg");
		viewObjects.add(background);
		Button startBattle = new Button(540,512, 200, 200, "Start Battle", new Action() {
			public void act() {
				MainGame.game.setScreen(MainGame.battle);
			}
		});
		viewObjects.add(startBattle);
	}
	
	public void addCharacter(Object c) {
		if(characters.size() < 6) {
			characters.add(c);
		}else {
			//displayError();
		}
	}

	public void displayError() {
		
	}
}
