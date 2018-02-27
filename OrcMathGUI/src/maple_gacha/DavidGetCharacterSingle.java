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

public class DavidGetCharacterSingle extends FullFunctionScreen implements BannerInterface{

	private Button back;
	private AnimatedComponent lighting;
	public boolean srare;
	public double rate;
	public boolean lightingCheck;
	public ArrayList<Hero> resistanceB;
	public ArrayList<Hero> resistance;
	public int cardNum;
	public int bannerNum;
	public int cardNumB;
	private CustomCursor customCursor;
	

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
		//the rate of getting a s or higher card
		if (rate < 1) {
			srare = true;
			lightingCheck = true;
		} else {
			srare = false;
		}
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		customCursor = new CustomCursor(this); 

		getBanner();
		rng();
		getCard();


		StyledComponent.setButtonOutline(false);
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/abc.png");
		viewObjects.add(background);
		background.setVisible(false);
		
		cardNum = (int) (Math.random() * resistance.size());
		System.out.println(cardNum);
		

		// TextArea descrip = new TextArea((int)(getWidth()/2 * .75),
		// (int)(getHeight()/2 * .9), 150, 150,
		// MainGame.summon.getThings().get(0).getRank());

		Graphic bannerCard = new Graphic(475, 350, 100, 200, resistance.get(cardNum).getImage());

		back = new Button(600, 500, 100, 75, "Back", Color.YELLOW, new Action() {

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
					//the animation can be a bit slow
					lighting.setRepeat(false);
					lighting.addSequence("resources/summoninganimation (1) (1).png", 200, 0, 0, 1374, 1023, 21);
					Thread light = new Thread(lighting);
					light.start();

					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					viewObjects.remove(lighting);
					
					
					
					viewObjects.add(bannerCard);
					
					
					MainGame.addHero(resistance.get(cardNum));

					back.setVisible(true);
					back.setEnabled(true);
					
					background.setVisible(true);

				} else {

					cardNumB = (int) (Math.random() * resistanceB.size());
					System.out.println("character "+cardNumB);
					background.setVisible(true);

					Graphic bannerCardB = new Graphic(475, 350, 100, 200, resistanceB.get(cardNumB).getImage());
					
					viewObjects.add(bannerCardB);
					
					MainGame.addHero(resistanceB.get(cardNumB));
					
					back.setVisible(true);
					back.setEnabled(true);
					background.setVisible(true);
					

				}
			}
		}.start();

		// MainGame.main.getThings().loadImages(MainGame.summon.getThings().get(0).getImage(),
		// getWidth()/2-359, 155);

		// MainGame.game.addHero(MainGame.summon.getThings().get(0).getImage(),MainGame.summon.getThings().get(0).getRank(),MainGame.summon.getThings().get(0).getStrength(),MainGame.summon.getThings().get(0).getSpeed(),MainGame.summon.getThings().get(0).getAttack(),MainGame.summon.getThings().get(0).getDefense(),MainGame.summon.getThings().get(0).getHP());

	}

	private void getBanner() {
		bannerNum = MainGame.summon.bannerType();
		//System.out.println(bannerNum);

		
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

	@Override
	public void summonBanner(int idx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPotentialChars() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int bannerType() {
		// TODO Auto-generated method stub
		return 0;
	}

}
