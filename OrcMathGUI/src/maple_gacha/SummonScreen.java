package maple_gacha;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class SummonScreen extends FullFunctionScreen {

	public SummonScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(false);
		// leftarrow.setActiveBorderColor(null);
		// rightarrow.setActiveBorderColor(null);

		// TODO Auto-generated method stub

		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/abc.png");
		viewObjects.add(background);

		Graphic banner = new Graphic(getWidth() / 2, getHeight() / 2, 650, 350, "resources/banner.jpg");
		viewObjects.add(banner);

		Graphic banner1 = new Graphic(getWidth() / 2, getHeight() / 2, 650, 350, "resources/banner1.jpg");
		// banner1.setVisible(false);
		viewObjects.add(banner1);

		Button single = new Button(getWidth() / 2 + 50, getHeight() / 2 + 50, 75, 75, "x1", new Action() {

			@Override
			public void act() {
				// single summon button
			}
		});

		Button multi = new Button(getWidth() / 2 + 125, getHeight() / 2 + 125, 75, 75, "x5", new Action() {

			@Override
			public void act() {
				// multi summon button
			}
		});

		Button feature = new Button(getWidth() / 2 + 125, getHeight() / 2 + 125, 150, 75, "feature", new Action() {

			@Override
			public void act() {
				// feature summon button
			}
		});

		Button rightarrow = new Button(getWidth() / 2 + 125, getHeight() / 2 + 125, 150, 75, "feature", new Action() {

			@Override
			public void act() {
				// feature summon button
			}
		});

		Button leftarrow = new Button(getWidth() / 2 + 125, getHeight() / 2 + 125, 150, 75, "feature", new Action() {

			@Override
			public void act() {
				// feature summon button
			}
		});

	}

}
