//Daksh Agrawal
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
 * 	try 1-4 (wont give error), and -2, 14 (will give error)
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
		Postage post = new Postage();
		post.sendThis();
	}
	
	public void sendThis()
	{
		getData();
		calculateCost();
		printInfo();
	}
	
	public void printInfo()
	{
		if (category == 1 || category == 2 || category == 3)
		{
			System.out.printf("%n%n%-33s","Your postage class:");
			if (category == 1)
			{
				System.out.print("First class, domestic\n");
				if (weight == 1)
					System.out.printf("%-33s%s%n","Weight:",(weight+" ounce"));
				else
					System.out.printf("%-33s%s%n","Weight:",(weight+" ounces"));
			}
			else if (category == 2)
			{
				System.out.print("Postcards, domestic\n");
				//print values
			}
			else if (category == 3)
			{
				System.out.print("Media Mail\n");
				if (weight == 1)
					System.out.printf("%-33s%s%n","Weight:",(weight+" pound"));
				else
					System.out.printf("%-33s%33s%n","Weight:",(weight+" pounds"));
			}
			System.out.printf("%-33s$%.2f%n","Charge:",cost);
		}
		
		System.out.print("\nHave a nice day!");
		System.out.print("\n\n\n");
	}
	
	public void calculateCost()
	{
		//costs
		final double FIRSTOUNCECOST = 0.78;
		final double ADDITIONALOUNCECOST = 0.29;
		final double ANYPOSTCARDCOST = 0.61;
		final double FIRSTPOUNDCOST = 4.47;
		final double ADDITIONALPOUNDCOST = 0.72;
		
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
	
	public void getData()
	{
		String categoryTest = new String();
		String weightTest = new String();
		
		Scanner input = new Scanner(System.in);
		System.out.print("\n\n\n");
		
		System.out.println("Hello, and welcome to the US Post Office.");
		System.out.println("\n\t(1) First class, domestic");
		System.out.println("\t(2) Postcards, domestic");
		System.out.println("\t(3) Media Mail");
		
		System.out.printf("%n%-65s %-5s",("Using the menu above, please enter the "
						+ "category of your postage"),"->");
		categoryTest = input.nextLine();	
		
		if (categoryTest.equals("1"))
		{
			category = 1;
			System.out.printf("%-65s %-5s",("Enter the weight, in ounces,"
						+ " of your letter (an integer)"),"->");
			weightTest = input.nextLine();
		}
		else if (categoryTest.equals("2")) 
		{
			category = 2;
			//no question for weight
		}
		else if (categoryTest.equals("3")) 
		{
			category = 3;
			System.out.printf("%-65s %-5s",("Enter the weight, in pounds,"
						+ " of your package (an integer)"),"->");
			weightTest = input.nextLine();
		}
		else
		{
			System.out.println("\nPlease enter a valid postage class!\n");
		}
		//! fix the weight thing here for decimal values
		if ((category == 1 || category == 3) && !weightTest.equals())
		{
			System.out.println("The weight you entered is not a valid input. "
								+ "Rerun the program and input a positive"
								+ " integer");
		}
	}
}
