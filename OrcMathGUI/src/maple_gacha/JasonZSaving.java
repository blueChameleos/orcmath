package maple_gacha;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class JasonZSaving {

	public static void main(String[] args)
	{
		try {
			FileOutputStream saveFile= new FileOutputStream("saveFile.ser");
			ObjectOutputStream reader = new ObjectOutputStream(saveFile);
			
			ArrayList<Items> inventory = MainGame.game.battle.backend.getInventory();
			ArrayList<Hero> heros = MainGame.team; 
			for(int i =0; i<inventory.size(); i++)
			{
				reader.writeObject(inventory.get(i));
			}
			for(int i = 0; i<heros.size(); i++)
			{
				reader.writeObject(heros.get(i));
			}
			reader.close();


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getInformation(String input)
	{
		FileInputStream
	}
}
