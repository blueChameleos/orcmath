package myStuff;

import java.util.List;

import guiPlayer.CatalogMaker;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.components.*;

public class CatalogScreen extends FullFunctionScreen {
	
	private TextField nameField;
	private TextField typeField;
	private TextField hpField;
	private TextField descriptionField;
	private Button add;
	private TextArea descriptionArea;
	private CatalogMaker catalog;

	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		catalog = new CatalogMaker();
		nameField = new TextField(40,40,200,30,"Monster Name","rawr");
		viewObjects.add(nameField);
		hpField = new TextField(40,100,200,30, "Base HP", "rawr");
		viewObjects.add(hpField);
		descriptionField = new TextField(40, 160, 200, 30, "Description", "rawr");
		add = new Button(260,40,20,10,"Add", new Action(){
			@Override
			public void act() {
				descriptionField.setText(addButtonClicked());
			}
		});
		viewObjects.add(add);
		descriptionArea = new TextArea(40, 220, 200, 30, "Insert text here");
		viewObjects.add(descriptionArea);
	}

	protected String addButtonClicked() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
