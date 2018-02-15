package maple_gacha;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableCharacter;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.*;

//SCREEN FOR USER PICKS ONE OUT OF THREE BEGINNER CHARACTERS

public class BeginnerSelectionScreen extends FullFunctionScreen {

	private ArrayList<ClickableCharacter> allBeg;
	private ClickableCharacter begArcher;
	private ClickableCharacter begSword;
	private ClickableCharacter begWizard;
	private boolean selected;

	public BeginnerSelectionScreen(int width, int height) {
		super(width, height);

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		TextLabel text = new TextLabel(410, 200, 1000, 500, "Choose your hero!");

		Color or = new Color(255, 230, 179);

		Graphic charBg = new Graphic(0, 0, getWidth(), getHeight(), "resources/screenPics/charSelectBG.png");
		charBg.setVisible(true);
		viewObjects.add(charBg);

		begArcher = new ClickableCharacter(200, 500, 200, 200, MainGame.game.beginnerArcher.getImage(), null);
		begSword = new ClickableCharacter(600, 500, 200, 200, MainGame.game.beginnerSword.getImage(), null);
		begWizard = new ClickableCharacter(1000, 500, 200, 200, MainGame.game.beginnerWizard.getImage(), null);

		Button next = new Button(670, 780, 70, 70, "Next", or, null);
		next.setVisible(false);

		Button retry = new Button(595, 780, 70, 70, "Redo", or, null);
		retry.setVisible(false);

		retry.setAction(new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				MainGame.game.team.clear();
				showChars();
				text.setText("Choose your hero!");
			}

		});

		// ClickableGraphic next = new ClickableGraphic(500, 780, 500 ,125,
		// "resources/characterPics/playbutton.png");

		next.setAction(new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				if (!MainGame.game.team.isEmpty()) {
					MainGame.game.setScreen((new CharacterScreen(getWidth(), getHeight())));
				} else {
					text.setText("You must choose a hero first!");
					text.setX(300);
				}

			}

		});
		// s

		text.setSize(60);
		text.setCustomTextColor(or);
		viewObjects.add(text);

		allBeg = new ArrayList<ClickableCharacter>();
		allBeg.add(begArcher);
		allBeg.add(begSword);
		allBeg.add(begWizard);

		Graphic lightbulb = new Graphic(100, 400, 100, 100, "resources/lightbulb.png");
		lightbulb.setVisible(false);
		viewObjects.add(lightbulb);

		for (ClickableCharacter c : allBeg) {
			c.setHoverAction(new Action() {

				@Override
				public void act() {
					lightbulb.setVisible(true);
					lightbulb.setX(c.getX() + 30);
				}

			});
		}

		viewObjects.add(begArcher);
		viewObjects.add(begSword);
		viewObjects.add(begWizard);

		System.out.println(MainGame.game.beginnerArcher);

		begArcher.setAction(new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				begSword.setVisible(false);
				begWizard.setVisible(false);
				MainGame.addHero(MainGame.beginnerArcher);
				MainGame.addHero(MainGame.game.beginnerSword);
				MainGame.addHero(MainGame.beginnerArcher);
				MainGame.addHero(MainGame.game.beginnerSword);
				MainGame.addHero(MainGame.beginnerArcher);
				MainGame.addHero(MainGame.game.beginnerWizard);

				text.setX(410);
				begArcher.setX(560);
				lightbulb.setX(begArcher.getX() + 30);
				text.setText("You chose the archer!");

				retry.setVisible(true);
				next.setVisible(true);

			}

		});

		begSword.setAction(new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				begArcher.setVisible(false);
				begWizard.setVisible(false);
				MainGame.addHero(MainGame.game.beginnerSword);
				text.setText("You chose the Swordsman!");
				retry.setVisible(true);
				next.setVisible(true);
				text.setX(410);
				lightbulb.setX(begSword.getX() + 30);


			}

		});

		begWizard.setAction(new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				begArcher.setVisible(false);
				begSword.setVisible(false);
				MainGame.addHero(MainGame.game.beginnerWizard);
				text.setText("You chose the Wizard!");
				begWizard.setX(600);
				retry.setVisible(true);
				next.setVisible(true);
				text.setX(410);
				lightbulb.setX(begWizard.getX() + 30);


			}
		});

		try {
			File fontFile2 = new File("resources//deloise.ttf");
			Font font2 = Font.createFont(Font.TRUETYPE_FONT, fontFile2);
			Font baseFont2 = font2.deriveFont(90f);
			text.setFont(baseFont2);
			baseFont2 = font2.deriveFont(16f);
			next.setFont(baseFont2);
			retry.setFont(baseFont2);
		} catch (Exception e) {
 
		}

		viewObjects.add(next);

		viewObjects.add(retry);
		for (int i = 0; i < 30; i++) {
			viewObjects.add(new SnowFlake(getWidth(), getHeight()));
		}

	}

	private void showChars() {
		begArcher.setX(200);
		begSword.setX(600);
		begWizard.setX(1000);
		begArcher.setVisible(true);
		begSword.setVisible(true);
		begWizard.setVisible(true);
	}

}
