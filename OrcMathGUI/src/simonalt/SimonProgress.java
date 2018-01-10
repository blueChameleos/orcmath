package simonalt;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class SimonProgress extends Component {
	
	private int roundNumber;
	private int sequenceSize;
	private boolean playing;

	public SimonProgress(int x, int y, int w, int h) {
		super(x, y, w, h);
		playing = true;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		clear();
		if(playing) {
			//g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.black);
			g.drawString("Round: " + this.roundNumber, 660, 40);
			g.drawString("Sequence Size: " + this.sequenceSize, 660, 60);
		}else {
			//g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.black);
			g.drawString("Game Over", 660, 40);
			g.drawString("Round: " + this.roundNumber, 660, 60);
			g.drawString("Sequence Size: " + this.sequenceSize, 660, 80);
		}
	}
	
	public void lose() {
		playing = false;
		update();
	}

	public void setRound(int roundNumber) {
		this.roundNumber = roundNumber;
		update();
	}

	public void setSequenceSize(int size) {
		this.sequenceSize = size;
		update();
	}

}
