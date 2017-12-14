package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class Limit extends Component {

	public Limit() {
		super(40, 40, 100, 100);
		update();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

}
