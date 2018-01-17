package maple_gacha;

import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class SummonScreen extends FullFunctionScreen {
	
	

	public SummonScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
		Graphic background = new Graphic(0,0,getWidth(),getHeight(), "resources/abc.png");
		viewObjects.add(background);

	}

}
