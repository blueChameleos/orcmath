package maple_gacha;

public class Hero implements Character {

	private String img;
	private String rank;
	private int strength;
	private int speed;
	private int attack;
	private int defense;
	private int hp;
	private int uniqueID;
	 
	public Hero(String img, String rank, int strength, int speed, int attack, int defense, int hp) {
		this.img = img;
		this.rank = rank;
		this.strength = strength;
		this.speed = speed;
		this.attack = attack;
		this.defense = defense;
		this.hp = hp;
		this.uniqueID = (int) (Math.random() * 1000000 + 10000) - (int) (Math.random() * 5000);
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
	
	public int getID() {
		return this.uniqueID;
	}
}
