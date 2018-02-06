package maple_gacha;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class DavidGetCharacterSingle extends FullFunctionScreen {

	private Button back;
	private AnimatedComponent lighting;
	public boolean srare;
	public double rate;
	private Button skipAn;
	public boolean lightingCheck;
	
	public DavidGetCharacterSingle(int width, int height) {
		super(width, height);
	}

	public void lighting() {
		lighting.addSequence("resources/summoninganimation (1) (1).png", 200, 0, 0, 1374, 1023, 21);
		System.out.println("10");
		Thread light = new Thread(lighting);
		light.start();

	}

	public void rng() {
		rate = (int) Math.floor(Math.random() * 101);
	}

	public void getCard() {
		
		if (rate < 50) {
			srare = true;
			lightingCheck = true;
		} else {
			srare = false;
		}
	}
	
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		StyledComponent.setButtonOutline(false);
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/summoningbackground.png");
		Graphic mech = new Graphic(475, 350, 650, 350,"resources/mech.jpg");
		
		back = new Button(600, 900, 100, 75, "Back", Color.YELLOW, new Action() {

			@Override
			public void act() {
				
				
				viewObjects.remove(background);
				viewObjects.remove(mech);
				viewObjects.remove(back);
				viewObjects.add(skipAn);
				viewObjects.add(lighting);
				
				MainGame.game.setScreen(MainGame.summon);
			}
		});
		
		viewObjects.add(background);
		viewObjects.add(mech);
		viewObjects.add(back);
		
		
		
		rng();
		getCard();
		
		

		skipAn = new Button(0,0,getWidth() ,getHeight()," ", new Action() {

				@Override
				public void act() {
						
					viewObjects.remove(lighting);
					skipAn.setVisible(false);
					viewObjects.remove(skipAn);

				}
			});
		
		viewObjects.add(skipAn);
		
		
		
		
		lighting = new AnimatedComponent(0, 0, 1375, 1024);
		viewObjects.add(lighting);

		new Thread() {
			
			public void run() {	

				if (srare == true) {
					lighting();
				}
				
			}
		}.start();
		
	}
}
		
	
	

