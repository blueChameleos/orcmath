package maple_gacha;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
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
	public static Hero Archer;
	public static Hero Sword;
	public static Hero Wizard;
	public ArrayList<Hero> stuff;
	
	private Button back1;

	
	public ArrayList<Hero> getStuff() {
		return stuff;
	}

	public void setStuff(ArrayList<Hero> stuff) {
		this.stuff = stuff;
	}

	public DavidGetCharacterSingle(int width, int height) {
		super(width, height);
	}
	

	
	

	public void lighting() {
		lighting.setRepeat(false);
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
		asdf.add(MainGame.beginnerArcher);
		
				
		StyledComponent.setButtonOutline(false);
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/summoningbackground.png");
		

		
		back1 = new Button(600, 900, 100, 75, "Back", Color.WHITE, new Action() {

			@Override
			public void act() {

				
			}
		});
		
		
		viewObjects.add(back1);

		//TextArea descrip = new TextArea((int)(getWidth()/2 * .75), (int)(getHeight()/2 * .9), 150, 150, MainGame.summon.getThings().get(0).getRank());
		
		rng();
		getCard();
		banner();
		
		
		Graphic bannerCard = new Graphic(475, 350, 650, 350,MainGame.summon.getThings().get(0).getImage());
		
		viewObjects.add(bannerCard);
		
		back = new Button(600, 900, 100, 75, "Back", Color.YELLOW, new Action() {

			@Override
			public void act() {
				
				
				//viewObjects.remove(background);
				//viewObjects.remove(mech);
				//viewObjects.add(skipAn);
				//viewObjects.add(lighting);
				//viewObjects.remove(back);
				MainGame.game.setScreen(MainGame.summon);
				
			}
		});
		
		
		

/*		skipAn = new Button(0,0,getWidth() ,getHeight()," ", new Action() {

				@Override
				public void act() {
						
					viewObjects.remove(lighting);
					
					viewObjects.add(background);
					viewObjects.add(mech);
					viewObjects.add(back);
					viewObjects.remove(skipAn);
					skipAn.setVisible(false);
					
				}
			});*/
		
		//viewObjects.add(skipAn)
		
		
		lighting = new AnimatedComponent(0, 0, 1375, 1024);
		viewObjects.add(lighting);

		new Thread() {
			
			public void run() {	

				if (srare == true) {
					
					
					//viewObjects.add(background);
					
					lighting.setRepeat(false);
					lighting.addSequence("resources/summoninganimation (1) (1).png", 200, 0, 0, 1374, 1023, 21);
					Thread light = new Thread(lighting);
					light.start();
					
					
					MainGame.addHero(asdf.get((int) (Math.random()*asdf.size())));

				}
				
			}
		}.start();
		
		
		
       // MainGame.main.getThings().loadImages(MainGame.summon.getThings().get(0).getImage(), getWidth()/2-359, 155);
        
		//MainGame.game.addHero(MainGame.summon.getThings().get(0).getImage(),MainGame.summon.getThings().get(0).getRank(),MainGame.summon.getThings().get(0).getStrength(),MainGame.summon.getThings().get(0).getSpeed(),MainGame.summon.getThings().get(0).getAttack(),MainGame.summon.getThings().get(0).getDefense(),MainGame.summon.getThings().get(0).getHP());
		
		
	}
	public void banner()
	{
		
		asdf.add(Archer);
		asdf.add(Sword);
		asdf.add(Wizard);
		
		
		System.out.println("Character added "+asdf.get(0));
		System.out.println("Character added "+asdf.get(1));
		System.out.println("Character added "+asdf.get(2));

	}
	
	
}
