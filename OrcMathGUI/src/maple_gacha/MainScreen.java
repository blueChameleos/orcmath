package maple_gacha;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.GUIApplication;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import guiTeacher.userInterfaces.FullFunctionScreen;
import holiday.HolidayCard;

public class MainScreen extends FullFunctionScreen {
	
	public static MainScreen main;
	
	public static EthanSummonScreen summon;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Button dungeon;
	private Button summonb;
	private Button inventory;
	
	public MainScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
		//setVisible(true);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		dungeon = new Button(getWidth()/2 - 100,462,200,75,"New Game",Color.cyan,new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

}
