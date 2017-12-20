package myStuff;

import java.util.List;

import guiPlayer.CatalogMaker;
import guiPlayer.Monsters;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.components.*;

public class CatalogScreen extends FullFunctionScreen {
	
	private TextField nameField;
	private TextField typeField;
	private TextField hpField;
	private TextField fireResField;
	private TextField iceResField;
	private TextField waterResField;
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
		nameField = new TextField(40,40,200,30,"","Monster Name");
		viewObjects.add(nameField);
		hpField = new TextField(40,100,200,30, "", "Base HP");
		hpField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(hpField);
		fireResField = new TextField(40, 160, 200, 30, "", "Fire Res");
		fireResField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(fireResField);
		iceResField = new TextField(40, 220, 200, 30, "", "Ice Res");
		iceResField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(iceResField);
		waterResField = new TextField(40, 280, 200, 30, "", "Water Res");
		waterResField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(waterResField);
		descriptionField = new TextField(40, 160, 200, 30, "", "rawr");
		add = new Button(260,40,40,40,"Add", new Action(){
			@Override
			public void act() {
				descriptionField.setText(addButtonClicked());
			}
		});
		descriptionArea = new TextArea(40, 280, 200, 30, "Insert text here");
		viewObjects.add(descriptionArea);
		viewObjects.add(add);
	}

	protected String addButtonClicked() {
		Monsters m = new Monsters(nameField.getText(), Integer.parseInt(hpField.getText()), Integer.parseInt(fireResField.getText()), Integer.parseInt(iceResField.getText()), borderWidth, borderWidth, borderWidth, borderWidth, borderWidth, borderWidth, borderWidth, borderWidth, borderWidth, name, alpha);
		String s = descriptionArea.getText() + m + "\n";
		descriptionArea.setText(s);;
		catalog.getCatalog().add(m);
		return null;
	}
	
	

}
