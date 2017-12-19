package myStuff;

import java.util.List;

import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.components.*;

public class CatalogScreen extends FullFunctionScreen {
	
	private TextField nameField;
	private TextField 
	private TextField descriptionField;
	

	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		descriptionField = new TextField(40,40,200,30,"Monster Name","rawr");
		viewObjects.add(descriptionField);
	}
	
	

}
