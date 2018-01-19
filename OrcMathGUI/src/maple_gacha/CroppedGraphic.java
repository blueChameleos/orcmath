package maple_gacha;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import guiTeacher.components.Component;
import guiTeacher.interfaces.Visible;

public class CroppedGraphic extends Component {
	
	private BufferedImage image;
	private float alpha;
	private int x;
	private int y;
	private boolean visible;

	public CroppedGraphic(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h);
		this.x = x;
		this.y = y;
		this.alpha = 1.0f;
		visible = true;
		loadImages(imageLocation, w, h);
	}

	public void loadImages(String imageLocation, int w, int h) {
		try{
			//get the full-size image
			ImageIcon icon = new ImageIcon(imageLocation);

			//use image size of original
			if(w==0 && h == 0){
				image = new BufferedImage(icon.getIconWidth(),icon.getIconHeight(),BufferedImage.TYPE_INT_ARGB);
				Graphics2D g = image.createGraphics();
				g.drawImage(icon.getImage(), 0, 0, null);
			}else{
				//make a full-size image
				image = new BufferedImage(icon.getIconWidth(),icon.getIconHeight(),BufferedImage.TYPE_INT_ARGB);
				Graphics2D g = image.createGraphics();
				g.drawImage(icon.getImage(), 0, 0, null);
				
				//scale the image to size
				AffineTransform scale = new AffineTransform();
				
				//make it fit to the smaller of the two
				double scaleWidth = w/(double)icon.getIconWidth();
				double scaleHeight = h/(double)icon.getIconHeight();
				double smallerOfTwo = (scaleWidth < scaleHeight)? scaleWidth : scaleHeight;
				
//				scale.scale(w/(double)icon.getIconWidth(), h/(double)icon.getIconHeight());
				scale.scale(scaleWidth, scaleWidth);
				AffineTransformOp scaleOp = new AffineTransformOp(scale, AffineTransformOp.TYPE_BILINEAR);
				image = scaleOp.filter(image,new BufferedImage((int)(image.getWidth()*scaleWidth), (int)(image.getHeight()*scaleWidth), BufferedImage.TYPE_INT_ARGB));
//				g.drawImage(icon.getImage(), 0, 0, w, h, 0,0,icon.getIconWidth(), icon.getIconHeight(), null);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void move(int newX, int newY, int durationMS){
		Visible.move(this, newX, newY, durationMS);
	}
	

	public BufferedImage getImage() {
		return image;
	}

	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return image.getWidth();
	}

	public int getHeight() {
		return image.getHeight();
	}

	public void update() {
		//does nothing, since image never changes
	}

	public boolean isAnimated() {
		return false;
	}
	
	public boolean isVisible() {
		return visible;
	}


	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public void unhoverAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hoverAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getAlpha() {
		return alpha;
	}

	@Override
	public void setAlpha(float f) {
		this.alpha = f;
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
}
