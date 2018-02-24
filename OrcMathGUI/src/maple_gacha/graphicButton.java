package maple_gacha;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;

public class graphicButton extends Button {
	
	private Image background;

	public graphicButton(int x, int y, int w, int h, String text, Color color, Action action, Image picture) {
		super(x, y, w, h, text, color, action);
		background = picture;
	}

	public graphicButton(int x, int y, int w, int h, String text, Action action, Image picture) {
		super(x, y, w, h, text, action);
		background = picture;
	}
	
	public void drawButton(Graphics2D g, boolean hover){
		g.drawImage(background, 0, 0, getWidth(), 0, 0, 0, getWidth(),0, null);
		super.drawButton(g, hover);
	}
	
	public void hoverAction()
	{
		
	}

}
