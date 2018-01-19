package maple_gacha;

import java.awt.event.MouseEvent;
import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class BattleScreen extends FullFunctionScreen implements Runnable{
	
	private int roundNum;
	public static GBattleSystem backend;
	
	private static final long serialVersionUID = 2809999782648181302L;

	public BattleScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic background = getRandomBackground();
		viewObjects.add(background);
	}

	private Graphic getRandomBackground() {
		return new Graphic(0,0, getWidth(), getHeight(), "resources/b_background"+0+".jpg");
	}

	@Override
	public void run() {
		
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}

}
