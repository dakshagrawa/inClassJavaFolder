//Daksh Agrawal
/* Period 7
 * 10/14/2025
 * MultiplayerStave.java
 */

import java.util.Scanner;

public class MultiplayerStave
{
	private char roll1_p1;
	private char roll2_p1;
	private char roll3_p1;
	private char roll4_p1;
	private int score_p1;
	private int runningScore_p1;
	
	private char roll1_p2;
	private char roll2_p2;
	private char roll3_p2;
	private char roll4_p2;
	private int score_p2;
	private int runningScore_p2;

	private int numOfRolls;

	private String player1;
	private String player2;

	private String rig;
	
	public MultiplayerStave()
	{
		roll1_p1 = '?';
		roll2_p1 = '?';
		roll3_p1 = '?';
		roll4_p1 = '?';
		score_p1 = 0;
		runningScore_p1 = 0;
		
		roll1_p2 = '?';
		roll2_p2 = '?';
		roll3_p2 = '?';
		roll4_p2 = '?';
		score_p2 = 0;
		runningScore_p2 = 0;

		numOfRolls = 3;

		rigger();

		NamePlayers username = new NamePlayers(); //asking user for their username
		player1 = username.player1Name();
    }
	
	public static void main (String [] args) // main is complete 
	{
		System.out.println("\n\n\n");

		/*GameStart start = new GameStart(); //start game prompt
		start.Start();*/
		
		MultiplayerStave mpst = new MultiplayerStave (); 

		mpst.mpRunGame();
		System.out.println("\n\n\n");
	}

	public void mpRunGame()
	{
		NamePlayers username = new NamePlayers(); //asking user for their username
		player2 = username.player2Name();

		RollsOfStave numRolls = new RollsOfStave(); //asking user how many roles user wants
		numOfRolls = numRolls.numberOfRolls();

		for (int i = 1; i <= numOfRolls; i++)	// this is a loop that runs numRolls times times, so it calls
		{							        // all three methods in order more number of times.
			playGame_p1();
			scoreGame_p1();
			updateScore_p1();
			playGame_p2();
			scoreGame_p2();
			updateScore_p2();
		}

		staveWinner();
	}
	
	public void playGame_p1 () 
	{
		Scanner input = new Scanner(System.in);
		Roll rollem = new Roll();
		ShowStave mpShow1 = new ShowStave();
		
		System.out.printf("%n%-80s", player1+" click Enter to play STAVE! ...");
		input.nextLine();

		roll1_p1 = rollem.rollStave(); 
		mpShow1.displayStave(roll1_p1); 
		
		roll2_p1 = rollem.rollStave(); 
		mpShow1.displayStave(roll2_p1); 
		
		roll3_p1 = rollem.rollStave(); 
		mpShow1.displayStave(roll3_p1); 
		
		roll4_p1 = rollem.rollStave(); 
		mpShow1.displayStave(roll4_p1); 
		
	} 
	public void playGame_p2 () 
	{
		Scanner input = new Scanner(System.in);
		Roll rollem = new Roll();
		ShowStave mpShow2 = new ShowStave();
		
		System.out.printf("%n%80s",("... "+player2+", click Enter to play STAVE! ..."));
		input.nextLine();

		roll1_p2 = rollem.rollStave(); 
		mpShow2.displayStaveR(roll1_p2); 
		
		roll2_p2 = rollem.rollStave(); 
		mpShow2.displayStaveR(roll2_p2); 
		
		roll3_p2 = rollem.rollStave(); 
		mpShow2.displayStaveR(roll3_p2); 
		
		roll4_p2 = rollem.rollStave(); 
		mpShow2.displayStaveR(roll4_p2); 
		
	} 
	
/* This method is complete.  scoreGame() builds a String of all 4 rolls 
 * as characters, then looks at all 4 characters, counting how many '$' 
 * there are.  If four or no '$' score increases by 2.  If two '$' score
 *  increases by 1.*/
	public void scoreGame_p1() 
	{ 
		String rolls = new String("");
		rolls = "" + (char)roll1_p1 + (char)roll2_p1 + (char)roll3_p1 + (char)roll4_p1; 
		int count = 0;
		score_p1 = 0;		
		for (int i = 0; i < 4; i++) 
		{  
			if (rolls.charAt(i) == '$')
				count++;
		} 
		
		if (count == 4 || count == 0) 
			score_p1+=2; 
		else if (count == 2) 
			score_p1++; 
	}

	public void scoreGame_p2() 
	{ 
		String rolls = new String("");
		rolls = "" + (char)roll1_p2 + (char)roll2_p2 + (char)roll3_p2 + (char)roll4_p2; 
		int count = 0;
		score_p2 = 0;		
		for (int i = 0; i < 4; i++) 
		{  
			if (rolls.charAt(i) == '$')
				count++;
		} 
		
		if (count == 4 || count == 0) 
			score_p2+=2; 
		else if (count == 2) 
			score_p2++; 
	}
	
	public void updateScore_p1 () 
	{
		runningScore_p1+=score_p1;
		System.out.println("\nYour score for this roll is: "+score_p1);
		System.out.println("Your total score is: "+runningScore_p1);
	} 

	public void updateScore_p2 () 
	{
		runningScore_p2+=score_p2;
		System.out.printf("%n%80s","Your score for this roll is: "+score_p2);
		System.out.printf("%n%80s","Your total score is: "+runningScore_p2);
	}

	public void staveWinner()
	{
		RigStave rigged = new RigStave();
		boolean isRigged = rigged.trueWinner(player1,player2,rig);

		String wStmnt = new String("~_~"); //statement that prints out who won
		if (isRigged)
		{
			wStmnt = rigged.returnName()+" won the match!";
		}
		else if (runningScore_p1 > runningScore_p2)
		{
			wStmnt = player1 + " won the match!";
		}
		else if (runningScore_p1 < runningScore_p2)
		{
			wStmnt = player2 + " won the match!";
		}
		else
		{
			wStmnt = "It's a TIE!!!";
		}

		System.out.printf("%n%n%25s%s","",wStmnt);
	}

	public void rigger()
	{
		GameStart start = new GameStart(); //start game prompt
		rig = start.Start();
	}
}
