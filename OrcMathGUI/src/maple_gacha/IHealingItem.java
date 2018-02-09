package maple_gacha;

public class IHealingItem extends Items {

	public IHealingItem(int value, String name) {
		super(value, name);
		// TODO Auto-generated constructor stub
	}
	
	public void act(Hero target, int value)
	{
		target.setHP(target.getHP()+value);
	}

}
