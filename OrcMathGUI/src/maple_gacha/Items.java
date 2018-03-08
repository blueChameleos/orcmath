package maple_gacha;

import java.io.Serializable;
import java.util.ArrayList;

import guiTeacher.components.Action;

public class Items implements Serializable{
	
	private String name;
	private int value;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Items(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public void act(Monster[] enemiesList, int value) {
		
	}
	
	public void act(JohnsonHero target, int value)
	{
		
	}
	
	public int getValue() {
		return this.value;
	}

}
