package maple_gacha;

import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class WeiLightingScreen extends FullFunctionScreen {

	public Graphic blackCover;
	public Graphic whiteCover;

	public WeiLightingScreen(int width, int height) {
		super(width, height);
	}

	public void initObjects(List<Visible> viewObjects) {
		super.initObjects(viewObjects);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		blackCover = new Graphic(0,0,getWidth(),getHeight(),"resources/hider.jpg");
		whiteCover = new Graphic(0,0,getWidth(),getHeight(), "resources/lights.jpg");
		whiteCover.setAlpha(0);
		viewObjects.add(blackCover);
		viewObjects.add(whiteCover);
	}

	public void fadeIn() {
		Thread animator = new Thread(new Runnable() {
			@Override
			public void run() {
				while(blackCover.getAlpha() > 0.01) {
					blackCover.setAlpha((float)(blackCover.getAlpha()-0.01));
					try {
						Thread.sleep(1000/60);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				blackCover.setAlpha(0);
			}
		});
		animator.start();
	}

	public void fadeOut() {
		Thread animator = new Thread(new Runnable() {
			@Override
			public void run() {
				while(blackCover.getAlpha() < 0.99) {
					blackCover.setAlpha((float)(blackCover.getAlpha()+0.01));
					try {
						Thread.sleep(1000/60);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					blackCover.setAlpha((float) 1.0);
				}
			}
		});
		animator.start();
	}

	public void brighten() {
		Thread animator = new Thread(new Runnable() {

			@Override
			public void run() {
				while(whiteCover.getAlpha() < 0.99) {
					whiteCover.setAlpha((float)(blackCover.getAlpha()+0.01));
					try {
						Thread.sleep(1000/60);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					whiteCover.setAlpha((float) 1.0);
				}
			}
		});
		animator.start();
	}

	public void dim() {
		Thread animator = new Thread(new Runnable() {

			@Override
			public void run() {
				while(whiteCover.getAlpha() > 0.01) {
					whiteCover.setAlpha((float)(blackCover.getAlpha()-0.01));
					try {
						Thread.sleep(1000/60);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				whiteCover.setAlpha(0);
			}
		});
		animator.start();
	}
	
	public void flash() {
		Thread animator = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(whiteCover.getAlpha() < 0.99) {
					whiteCover.setAlpha((float)(blackCover.getAlpha()+0.01));
					try {
						Thread.sleep(1000/60);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					whiteCover.setAlpha((float) 1.0);
				}
				while(whiteCover.getAlpha() > 0.01) {
					whiteCover.setAlpha((float)(blackCover.getAlpha()-0.01));
					try {
						Thread.sleep(1000/60);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				whiteCover.setAlpha(0);
			}
		});
		animator.start();
	}
}
