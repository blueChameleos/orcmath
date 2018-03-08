package maple_gacha;

public class Monster extends JohnsonHero implements Character {


	public Monster(String img, String rank, int strength, int speed, int attack, int defense, int hp, String name) {
		super(img, rank, strength, speed, attack, defense, hp,name);
	}

	@Override
	public void attack() {
		if(MainGame.game.battle.backend.getCurrentPlayer().getGuard()) {
			
		}else {
			
		}
	}

	@Override
	public String getImage() {
		// TODO Auto-generated method stub
		return super.getImage();
	} 
 
	@Override
	public int getHP() {
		// TODO Auto-generated method stub
		return super.getHP();
	}

	@Override
	public void setHP(int hp) {
		// TODO Auto-generated method stub
		super.setHP(hp);;
		MainGame.battle.updateHp();
	}
	
	public int getMaxHp() {
		return super.returnMaxHp();
	}
	@Override
	public void special() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString()
	{
		return "Monster";
	}
}
