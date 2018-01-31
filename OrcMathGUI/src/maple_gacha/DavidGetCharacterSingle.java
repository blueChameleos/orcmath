package maple_gacha;

import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class DavidGetCharacterSingle extends FullFunctionScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6471336238619387248L;
	Button back;
	AnimatedComponent lighting;
	
	public DavidGetCharacterSingle(int width, int height) {
		super(width, height);
		getCard();
		lighting();
		// TODO Auto-generated constructor stub
	}

	public void lighting() {
		
	}

	public void getCard() {

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub

		back = new Button(600, 500, 100, 75, "Back", Color.YELLOW, new Action() {

			@Override
			public void act() {

			}
		});

		viewObjects.add(back);

		Graphic mech = new Graphic((int) (getWidth() / 10 * 2.5), (int) (getHeight() / 2 * .65), 650, 350,
				"resources/mech.jpg");

		getCard(mech);
		
		
		
		lighting = new AnimatedComponent(250, 265, 29, 34);
		lighting.addSequence("resources/summoninganimation.png", 150, 234, 50, 29, 34, 3);
		
		Thread run = new Thread(lighting);
		run.start();
		
		viewObjects.add(lighting);
	}

	public void getCard(Graphic asdf) {
		
	}

}
