// Daksh Agrawal
/* Period: 7
 * 11-04-2025 
 * 
 * AreWeThereYet.java
 * 
 * 	
 */

public class AreWeThereYet
{
	public static void main(String[] args)
	{
		AreWeThereYet awty = new AreWeThereYet();
		awty.journey();
	}
	
	public void journey()
	{
		System.out.println("\n");
		int i = 50;
		while (i>0)
		{
			printLines(i);
			i-=5;
		}
		System.out.print("\nYes, we finally made it there!");
		System.out.println("\n\n");
	}
	public void printLines(int d)
	{
		if (d%2==0)
		{
			System.out.println();
		}
		System.out.print("Are we there yet?\t");
		System.out.print("No, "+d+" miles to go.\t");
	}
}
