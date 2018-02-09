package maple_gacha;

import java.io.Serializable;

public class Hero implements Character, Serializable{

	private String img;
	private String rank;
	private int strength;
	private int speed;
	private int attack;
	private int defense;
	private int hp;
	private int uniqueID;
	private int exp;
	private boolean clickE;
	private boolean guarding;
	private double defensePercentage = .1;
	
	public double getDefensePercentage() {
		return defensePercentage;
	}
	public void setDefensePercentage(double defensePercentage) {
		this.defensePercentage = defensePercentage;
	}
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
	public void setHP(int hp) {
		this.hp = hp;
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
	public void setGuard(boolean b) {
		this.guarding = b;
	}
	
	public boolean getGuard()
	{
		return this.guarding;
	}
}
