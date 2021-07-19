package snakeAndLadder;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class snakeLadder {

	public static void main(String[] args) {
		SnakeNLadder s = new SnakeNLadder();
		s.startGame();

	}

}

class SnakeNLadder
{
	
	final static int WINPOINT = 100;
	
	
	static Map<Integer,Integer> snake = new HashMap<Integer,Integer>();
	static Map<Integer,Integer> ladder = new HashMap<Integer,Integer>();
	
	{
		snake.put(99,52);
		snake.put(87,55);
		snake.put(62,42);
		snake.put(28,4);
		snake.put(95,72);
		
		ladder.put(9,25);
		ladder.put(13,40);
		ladder.put(60,85);
		ladder.put(45,94);
		ladder.put(16,67);
	}
	
	
	
	public int rollDice()
	{
		int n = 0;
		Random r = new Random();
		n=r.nextInt(7);
		return (n==0?1:n);
	}
	
	public void startGame()
	{
		int player1 =0, player2=0;
		int currentPlayer=-1;
		Scanner s = new Scanner(System.in);
		String str;
		int diceValue =0;
		do
		{
			System.out.println(currentPlayer==-1?"\n\nFIRST PLAYER'S MOVE":"\n\nSECOND PLAYER'S MOVE");
			System.out.println("PRESS r TO ROLL THE DICE");
			str = s.next();
			diceValue = rollDice();
			
			
			if(currentPlayer == -1)
			{
				player1 = calculatePlayerValue(player1,diceValue);
				System.out.println("First Player :: " + player1);
				System.out.println("Second Player :: " + player2);
				System.out.println("------------------");
				if(isWin(player1))
				{
					System.out.println("!!!FIRST PLAYER WINS!!!");
					return;
				}
			}
			else
			{
				player2 = calculatePlayerValue(player2,diceValue);
				System.out.println("First Player :: " + player1);
				System.out.println("Second Player :: " + player2);
				System.out.println("------------------");
				if(isWin(player2))
				{
					System.out.println("!!!SECOND PLAYER WINS!!!");
					return;
				}
			}
			
			currentPlayer= -currentPlayer;
			
			
			
		}while("r".equals(str));
	}
	
	
	public int calculatePlayerValue(int player, int diceValue)
	{
		player = player + diceValue;
		
		if(player > WINPOINT)
		{
			player = player - diceValue;
			return player;
		}
		
		if(null!=snake.get(player))
		{
			System.out.println("SWALLOWED BY SNAKE");
			player= snake.get(player);
		}
		
		if(null!=ladder.get(player))
		{
			System.out.println("CLIMB UP THE LADDER");
			player= ladder.get(player);
		}
		return player;
	}
	
	public boolean isWin(int player)
	{
		return WINPOINT == player;
	}
	
}
