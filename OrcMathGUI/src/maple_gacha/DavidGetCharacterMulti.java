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
	public ArrayList<Hero> banner;
	public int cardNum;
	public int bannerNum;
	public int cardNum1;
	public int cardNum2;
	public ArrayList<Number> num;
	private CustomCursor customCursor;
	
	public ArrayList<Hero> getStuff() {
		return banner;
	}

	public void setStuff(ArrayList<Hero> stuff) {
		this.banner = stuff;
	}

	public DavidGetCharacterMulti(int width, int height) {
		super(width, height);
	}

	public void rng() {
		rate = (int) Math.floor(Math.random() * 101);
	}

	public void getCardType() {

		if (rate < 1) {
			srare = true;
			lightingCheck = true;
		} else {
			srare = false;
		}
	}
	
	public ArrayList<Number> cardNum()
	{
		//generate the cards pull from a fixed pool of cards after the rarity is determined
		
		
		if(srare == false)
		{
			
			for(int i=0; i<5; i++)
			{
				cardNum = 2 + (int)(Math.random() * ((4 - 2) + 1));
				num.add(cardNum);
			}
			//dead multi
		}
		else
		{
			while(srare != true && !num.contains(0)||!num.contains(1))
			{
				for(int i=0; i<5; i++)
				{
					cardNum = 0 + (int)(Math.random() * ((4) + 1));
					num.add(cardNum);
				
				}
				return num;
			}
		}
		
		
		return num;
		

		
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		customCursor = new CustomCursor(this); 
		

		num = new ArrayList<Number>();

		getBanner();
		rng();
		getCardType();

		StyledComponent.setButtonOutline(false);
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/abc.png");
		viewObjects.add(background);
		background.setVisible(false);
				
		
		
		// TextArea descrip = new TextArea((int)(getWidth()/2 * .75),
		// (int)(getHeight()/2 * .9), 150, 150,
		// MainGame.summon.getThings().get(0).getRank());
		//cardNum = (int) (Math.random() * resistance.size());

		
		
		back = new Button(600, 500, 100, 75, "Back", Color.YELLOW, new Action() {

			@Override
			public void act() {

				banner.clear();
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

					System.out.println("Character "+cardNum().get(0));
					System.out.println("Character "+cardNum().get(1));
					System.out.println("Character "+cardNum().get(2));
					System.out.println("Character "+cardNum().get(3));
					System.out.println("Character "+cardNum().get(4));

					
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
					
					Graphic bannerCard1 = new Graphic(300, 300, 100, 200, banner.get((int) cardNum().get(0)).getImage());
					Graphic bannerCard2 = new Graphic(500, 300, 100, 200, banner.get((int) cardNum().get(1)).getImage());
					Graphic bannerCard3 = new Graphic(700, 300, 100, 200, banner.get((int) cardNum().get(2)).getImage());
					Graphic bannerCard4 = new Graphic(400, 500, 100, 200, banner.get((int) cardNum().get(3)).getImage());
					Graphic bannerCard5 = new Graphic(600, 500, 100, 200, banner.get((int) cardNum().get(4)).getImage());
					
					viewObjects.add(bannerCard1);
					viewObjects.add(bannerCard2);
					viewObjects.add(bannerCard3);
					viewObjects.add(bannerCard5);
					viewObjects.add(bannerCard4);



					MainGame.addHero(banner.get((int) cardNum().get(0)));
					MainGame.addHero(banner.get((int) cardNum().get(1)));
					MainGame.addHero(banner.get((int) cardNum().get(2)));
					MainGame.addHero(banner.get((int) cardNum().get(3)));
					MainGame.addHero(banner.get((int) cardNum().get(4)));


					back.setVisible(true);
					back.setEnabled(true);
					
					
					
					background.setVisible(true);
					
				} else {
					
					//cardNum = (int) (Math.random() * resistanceB.size());
					
					
					System.out.println("Character "+cardNum().get(0));
					System.out.println("Character "+cardNum().get(1));
					System.out.println("Character "+cardNum().get(2));
					System.out.println("Character "+cardNum().get(3));
					System.out.println("Character "+cardNum().get(4));
					

					Graphic bannerCardB1 = new Graphic(300,300,100,200, banner.get((int) cardNum().get(0)).getImage());
					Graphic bannerCardB2 = new Graphic(500,300,100,200, banner.get((int) cardNum().get(1)).getImage());
					Graphic bannerCardB3 = new Graphic(700,300,100,200, banner.get((int) cardNum().get(2)).getImage());
					Graphic bannerCardB4 = new Graphic(400,500,100,200, banner.get((int) cardNum().get(3)).getImage());
					Graphic bannerCardB5 = new Graphic(600,500,100,200, banner.get((int) cardNum().get(4)).getImage());

					viewObjects.add(bannerCardB1);
					viewObjects.add(bannerCardB2);					
					viewObjects.add(bannerCardB3);
					viewObjects.add(bannerCardB4);
					viewObjects.add(bannerCardB5);

					
					MainGame.addHero(banner.get((int) cardNum().get(0)));
					MainGame.addHero(banner.get((int) cardNum().get(1)));
					MainGame.addHero(banner.get((int) cardNum().get(2)));
					MainGame.addHero(banner.get((int) cardNum().get(3)));
					MainGame.addHero(banner.get((int) cardNum().get(4)));
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
			banner = new ArrayList<Hero>();
			banner.add(MainGame.highPrincess);//SS
			banner.add(MainGame.highTank);//S
			banner.add(MainGame.bCoolGuys);//A
			banner.add(MainGame.mediumAxe);//A
			banner.add(MainGame.beginnerSword);//B

			
			System.out.println("RESISTANCE BANNER HAS BEEN CREATED");
		}
		
		if(bannerNum == 1)
		{
			banner = new ArrayList<Hero>();
			banner.add(MainGame.highAssassin);//SS
			banner.add(MainGame.mediumHighSchoolGirl);//S
			
			banner.add(MainGame.bFanWoman);//A
			banner.add(MainGame.mediumWitch);//A
			banner.add(MainGame.beginnerArcher);//B
			
			System.out.println("RED BANNER HAS BEEN CREATED");
		}
		
		if(bannerNum == 2)
		{
			banner = new ArrayList<Hero>();
			banner.add(MainGame.highSirandHorse);//SS
			banner.add(MainGame.mediumCannonMan);//S
			
			banner.add(MainGame.mediumWizard);//A
			banner.add(MainGame.mediumWolfGirl);//A
			banner.add(MainGame.beginnerWizard);//B

			
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
