package maple_gacha;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class JasonZSaving {

	public static void main(String[] args)
	{
		try {
			FileOutputStream saveFile= new FileOutputStream("saveFile.ser");
			ObjectOutputStream writer = new ObjectOutputStream(saveFile);
			
			ArrayList<Items> inventory = MainGame.game.battle.backend.getInventory();
			ArrayList<Hero> heros = MainGame.team;
			
			writer.writeObject(inventory);
			writer.writeObject(heros);
			writer.close();
			saveFile.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getInformation(String fileName)
	{
		ArrayList<Items> loadedItems = new ArrayList<Items>();
		ArrayList<Hero> team = new ArrayList<Hero>();
		try {
			FileInputStream loadFile = new FileInputStream(fileName);
			ObjectInputStream reader = new ObjectInputStream(loadFile);
			ArrayList<Object> obj = (ArrayList<Object>) reader.readObject();
			for(int i =0; i< obj.size(); i++)
			{
				if(obj.get(i) instanceof Hero)
				{
					team.add((Hero) obj.get(i));
				}
				else
				if(obj.get(i) instanceof Items)
				{
					loadedItems.add((Items) obj.get(i));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainGame.battle.backend.setInventory(loadedItems);
		MainGame.team = team; 
	}
}
