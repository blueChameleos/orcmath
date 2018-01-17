package maple_gacha;

public class Hero implements Character {

	private String img;
	private String rank;
	private int strength;
	private int speed;
	private int attack;
	private int defense;
	private int hp;
	 
	public Hero(String img, String rank, int strength, int speed, int attack, int defense, int hp) {
		this.img = img;
		this.rank = rank;
		this.strength = strength;
		this.speed = speed;
		this.attack = attack;
		this.defense = defense;
		this.hp = hp;
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getImage() {
		// TODO Auto-generated method stub
		return this.img;
	}

	@Override
	public int getHP() {
		// TODO Auto-generated method stub
		return this.hp;
	}

	@Override
	public void setHP() {
		
	}

	@Override
	public void special() {
		
	}
	
	public String toString() {
		return "THIS IS HERO";
	}
	
}
