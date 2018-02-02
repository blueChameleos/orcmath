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

	private Button back;
	private AnimatedComponent lighting;
	public boolean lightingCount;
	public boolean srare;
	public double rate;

	public DavidGetCharacterSingle(int width, int height) {
		super(width, height);
	}

	public void lighting() {

	}
	
	

	public void rng() {
		rate = (int) Math.floor(Math.random() * 101);
	}

	public void getCard() {
		if (rate < 100) {
			srare = true;
			lightingCount = true;
		} else {
			srare = false;
		}
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		rng();
		getCard();
		
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/summoningbackground.png");
		
		
		back = new Button(600, 900, 100, 75, "Back", Color.YELLOW, new Action() {

			@Override
			public void act() {

				MainScreen.main.setScreen(MainScreen.summon);
			}
		});

		

		Graphic mech = new Graphic(475, 350, 650, 350,"resources/mech.jpg");
		
		
		lighting = new AnimatedComponent(0, 0, 1375, 1024);
		viewObjects.add(lighting);

		if (srare == true) {
			new Thread() {
				
				public void run() {	

					if (lightingCount == true) {
						lighting.setRepeat(false);
						lighting.addSequence("resources/summoninganimation (1) (1).png", 200, 0, 0, 1374, 1023, 21);
						Thread light = new Thread(lighting);
						light.start();
						
						try {
							light.sleep(4500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						viewObjects.add(background);
						viewObjects.add(mech);
						viewObjects.add(back);
						
					}
				}
			}.start();
		} else {
			System.out.println("trash");
		}
	}
	
	
	
}
