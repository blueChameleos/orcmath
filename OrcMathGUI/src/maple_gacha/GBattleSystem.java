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
	private Items[] itemsList = {new IHealingItem(20, "Small Heal Potion"), new IHealingItem(50, "Medium Healing Potion"), new IHealingItem( 100, "Huge Healing Potion"), new IHealingItem(300, "Cheat Heal"), new IProjectileAoe(30, "Molotov"),new IProjectileAoe(50, "Grenade"), new IProjectileAoe(100, "Pms Ray"), new IProjectileSingle(40, "Syringe"), new IProjectileSingle(80, "Javelin"), new IProjectileSingle(15, "Shuriken")};
	private ArrayList<ArrayList<Items>> inventory = new ArrayList<ArrayList<Items>>();
	private Character currentPlayer;
	private Character currentEnemy;

	//creation of System
	public Character getCurrentEnemy() {
		return currentEnemy;
	}

	public void setCurrentEnemy(Character currentEnemy) {
		this.currentEnemy = currentEnemy;
	}

	public Character getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Character currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

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
			currentPlayer = order.get(i);
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

	public void useItem(Items items) {
		if(items instanceof IProjectileAoe)
		{
			items.act(enemiesList[round], items.getValue());
		}
		else 
		{
			items.act(currentEnemy, items.getValue());
		}
		
		inventory.get(inventory.indexOf(items)).remove(0);
		
		//next turn;
	}

	public Object[][] getEnemiesList() {
		return enemiesList;
	}

	public ArrayList<ArrayList<Items>> getInventory() {
		return this.inventory;
	}

	public void setInventory(ArrayList<ArrayList<Items>> inventory) {
		this.inventory = inventory;
	}

}
