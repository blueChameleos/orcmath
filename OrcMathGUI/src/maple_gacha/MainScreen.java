package maple_gacha;

import java.util.List;

import guiTeacher.GUIApplication;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import holiday.HolidayCard;

public class MainScreen extends GUIApplication {
	
	public static MainScreen main;
	
	public static EthanSummonScreen summon;
	
	public static DavidGetCharacterSingle single;
	
	public static DavidGetCharacterMulti multi;
	
	public static LoadingScreen load;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainScreen(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
		
	}

	public void initScreen() {
		load = new LoadingScreen(getWidth(), getHeight());
		summon = new EthanSummonScreen(getWidth(),getHeight());
		single = new DavidGetCharacterSingle(getWidth(),getHeight());
		multi = new DavidGetCharacterMulti(getWidth(),getHeight());
		setScreen(summon);
	}
	
	public static void main(String[] args) {
		main = new MainScreen(1280,1024);
		Thread r = new Thread(main);
		r.start();
	}
//fff
}
