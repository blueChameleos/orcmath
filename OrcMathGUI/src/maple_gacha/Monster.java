package maple_gacha;

public class Monster extends Hero implements Character {

	public Monster(String img, String rank, int strength, int speed, int attack, int defense, int hp) {
		super(img, rank, strength, speed, attack, defense, hp);
	}
	
	public Monster(int strength, int speed, int attack, int defense, int hp) {
		super("resources/characterPics/Hero_BeginnerArcher.png", "SS", strength, speed, attack, defense, hp);
	}

	@Override
	public void attack() {
		if(MainGame.game.battle.backend.getCurrentPlayer().getGuard(b)) {
			
		}else {
			
		}
	}

	@Override
	public String getImage() {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public int getHP() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setHP(int hp) {
		// TODO Auto-generated method stub
		this.hp = hp;
	}

	@Override
	public void special() {
		// TODO Auto-generated method stub
		
	}

}
