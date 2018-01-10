package simonalt;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreen extends ClickableScreen implements Runnable {

	private static final long serialVersionUID = 5052816983959372535L;
	private int roundNumber;
	private static ArrayList<Move> sequence;
	private static SimonProgress progress;
	private static SimonButton[] buttons;
	private static SimonButton lastButton;
	private TextLabel label;
	private int sequenceIndex;
	private boolean acceptingInput;

	public SimonScreen(int width, int height) {
		super(width, height);
		Thread screen = new Thread(this);
		screen.start();
	}

	@Override
	public void run() {
		//label.setText("");
	    nextRound();
	}

	public void nextRound() {
		acceptingInput = false;
		roundNumber++;
		sequence.add(randomMove());
		progress.setRound(roundNumber);
		progress.setSequenceSize(sequence.size());
		changeText("Simon's turn");
		playSequence();
		changeText("Your turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}
	
	public void playSequence() {
		SimonButton b = null;
		for(int i = 0; i < sequence.size(); i++) {
			if(b != null) {
				b.dim();
			}
			b = sequence.get(i).getButton();
			//System.out.println(b);
			b.highlight();
			try {
				Thread.sleep(650);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		b.dim();
	}  
	
	public void changeText(String text) {
		Thread changer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				label.setText(text);
				try {
					Thread.sleep(650);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				label.setText("");
			}
			
		});
		changer.start();
	}

	public Move randomMove() {
		SimonButton b = buttons[(int)(Math.random()*buttons.length)];
		while(b == lastButton) {
			 b = buttons[(int)(Math.random()*buttons.length)];
		}
		lastButton = b;
		return new Move(b);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(Button b: buttons) {
			viewObjects.add(b);
		}
		progress = new SimonProgress(0, 0, 860, 100);
		label = new TextLabel(30,40,300,40,"Let's play Simon!");
		sequence = new ArrayList<Move>();
		//add 2 moves to start
		lastButton = null;
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
		//run();
	}

	public void addButtons() {
		int numberOfButtons = 4;
		Color[] colors = new Color[numberOfButtons];
		buttons = new SimonButton[numberOfButtons];
		int x = 180;
		int y = 200;
		colors[0] = Color.green;
		colors[1] = Color.blue;
		colors[2] = Color.yellow;
		colors[3] = Color.red;
		for(int i = 0; i < buttons.length; i++) {
			final SimonButton b = getAButton();
			b.setColor(colors[i]);
			b.setX(x);
			b.setY(y);
			b.setAction(new Action() {
				
				@Override
				public void act(){
					if(acceptingInput) {
						Thread blink = new Thread(new Runnable(){
							public void run(){
								b.highlight();
								try {
									Thread.sleep(650);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								b.dim();
							}
						});
						blink.start();
						if(b == sequence.get(sequenceIndex).getButton()) {
							sequenceIndex++;
							if(sequenceIndex == sequence.size()){ 
							    Thread nextRound = new Thread(SimonScreen.this); 
							    nextRound.start(); 
							}
						}
						else {
							gameOver();
						}
					}
				}
				
			});
			
			x += 210;
			if(i == 1) {
				x = 180;
				y += 160;
			}
			buttons[i] = b;
		}
		
	}

	public void gameOver() {
		progress.lose();
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setEnabled(false);
		}
	}

	public SimonButton getAButton() {
		return new SimonButton(0, 0, 200, 150, "", null);
	}
}
