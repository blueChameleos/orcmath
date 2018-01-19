package maple_gacha;

import java.awt.Image;
import java.util.ArrayList;

public class GBattleSystem implements Runnable {

	private int enemiesNum;
	private Image backgroundImage;
	private Character[] mainParty;
	private Object[][] enemiesList; //round -> enemies 
	private int round;
	private ArrayList<Character> order = new ArrayList<Character>();
	private ArrayList<ArrayList<String>> changes = new ArrayList<ArrayList<String>>();
	private Thread gameSystem;
	private Items[] itemsList = {new Items("Heal", 20, "Small Heal Potion"), new Items("Heal", 50, "Medium Healing Potion"), new Items("Heal", 100, "Huge Healing Potion"), new Items("Heal", 300, "Cheat Heal"), new Items("Aoe", 30, "Molotov"),new Items("Aoe", 50, "Grenade"), new Items("Aoe", 100, "Pms Ray"), new Items("Single", 40, "Syringe"), new Items("Single", 80, "Javelin"), new Items("Single", 15, "Shuriken")};
	

	//creation of System
	public GBattleSystem(int difficulty, Image backgrnd, Character[] mainParty)
	{
		changeDifficulty(difficulty); 
		this.backgroundImage = backgrnd;
		this.mainParty = mainParty;

		gameSystem = new Thread(this);
		gameSystem.start();
	}

	public void run() {
		playGame();
		updateGame();
	}

	private void playGame() {
		for( int i=0; i<order.size();i++)
		{
			Character currentPlayer = order.get(i);
			if(currentPlayer.getClass() == Enemies)
			{
				order.get(i).attack(randomTarget(), (int) (Math.random()*3));
			}
			else
			{
				getUserInput();
			}
		}
	}

	private Character randomTarget() {
		return mainParty[(int) Math.random()*mainParty.length];
	}

0	private void changeDifficulty(int difficulty) {
		setRounds((int) Math.pow(difficulty, 1.5));
		setEnemiesNum((int) Math.pow(difficulty, 1.3));
		enemiesList = new Enemies[round][enemiesNum];

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
