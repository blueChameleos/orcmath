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
	public boolean lightingCheck;
	public ArrayList<Hero> resistanceB;
	public ArrayList<Hero> resistance;
	public int cardNum;
	public int bannerNum;
	

	public ArrayList<Hero> getStuff() {
		return resistance;
	}

	public void setStuff(ArrayList<Hero> stuff) {
		this.resistance = stuff;
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

		if (rate < 5) {
			srare = true;
			lightingCheck = true;
		} else {
			srare = false;
		}
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		getBanner();
		rng();
		getCard();


		StyledComponent.setButtonOutline(false);
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/abc.png");
		viewObjects.add(background);
		cardNum = (int) (Math.random() * resistance.size());
		System.out.println(cardNum);
		

		// TextArea descrip = new TextArea((int)(getWidth()/2 * .75),
		// (int)(getHeight()/2 * .9), 150, 150,
		// MainGame.summon.getThings().get(0).getRank());

		Graphic bannerCard = new Graphic(475, 350, 650, 350, resistance.get(cardNum).getImage());

		back = new Button(600, 900, 100, 75, "Back", Color.YELLOW, new Action() {

			@Override
			public void act() {

				resistanceB.clear();
				resistance.clear();
				MainGame.game.setScreen(MainGame.summon);

			}
		});

		back.setVisible(false);
		back.setEnabled(false);
		viewObjects.add(back);

		lighting = new AnimatedComponent(0, 0, 1375, 1024);
		viewObjects.add(lighting);

		new Thread() {

			public void run() {

				if (srare == true) {
					// viewObjects.add(background);

					lighting.setRepeat(false);
					lighting.addSequence("resources/summoninganimation (1) (1).png", 200, 0, 0, 1374, 1023, 21);
					Thread light = new Thread(lighting);
					light.start();

					try {
						Thread.sleep(6000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					viewObjects.remove(lighting);
					viewObjects.add(bannerCard);
					MainGame.addHero(resistance.get(cardNum));

					back.setVisible(true);
					back.setEnabled(true);
				} else {

					cardNum = (int) (Math.random() * resistanceB.size());
					background.setVisible(true);

					Graphic bannerCardB = new Graphic(475, 350, 650, 350, resistanceB.get(cardNum).getImage());
					viewObjects.add(bannerCardB);
					MainGame.addHero(resistanceB.get(cardNum));
					back.setVisible(true);
					back.setEnabled(true);
					

				}
			}
		}.start();

		// MainGame.main.getThings().loadImages(MainGame.summon.getThings().get(0).getImage(),
		// getWidth()/2-359, 155);

		// MainGame.game.addHero(MainGame.summon.getThings().get(0).getImage(),MainGame.summon.getThings().get(0).getRank(),MainGame.summon.getThings().get(0).getStrength(),MainGame.summon.getThings().get(0).getSpeed(),MainGame.summon.getThings().get(0).getAttack(),MainGame.summon.getThings().get(0).getDefense(),MainGame.summon.getThings().get(0).getHP());

	}

	private void getBanner() {
		bannerNum = MainGame.summon.bannerType();
		System.out.println(bannerNum);

		
		if(bannerNum == 0)
		{
			resistance = new ArrayList<Hero>();
			resistance.add(MainGame.highPrincess);//SS
			resistance.add(MainGame.highTank);//S

			resistanceB = new ArrayList<Hero>();
			resistanceB.add(MainGame.bCoolGuys);//A
			resistanceB.add(MainGame.mediumAxe);//A
			resistanceB.add(MainGame.beginnerSword);//B

			
			System.out.println("RESISTANCE BANNER HAS BEEN CREATED");
		}
		
		if(bannerNum == 1)
		{
			resistance = new ArrayList<Hero>();
			resistance.add(MainGame.highAssassin);//SS
			resistance.add(MainGame.mediumHighSchoolGirl);//S
			
			resistanceB = new ArrayList<Hero>();
			resistanceB.add(MainGame.bFanWoman);//A
			resistanceB.add(MainGame.mediumWitch);//A
			resistanceB.add(MainGame.beginnerArcher);//B
			
			System.out.println("RED BANNER HAS BEEN CREATED");
		}
		
		if(bannerNum == 2)
		{
			resistance = new ArrayList<Hero>();
			resistance.add(MainGame.highSirandHorse);//SS
			resistance.add(MainGame.mediumCannonMan);//S
			
			resistanceB = new ArrayList<Hero>();
			resistanceB.add(MainGame.mediumWizard);//A
			resistanceB.add(MainGame.mediumWolfGirl);//A
			resistanceB.add(MainGame.beginnerWizard);//B

			
			System.out.println("OG BANNER HAS BEEN CREATED");

		}
	}

}
