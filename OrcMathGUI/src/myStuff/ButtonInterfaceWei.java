package myStuff;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceWei extends Clickable {
	void setAction(Action action);

	void highlight();

	void dim();

	void setColor(Color color);
}
