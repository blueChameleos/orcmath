package simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreen extends ClickableScreen implements Runnable {
	
	private static TextArea progress;
	private ArrayList<Move> sequence;
	private TextLabel label;
	private static Button[] buttons;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private static int lastSelectedButton;

	public SimonScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
	}

	public void addButtons() {
		int numberOfButtons = 6;
		buttons = new Button[numberOfButtons];
		Color[] colors = new Color[numberOfButtons];
		int x = 100;
		int y = 400;
		
		colors[0] = Color.blue;
		colors[1] = Color.red;
		colors[2] = Color.yellow;
		colors[3] = Color.green;
		colors[4] = Color.cyan;
		colors[5] = Color.magenta;
		
		for(int i = 0; i < buttons.length; i++) {
			final Button b = getAButton();
			b.setBackground(colors[i]);
		}
	}

	private Button getAButton(int x, int y) {
		return null;
	}

}
