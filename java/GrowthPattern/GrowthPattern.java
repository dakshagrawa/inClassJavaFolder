// Daksh Agrawal
/* Period 7
* 01/12/2026
* 
* GrowthPattern.java
* 
* >Objective:
* 
* >Description:
*
* >Learning:
*
* >Pseudocode:
* 	Class Header
* 	Make a private FV that holds the array of integers (height)
* 
* 	constructor:
* 		set values for array FV (height)
* 
* 	main:
* 		call constructor
* 		call growIt()
* 
* 	growIt:
* 		3 BLs
* 		loop that runs the number of times the length of the array
* 			call decideSymbols() and store the haracter in a char
* 			call printSymbols() and send in the char.
* 		call printRate()
* 		3 BLs
* 	
* 	decideSymbols:
* 		if it is the first index
*
* >Testing:
*
*   
*/

public class GrowthPattern
{
	private int[] height;
	
	public GrowthPattern()
	{
		height = new int[15]{-1, -3, 1, 2, 3, 4, 3, 4, 4, 6, 8, 6, 6, 7, 10};
	}
	
	public static void main(String[] args)
	{
		GrowthPattern gp = new GrowthPattern();
		gp.growIt();
	}
	
	public void growIt()
	{
		System.out.println("\n\n");
		
		for(int i = 0; i < height.length; i++)
		{
			char isNegative = decideSymbol();
			printSymbols(isNegative);
		}
		printRate();
		
		System.out.println("\n\n");
	}
	
	public void decideSymbols()
	{
		
	}
	
	public void printSymbols(int index)
	{
		System.out.prinf("","t"+index);
		
	}
	
	public void printRate()
	{
		double rateOfGrowth = (height[0]-height[height.length-1])/height.length;
	}
}
