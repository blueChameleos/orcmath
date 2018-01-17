package maple_gacha;

import java.awt.Image;
import java.util.ArrayList;

public class GBattleSystem implements Runnable {

	private int enemiesNum;
	private Image backgroundImage;
	private Character[] mainParty;
	private Enemies[][] enemiesList; //round -> enemies 
	private int round;
	private ArrayList<Character> order = new ArrayList<Character>();

	//creation of System
	public GBattleSystem(int difficulty, Image backgrnd, Character[] mainParty)
	{
		changeDifficulty(difficulty); 
		this.backgroundImage = backgrnd;
		this.mainParty = mainParty;

		Thread gameSystem = new Thread(this);
		gameSystem.start();
		run();

	}

	public void run() {
		updateGame();
	

	}

	private void changeDifficulty(int difficulty) {
		setRounds((int) Math.pow(difficulty, 1.5));
		setEnemiesNum((int) Math.pow(difficulty, 1.3));

		populateEnemies();
		changeStats( Math.log((difficulty+1))+.5);

	}


	private void changeStats(double d) {
		for(Enemies e: enemiesList)
		{
			e.setAttack((int)e.getAttack*d);
			e.setHealth((int)e.getHealth*d);
			e.setSpeed((int)e.getSpeed*d);
		}
	}

	private void populateEnemies() {
		for( int rounds =0; rounds< enemiesList.length; i++)
		{
			for(int idx = 0; idx<enemiesList[rounds][idx].length; idx++)
			{
				enemeisList[rounds][idx] = new Enemies();
			}
		}
	}

	private void makeOrder() {

		for(Character c: mainParty)
		{
			order.add(c);
		}

		for(Enemies e: enemieslist[round])
		{
			order.add(e);
		}

		sortOrder(order);
	}

	private void sortOrder(ArrayList<Character> list) {
		int currentIdx = order.size();
		int pivotSpeed = order.get(0);

		if(list.size() > 1)
		{
			for(int i = 1; i< order.size(); i++)
			{
				if(list.get(i).getSpeed() < pivotSpeed)
				{
					currentIdx --;
					swap(currentIdx, i);
				}
			}

			currentIdx --;
			swap(currentIdx, 0);
			sortOrder((ArrayList<Character>) order.subList(0, currentIdx));
			sortOrder((ArrayList<Character>) order.subList(currentIdx+1, order.size()));

		}

	}

	private void swap(int currentIdx, int i) {
		Character holder = order.get(currentIdx);
		order.set(currentIdx, order.get(i));
		order.set(i, holder);
	}

	@Override


	private void updateGame() {
		
	}
	
	private void setEnemiesNum(int enemiesNum) {
		this.enemiesNum = enemiesNum;
	}

	private void setRounds(int round) {
		this.round = round;
	}

}
