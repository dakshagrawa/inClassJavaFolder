// Daksh Agrawal
/* Period: 7
 * 11-04-2025 
 * 
 * AreWeThereYet.java
 * 
 * 	
 */

public class AreWeThereYet2
{
	public static void main(String[] args)
	{
		AreWeThereYet2 awty = new AreWeThereYet2();
		awty.journey();
	}
	
	public void journey()
	{
		System.out.println("\n");
		for (int i = 50; i>0; i-=5)
		{
			printLines(i);
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
