//Daksh Agrawal
/* Period 7
 * 10/14/2025
 * ModifiedStave.java
 * 
 * Testing Plan: 
 * 1. <enter key> -> should work
 * 2. "hi this is an enter key" -> should work
 * 3. "u2hryu3 34c8f 4uh rui hui4f h" -> should work
*/

import java.util.Scanner;

public class ModifiedStave 
{	
	/* Declare all field variables here (6 int variables).  Be sure they are private. */
	private char roll1;
	private char roll2;
	private char roll3;
	private char roll4;
	private int score;
	private int runningScore;

	private boolean isMultiplayer;

	public int numOfRolls;
	public String player;

	public ModifiedStave () 
	{  
		// initialize all field variables
		roll1 = '?';
		roll2 = '?';
		roll3 = '?';
		roll4 = '?';
		score = 0;
		runningScore = 0;
		isMultiplayer = false;
		numOfRolls = 3;
	} 
	
	public static void main (String [] args) // main is complete 
	{
		/*GameStart start = new GameStart(); //start game prompt
		start.Start();*/

		ModifiedStave st = new ModifiedStave (); 
		st.runGame();
	}
	
	public void runGame()
	{
		System.out.println("\n\n\n");

		System.out.printf("%20s%s","","Welcome to Stave!");

		ifMultiplayer(); //checks if the user wants to play multiplayer

		if (isMultiplayer)
		{
			System.out.print("\n\n");
			MultiplayerStave mpst = new MultiplayerStave();
			mpst.mpRunGame();
		}
		else
		{
			rollsOfStave numRolls = new rollsOfStave(); //asking user how many roles user wants
			numOfRolls = numRolls.numberOfRolls();

			player = playerName();

			System.out.println("\n\n\n");
			for (int i = 1; i <= numOfRolls; i++)	// this is a loop that runs 3 times, so it calls
			{							// all three methods in order 3 times.
				playGame();
				scoreGame();
				updateScore();
			}
			System.out.println("\n\n\n");
		}
		System.out.println("\n\n\n");
	}
	
	public void playGame () 
	{
		Scanner input = new Scanner(System.in);
		Roll rollem = new Roll();
		ShowStave show = new ShowStave();
		
		System.out.print("\nPlease click Enter to play STAVE! ...");
		input.nextLine();

		roll1 = rollem.rollStave(); 
		show.displayStave(roll1); 
		
		roll2 = rollem.rollStave(); 
		show.displayStave(roll2); 
		
		roll3 = rollem.rollStave(); 
		show.displayStave(roll3); 
		
		roll4 = rollem.rollStave(); 
		show.displayStave(roll4); 
		
	} 
	
/* This method is complete.  scoreGame() builds a String of all 4 rolls 
 * as characters, then looks at all 4 characters, counting how many '$' 
 * there are.  If four or no '$' score increases by 2.  If two '$' score
 *  increases by 1.*/
	public void scoreGame() 
	{ 
		String rolls = new String("");
		rolls = "" + (char)roll1 + (char)roll2 + (char)roll3 + (char)roll4; 
		int count = 0;
		score = 0;		
		for (int i = 0; i < 4; i++) 
		{  
			if (rolls.charAt(i) == '$')
				count++;
		} 
		
		if (count == 4 || count == 0) 
			score+=2; 
		else if (count == 2) 
			score++; 
	}
	
	public void updateScore () 
	{
		runningScore+=score;
		System.out.println("\n"+player+", your score for this roll is: "+score);
		System.out.println(player+", your total score is: "+runningScore);
	} 
	public void ifMultiplayer()
	{
		Scanner in = new Scanner(System.in);
		String yesorno = new String("~_~");
		
		System.out.print("\n\nDo you want to play Multiplayer (2 player)? [Answer with 'Y' or 'N' for yes or no] --> ");
		yesorno = in.next();
		if (yesorno.strip().toLowerCase().equals("y"))
		{
			isMultiplayer = true;
		}
		else
		{
			isMultiplayer = false;
		}
	}

	public String playerName()
	{
		String playerNameIn;
		Scanner in = new Scanner(System.in);
		System.out.print("\n\nWhat is your username? ");
		playerNameIn = in.nextLine();
		return playerNameIn;
	}

} // end class Stave
//Be sure other two classes are written as well (both are very short).
// Neither class uses “static” in their methods – leave it out.  :)
