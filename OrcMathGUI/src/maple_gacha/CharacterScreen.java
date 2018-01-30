package maple_gacha;


import java.lang.reflect.Array;
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
	private ClickableGraphic g1;
	private ClickableGraphic g2;
	private ClickableGraphic g3;
	private ClickableGraphic g4;
	private ClickableGraphic g5;
	
	private ClickableGraphic c1;
	private ClickableGraphic c2;
	private ClickableGraphic c3;
	
	
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

		ClickableGraphic[] clickList = new ClickableGraphic[8];

		clickList[0] = g1;
		clickList[1] = g2;
		clickList[2] = g3;
		clickList[3] = g4;
		clickList[4] = g5;
		clickList[5] = c1;
		clickList[6] = c2;
		clickList[7] = c3;
		
		
	}
}
	
	
