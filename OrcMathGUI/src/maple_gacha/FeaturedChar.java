package maple_gacha;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class FeaturedChar extends FullFunctionScreen {
	private ArrayList<Hero> chars;

	public FeaturedChar(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/abc.png");
		viewObjects.add(background);
		
		
		Hero featuredChar1 = new Hero("resources/characterPics/Hero_BeginnerArcher.png","B", 10, 10, 10, 10, 100);
//		viewObjects.add(featuredChar1);
		Graphic begArcher = new Graphic(200, 500, 200, 200, featuredChar1.getImage());
		System.out.println("went past statement");
		viewObjects.add(begArcher);
	}

}
