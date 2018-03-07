package maple_gacha;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
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

	private AnimatedComponent featured;
	private CustomButtonFront dungeon;
	private CustomButtonFront summonb;
	private CustomButtonFront inventory;
	private CustomButtonFront quit;
	private TextArea name;
	public ArrayList<Graphic> unitlist;
	public Graphic unit1;
	public Graphic unit2;
	public Graphic unit3;
	public boolean plo;
	private TextArea dungeontext;
	private TextArea summontext;
	private TextArea unitstext;
	private TextArea quittext;

	public MainScreen(int width, int height) {
		super(width, height);
	}
	public void initAllObjects(List<Visible> viewObjects) {		
		plo = false;
		if(Math.random() > .5) {
			viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/home.jpg"));
			viewObjects.add(new Graphic((getWidth()/2)-359,155,226,339,"resources/border6.png"));
			viewObjects.add(new Graphic((getWidth()/2)-113,155,226,339,"resources/border6.png"));
			viewObjects.add(new Graphic((getWidth()/2)+133,155,226,339,"resources/border6.png"));
		}else {
			viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/home2.png"));		
			viewObjects.add(new Graphic((getWidth()/2)-359,155,226,339,"resources/border1.png"));
			viewObjects.add(new Graphic((getWidth()/2)-113,155,226,339,"resources/border1.png"));
			viewObjects.add(new Graphic((getWidth()/2)+133,155,226,339,"resources/border1.png"));
		}
		featured = new AnimatedComponent((getWidth()/2)-325,510,650,350);
		featured.addSequence("resources/banners.png", 5000,0,0,650,350,3);	
		viewObjects.add(featured);
		Thread banner = new Thread(featured);
		banner.start();		
		unitlist = new ArrayList<Graphic>();
		unit1 = new Graphic((getWidth()-605)/2,225,226,339,"resources/transparent.png");
		unit2 = new Graphic((getWidth()-113)/2,225,226,339,"resources/transparent.png");
		unit3 = new Graphic((getWidth()+379)/2,225,226,339,"resources/transparent.png");		
		unitlist.add(unit1);
		unitlist.add(unit2);
		unitlist.add(unit3);
		reload();
		for(int i = 0; i < unitlist.size(); i++) {
			viewObjects.add(unitlist.get(i));
		}
		dungeon = new CustomButtonFront((getWidth()/4)-50,875,200,100);
		dungeon.setAction(new Action() {	
			public void act() {
				if(!plo) {
					MainGame.playMusic("resources/everythingelse.wav");
					plo = true;
				}
		//		MainGame.playMusic("resources/everythingelse.wav");
				MainGame.game.setBattle(new BattleScreen(getWidth(), getHeight()));
				MainGame.game.setScreen(MainGame.game.battle);
			}			
		});
		dungeontext = new TextArea((getWidth()/4)+5,885,200,100,"Dungeon");
		summonb = new CustomButtonFront(getWidth()/2-100,875,200,100);
		summonb.setAction(new Action() {
			public void act() {
				MainGame.game.setScreen(MainGame.summon);
				if(!plo) {
					MainGame.playMusic("resources/everythingelse.wav");
					plo = true;
				}
				
	//			MainGame.playMusic("resources/everythingelse.wav");	
			}
			
		});
		summontext = new TextArea((getWidth()/2)-45,885,200,100,"Summon");
		inventory = new CustomButtonFront(((getWidth()/4)*3)-150,875,200,100);
		inventory.setAction(new Action() {
			public void act() {
				MainGame.game.setScreen(new CharacterScreen(getWidth(), getHeight()));
				if(!plo) {
					MainGame.playMusic("resources/everythingelse.wav");
					plo = true;
				}
		//		MainGame.playMusic("resources/everythingelse.wav");

			}
			
		});
		unitstext = new TextArea(((getWidth()/4)*3)-75,885,200,100,"Units");
		quit = new CustomButtonFront(getWidth()-175,getHeight()-100,150,75);
		quit.setAction(new Action() {
			public void act() {
				System.exit(1);
			}
		});
		quittext = new TextArea(getWidth()-120,getHeight()-100,150,75,"QUIT");
		name = new TextArea(480,10,600,200,"GachaStory");		
		try {		
			File fontFile = new File("resources//Bobbleboddy.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(16f);
			quit.setFont(baseFont);
			quit.setSize(24);
			dungeon.setFont(baseFont);
			dungeon.setSize(36);
			summonb.setFont(baseFont);
			summonb.setSize(36);
			inventory.setFont(baseFont);
			inventory.setSize(36);	
			File fontFile2 = new File("resources//deloise.ttf");
			Font font2 = Font.createFont(Font.TRUETYPE_FONT, fontFile2);
			Font baseFont2=font2.deriveFont(16f);
			name.setFont(baseFont2);
			name.setSize(100);
		} 
		catch (Exception e) {
			 e.printStackTrace();
		}
		viewObjects.add(new Graphic(795, 30, 75,75,"resources/mapleleaf.png"));		
		viewObjects.add(name);
		viewObjects.add(dungeon);
		viewObjects.add(summonb);
		viewObjects.add(inventory);
		viewObjects.add(quit);
		viewObjects.add(dungeontext);
		viewObjects.add(summontext);
		viewObjects.add(unitstext);
		viewObjects.add(quittext);
	}
	
	public void reload() {
		for(int i = 0; i < 3; i++) {
            if (MainGame.currentTeam.size() > i) {
            	unitlist.get(i).loadImages(MainGame.currentTeam.get(i).getImage(), (getWidth()/2)-359+(i*246), 175);
            }else {
            	System.out.println("aah");
            	unitlist.get(i).loadImages("resources/transparent.png", (getWidth()/2)-359+(i*246)+113, 175);
            }
        }

	}

}
