// Daksh Agrawal
/* 10/28/2025 
 * Period 7
 * Postage.java
 * 
 * Get int from the user, use conditional statements to determine and print 
 * 	the associated line from "Buckle My Shoe."
 * 
 * Working on: If-else statements
 * 
 * Testing: Only integers between 1&4 (inclusive) should give a line,
 * 	everything else gives an error message 
 * 	try 1-4 (wont give error), and -2, -1, 14 (will return error handled statement)
 */

import java.util.Scanner;

public class Postage
{
	private int category;
	private int weight;
	private double cost;
	
	public Postage()
	{
		//blank 
	}
	
	public static void main(String[] args)
	{
		// Creates a new Postage object and sends it using the sendThis method
		Postage post = new Postage();
		post.sendThis();
	}
	
	public void sendThis()
	{
		getData();
		calculateCost();
		printInfo();
	}
	
	// This method determines the postage class, checks weight, and calculates the shipping charge accordingly.
	public void printInfo()
	{
		// Checks postage category, weight, and calculates the charge based on the input values
		if ((category == 1 || category == 2 || category == 3) && (weight==0 || weight>=1) && weight%1==0)
		{
			System.out.printf("%n%-33s","Your postage class:");

			// This code prints different shipping categories and weight details based on category and weight.
			if (category == 1)
			{
				System.out.print("First class, domestic\n");
				// Checks whether weight is 1 ounce and print appropriately with pluralization adjustment.
				if (weight == 1)
					System.out.printf("%-33s%s%n","Weight:",(weight+" ounce"));
				else
					System.out.printf("%-33s%s%n","Weight:",(weight+" ounces"));
			}
			else if (category == 2)
			{
				System.out.print("Postcards, domestic\n");
				System.out.printf("%-33s%s%n","Weight:","--");
			}
			else if (category == 3)
			{
				System.out.print("Media Mail\n");
				// Checks whether weight is 1 ounce and print appropriately with pluralization adjustment.
				if (weight == 1)
					System.out.printf("%-33s%s%n","Weight:",(weight+" pound"));
				else
					System.out.printf("%-33s%s%n","Weight:",(weight+" pounds"));
			}
			System.out.printf("%-33s$%.2f%n","Charge:",cost);
		}
		
		System.out.print("\nHave a nice day!");
		System.out.print("\n\n\n");
	}

	// Calculates shipping cost based on category and weight with given rates for each category
	public void calculateCost()
	{
		// Defining constant costs for conversion items
		final double FIRSTOUNCECOST = 0.78;
		final double ADDITIONALOUNCECOST = 0.29;
		final double ANYPOSTCARDCOST = 0.61;
		final double FIRSTPOUNDCOST = 4.47;
		final double ADDITIONALPOUNDCOST = 0.72;
		
		// Calculate shipping cost based on category and weight 
		if (category == 1)
		{
			cost = FIRSTOUNCECOST + (weight-1)*ADDITIONALOUNCECOST;
		}
		else if (category == 2)
		{
			cost = ANYPOSTCARDCOST;
		}
		else if (category == 3)
		{
			cost = FIRSTPOUNDCOST + (weight-1)*ADDITIONALPOUNDCOST;
		}
	}
	
	// This method collects postage category and weight from the user for mailing 
	public void getData()
	{
		// Declares a String variable 'categoryTest' and a double variable 'weightTest' to account for incorrect input values
		String categoryTest = new String();
		double weightTest = -100.1; //impossible value assigned
		
		Scanner input = new Scanner(System.in);
		System.out.print("\n\n\n"); //3 BLs in the start
		
		// Prints a welcome message and lists postal service options. 
		System.out.println("Hello, and welcome to the US Post Office.");
		System.out.println("\n\t(1) First class, domestic");
		System.out.println("\t(2) Postcards, domestic");
		System.out.println("\t(3) Media Mail");
		
		// Prints a formatted message asking the user to enter a category for postage, then reads the input from the user.
		System.out.printf("%n%-65s %-5s",("Using the menu above, please enter the "
						+ "category of your postage"),"->");
		categoryTest = input.nextLine().strip(); //this is to account for String values, decimal values, or any wrong inputs entered by user
		
		// Checks the category of the item and asks for weight input accordingly, with specific messages for different categories (like ounces and pounds)
		if (categoryTest.equals("1"))
		{
			category = 1;
			System.out.printf("%-65s %-5s",("Enter the weight, in ounces,"
						+ " of your letter (an integer)"),"->");
			weightTest = input.nextDouble();
		}
		else if (categoryTest.equals("2")) 
		{
			category = 2;
			//no question for weight in Postcards, domestic
		}
		else if (categoryTest.equals("3")) 
		{
			category = 3;
			System.out.printf("%-65s %-5s",("Enter the weight, in pounds,"
						+ " of your package (an integer)"),"->");
			weightTest = input.nextDouble();
		}
		else
		{
			System.out.println("\nPlease enter a valid postage class!");
		}
		
		if ((category == 1 || category == 3) && (weightTest<1 || weightTest%1!=0))
		{
			System.out.println("\nThe weight you entered is not a valid input. "
								+ "Rerun the program and input a positive"
								+ " integer");
			category = 0;
		}
		else if (category == 1 || category == 3)
		{
			weight = (int)weightTest;
		}
	}
}
