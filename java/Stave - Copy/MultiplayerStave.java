//Daksh Agrawal
/* Period 7
 * 10/14/2025
 * MultiplayerStave.java
 */
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
		
    }
    
    public void displayStave(char rollResult)
    {
		System.out.println(rollResult);
	}
	
	public static void main (String [] args) // main is complete 
	{ 
		Stave st = new Stave (); 
		st.runGame();
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
}
