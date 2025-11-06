// Daksh Agrawal
/* Period: 7
 * 11-04-2025 
 * 
 * AreWeThereYet.java
 * 
 * 	
 */

public class AreWeThereYet3
{
	public static void main(String[] args)
	{
		AreWeThereYet3 awty = new AreWeThereYet3();
		awty.journey();
	}
	
	public void journey()
	{
		System.out.println("\n");
		int i = 50;
		do
		{
			printLines(i);
			i-=5;
		}while (i>0);
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
