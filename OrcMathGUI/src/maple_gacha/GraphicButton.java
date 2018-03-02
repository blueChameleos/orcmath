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

	private GraphicButton nextButton;
	private BufferedImage image;

	public GraphicButton(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, action);
		nextButton = new GraphicButton(x, y, w, h, text, color, action, "/maplePlayButton.png");
		update();
	}


	public GraphicButton(int x, int y, int w, int h, String text, Color color, Action action, String imageAdress) {
		super(x, y, w, h ,text, action);
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imageAdress));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		update();
	}

	public void drawButton(Graphics2D g, boolean hover)
	{
		if(image != null)
		{
			double widthScale = 1;
			double heightScale =1;
			int width = getWidth();
			int imageWidth = image.getWidth();
			int height = getHeight();
			int imageHeight = image.getHeight();
			if(getWidth() < image.getWidth())
			{
				widthScale = ((double) getWidth())/image.getWidth();
			}
			if(getHeight() < image.getHeight())
			{
				heightScale = ((double)getHeight())/image.getHeight();
			}
			if(getWidth() > image.getWidth())
			{
				widthScale = ((double) getWidth())/image.getWidth();
			}
			if(getHeight() > image.getHeight())
			{
				heightScale = ((double)getHeight())/image.getHeight();
			}
			g.drawImage(image, 0, 0, (int)(image.getWidth()*widthScale),(int) (image.getHeight()*heightScale) ,null);
		}
		super.drawButton(g, hover);
	}

}
