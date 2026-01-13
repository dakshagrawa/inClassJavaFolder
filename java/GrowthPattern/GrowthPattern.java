// Daksh Agrawal
/* Period 7
* 01/12/2026
* 
* GrowthPattern.java
* 
* >Objective:
*   Analyze a sequence of height values and visually represent growth,
*   decline, or no change using symbols.
* 
* >Description:
*   This program stores a series of integer height measurements and prints
*   a symbolic representation of how each value compares to the previous one.
*   It also calculates and prints the average rate of change across the data.
*
* >Learning:
*   - Working with arrays
*   - Using loops and conditionals
*   - Creating helper methods
*   - Formatting console output with printf
*
* >Pseudocode:
*   Class Header
*   Make a private FV that holds the array of integers (height)
* 
*   constructor:
*       set values for array FV (height)
* 
*   main:
*       call constructor
*       call growIt()
* 
*   growIt:
*       3 BLs
*       loop that runs the number of times the length of the array
*           call decideSymbols() and store the character in a char, takes in index number.
*           call printSymbols() and send in the char along with the index number of the loop.
*       call printRate()
*       3 BLs
*   
*   decideSymbols: (takes in the index number)
*       if it is the first index of the array, skip it. 
*           calls returns the symbol 'o' 
*       else
*           check if the previous index is greater than, equal to or less than the next index value
*           if it is less, return '-', if more, return '+', if equal, return 'o'
* 
*   printSymbol: (takes in the values of the index as int and the the symbol as char)
*       prints the symbols using printf and formats the characters respectively.
* 
*   printRate:
*       calculate the rate of change by taking the first and last index values of the array and 
*           dividing that by the total number of values in the array. 
*       
*
* >Testing:
*   - Verified output alignment
*   - Checked symbol correctness for positive, negative, and equal values
*   - Confirmed rate calculation accuracy
*/

public class GrowthPattern
{
	// Array storing height values at each time step
	private int[] height;
	
	public GrowthPattern()
	{
		// Initialize the height array with predefined values
		height = new int[]{-1, -3, 1, 2, 3, 4, 3, 4, 4, 6, 8, 6, 6, 7, 10};
	}
	
	public static void main(String[] args)
	{
		// Create a GrowthPattern object and run the visualization
		GrowthPattern gp = new GrowthPattern();
		gp.growIt();
	}
	
	public void growIt()
	{
		// Print blank lines for spacing
		System.out.println("\n\n");
		
		// Loop through each index of the height array
		for(int i = 0; i < height.length; i++)
		{
			// Determine which symbol to print based on growth pattern
			char printSymbol = decideSymbols(i);
			
			// Print the appropriate number of symbols for this index
			printSymbols(printSymbol,i);
		}
		
		// Print the average rate of growth across the dataset
		printRate();
		
		// Ending blank lines for spacing
		System.out.println("\n\n");
	}
	
	public char decideSymbols(int index)
	{
		// First index has no previous value to compare to
		if (index==0)
			return 'o';
		else 
		{
			// No change from previous value
			if(height[index-1]==height[index])
				return 'o';
			// Increase from previous value
			else if(height[index-1]<height[index])
				return '+';
			// Decrease from previous value
			else if(height[index-1]>height[index])
				return '-';
			// Fallback (should never occur)
			else
				return '?';
		}
	}
	
	public void printSymbols(char symbol, int index)
	{
		// Build a string containing repeated symbols based on height value
		String characters = new String();
		
		// If height is negative, print symbols to the left of the bar
		if (height[index]<0)
			for(int i = height[index]; i < 0; i++)
				characters+=symbol;
		else
			// If height is positive, print symbols to the right of the bar
			for(int i = 0; i < height[index]; i++)
				characters+=symbol;
			
		// Print index label
		System.out.printf("%nt%-5d ",index);
		
		// Print symbols formatted around a vertical bar
		if (height[index]<0)
			System.out.printf("%5s|%s",characters,"");
		else
			System.out.printf("%5s|%s","",characters);
		
	}
	
	public void printRate()
	{
		// Calculate average rate of change using first and last values
		double rateOfGrowth = (0.0+height[0]-height[height.length-1])/(height.length-1);
		
		// Convert negative rate to positive magnitude
		if (rateOfGrowth<0)
			rateOfGrowth = rateOfGrowth*-1;
		
		// Print formatted growth rate
		System.out.printf("\n\nThe average growth rate is %.2f millimeters per unit of time.", rateOfGrowth);
	}
}
