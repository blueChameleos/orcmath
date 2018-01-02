package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;

import guiPlayer.CustomLabel;
import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CustomButton extends Button implements CustomLabel{

	public CustomButton(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		// TODO Auto-generated constructor stub
	}

	public CustomButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		// TODO Auto-generated constructor stub
	}
	
	public CustomButton(int x, int y, String text, Action action) {
		super(x, y, 800, 800, text, action);
	}

	@Override
	public void updateString1(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateString2(String string) {
		// TODO Auto-generated method stub
		
	}
	
	public void drawButton(Graphics2D g, boolean hover){
		if(hover) {
			g.setColor(Color.black);
		}else {
			g.setColor(Color.white);
		}
	}

	@Override
	public void setIconColor(Color color) {
		// TODO Auto-generated method stub
		
	}


}
