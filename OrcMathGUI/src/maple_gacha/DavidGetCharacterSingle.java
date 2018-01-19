package maple_gacha;

import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class DavidGetCharacterSingle extends FullFunctionScreen{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6471336238619387248L;
	Button back;
	
	public DavidGetCharacterSingle(int width, int height) {
		super(width, height);
		//getCard();
		//lighting();
		// TODO Auto-generated constructor stub
	}

	public void lighting()
	{
		URL url = null;
		try {
			url = new URL("Level_up_animation_You&I");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);

        JFrame f = new JFrame("Animation");
        f.getContentPane().add(label);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
	}
	

	public void getCard()
	{
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		back = new Button(600,500,100,75,"Back",Color.YELLOW,new Action() {
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
		});
		
		viewObjects.add(back);
		
	}

}
