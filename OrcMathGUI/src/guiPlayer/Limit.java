package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Limit extends AnimatedComponent {

	public Limit() {
		super(40, 40, 962, 10);
		addSequence("resources/ken-sprite-sheet.png", 150, 0, 0, 60, 66, 2);
		Thread animation = new Thread(this);
		update();
	}

	@Override
	public void update(Graphics2D g) {
		//g.setColor(Color.blue);
		//g.fillRect(0, 0, getWidth(), getHeight());
		super.update(g);
	}

}
