package maple_gacha;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Component;

public class HpBar extends Component {

	private int hp;
	private int maxHp;
	
	public int getHp() { 
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
		update();
	}
	
	public void setMax(int maxHp) {
		this.maxHp = maxHp;
	}
	
	public HpBar(int x, int y) {
		super(x, y, 80, 20);
	}

	@Override
	public void update(Graphics2D g) {
		clear();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.red);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, (int)((getWidth() / 100.0) * (int)((hp*100/maxHp))), getHeight());
	}

}
