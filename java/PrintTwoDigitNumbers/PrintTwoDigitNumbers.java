// Daksh Agrawal
/* Period 7
* 01/06/2026
* 
* PrintTwoDigitNumbers.java
* 
* >Description: Program uses nested loops to print table of two digit numbers
* 				from the user's start nember to the user's end number.
*
* >Learning:
* 
* >Testing:
*
*/

import java.util.Scanner;

public class PrintTwoDigitNumbers
{
	public int start; //the starting value of the chart
	public int end;   //the ending value of the chart
	
	public PrintTwoDigitNumbers()
	{
		start = end = 0;
	}
	
	public static void main(String[] args)
	{
		PrintTwoDigitNumbers ptdn = new PrintTwoDigitNumbers();
		ptdn.printIt();
	}
	
	/* printIt controls the program and prints the welcome message. */
	public void printIt()
	{
		System.out.println("\n\n\n");
		System.out.println("\t\tWelcome to PrintTwoDigitNumbers\nThis program " +
			"asks the user for the start and end number, then prints the number " +
			"in a table\n");
		getValues();
		printNumbers();
		System.out.println("\n\n\n");
	}
	
	/* Prompts and reads the user's numbers to start and end the table. */
	public void getValues()
	{
		Scanner keyboard = new Scanner(System.in);
		
		do
		{
			System.out.print("Enter the start value for the two digit numbers chart " +
				"(10 - 99) -> ");
			start = keyboard.nextInt();
		}while(start < 10 || start > 99);
		
		do
		{
			System.out.printf("Enter the end value for the numbers chart " +
				"(%d - 99) -> ", start);
			end = keyboard.nextInt();
		}while(end < start || end > 99);
	}
	
	/* Uses nested loops to print the chart. The outer loop prints the tens digit
	 * and the inner loop prints the units digit. */
	 public void printNumbers()
	 {
		 for(int outer = start/10; outer < end/10 +1; outer++)
		 {
			 System.out.println();
			 for(int inner = 0; inner < 10; inner++)
			 {
				if (outer == start/10 && inner < start%10)
					System.out.print("\t");
				else if(outer < end/10)
					System.out.printf("%d%d\t", outer, inner);
				else if(outer == end/10 && inner <= end%10)
					System.out.print(outer + "" + inner + "\t");
			}
			System.out.println();	
		}
	}
}
