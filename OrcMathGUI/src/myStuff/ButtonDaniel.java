package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonDaniel extends Button implements ButtonInterfaceWei {
	private Color color;
	public ButtonDaniel(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		// TODO Auto-generated constructor stub
	}

	public ButtonDaniel(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		// TODO Auto-generated constructor stub
	}
	public void drawButton(Graphics2D g, boolean hover)
	{
		
	}

	@Override
	public void highlight() {
		int red = this.color.getRed() + 10;
		int blue = this.color.getBlue() + 10;
		int green = this.color.getGreen() + 10;
 		this.setColor(new Color(red,green,blue));
	}

	@Override
	public void dim() {
		this.setColor(Color.black);
	}

	public Color getColor()
	{
		return this.color;
	}
	public void setColor(Color color) {
		this.setBackground(Color.blue);
		
	}

	

}
