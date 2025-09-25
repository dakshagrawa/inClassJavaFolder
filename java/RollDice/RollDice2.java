//Daksh Agrawal
//9-25-2025 Per7
//RollDice2.java

/* What program does:
 * 	Gives a random roll of a 6-sided die.
 * 
 * Working on: 
 * 	using Math.random() to make a random # from 1 to 6, but this version
 * 		calls the method roll() from main, and then that method returns a random
 * 		number from 1 to 6.
 */

public class RollDice2
{
	/* main calls a method roll(), saves he return value and then prints it*/
	public static void main(String[] args)
	{
		byte di = 0;
		di = roll(); //calls roll (no parameter)
		
		System.out.println("\n\n\n");	
		System.out.println("You rolled " + di);
		System.out.println("\n\n\n");
	}
	
	/*roll has no parameter. It returns a random # 1 to 6 */
	public static byte roll()
	{
		byte rollDi = 0;
		rollDi = (byte)(Math.random()*6+1);
		return rollDi;
	}
}
