package maple_gacha;

import java.util.ArrayList;

public class GRewardSystem {

	private int nx;
	private ArrayList<ArrayList<Items>> items = new ArrayList<ArrayList<Items>>();
	
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
	
	public void addItem(Items item)
	{
		for( int i = 0; i< items.size(); i++)
		{
			if( items.get(i).contains(item))
			{
				items.get(i).add(item);
				return;
			}
		}
		items.add(new ArrayList<Items>());
		items.get(items.size()-1).add(item);
	}
	
	public void removeItem(Items item)
	{
		for( ArrayList<Items> i : items)
		{
			if( i.contains(item))
			{
				i.remove(0);
			}
		}
	}
}
