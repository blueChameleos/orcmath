package maple_gacha;

import java.util.ArrayList;

public class IProjectileAoe extends IProjectile {

	public IProjectileAoe(int value, String name) {
		super(value, name);
		// TODO Auto-generated constructor stub
	}

	public void act(Monster[] targets, int value)
	{
		for(int i = 0; i< targets.length; i++)
		{
			targets[i].setHP(targets[i].getHP() - value);
		}
	}
}
