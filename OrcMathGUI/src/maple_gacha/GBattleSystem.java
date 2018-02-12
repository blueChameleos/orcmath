package maple_gacha;

import java.awt.Image;
import java.util.ArrayList;

public class GBattleSystem implements Runnable {


	/*	things to do:

			user input on BattleScreen (Saturday + Sunday)

			begin testing after merge.
	 */
	private int enemiesNum;
	private Hero[] mainParty;
	private Monster[][] enemiesList; //round -> enemies 
	private int round = 0;
	private ArrayList<Hero> order = new ArrayList<Hero>();
	private Thread gameSystem;
	private ArrayList<ArrayList<String>> changes = new ArrayList<ArrayList<String>>();
	private Items[] itemsList = {new IHealingItem(20, "Small Heal Potion"), new IHealingItem(50, "Medium Healing Potion"), new IHealingItem( 100, "Huge Healing Potion"), new IHealingItem(300, "Cheat Heal"), new IProjectileAoe(30, "Molotov"),new IProjectileAoe(50, "Grenade"), new IProjectileAoe(100, "Pms Ray"), new IProjectileSingle(40, "Syringe"), new IProjectileSingle(80, "Javelin"), new IProjectileSingle(15, "Shuriken")};
	private ArrayList<Items> inventory = new ArrayList<Items>();
	private Hero currentPlayer;
	private Monster currentEnemy;
	private boolean waiting = false;
	private boolean playing;

	//creation of System

	public GBattleSystem(int difficulty, Hero[] mainParty)
	{
		changeDifficulty(difficulty); 
		this.mainParty = mainParty;
		currentPlayer = new Hero("resources/characterPics/Hero_BeginnerArcher.png", "B", 10, 10, 10, 10, 100);
		currentEnemy = enemiesList[0][0];
		gameSystem = new Thread(this);
		addItems();
		gameSystem.run();
	}

	public void run() {
		makeOrder();
		playGame();
	}

	private void playGame() {
		while(playing)
		{
			for(int i=0; i<order.size();i++)
			{
				currentPlayer = order.get(i);

				if(currentPlayer instanceof Monster)
				{
					MainGame.battle.SwitchUIAI(); //switch user interface to the ai turn
					Hero target = mainParty[(int) Math.random()*mainParty.length];
					int action = (int) (Math.random()*3);
					/*order.get(i).useTurn(target, action);
				BattleScreen.showAiTurn(order.get(i), target, action); //changes ai text-area to show events
					 */			}
				else
				{
					//sleep until user does something.
					MainGame.battle.SwitchAIUI(); //switch Ai interface to user interface
					currentPlayer.setGuard(false);


					try {
						MainGame.battle.backend.gameSystem.sleep(Long.MAX_VALUE);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	//when someone dies (all monster dies or heros)
	public void checkChanges() {
		int instancesOfMonster = 0;
		int instancesOfHeros = 0;
		for(int i = 0; i<order.size(); i++)
		{
			System.out.println(order.get(i));
			if(order.get(i).getHP() <= 0)
			{
				order.remove(i);
				i--;
			}
			else
			{
				if(order.get(i) instanceof Monster)
				{
					instancesOfMonster ++;
				}
				else
				{
					instancesOfHeros ++;
				}
			}

		}

		if(instancesOfMonster == 0 || instancesOfHeros == 0)
		{
			if(round == enemiesList.length-1)
			{
				endGame();
			}
			else
			{
				newRound();
			}

		}
	}

	private void endGame() {
		while(MainGame.battle.userui.printingText) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//		showRewards();
		MainGame.battle.userui.updateLog("asfjaskjfaskjfgjkgs");
	}

	private void newRound() {
		round ++;
		order = new ArrayList<Hero>();
		makeOrder();
	}

	//testing items
	public void addItems()
	{
		for(int i = 0; i<itemsList.length; i++)
		{
			inventory.add(itemsList[i]);
		}
	}

	//difficulty
	private void changeDifficulty(int difficulty) {
		setEnemiesNum((int) Math.pow(difficulty, 1.3 ));
		enemiesList = new Monster[(int) Math.pow(difficulty, 1.5)][enemiesNum];

		populateEnemies();
		//		changeStats(Math.log((difficulty+1))+.5); //good function //good comment btw
	}


	private void changeStats(double d) {
		for(Monster[] el: enemiesList)
		{
			for(Monster e: el)
			{
				/*e.setAttack((int)e.getAttack()*d);
				e.setHP((int)e.getHP()*d);
				e.setSpeed((int)e.getSpeed()*d);*/
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

		System.out.println(enemiesList.length);

		for(Monster e: enemiesList[round])
		{
			if(e.getHP() > 0)
				order.add(e);
		}

		sortOrder(order, 0, order.size());
	}

	private void sortOrder(ArrayList<Hero> heroList, int startIdx, int endIdx) {
		int currentIdx = endIdx;
		int pivotSpeed = heroList.get(startIdx).getSpeed();

		if(endIdx - startIdx >= 1)
		{
			for(int i = startIdx+1; i< endIdx; i++)
			{
				if(heroList.get(i).getSpeed() < pivotSpeed)
				{
					currentIdx --;
					swap(currentIdx, i);
				}
			}

			currentIdx --;
			swap(currentIdx, startIdx);
			if(currentIdx != startIdx)
			{
				sortOrder(heroList, startIdx, currentIdx);

			}
			if(currentIdx+1 < heroList.size())
			{
				sortOrder(heroList, currentIdx+1, endIdx);
			}


		}

	}

	private void swap(int currentIdx, int i) {
		Hero holder = order.get(currentIdx);
		order.set(currentIdx, order.get(i));
		order.set(i, holder);
	}

	// end of sort

	public void useItem(Items item) {
		if(item instanceof IProjectileAoe)
		{
			item.act(enemiesList[round], item.getValue());
		}
		else 
		{
			if(item instanceof IHealingItem)
			{
				item.act(currentPlayer, item.getValue());
			}
			else
			{
				item.act(currentEnemy, item.getValue());
			}

		}

		inventory.remove(inventory.indexOf(item));

		//next turn;
	}

	//setters and getters.
	private void setEnemiesNum(int enemiesNum) {
		this.enemiesNum = enemiesNum;
	}

	public int getRound() {
		return this.round;
	}

	public Monster[][] getEnemiesList() {
		return enemiesList;
	}

	public ArrayList<Items> getInventory() {
		return this.inventory;
	}

	public ArrayList<Hero> getCharacters(){
		return this.order;
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

	public void setWaiting(boolean waiting) {
		this.waiting = waiting;
	}

	public void setInventory(ArrayList<Items> inventory) {
		this.inventory = inventory;
	}

	public Thread getGameSystem() {
		return gameSystem;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}
}
