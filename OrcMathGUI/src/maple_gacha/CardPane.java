package maple_gacha;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Graphic;
import guiTeacher.components.Pane;
import guiTeacher.interfaces.Clickable;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;

public class CardPane extends Pane implements Runnable {
	
	private Action action;
	private Hero hero;
	private Graphic bg;
	private Graphic charImg;
	private Action hoverAction;
	
	public CardPane(FocusController focusController, int x, int y, int width, int height,Hero g) {
		super(focusController, x, y, width, height);
		System.out.println("xd");
		this.hero = g;
		// TODO Auto-generated constructor stub
	}
	
	

	public void initAllObjects(List<Visible> viewObjects){
		setVisible(true);
		bg = new Graphic(0, 0, getWidth(), getHeight(), "resources/Empty2.png");
		viewObjects.add(bg);
		charImg = new Graphic(60,50,2,2, "resources/cardPics/Agrade.png");
		viewObjects.add(charImg);
		update();
		
	}
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	public void setImage(String img) {
		this.charImg.loadImages(img, 50, 50);
		update();
	}
	
	
	@Override
	public void run() {
		charImg.loadImages(hero.getImage(), 100, 100);
		if (hero.getRank().equals("A") ) {
			bg.loadImages("resources/cardPics/Agrade.png", getWidth(), getHeight());
		}else if(hero.getRank().equals("B")) {
			bg.loadImages("resources/cardPics/Bgrade.png", getWidth(), getHeight());
		}
		else if(hero.getRank().equals("S")) {
			bg.loadImages("resources/cardPics/Sgrade.png", getWidth(), getHeight());
		}
		else if(hero.getRank().equals("SS")) {
			bg.loadImages("resources/cardPics/SSgrade.png", getWidth(), getHeight());
		}
		update();
	}
	public void hide() {
		bg.loadImages("resources/Empty2.png", 206, 319);
		charImg.loadImages("resources/Empty2.png", 2, 2);
		update();
	}
	public void setAction(Action action) {
		this.action = action;
		
	}
	
	public void act() {
		if(action != null)action.act();
	}
	
	public Hero getHero() {
		return hero;
	}
	
	public boolean isHovered(int x, int y) {
		return x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight();
	}
	
	public void hoverAction(){
		if(hoverAction != null)hoverAction.act();
	}
	
	
	public void setHoverAction(Action hoverAction) {
		this.hoverAction = hoverAction;
	}

}
