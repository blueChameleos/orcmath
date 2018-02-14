package maple_gacha;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableCharacter;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Component;
import guiTeacher.components.Graphic;
import guiTeacher.components.Pane;
import guiTeacher.components.ProgressBar;
import guiTeacher.interfaces.Task;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ComponentContainer;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class BattleScreen extends FullFunctionScreen implements Runnable {

	private static final long serialVersionUID = 2809999782648181302L;
	private int roundNum;
	public static GBattleSystem backend;
	public static BattleMenu userui;
	public static ItemMenu itemui;
	public static Pane fader;
	public static Thread game;
	private CharacterImage currentlySelectedCharacterImage;

	public static ClickableGraphic heroPos1;
	public static ClickableGraphic heroPos2;
	public static ClickableGraphic heroPos3;

	public static ClickableCharacter g;
	
	public static ClickableGraphic monsterPos1;
	public static ClickableGraphic monsterPos2;
	public static ClickableGraphic monsterPos3;

	public static HpBar eHp1;

	ArrayList<ClickableGraphic> clickHero;
	ArrayList<ClickableGraphic> clickMonster;
	
	ArrayList<CharacterImage> monsterImg;

	public BattleScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Hero[] currentTeam = new Hero[MainGame.currentTeam.size()];
		for (int i = 0; i < currentTeam.length; i++) {
			currentTeam[i] = MainGame.currentTeam.get(i);
		}
		backend = new GBattleSystem(3, currentTeam);

		int playerSizeH = 100;
		int playerSizeW = 100;
		Graphic background = getRandomBackground();
		viewObjects.add(background);

		monsterImg = new ArrayList<CharacterImage>();
		
		clickHero = new ArrayList<ClickableGraphic>();
		clickHero.add(heroPos1);
		clickHero.add(heroPos2);
		clickHero.add(heroPos3);

		userui = new BattleMenu(this, 30, 800);
		userui.update();
		itemui = new ItemMenu(this, 1000, 400);
		itemui.setAlpha(0);
		itemui.setVisible(false);
		viewObjects.add(userui);
		viewObjects.add(itemui);
		for (int i = 0; i < MainGame.currentTeam.size(); i++) {
			int number = i;
			clickHero.set(i, new ClickableGraphic(700 + (i * 100), 600, playerSizeW, playerSizeH,
					MainGame.currentTeam.get(i).getImage()));
			clickHero.get(i).setAction(new Action() {
				@Override
				public void act() {
					userui.playerPortrait.loadImages(MainGame.currentTeam.get(number).getImage(), 150, 150);
					userui.update();
				}
			});
			viewObjects.add(clickHero.get(i));
		}

		for (int i = 0; i < backend.getEnemiesList()[backend.getRound()].length; i++) {
			// backend.getEnemiesList()[backend.getRound()][i].getImage()
			CharacterImage g = new CharacterImage(100 + (i * 100), 600,
					"resources/characterPics/Boss_Killer.png", null);
			int number = i;
			
			g.setAction(new Action() {
				@Override
				public void act() {
					if (currentlySelectedCharacterImage != null) {
						currentlySelectedCharacterImage.setSelected(false);
					}
					backend.setCurrentEnemy(backend.getEnemiesList()[backend.getRound()][number]);
					g.setSelected(true);
					currentlySelectedCharacterImage = g;
					update();
				}
			});
			monsterImg.add(g);
			viewObjects.add(g);
		}
		fader = new Pane(this,0,0,getWidth(),getHeight());
		fader.setBackground(Color.BLACK);
		viewObjects.add(fader);
		run();
		backend.setPlaying(true);
		game = new Thread(backend);
		game.start();
	}

	private Graphic getRandomBackground() {
		return new Graphic(0, 0, getWidth(), getHeight(), "resources/winter.png");
	}

	@Override
	public void run() {
		Thread animator = new Thread(new Runnable() {
			@Override
			public void run() {
				while(fader.getAlpha() > 0.01) {
					fader.setAlpha((float)(fader.getAlpha()-0.01));
					try {
						Thread.sleep(1000/60);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				fader.setAlpha(0);
			}
		});
		animator.start();
	}
	
	public void updateHp() {
		
	}
	public void SwitchUIAI() {

	}

	public void SwitchAIUI() {

	}

}
