//Daksh Agrawal
/* Period 7
 * 10/14/2025
 * rollsOfStave.java
*/
import java.util.Scanner;

public class rollsOfStave 
{
	public rollsOfStave()
	{
		//blank
	}

    public int numberOfRolls()
	{
		Scanner in = new Scanner(System.in);

		int howManyRolls;

		System.out.print("\nHow many rolls do you want to do (type in 3 for 3 rolls)? ");
		howManyRolls = in.nextInt();
		return howManyRolls;
	}
}
