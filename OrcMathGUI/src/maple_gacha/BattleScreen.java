package maple_gacha;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ComponentContainer;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class BattleScreen extends FullFunctionScreen implements Runnable{
	
	private static final long serialVersionUID = 2809999782648181302L;
	private int roundNum;
	public static GBattleSystem backend;
	public static BattleMenu userui;
	
	public BattleScreen(int width, int height) {
		super(width, height);
		backend = new GBattleSystem(1, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic background = getRandomBackground();
		userui = new BattleMenu(this,30,800);
		userui.update();
		viewObjects.add(background);
		viewObjects.add(userui);
	}

	private Graphic getRandomBackground() {
		return new Graphic(0,0, getWidth(), getHeight(), "resources/b_background"+0+".jpg");
	}

	@Override
	public void run() {
		
	}

	public void SwitchUIAI() {
		
	}

	public void SwitchAIUI() {
		
	}
 
}
 