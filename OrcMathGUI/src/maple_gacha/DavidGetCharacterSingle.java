package maple_gacha;

import java.awt.Color;
import java.util.List;

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
	private Button back;
	private AnimatedComponent lighting;
	public boolean lightingCount;
	
	public DavidGetCharacterSingle(int width, int height) {
		super(width, height);
		lightingCount = false;
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
				

				MainScreen.main.setScreen(MainScreen.summon);
			}
		});

		viewObjects.add(back);

		Graphic mech = new Graphic((int) (getWidth() / 10 * 2.5), (int) (getHeight() / 2 * .65), 650, 350,"resources/mech.jpg");

		//viewObjects.add(mech);
		
		
		
		lighting = new AnimatedComponent(0, 0, 1375, 1024);
		lighting.addSequence("resources/summoninganimation.png", 200, 0, 0, 1375, 1024, 21);
		viewObjects.add(lighting);
		
		/*public void Thread()
		{
			if(lightingCount == false)
			{
			
				Thread light = new Thread(lighting);
			
				light.start();
			}
			else
			{
				
			}
		}*/
		//dsdd
			
		
		
		
		
	}

	public void getCard(Graphic asdf) {
		
	}

}
