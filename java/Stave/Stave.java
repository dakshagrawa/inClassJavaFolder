//Daksh Agrawal
/* Period 7
 * 10/14/2025
 * Stave.java
 * 
 * Testing Plan: 
 * 1. <enter key> -> should work
 * 2. "hi this is an enter key" -> should work
 * 3. "u2hryu3 34c8f 4uh rui hui4f h" -> should work
*/

import java.util.Scanner;

public class Stave 
{	
	/* Declare all field variables here (6 int variables).  Be sure they are private. */
	private char roll1;
	private char roll2;
	private char roll3;
	private char roll4;
	private int score;
	private int runningScore;

	public Stave () 
	{  
		// initialize all field variables
		roll1 = '?';
		roll2 = '?';
		roll3 = '?';
		roll4 = '?';
		score = 0;
		runningScore = 0;
	} 
	
	public static void main (String [] args) // main is complete 
	{ 
		Stave st = new Stave (); 
		st.runGame();
	}
	
	public void runGame()
	{
		System.out.println("\n\n");
		System.out.printf("%30s","Welcome to Stave!");
		for (int i = 0; i < 3; i++)	// this is a loop that runs 3 times, so it calls
		{							// all three methods in order 3 times.
			playGame();
			scoreGame();
			updateScore();
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
		runningScore++;
		System.out.println("Your score for this roll is: "+score);
		System.out.println("Your total score is: "+runningScore);
	} 

} // end class Stave
//Be sure other two classes are written as well (both are very short).
// Neither class uses “static” in their methods – leave it out.  :)
