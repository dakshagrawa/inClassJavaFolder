//Daksh Agrawal
//9-25-2025 Per7
//UnitConverter.java
/*
 * What program does:
 * 	Gives the user a unit converter where they can convert inches to 
 * 		feet, yards, centimeters
 * 
 * Working on:
 * 	1. Multiple method program
 * 	2. Using field variables
 *  3. Scanner class
 * 
 * Testing plan:
 * 	1. 23 (expected output: 1.92 feet, 0.64 yards, 58.42 centimeters)
 *  2. 100 (expected output: 8.33 feet, 2.78 yards, 254.00 centimeter)
 */

import java.util.Scanner; //import Scanner

public class UnitConverter
{
	public static double inches = -100.0;
	
	public static void main(String[] args) //main
	{
		/*D&I*/
		double feet, cm, yards = -100.0;
		//double cm = -100.0; 
		//double yards = -100.0;
		
		input();

		feet = InchesToFeet();
		yards = InchesToYards();
		cm = InchesToCm();

		print(feet,yards,cm);
	}

	/*input by user of the number of inches method */
	public static void input()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("\n\n\n");
		System.out.println("Welcome to Unit Converter! This program will take in the"+
			" number of inches and print the number of feet, yards and centimeters\n");
		System.out.print("Please enter the number of inches --> ");
		inches = input.nextDouble();
	}

	/*inches to feet method*/
	public static double InchesToFeet() 
	{
		final double INTOFT = 12.0;
		double feetAns = inches/INTOFT;
		return feetAns;
	}

	/*inches to yards method*/
	public static double InchesToYards() 
	{
		final double INTOYDS = 36;
		double yardsAns = inches/INTOYDS;
		return yardsAns;
	}

	/*inches to centimeters method*/
	public static double InchesToCm() 
	{
		final double INTOCM = 2.54;
		double cmAns = inches*INTOCM;
		return cmAns;
	}

	/*print all values out method*/
	public static void print(double finalFeet, double finalYards, double finalCm) 
	{
		/*System.out.printf("%n %.0f inches is equivalent to %.2f feet, %.2f "+
			"yards, and %.2f centimeters.%n",inches,finalFeet, finalYards, finalCm);*/

		//original statement is above. modified using if-else is below

		if (inches%1 == 0)
		{
			System.out.printf("%n %d inches is equivalent to %.2f feet, %.2f "+
			"yards, and %.2f centimeters.%n",(int)inches,finalFeet, finalYards, finalCm);
		} 
		else
		{
			System.out.printf("%n %f inches is equivalent to %.2f feet, %.2f "+
			"yards, and %.2f centimeters.%n",inches,finalFeet, finalYards, finalCm);
		}
		System.out.println("\n\n\n");
	}
}