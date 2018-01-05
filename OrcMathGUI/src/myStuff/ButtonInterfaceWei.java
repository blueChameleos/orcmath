package myStuff;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceWei extends Clickable {
	void setAction(Action action);

	void highlight();

	void dim();
}
