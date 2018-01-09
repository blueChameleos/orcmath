package myStuff;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

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
	
	public void drawButton(Graphics2D g, boolean hover){
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		drawShape(g, hover);
		g.setColor(getForeground());
		g.setFont(getFont());
		FontMetrics fm = g.getFontMetrics();
		
		if(getText()!= null){
			g.setColor(getForeground());
			String t = getText();
			int cutoff = t.length();
			while(cutoff > 0 && fm.stringWidth(t) > getWidth()){
				cutoff --;
				t = t.substring(0,cutoff); 
			}
			g.drawString(t, (getWidth()-fm.stringWidth(t))/2, 
					(getHeight()+fm.getHeight()-fm.getDescent())/2);
		}
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
		int red = this.color.getRed() - 10;
		int blue = this.color.getBlue() - 10;
		int green = this.color.getGreen() - 10;
 		this.setColor(new Color(red,green,blue));
	}

	public Color getColor(){
		return this.color;
	}
	
	public void setColor(Color color) {
		this.setBackground(color);
	}
}
