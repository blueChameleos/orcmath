package simonalt;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class SimonButton extends Button {
	
	private Color color;

	public SimonButton(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
	}

	public SimonButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		// TODO Auto-generated constructor stub
	}

	public void highlight() {
		this.setBackground(Color.white);
		update();
	}

	public void dim() {
		this.setBackground(this.color);
		update();
	}

	public void setColor(Color color) {
		this.setBackground(color);
		this.color = color;
		update();
	}

}
