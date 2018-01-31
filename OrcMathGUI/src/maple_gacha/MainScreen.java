package maple_gacha;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.GUIApplication;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import guiTeacher.userInterfaces.FullFunctionScreen;
import holiday.HolidayCard;

public class MainScreen extends FullFunctionScreen {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Button featured;
	private Button summonb;
	private Button inventory;
	private Button quit;
	private TextArea name;
	
	public MainScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
		//setVisible(true);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		featured = new Button((getWidth()/2)-((getWidth()-200)/2),550,getWidth()-200,200,"",Color.blue,new Action() {
			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
			
		});
		summonb = new Button(getWidth()/2-100,875,200,100,"Summon",Color.yellow,new Action() {
			@Override
			public void act() {
				// TODO Auto-generated method stub
				MainGame.game.setScreen(MainGame.summon);
			}
			
		});
		quit = new Button(1100,900,150,75,"QUIT",Color.red,new Action() {

			@Override
			public void act() {
				System.exit(1);
			}
			
		});
		name = new TextArea(480,10,600,200,"GachaStory");		
		try {			
			File fontFile2 = new File("resources//deloise.ttf");
			Font font2 = Font.createFont(Font.TRUETYPE_FONT, fontFile2);
			Font baseFont2=font2.deriveFont(16f);
			name.setFont(baseFont2);
			name.setSize(100);
		} 
		catch (Exception e) {
			 e.printStackTrace();
		}
		if(Math.random() > .5) {
			viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/home.jpg"));
		}else {
			viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/home2.png"));
		}
		viewObjects.add(new Graphic(795, 30, 75,75,"resources/mapleleaf.png"));
		viewObjects.add(featured);
		viewObjects.add(summonb);
		viewObjects.add(quit);
		viewObjects.add(name);
		
	}

}
