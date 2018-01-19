package maple_gacha;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

//SCREEN FOR USER PICKS ONE OUT OF THREE BEGINNER CHARACTERS

public class BeginnerSelectionScreen extends FullFunctionScreen {

	public BeginnerSelectionScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
 
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic charBg = new Graphic(0, 0, getWidth(), getHeight(), "resources/screenPics/charSelectBG.png");
		charBg.setVisible(true);
		viewObjects.add(charBg);
		Button next = new Button(400, 780, 500, 125, "Next", null);
		next.setSize(100);
		next.setEnabled(false);
		next.setAction(new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				MainGame.game.setScreen((MainGame.game.cScreen));
				
			}
			
		});
		TextLabel text = new TextLabel(400,200,1000,500, "Choose your hero!");
		
	
		
		text.setSize(60);
		text.setTextColor(Color.orange);
		
		viewObjects.add(text);
		
		ClickableGraphic begWizard = new ClickableGraphic(1000, 400, 200 ,200, MainGame.game.beginnerWizard.getImage());
		ClickableGraphic begArcher = new ClickableGraphic(200, 400, 200, 200, MainGame.game.beginnerArcher.getImage());
		ClickableGraphic begSword = new ClickableGraphic(600, 400, 200 ,200, MainGame.game.beginnerSword.getImage());

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
				MainGame.game.team.add(MainGame.game.beginnerArcher);
				text.setText("You chose the archer!" );
				next.setEnabled(true);

			}

		});
		
		begSword.setAction(new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				begArcher.setVisible(false);
				begWizard.setVisible(false);
				MainGame.game.team.add(MainGame.game.beginnerSword);
				text.setText("You chose the Sword!" );
				next.setEnabled(true);

			}

		});
		
		begWizard.setAction(new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				begArcher.setVisible(false);
				begSword.setVisible(false);
				MainGame.game.team.add(MainGame.game.beginnerWizard);
				text.setText("You chose the Wizard!" );
				next.setEnabled(true);

			}
		});
		
		
		viewObjects.add(next);


	}

}
