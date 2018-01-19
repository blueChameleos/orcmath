package maple_gacha;

import java.util.List;

import guiTeacher.GUIApplication;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import holiday.HolidayCard;

public class MainScreen extends GUIApplication {
	
	public static MainScreen main;
	
	public static EthanSummonScreen summon;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainScreen(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
		//setVisible(true);
	}

	public void initScreen() {
		summon = new EthanSummonScreen(getWidth(),getHeight());
		setScreen(summon);
	}
	
	public static void main(String[] args) {
		main = new MainScreen(1280,1024);
		Thread r = new Thread(main);
		r.start();
	}

}
