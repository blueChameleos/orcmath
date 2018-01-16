package maple_gacha;

import java.util.ArrayList;

public class GRewardSystem {

	private int nx;
	private ArrayList<Items> items = new ArrayList<Items>();
	
	
	public GRewardSystem()
	{
		nx = 0;
		
	}
	
	public void addExp(Character person, int exp)
	{
		person.addExp(exp);
	}
	
	public void addRewards(int NX)
	{
		nx += NX;
	}
	
	public void addItem(Item item)
	{
		items.add(item);
	}
}
