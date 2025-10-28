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
 * Testing: ONly integers btween 1&4 (inclusive) should give a line,
 * 	everything else gives an error message 
 * 	try 1-4, and -2, 14
 */

import java.util.Scanner;

public class Postage
{
	private int category;
	private int weight;
	private double cost;
	
	public Postage
	{
		//blank 
	}
	
	public static void Main(String[] args)
	{
		Postage post = new Postage();
		Postage.sendThis();
	}
	
	public void sendThis()
	{
		getData();
		calculateCost();
		printInfo();
	}
	
	public void printInfo()
	{
		if (category == 1)
		{
			//print values
		}
		else if (category == 2)
		{
			//print values
		}
		else if (category == 3)
		{
			//print values
		}
		
		System.out.print("Have a nice day!");
		System.out.print("\n\n\n");
	}
	
	public void calculateCost()
	{
		if (category == 1)
		{
			cost = 0.79 + (weight-1)*0.29;
		}
		else if (category == 2)
		{
			cost = 0.61
		}
		else if (category == 3)
		{
			cost = 4.41 + (weight-1)*0.72;
		}
	}
	
	public void getData()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("\n\n\n");
		
		System.out.print("Eneter category");
	}
