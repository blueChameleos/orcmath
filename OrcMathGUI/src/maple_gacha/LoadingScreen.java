package maple_gacha;

import java.awt.Color;
import java.util.List;

import java.awt.Font;
import java.io.File;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.Link;
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
	private TextArea name;
	
	public LoadingScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		play = new Link(540,462,200,100,"PLAY",new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
			
		});
		try {
			File fontFile = new File("resources//Bobbleboddy.ttf");
			// File fontFile = new File("resources//DayRoman.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(16f);
			play.setFont(baseFont);
			play.setSize(60);
		} 
		catch (Exception e) {
			 e.printStackTrace();
		}
		quit = new Button(1000,900,200,50,"QUIT",Color.red,new Action() {

			@Override
			public void act() {
				System.exit(1);
			}
			
		});
		try {
			File fontFile = new File("resources//Bobbleboddy.ttf");
			// File fontFile = new File("resources//DayRoman.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(16f);
			quit.setFont(baseFont);
			quit.setSize(24);
		} 
		catch (Exception e) {
			 e.printStackTrace();
		}
		name = new TextArea(420,200,600,200,"MapleStory");
		try {
			File fontFile = new File("resources//deloise.ttf");
			// File fontFile = new File("resources//DayRoman.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(16f);
			name.setFont(baseFont);
			name.setSize(100);
		} 
		catch (Exception e) {
			 e.printStackTrace();
		}		
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/homescreen.png"));
		viewObjects.add(play);
		viewObjects.add(quit);
		viewObjects.add(name);		

	}

	
}
