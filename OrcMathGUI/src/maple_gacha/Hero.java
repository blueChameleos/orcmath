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
	private int exp;
	private int level;
	private boolean clickE;

	public Hero(String img, String rank, int strength, int speed, int attack, int defense, int hp) {
		this.img = img;
		this.rank = rank;
		this.strength = strength;
		this.speed = speed;
		this.attack = attack;
		this.defense = defense;
		this.hp = hp;
		this.uniqueID = (int) (Math.random() * 1000000 + 10000) - (int) (Math.random() * 5000);
		this.exp = 0;
		this.level = 1;
	}
//s
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

	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setExp(int exp) {
		if(this.exp + exp >= getLevel() * 2) {
			this.exp = 0;
			setLevel(1);
		}
	}
	
	
	public void setLevel(int level) {
		this.level += level;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	
	@Override
	public void special() {
		
	}
	
	public String toString() {
		return "Hero Rank: " + getRank() + ", Level: " + getLevel() + ", Exp: " + getExp();
	}
	
	public int getID() {
		return this.uniqueID;
	}
	
	public int getEXP() {
		return this.exp;
	}
	public String getImg() {
		return img;
	}

	public String getRank() {
		return rank;
	}

	public int getStrength() {
		return strength;
	}

	public int getSpeed() {
		return speed;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public int getHp() {
		return hp;
	}

	public int getUniqueID() {
		return uniqueID;
	}

	public int getExp() {
		return exp;
	}
	public void reloadID() {
		this.uniqueID = (int) (Math.random() * 1000000 + 10000) - (int) (Math.random() * 5000);
	}
	public boolean isClickE() {
		return clickE;
	}

	public void setClickE() {
		clickE = !clickE;
	}
}
