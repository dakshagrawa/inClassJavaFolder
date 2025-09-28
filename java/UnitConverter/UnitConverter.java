//Daksh Agrawal
//9-25-2025 Per7
//UnitConverter.java

/* What program does:
 * 	Gives the user a unit converter where they can convert inches to 
 * 		feet, yards, centimeters
 * 
 * Working on:
 * 	1. Multiple class
 */

import java.util.Scanner; //import Scanner

public class UnitConverter
{
	public static double inches = -100.0;
	public static void main(String[] args) //main class
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

	public static void input() //input the number of inches
	{
		Scanner input = new Scanner(System.in);
		System.out.println("\n\n\n");
		System.out.print("Please enter the number of inches --> ");
		inches = input.nextDouble();
	}
	public static double InchesToFeet() //inches to feet
	{
		final double INTOFT = 12.0;
		double feetAns = inches/INTOFT;
		return feetAns;
	}
	public static double InchesToYards() //inches to yards
	{
		final double INTOYDS = 36;
		double yardsAns = inches/INTOYDS;
		return yardsAns;
	}
	public static double InchesToCm() //inches to centimeters
	{
		final double INTOCM = 2.54;
		double cmAns = inches*INTOCM;
		return cmAns;
	}
	public static void print(double finalFeet, double finalYards, double finalCm) //printing all values out
	{
		System.out.printf("%n %.0f inches is equivalent to %.2f feet, %.2f yards, and %.2f centimeters.%n",inches,finalFeet, finalYards, finalCm);
		System.out.println("\n\n\n");
	}
}