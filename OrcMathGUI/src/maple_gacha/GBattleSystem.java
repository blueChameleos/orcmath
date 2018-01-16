package maple_gacha;

import java.awt.Image;
import java.util.ArrayList;

public class GBattleSystem {

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
		
		this.playGame();
		
	}

	private void changeDifficulty(int difficulty) {
		setRounds();
		setEnemiesNum();
		
		populateEnemies();
		changeStats();
	}

	
	private void populateEnemies() {
		for( int rounds =0; rounds< enemiesList.length; i++)
		{
			for(int idx = 0; idx<enemiesList[rounds][idx].length; idx++)
			{
				enemeisList[rounds][idx] = new enemies();
			}
		}
	}

	private void playGame() {
		makeOrder();
		
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
		
		sortOrder();
	}

	private void sortOrder() {
		// TODO Auto-generated method stub
		
	}
}
