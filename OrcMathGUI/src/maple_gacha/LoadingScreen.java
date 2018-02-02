package maple_gacha;

import java.awt.Color;
import java.util.List;

import java.awt.Font;
import java.io.File;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.Link;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import holiday.HolidayCard;
import holiday.Snowflake;

public class LoadingScreen extends FullFunctionScreen{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button play;
	private Button quit;
	private Button loadgame;
	private Button newgame;
	private TextArea name;
	
	public LoadingScreen(int width, int height) {
		super(width, height);
	}


	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(true);
		newgame = new Button(getWidth()/2 - 100,462,200,75,"New Game",Color.cyan,new Action() {
			public void act() {
				MainGame.game.setScreen(MainGame.main);
			}
			
		});
		loadgame = new Button(getWidth()/2 - 100,550,200,75,"Load Game",Color.cyan,new Action() {
			public void act() {
				MainGame.game.setScreen(MainGame.main);
			}
			
		});
		newgame.setVisible(false);
		loadgame.setVisible(false);
		play = new Button(540,462,200,75,"PLAY",Color.green,new Action() {
			public void act() {
				play.setEnabled(false);
				viewObjects.remove(play);
				newgame.setVisible(true);
				loadgame.setVisible(true);
			}
		});	
		quit = new Button(1000,900,200,50,"QUIT",Color.red,new Action() {

			@Override
			public void act() {
				System.exit(1);
			}
			
		});
		name = new TextArea(480,200,600,200,"GachaStory");
		try {
			File fontFile = new File("resources//Bobbleboddy.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(16f);
			quit.setFont(baseFont);
			quit.setSize(24);
			play.setFont(baseFont);
			play.setSize(48);
			loadgame.setFont(baseFont);
			loadgame.setSize(36);
			newgame.setFont(baseFont);
			newgame.setSize(36);			
			File fontFile2 = new File("resources//deloise.ttf");
			Font font2 = Font.createFont(Font.TRUETYPE_FONT, fontFile2);
			Font baseFont2=font2.deriveFont(16f);
			name.setFont(baseFont2);
			name.setSize(100);
		} 
		catch (Exception e) {
			 e.printStackTrace();
		}		
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/homescreen.png"));
		viewObjects.add(new Graphic(750, 160, 150,150,"resources/mapleleaf.png"));
		viewObjects.add(play);
		viewObjects.add(quit);
		viewObjects.add(name);		
		viewObjects.add(loadgame);
		viewObjects.add(newgame);
	}

	
}
