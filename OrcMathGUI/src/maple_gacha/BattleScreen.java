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
		Button attackbttn = new Button(getWidth() - 300, getHeight() - 400, 250, 200, "Attack", new Action() {
			public void act() {
				//uses the current characters default atk
			}
		});
		Button skillbttn = new Button(getWidth() - 275, getHeight() - 350, 275, 200, "Skill", new Action() {
			public void act() {
				//opens skill menu, then allows user to atk with skill
			}
		});
		Button defbttn = new Button(getWidth() - 300, getHeight() - 350, 275, 200, "Guard", new Action() {
			public void act() {
				//sends character into guard pose
			}
		});
		Button itembttn = new Button(getWidth() - 275, getHeight() - 350, 275, 200, "Items", new Action() {
			public void act() {
				//opens items menu, then allows user to use items
			}
		});
		
		viewObjects.add(attackbttn);
		viewObjects.add(skillbttn);
		viewObjects.add(defbttn);
		viewObjects.add(itembttn);
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
