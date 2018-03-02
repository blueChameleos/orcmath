package maple_gacha;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Component;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Clickable;

public class CustomButtonFront extends Component implements Clickable{

	private Graphic buttonimg;
	private Action baction;
	
	public CustomButtonFront(int x, int y, int w, int h) {
		super(x, y, w, h);
		buttonimg = new Graphic(0,0,w,h,"resources/finalbutton.jpg");
		// TODO Auto-generated constructor stub
		update();
	}

	@Override
	public boolean isHovered(int x, int y) {
		// TODO Auto-generated method stub
		return x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight();
	} 

	@Override
	public void act() {
		// TODO Auto-generated method stub
		if(baction != null) {
			baction.act();
		}
	}

	@Override
	public void setAction(Action a) {
		// TODO Auto-generated method stub
		this.baction = a;
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(buttonimg.getImage(), buttonimg.getX(), buttonimg.getY(), null);
	}

}
