package maple_gacha;

import java.awt.Color;
import java.util.List;

import java.awt.Font;
import java.io.File;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class LoadingScreen extends FullFunctionScreen{

	private Button play;
	private Button quit;
	private TextArea name;
	
	public LoadingScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		play = new Button(540,462,200,100,"PLAY",Color.green,new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
			
		});
		quit = new Button(1000,900,200,50,"QUIT",Color.red,new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
			
		});
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
		viewObjects.add(play);
		viewObjects.add(quit);
		viewObjects.add(name);
	}

	
}
