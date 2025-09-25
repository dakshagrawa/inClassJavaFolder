//Daksh Agrawal
//9-16-2025 Per7
//InchesToFeet.java

/* What program does:
 * Writing a program that accepts the number of inches from a user 
 * (integer), then prints the equivalent amount of feet (decimal),
 * formatted to 2 decimal places).
 * 
 * Working on: 
 * 1. Inputting from a keyboard
 * 2. Using a Math method
 * 3. using printf()
 * 
 * Pseudoecode:
 * 	Import the scanner library
 * 	class header
 * 	main header
 * 
 * 	Creates a new instance of Scanner and puts System.in in keyboard
 * 
 * 	D&I:
 * 		- final int CONVERSIONRATE = 12;
 * 		- integer userInches = -1;
 * 		- double userFeet = -1.0;
 * 
 * 	Three blank lines
 * 
 * 
 * 	Ask user to enter inches inside the variable userInches smaller than 
 * 		2,147,483,647, larger than 0, and its supposed to be a numeral symbol
 *
 * 	userInches equals to keyboard.nextInt()	
 *
 *  userFeet equals to userInches divided by conversionRate
 * 
 * 	Using printf we display the users final output (userFeet) to the second decimal
 * 
 * 	Three blank lines
 * 
 * Test Plan:
 * 	- 2147483646 = 178,956,970.50
 *  - 10 = 0.83
 *  - -98 = 
 *  - 0
 */

import java.util.Scanner; //import the Scanner library

public class InchesToFeet
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in); //Opens the Scanner 
		                                           //System.in is the keyboard
		
		//D&I:
		final int CONVERSIONRATE = 12;
		int userInches = -1;
		double userFeet = -1.0;
		
		//output
		
		System.out.println("\n\n\n");
		
		System.out.print("Please enter the integer of inches you need" 
			+ " to convert to feet (smaller than 2,147,483,646 but"
			+ " larger than 0, as a positive numeral digit) -> "); //asking for an input
		userInches = keyboard.nextInt(); //assigns the input value to userInches
		
		userFeet = (double)userInches/(double)CONVERSIONRATE; //converting inches to feet
		
		System.out.printf("%n%n%d inches is equivalent to %.2f feet",userInches,userFeet);
		
		System.out.println("\n\n\n");
	}
}
