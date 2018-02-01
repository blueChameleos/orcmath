package maple_gacha;

import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class FeaturedChar extends FullFunctionScreen {

	public FeaturedChar(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic arrow = new Graphic((int) (getWidth() / 10 * .75), (int) (getHeight() / 2 * .80), 178, 179,
				"resources/picture1.png");
		viewObjects.add(arrow);
	}

}
