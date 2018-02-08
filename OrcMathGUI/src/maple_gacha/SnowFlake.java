package maple_gacha;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Graphic;
import guiTeacher.components.MovingComponent;

public class SnowFlake extends MovingComponent {

	private BufferedImage img;
	
	public SnowFlake(int w, int h) {
		super((int)(Math.random()*w), (int)(Math.random()*h),50,50);
		img = new Graphic(0,0,50,50, "resources/snowflake.png").getImage();
		setVx(-.5);
		setVy(1.5+Math.random()*2.0);
		update();
		Thread t = new Thread(this);
		t.start();
//		setY((int)(Math.random()*h));
	}

	@Override
	public void drawImage(Graphics2D g) {
		
		if(img != null){
			g.drawImage(img, 0, 0, null);
		}
	}

	@Override
		public void checkBehaviors(){
			if(getY() > 1024) {
				setY(0);
			}
			if(getX() < -20) {
				setX((int)(Math.random()*1280));
			}
		}
	

}