package maple_gacha;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Clickable;

public class CustomButton extends Button implements Clickable{

	private Graphic charImg;

	public CustomButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		update(); 
		// TODO Auto-generated constructor stub
	}
	
	public void setImage(String img) {
		this.charImg.loadImages(img, 50, 50);
		update();
	}
	
	public void setText() {
		
	}
}
