// Daksh Agrawal
/* Period 7
 * 11-04-2025 
 * 
 * Hailstone.java
 * 
 * Testing: 
 * 	1. Numbers: 1, 0, 67, 6171, -1
 * 	2. Expected corresponding outputs: 1, {error message}, 28, 262, {thank you message}
 */

import java.util.Scanner; // Import Scanner class for user input

public class Hailstone
{
	private int counter;			// Tracks number of steps in the sequence
	private int userInput;			// Stores the current number entered by the user
	private int numOfPrintColumns;	// Keeps track of how many numbers have been printed per line
	
	public Hailstone()
	{
		// Initialize variables
		counter = 0;
		userInput = 0;
		numOfPrintColumns = 0;
	}

	public static void main(String[] args)
	{
		// Create Hailstone object and start the program
		Hailstone hs = new Hailstone();
		hs.findIt();
	}

	public void findIt()
	{
		// Display welcome message
		System.out.println("\n\n\nWelcome to the HailStone Game!\n\n This "
						+ "program is the simulation of the HailStone problem."
						+ " The Hailstone Sequence was\nproposed by German "
						+ "mathematician Lothar Collatz. The sequence always"
						+ " ends in a 1, \nalthough it has yet to be proven."
						+ " The sequence works this way: pick a number, if"
						+ " it\nis even then half it, if it is odd then multiply"
						+ " by 3 and add one. This program does\njust that!");
		do
		{
			// Get user input
			getInput();
			if (userInput>0 && userInput<=10000)
			{
				// Resets number of columns for new number
				numOfPrintColumns = 0;
				// Print the starting number
				printNum();
				counter = 1; // Initialize counter
				
				// Continue until the sequence reaches 1
				while(userInput>1)
				{
					// If number is even, divide by 2
					if (userInput%2==0)
					{
						changeWhenEven();
					}
					// If number is odd, multiply by 3 and add 1
					else
					{
						changeWhenOdd();
					}
					// Increment counter and print current number
					printNum();
					counter++;
				}
				// Print total number of steps
				printCounter();
			}
			// Handle invalid input (not positive and not -1)
			else if (userInput!=-1)
			{
				System.out.println("\nEnter a value within the range, please!");
			}
		} while(userInput!=-1); // Repeat until user enters -1
		System.out.println("Thank you for playing Hailstone.\n\n");
	}

	public void getInput()
	{
		// Prompt user for input
		Scanner input = new Scanner(System.in);
		System.out.print("\n\nEnter a positive integer ( 1 - 10000 ). "
						+ "To quit, enter -1:\t");
		userInput = input.nextInt(); // Store user input
		System.out.println();
	}

	public void printNum()
	{
		// Print numbers in columns of 10 per line
		if (numOfPrintColumns==10)
		{
			System.out.println();
			numOfPrintColumns = 0;
		}
		System.out.print("\t" + userInput);
		numOfPrintColumns++;
	}

	public void printCounter()
	{
		// Print how many times the loop executed
		System.out.println("\n\nThe loop executed "+counter+" times.");
	}

	public void changeWhenOdd()
	{
		// Apply odd rule: multiply by 3 and add 1
		userInput = userInput*3 + 1;
	}

	public void changeWhenEven()
	{
		// Apply even rule: divide by 2
		userInput = userInput/2;
	}
}
