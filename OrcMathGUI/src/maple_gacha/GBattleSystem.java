package maple_gacha;

import java.awt.Image;
import java.util.ArrayList;

public class GBattleSystem implements Runnable {

	
/*	things to do:

			user input on BattleScreen (Saturday + Sunday)

			begin testing after merge.
*/
	private int enemiesNum;
	private Image backgroundImage;
	private Hero[] mainParty;
	private Monster[][] enemiesList; //round -> enemies 
	private int round;
	private ArrayList<Hero> order = new ArrayList<Hero>();
	private ArrayList<ArrayList<String>> changes = new ArrayList<ArrayList<String>>();
	private Items[] itemsList = {new IHealingItem(20, "Small Heal Potion"), new IHealingItem(50, "Medium Healing Potion"), new IHealingItem( 100, "Huge Healing Potion"), new IHealingItem(300, "Cheat Heal"), new IProjectileAoe(30, "Molotov"),new IProjectileAoe(50, "Grenade"), new IProjectileAoe(100, "Pms Ray"), new IProjectileSingle(40, "Syringe"), new IProjectileSingle(80, "Javelin"), new IProjectileSingle(15, "Shuriken")};
	private ArrayList<ArrayList<Items>> inventory = new ArrayList<ArrayList<Items>>();
	private Hero currentPlayer;
	private Monster currentEnemy;

	//creation of System

	public GBattleSystem(int difficulty, Hero[] mainParty)
	{
		changeDifficulty(difficulty); 
		this.mainParty = mainParty;
		currentPlayer = new Hero("resources/characterPics/Hero_BeginnerArcher.png", "B", 10, 10, 10, 10, 100);
		currentEnemy = enemiesList[0][0];
	}

	public void run() {
		makeOrder();
		playGame();
	}

	private void playGame() {	
		for(int i=0; i<order.size();i++)
		{
			currentPlayer = order.get(i);
			if(currentPlayer instanceof Monster)
			{
				MainGame.battle.SwitchUIAI(); //switch user interface to the ai turn
				Hero target = mainParty[(int) Math.random()*mainParty.length];
				int action = (int) (Math.random()*3);
				order.get(i).attack(target, action);
				BattleScreen.showAiTurn(order.get(i), target, action); //changes ai text-area to show events
			}
			else
			{
				//sleep until user does something.
				MainGame.battle.SwitchAIUI(); //switch Ai interface to user interface
				currentPlayer.setGuard(false);
			}	
			
			updateGame(); //don't know the use for.
		}
	}
	
	private void updateGame() {
		// TODO Auto-generated method stub
	}

	//difficulty
	private void changeDifficulty(int difficulty) {
		setRounds((int) Math.pow(difficulty, 1.5)); 
		setEnemiesNum((int) Math.pow(difficulty, 1.3 ));
		enemiesList = new Monster[round][enemiesNum];

		populateEnemies();
//		changeStats(Math.log((difficulty+1))+.5); //good function //good comment btw
	}


	private void changeStats(double d) {
		for(Monster[] el: enemiesList)
		{
			for(Monster e: el)
			{
//				e.setAttack((int)e.getAttack()*d);
//				e.setHP((int)e.getHP()*d);
//				e.setSpeed((int)e.getSpeed()*d);
			}
			
		}
	}

	//end of difficulty	
	//creating enemies
	private void populateEnemies() {
		for(int rounds = 0; rounds< enemiesList.length; rounds++)
		{
			for(int idx = 0; idx<enemiesList[rounds].length; idx++)
			{
				enemiesList[rounds][idx] = MainGame.game.mobs[(int) Math.random()*MainGame.game.mobs.length];
				
			}
		}
	}

	
	//begin of quicksort for specific round
	private void makeOrder() {

		order = new ArrayList<Hero>();
		for(Hero c: mainParty)
		{
			if(c.getHP() > 0)
			order.add(c);
		}

		for(Monster e: enemiesList[round])
		{
			if(e.getHP() > 0)
			order.add(e);
		}

		sortOrder(order);
	}

	private void sortOrder(ArrayList<Hero> heroList) {
		int currentIdx = order.size();
		int pivotSpeed = order.get(0).getSpeed();

		if(heroList.size() > 1)
		{
			for(int i = 1; i< order.size(); i++)
			{
				if(heroList.get(i).getSpeed() < pivotSpeed)
				{
					currentIdx --;
					swap(currentIdx, i);
				}
			}

			currentIdx --;
			swap(currentIdx, 0);
			sortOrder((ArrayList<Hero>) order.subList(0, currentIdx));
			sortOrder((ArrayList<Hero>) order.subList(currentIdx+1, order.size()));

		}

	}

	private void swap(int currentIdx, int i) {
		Hero holder = order.get(currentIdx);
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
			if(items instanceof IHealingItem)
			{
				items.act(currentPlayer, items.getValue());
			}
			else
			{
				items.act(currentEnemy, items.getValue());
			}
			
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
	
	public ArrayList<Hero> getCharacters(){
		return this.order;
	}
	
	public int getRound() {
		return this.round;
	}
	
	public Monster getCurrentEnemy() {
		return currentEnemy;
	}

	public void setCurrentEnemy(Monster currentEnemy) {
		this.currentEnemy = currentEnemy;
	}

	public Hero getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Hero currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

}
