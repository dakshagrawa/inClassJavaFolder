//Daksh Agrawal
//9-15-2025 Per7
//ScannerExample.java
/* What program does:
 * This program gives you an example of how to use the Scanner class.
 * 
 * Working on: 
 * 1. Inputting from a keyboard
 * 2. Using a Math method
 */

import java.util.Scanner; //import the Scanner library


public class ScannerExample
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in); //Opens the Scanner 
		                                           //System.in is the keyboard
		System.out.print("\n\n\n");
		System.out.print("Input an Decimal\t-> "); //prompt user for int
		double input = 0;
		input = keyboard.nextDouble();               //read in the integer input
		System.out.println("Your decimal is "+input); //print out input
		
		//It is basically the same nextDouble, nextFloat, nextLong, etc.
		
		//keyboard.nextLine(); //flush the buffer to use nextLine - take out and see what happens!
		
		
		System.out.print("\nInput a sentence\t-> ");
		String str = new String("");
		str = keyboard.next();      //reads the first word
		System.out.println("Your first word of the sentence is: "+str);
		
		str = keyboard.nextLine(); //reads up to the end of the line
		System.out.println("Your sentence is: "+str);
		
		System.out.print("\n\n\n");
		
		//Using Math methods
		double power = 0.0;
		power = Math.pow(input, 3);
		System.out.println("\ninput number cubed, = "+power);
		
		power = Math.round(power);
		
		System.out.println("\npower round to nearest whole number = "+((int)(power)));
			//it is a double, so it gives the first decimal place 
			//Math round(float) returns an int
			//Math.round(double) returns a long, so you cannot save to an int!
			//To get around this, cast the souble as a float, then round or
			//use a long vs. int
		
		System.out.println("\n\n\n");
		
		//sqrt and stuff we haven't done (you can look up Java math method)
	}
}
