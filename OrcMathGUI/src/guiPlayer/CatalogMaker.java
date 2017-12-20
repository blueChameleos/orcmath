package guiPlayer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CatalogMaker {
	
	private ArrayList<Monsters> catalog;

	public CatalogMaker() {
		catalog = new ArrayList<Monsters>();
		//catalog.add(Monsters("Great Jaggi", 2600, ))
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CatalogMaker c = new CatalogMaker();
		c.addNewItem("Brachydios", 2000, 100,200, 500, 1000, "Brute Wyvern", 0.00000001);
		System.out.print(c.getCSVContent());
		c.testSaveContent("monsters.csv");
	}

	public String getCSVContent() {
		String data = "name,baseHP,jumpRes,koRes,mountRes,fireRes,iceRes,waterRes,thunderRes,dragonRes,poisonRes,sleepRes,blastRes,type,size\n";
		for(Monsters m: catalog) {
			data += m.toString() + "\n";
		}
		return data;
	}
	
	public void addNewItem(String name, int baseHP, int jumpRes, int koRes, int blastRes, int mountRes, String type, double size) {
		catalog.add(new Monsters(name, baseHP, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, type, size));
	}
	
	public void testSaveContent(String fileName) {
		try{    
			FileWriter fw=new FileWriter(fileName);    
			for(Monsters m : catalog) {
				fw.write(m + "\n");
			}
			fw.close();    
			System.out.println("Success! File \""+fileName+"\" saved!");

		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");

		}
	}

	public void loadContent() {
		
	}
	
	public ArrayList<Monsters> getCatalog() {
		return catalog;
	}
	
}
