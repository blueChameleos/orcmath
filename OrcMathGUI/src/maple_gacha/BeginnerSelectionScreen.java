package maple_gacha;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

//SCREEN FOR USER PICKS ONE OUT OF THREE BEGINNER CHARACTERS

public class BeginnerSelectionScreen extends FullFunctionScreen{

	public BeginnerSelectionScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic charBg = new Graphic(0, 0, getWidth(), getHeight(), "resources/screenPics/charSelectBG.png");
		charBg.setVisible(true);
		viewObjects.add(charBg);
		
		System.out.println(MainGame.game.beginnerArcher);
		
		Graphic begArcher = new Graphic(200,200, 200,200, MainGame.game.beginnerArcher.getImage());
		viewObjects.add(begArcher);
	}

}
