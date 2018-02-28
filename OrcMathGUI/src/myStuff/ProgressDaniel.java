package myStuff;

import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class ProgressDaniel extends Component implements ProgressInterfaceWei {
	
	private int roundNumber;

	public ProgressDaniel(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setRound(int x) {
		roundNumber = x;
	}

	@Override
	public void setSequenceSize(int x) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub

	}

}
