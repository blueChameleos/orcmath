package maple_gacha;

import java.awt.Image;
import java.util.ArrayList;

public class JasonZWeiGBattleSystem implements Runnable {

	private int enemiesNum;
	private JohnsonHero[] mainParty;
	private Monster[][] enemiesList; //round -> enemies 
	private int round = 0;
	private ArrayList<JohnsonHero> order = new ArrayList<JohnsonHero>();
	private ArrayList<ArrayList<String>> changes = new ArrayList<ArrayList<String>>();
	private Items[] itemsList = {new IHealingItem(20, "Small Heal Potion"), new IHealingItem(50, "Medium Healing Potion"), new IHealingItem( 100, "Huge Healing Potion"), new IHealingItem(300, "Cheat Heal"), new IProjectileAoe(30, "Molotov"),new IProjectileAoe(50, "Grenade"), new IProjectileAoe(100, "Pms Ray"), new IProjectileSingle(40, "Syringe"), new IProjectileSingle(80, "Javelin"), new IProjectileSingle(15, "Shuriken")};
	private ArrayList<Items> inventory = new ArrayList<Items>();
	private JohnsonHero currentPlayer;
	private Monster currentEnemy;
	private boolean waiting = false;
	private boolean playing;

	//creation of System

	public JasonZWeiGBattleSystem(int difficulty, JohnsonHero[] mainParty)
	{
		changeDifficulty(difficulty); 
		this.mainParty = mainParty;
		currentPlayer = new JohnsonHero("resources/characterPics/Hero_BeginnerArcher.png", "B", 10, 10, 10, 10, 100,"HiHero");
		currentEnemy = enemiesList[0][0];
		addItems();
	}

	public void run() {
		try {
			MainGame.battle.game.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("The game has started");
		}
		makeOrder();
		playGame();
	}

	//wei
	public void playGame() {
		MainGame.battle.userui.updateLog("Monsters have appeared!");
		try {
			MainGame.battle.game.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			System.out.println("An unnatural interruption has occurred. This should not ever happen");
		}
		while(playing)
		{
			System.out.println(order.toString());
			System.out.println(playing);
			for(int i = 0; i < order.size(); i++)
			{
				currentPlayer = order.get(i);
				if(currentPlayer.getClass() == Monster.class)
				{
					disableButtons();
					JohnsonHero target = order.get((int)(Math.random()*order.size()));
					while(target.getClass() == Monster.class) {
						target = order.get((int)(Math.random()*order.size()));
					}
					System.out.println(target.getHP());
					target.setHP(target.getHP() - currentPlayer.getAttack());
					System.out.println(target.getHP());
					MainGame.battle.userui.updateLog(currentPlayer + " attacked " + target + "!");
				}
				else
				{
					enableButtons();
					MainGame.battle.userui.updateLog("It's " + currentPlayer + "'s turn!");
					MainGame.battle.SwitchAIUI(); //switch Ai interface to user interface
					currentPlayer.setGuard(false);
					currentEnemy = enemiesList[round][(int) (Math.random()*enemiesList[round].length)];
					try {
						System.out.println("Backend is waiting for response from front end");
						MainGame.battle.game.sleep(Long.MAX_VALUE);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println("Backend has resumed running");
					}
				}
				checkChanges();
				if(!playing) {
					break;
				}
				try {
					disableButtons();
					MainGame.game.battle.game.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("Unnatural interruption from unknown source");
				}
			}
		}
	}
	
	public void enableButtons() {
		MainGame.game.battle.userui.attackbutton.setEnabled(true);
		MainGame.game.battle.userui.defbutton.setEnabled(true);
		MainGame.game.battle.userui.skillbutton.setEnabled(true);
		MainGame.game.battle.userui.itembutton.setEnabled(true);
	}

	public void disableButtons() {
		MainGame.game.battle.userui.attackbutton.setEnabled(false);
		MainGame.game.battle.userui.defbutton.setEnabled(false);
		MainGame.game.battle.userui.skillbutton.setEnabled(false);
		MainGame.game.battle.userui.itembutton.setEnabled(false);
	}

	//jason
	//when someone dies (all monster dies or heros)
	public void checkChanges() {
		MainGame.game.battle.updateHp();
		int instancesOfMonster = 0;
		int instancesOfHeros = 0;
		for(int i = 0; i<order.size(); i++)
		{
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
			if(round == enemiesList.length-1 || instancesOfHeros == 0)
			{
				endGame();
			}
			else
			{
				newRound();
			}

		}
	}

	//wei
	public void endGame() {
//		showRewards();
		playing = false;
		MainGame.battle.fadeOut();
		for(int i = 0; i < mainParty.length; i++) {
			mainParty[i].setHP(mainParty[i].returnMaxHp());
		}
		try {
			MainGame.battle.game.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Battle has ended.");
		}
		MainGame.game.setScreen(MainGame.game.main);
	}

	//jason
	private void newRound() {
		round++;
		order = new ArrayList<JohnsonHero>();
		makeOrder();
		MainGame.battle.nextRound();
	}

	//wei
	//testing items
	public void addItems()
	{
		for(int i = 0; i<itemsList.length; i++)
		{
			inventory.add(itemsList[i]);
		}
	}
	//jason
	//difficulty
	private void changeDifficulty(int difficulty) {
		setEnemiesNum((int) Math.pow(difficulty, 1.3 ));
		enemiesList = new Monster[(int) Math.pow(difficulty, 1.5)][enemiesNum];

		populateEnemies();
		//		changeStats(Math.log((difficulty+1))+.5); //good function //good comment btw
	}

	
	public void changeStats(double d) {
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
	//jason
	//creating enemies
	private void populateEnemies() {
		for(int rounds = 0; rounds< enemiesList.length; rounds++)
		{
			for(int idx = 0; idx<enemiesList[rounds].length; idx++)
			{
				enemiesList[rounds][idx] = MainGame.mobs[(int)(Math.random()*MainGame.mobs.length)];
			}
		}
	}


	//jason
	//begin of quicksort for specific round
	private void makeOrder() {
		order = new ArrayList<JohnsonHero>();
		for(JohnsonHero c: mainParty)
		{
			if(c.getHP() > 0)
				order.add(c);
		}

		for(Monster e: enemiesList[round])
		{
			if(e.getHP() > 0)
				order.add(e);
		}

		sortOrder(order, 0, order.size());
	}

	//jason
	private void sortOrder(ArrayList<JohnsonHero> heroList, int startIdx, int endIdx) {
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
		JohnsonHero holder = order.get(currentIdx);
		order.set(currentIdx, order.get(i));
		order.set(i, holder);
	}

	// end of sort
	
	//wei
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

	public ArrayList<JohnsonHero> getCharacters(){
		return this.order;
	}

	public Monster getCurrentEnemy() {
		return currentEnemy;
	}

	public void setCurrentEnemy(Monster currentEnemy) {
		this.currentEnemy = currentEnemy;
	}

	public JohnsonHero getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(JohnsonHero currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public void setWaiting(boolean waiting) {
		this.waiting = waiting;
	}

	public void setInventory(ArrayList<Items> inventory) {
		this.inventory = inventory;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}
}
