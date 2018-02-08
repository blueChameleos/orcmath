package maple_gacha;

import java.awt.Color;
import java.util.ArrayList;
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
	public ArrayList<Hero> asdf;
	public static Hero beginnerArcher;
	public static Hero beginnerSword;
	public static Hero beginnerWizard;
	
	
	public DavidGetCharacterSingle(int width, int height) {
		super(width, height);
	}
	
	public static void createCharacters() {
		beginnerArcher = new Hero("resources/characterPics/Hero_BeginnerArcher.png", "B", 10, 10, 10, 10, 100);
		beginnerSword = new Hero("resources/characterPics/Hero_BeginnerSword.png", "B", 10, 10, 10, 10, 100);
		beginnerWizard = new Hero("resources/characterPics/Hero_BeginnerWizard.png", "B", 10, 10, 10, 10, 100);
		//add the characters here?
		System.out.println(beginnerSword.getImage());
		System.out.println(beginnerArcher);
	}	
	
	

	public void lighting() {
		lighting.addSequence("resources/summoninganimation (1) (1).png", 200, 0, 0, 1374, 1023, 21);
		Thread light = new Thread(lighting);
		light.start();

	}

	public void rng() {
		rate = (int) Math.floor(Math.random() * 101);
	}

	public void getCard() {
		
		if (rate < 100) {
			srare = true;
			lightingCheck = true;
		} else {
			srare = false;
		}
	}
	
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		asdf = new ArrayList<Hero>();
		
		StyledComponent.setButtonOutline(false);
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/summoningbackground.png");
		Graphic mech = new Graphic(475, 350, 650, 350,"resources/mech.jpg");
		
		
		rng();
		getCard();
		banner();
		
		back = new Button(600, 900, 100, 75, "Back", Color.YELLOW, new Action() {

			@Override
			public void act() {
				//ss
				
				viewObjects.remove(background);
				viewObjects.remove(mech);
				viewObjects.add(skipAn);
				viewObjects.add(lighting);
				viewObjects.remove(back);
				MainGame.game.setScreen(MainGame.summon);
				
			}
		});
		
		viewObjects.add(back);

		skipAn = new Button(0,0,getWidth() ,getHeight()," ", new Action() {

				@Override
				public void act() {
						
					viewObjects.remove(lighting);
					
					viewObjects.add(background);
					viewObjects.add(mech);
					viewObjects.add(back);
					viewObjects.remove(skipAn);
					skipAn.setVisible(false);
					
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
	public void banner()
	{
		
		asdf.add(beginnerArcher);
		asdf.add(beginnerSword);
		asdf.add(beginnerWizard);
		
		
		System.out.println("Character added "+asdf.get(0));
		System.out.println("Character added "+asdf.get(1));
		System.out.println("Character added "+asdf.get(2));

	}
	
}
		
	
	

