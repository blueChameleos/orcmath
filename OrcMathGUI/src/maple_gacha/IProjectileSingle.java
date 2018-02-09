package maple_gacha;

public class IProjectileSingle extends IProjectile {

	public IProjectileSingle(int value, String name) {
		super(value, name);
		// TODO Auto-generated constructor stub
	}
	
	public void act(Monster target, int value) {
		target.setHP(target.getHP()- value);
	}
}
