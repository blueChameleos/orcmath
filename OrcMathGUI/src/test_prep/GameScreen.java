package test_prep;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Clickable;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class GameScreen extends FullFunctionScreen implements Runnable {

	private static final long serialVersionUID = 1506806585217939684L;
	private static int clicks = 0;
	private static int seconds = 5;
	private static Button b;
	private static TextLabel label;

	public GameScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		label = new TextLabel(getWidth()/2-30, (int)(0.1 * getHeight()), getWidth()/2, 100, "Click the button below to start the game");
		label.setBodyAlign(TextLabel.ALIGN_CENTER);
		viewObjects.add(label);
		b = new Button(getWidth()/2-50, getHeight()/2-25, 100, 50, "Start", new Action() {
			
			@Override
			public void act() {
				Thread timer = new Thread(MainGame.screen);
				timer.start();
			}
			
		});
		b.setBackground(Color.red);
		b.update();
		viewObjects.add(b);
	}

	private void startCountdown() {
		int countdown = 3;
		b.setBackground(Color.yellow);
		while(countdown > 0) {
			b.setText("Ready?");
			label.setText(countdown+"");
			try {
				//System.out.println(countdown);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			countdown--;
		}
		startGame();
	}

	private void playGame() {
		while(seconds > 0) {
			try {
				Thread.sleep(1000);
				seconds--;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		b.setEnabled(false);
		b.setText("Nice job!");
	}
	
	private void startGame() {
		updateLabel();
		b.setText("Click me!");
		b.setBackground(Color.green);
		b.setAction(new Action() {
			
			public void act() {
				clicks++;
				updateLabel();
			}
			
		});
		b.update();
		playGame();
	}

	private void updateLabel() {
		label.setText("Score: " + clicks);
	}

	@Override
	public void run() {
		startCountdown();
	}

}
