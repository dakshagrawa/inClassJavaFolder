//Daksh Agrawal
//9-25-2025 Per7
//RollDice3.java

/* What program does:
 * 	Gives a random roll of a 6-sided die.
 * 
 * Working on:
 * 
 * 	This will break down the work further. main calls roll, then passes the number
 * 		as a parameter to print , which will then print the number out.
 * 
 * 	From now on, we will NOT print in main!
 */

public class RollDice3
{
	/* main calls a method roll(), saves he return value and then prints it*/
	public static void main(String[] args)
	{
		byte di = 0;
		di = roll(); //calls roll (no parameter)
		print(di); //calls print (sends parameters di)
	}
	
	/*roll has no parameter. It returns a random # 1 to 6 */
	public static byte roll()
	{
		byte rollDi = 0;
		rollDi = (byte)(Math.random()*6+1);
		return rollDi;
	}
	
	/*takes in a parameter, then prints it.*/
	public static void print(byte diResult)
	{
		System.out.println("\n\n\n");	
		System.out.println("You rolled " + diResult);
		System.out.println("\n\n\n");
	}
}
