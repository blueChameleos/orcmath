package maple_gacha;

import java.awt.Color;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class DavidGetCharacterMulti extends FullFunctionScreen implements BannerInterface{

	private Button back;
	private AnimatedComponent lighting;
	public boolean srare;
	public double rate;
	public boolean lightingCheck;
	public ArrayList<Hero> resistanceB;
	public ArrayList<Hero> resistance;
	public int cardNum;
	public int bannerNum;
	public int cardNum1;
	public int cardNum2;
	public ArrayList<Number> num;
	private CustomCursor customCursor;
	
	public ArrayList<Hero> getStuff() {
		return resistance;
	}

	public void setStuff(ArrayList<Hero> stuff) {
		this.resistance = stuff;
	}

	public DavidGetCharacterMulti(int width, int height) {
		super(width, height);
	}

	public void rng() {
		rate = (int) Math.floor(Math.random() * 101);
	}

	public void getCard() {

		if (rate < 1) {
			srare = true;
			lightingCheck = true;
		} else {
			srare = false;
		}
	}
	
	public ArrayList<Number> cardNum(int x)
	{
		cardNum = (int) (Math.random() * x);
		
		cardNum1 = (int) (Math.random() * x);
		
		cardNum2 = (int) (Math.random() * x);
		
		num.add(cardNum);
		num.add(cardNum1);
		num.add(cardNum2);

		return num;
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		customCursor = new CustomCursor(this); 
		

		num = new ArrayList<Number>();

		getBanner();
		rng();
		getCard();

		StyledComponent.setButtonOutline(false);
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/abc.png");
		viewObjects.add(background);
		background.setVisible(false);
		System.out.println(cardNum);		

		// TextArea descrip = new TextArea((int)(getWidth()/2 * .75),
		// (int)(getHeight()/2 * .9), 150, 150,
		// MainGame.summon.getThings().get(0).getRank());
		//cardNum = (int) (Math.random() * resistance.size());

		Graphic bannerCard1 = new Graphic(500, 300, 100, 200, resistance.get((int) cardNum(resistance.size()).get(0)).getImage());
		Graphic bannerCard2 = new Graphic(300, 400, 100, 200, resistance.get((int) cardNum(resistance.size()).get(1)).getImage());
		Graphic bannerCard3 = new Graphic(300, 100, 100, 200, resistance.get((int) cardNum(resistance.size()).get(2)).getImage());

		
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

					lighting.setRepeat(false);
					lighting.addSequence("resources/summoninganimation (1) (1).png", 150, 0, 0, 1374, 1023, 21);
					Thread light = new Thread(lighting);
					light.start();

					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					viewObjects.remove(lighting);
					
					
					
					viewObjects.add(bannerCard1);
					viewObjects.add(bannerCard2);
					viewObjects.add(bannerCard3);


					MainGame.addHero(resistance.get((int) cardNum(resistance.size()).get(0)));
					MainGame.addHero(resistance.get((int) cardNum(resistance.size()).get(1)));
					MainGame.addHero(resistance.get((int) cardNum(resistance.size()).get(2)));


					back.setVisible(true);
					back.setEnabled(true);
					
					
					
					background.setVisible(true);
					
				} else {
					
					//cardNum = (int) (Math.random() * resistanceB.size());
					

					Graphic bannerCardB1 = new Graphic(500,300,100,200, resistanceB.get((int) cardNum(resistanceB.size()).get(0)).getImage());
					Graphic bannerCardB2 = new Graphic(300,400,100,200, resistanceB.get((int) cardNum(resistanceB.size()).get(1)).getImage());
					Graphic bannerCardB3 = new Graphic(300,100,100,200, resistanceB.get((int) cardNum(resistanceB.size()).get(2)).getImage());
					viewObjects.add(bannerCardB1);
					viewObjects.add(bannerCardB2);					
					viewObjects.add(bannerCardB3);
					

					
					MainGame.addHero(resistanceB.get((int) cardNum(resistanceB.size()).get(0)));
					MainGame.addHero(resistanceB.get((int) cardNum(resistanceB.size()).get(1)));
					MainGame.addHero(resistanceB.get((int) cardNum(resistanceB.size()).get(2)));

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
