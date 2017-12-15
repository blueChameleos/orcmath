package guiPlayer;

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
		System.out.print(c.getCSVContent());
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
}
