package maple_gacha;

public class Monster extends Hero implements Character {

	public Monster(String img, String rank, int strength, int speed, int attack, int defense, int hp, String name) {
		super(img, rank, strength, speed, attack, defense, hp,name);
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getImage() {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public int getHP() {
		// TODO Auto-generated method stub
		return this.hp;
	}

	@Override
	public void setHP() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void special() {
		// TODO Auto-generated method stub
		
	}

}
