package maple_gacha;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class MainScreen extends FullFunctionScreen {

	private Button dungeon;
	private Button summon;
	private Button inventory;
	
	public MainScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		dungeon = new Button(getWidth()/2 - 100,462,200,75,"New Game",Color.cyan,new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

}