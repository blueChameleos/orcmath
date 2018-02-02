package maple_gacha;

import java.awt.Image;
import java.util.ArrayList;

public class GBattleSystem implements Runnable {

	
/*	things to do:
		BattleSystem:
			implement turns(user Turn) - change ui on AI turn (do today)

			: ui change(figure out on friday)
				update screen each turn 

			user input on BattleScreen (Saturday + Sunday)


			create wait system for front end + back end (stoping until the other finsihes job ie. user input and updating)

			begin testign after merge.
*/
	private int enemiesNum;
	private Image backgroundImage;
	private Character[] mainParty;
	private Monster[][] enemiesList; //round -> enemies 
	private int round;
	private ArrayList<Character> order = new ArrayList<Character>();
	private ArrayList<ArrayList<String>> changes = new ArrayList<ArrayList<String>>();
	private Thread gameSystem;
	private Items[] itemsList = {new IHealingItem(20, "Small Heal Potion"), new IHealingItem(50, "Medium Healing Potion"), new IHealingItem( 100, "Huge Healing Potion"), new IHealingItem(300, "Cheat Heal"), new IProjectileAoe(30, "Molotov"),new IProjectileAoe(50, "Grenade"), new IProjectileAoe(100, "Pms Ray"), new IProjectileSingle(40, "Syringe"), new IProjectileSingle(80, "Javelin"), new IProjectileSingle(15, "Shuriken")};
	private ArrayList<ArrayList<Items>> inventory = new ArrayList<ArrayList<Items>>();
	private Character currentPlayer;
	private Character currentEnemy;

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
	}

	private void playGame() {
		for(int i=0; i<order.size();i++)
		{
			currentPlayer = order.get(i);
			if(currentPlayer instanceof Monster)
			{
				BattleScreen.SwitchUIAI(); //switch user interface to the ai turn
				Character target = mainParty[(int) Math.random()*mainParty.length];
				int action = (int) (Math.random()*3);
				order.get(i).attack(target, action); 
				BattleScreen.showAiTurn(order.get(i), target, action); //changes ai text-area to show events
			}
			else
			{
				//sleep until user does something.
				BattleScreen.SwitchAIUI(); //switch Ai interface to user interface
				BattleScreen.backend.gameSystem.sleep(Long.MAX_VALUE); //sleep for long time
			}
			
			
			updateGame(); //don't know the use for.
		}
	}
	
	//difficulty
	private void changeDifficulty(int difficulty) {
		setRounds((int) Math.pow(difficulty, 1.5)); 
		setEnemiesNum((int) Math.pow(difficulty, 1.3 ));
		enemiesList = new Monster[round][enemiesNum];

		populateEnemies();
		changeStats( Math.log((difficulty+1))+.5); //good function

	}


	private void changeStats(double d) {
		for(Monster e: enemiesList)
		{
			e.setAttack((int)e.getAttack*d);
			e.setHealth((int)e.getHealth*d);
			e.setSpeed((int)e.getSpeed*d);
		}
	}

	//end of difficulty
	
	//creating enemies
	private void populateEnemies() {
		for(int rounds = 0; rounds< enemiesList.length; i++)
		{
			for(int idx = 0; idx<enemiesList[rounds][idx].length; idx++)
			{
				enemeisList[rounds][idx] = new Monster(); 
			}
		}
	}

	
	//begin of quicksort for specific round
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
	
	// end of sort

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

	//setters and getters.
	private void setEnemiesNum(int enemiesNum) {
		this.enemiesNum = enemiesNum;
	}

	private void setRounds(int round) {
		this.round = round;
	}
	
	public Monster[][] getEnemiesList() {
		return enemiesList;
	}

	public ArrayList<ArrayList<Items>> getInventory() {
		return this.inventory;
	}

	public void setInventory(ArrayList<ArrayList<Items>> inventory) {
		this.inventory = inventory;
	}
	
	public ArrayList<Character> getCharacters(){
		return this.order;
	}
	
	public int getRound() {
		return this.round;
	}
	
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

}
