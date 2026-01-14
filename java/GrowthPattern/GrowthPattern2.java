// Daksh Agrawal
/* Period 7
* 01/13/2026
* 
* GrowthPattern2.java
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
*   - Working with arrays and index-based comparisons
*   - Using loops and conditionals to drive console visualization
*   - Creating modular helper methods for symbol logic and formatting
*   - Formatting console output with printf for alignment
*
* >Testing:
*   - Verified output alignment for both positive and negative heights
*   - Checked symbol correctness ('+', '-', 'o') for growth patterns
*   - Confirmed average rate calculation accuracy
*
*/

import java.util.Scanner;

public class GrowthPattern2
{
	private int[] height;
	
	public GrowthPattern2()
	{
		// Initialize the height array with predefined values
		height = new int[]{-1, -3, 1, 2, 3, 4, 3, 4, 4, 6, 8, 6, 6, 7, 10};
	}
	
	public static void main(String[] args)
	{
		// Create a GrowthPattern2 object and run the visualization
		GrowthPattern2 gp2 = new GrowthPattern2();
		gp2.growIt();
	}
	
	public void growIt()
	{
		// Print blank lines for spacing
		System.out.println("\n\n");
        System.out.println("Welcome to GrowthPattern! This tool provides a visual analysis "
                         + "of tree height data over time.\n");
		
        // Ask for user values for heights
        getHeights();
        
        System.out.println("Generating tree growth diagram (Legend: + ~Growth, - ~Decline, o ~No Change)...");
        System.out.println("\nIndex  [Decline] | [Growth]");
        System.out.print("-----------------|--------------");
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

    public void getHeights()
    {
        // Calls scanner class
        Scanner in = new Scanner(System.in);
        
        // Asks user whether they want to enter their own values
        System.out.print("Do you want to enter your own values "
                      + "for height instead of the preset ones (Type 'N' for no)? ");
        
        // Checks if the user entered 'n' or not
        if(!in.next().trim().equalsIgnoreCase("N"))
        {
            System.out.print("How many values of height do you want to enter including initial height? ");
            height = new int[in.nextInt()];

            System.out.println("\nEnter the values for each height of the plant "
                             + "(Include only integer values).");
            
            // Loop to take any every value the user enters
            for(int i = 0; i < height.length; i++)
            {
                if(i==0)
                    System.out.print("\n\tInitial height: ");
                else
                    System.out.print("\tTime #"+(i)+": \t");
                height[i] = in.nextInt();
            }
        }
        System.out.println();
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
		if (height[index]==0)
			System.out.printf("%11s",symbol+"");
		else if (height[index]<0)
			System.out.printf("%10s|%s",characters,"");
		else
			System.out.printf("%10s|%s","",characters);
		
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
