package simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenWei extends ClickableScreen implements Runnable{

	private static ProgressInterfaceWei progress;
	private ArrayList<MoveInterfaceWei> sequence;
	private TextLabel label;
	private static ButtonInterfaceWei[] buttons;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private static int lastSelectedButton;
	
	
	public SimonScreenWei(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceWei b: buttons){ 
		    viewObjects.add(b); 
		}
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceWei>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	public MoveInterfaceWei randomMove() {
		int selectedButton = (int)(Math.random()*buttons.length);
		while(selectedButton == lastSelectedButton) {
			selectedButton = (int)(Math.random()*buttons.length);
		}
		lastSelectedButton = selectedButton;
		return getMove(selectedButton);
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceWei getProgress() { 
	    // TODO Auto-generated method stub 
	    return null; 
	}

	public void addButtons() {
		int numberOfButtons = 6;
		buttons = new ButtonInterfaceWei[numberOfButtons];
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setColor(new Color((int)Math.random()*256, (int)Math.random()*256, (int)Math.random()*256));
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
