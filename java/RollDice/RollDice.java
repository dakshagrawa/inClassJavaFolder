//Daksh Agrawal
//9-25-2025 Per7
//RollDice.java

/* What program does:
 * 	Gives a random roll of a 6-sided die.
 * 
 * Working on:
 * 	using Math.random() to make a random # from 1 to 6.
 */

public class RollDice
{
	public static void main(String[] args)
	{
		byte rollDi = 0;
		rollDi = (byte)(Math.random()*6+1);
		System.out.println("\n\n\n");
		System.out.println("You rolled " + rollDi);
		System.out.println("\n\n\n");
	}
}
