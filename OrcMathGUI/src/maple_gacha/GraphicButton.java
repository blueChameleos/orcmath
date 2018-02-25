package maple_gacha;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.DayOfWeek;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;

public class GraphicButton extends Button {

	private BufferedImage playImage;
	
	public GraphicButton(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, action);
		try {
			playImage = ImageIO.read(getClass().getResourceAsStream("/maplePlayButton.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void drawButton(Graphics2D g, boolean hover)
	{
		g.drawImage(playImage, getX(), getY(), null);
		super.drawButton(g, hover);
	}

}
