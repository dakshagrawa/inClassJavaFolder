//Daksh Agrawal
//9-16-2025 Per7
//BookBuyers.java

/* What program does:
 * 	Ask the user for the cost of the books for each course - Calculus, 
 * 		English and History - then calculate the total cost including 
 * 		the discount and tax as well as the total number of books purchased. 
 * 		Print a formatted bill with all of this information.
 * 
 * Working on: 
 * 1. Inputting from a keyboard
 * 2. using printf()
 * 
 * Pseudocode:
 * 	Import the scanner library
 * 	class header
 * 	main header
 * 
 * 	Creates a new instance of Scanner and puts System.in inside Scanner input
 * 
 * 	D&I:
 * 		- double calculusBookCost = -1.0;
 * 		- double englishBookCost = -1.0;
 * 		- double historyBookCost = -1.0;
 * 		- final double DISCOUNTFOR2 = 0.10;
 * 		- double subtotal = -1.0;
 * 		- double discount = -1.0
 * 		- double totalWithoutTax = -1.0;
 * 		- final double TAX = 0.0925;
 *		- double taxCost = -1.0;
 * 		- double grandTotal = -1.0;
 * 		- int numOfStudents = 2; //number of students
 * 
 * 	Three blank lines
 * 
 * 	Ask user to enter cost of Calculus, English, and History books with 
 * 		tabs in between them (only positive numeral digits and decimals allowed.)
 * 
 * 	calculusBookCost equals to input.nextDouble();
 * 	englishBookCost equals to input.nextDouble();
 * 	historyBookCost equals to input.nextDouble();
 * 	
 * 	There are 5 english books, and 2 history books: 
 * 		reassign value to variable after using '*' (multiplication)
 * 
 * 	Enter the cost of all the books with '$' symbol and decimal of cost in a straight line (everything in 2 decimals)
 *  
 * 		add all the costs up to subtotal in subtotal variable
 * 		add discount, from DISCOUNTFOR2 variable, by multiplying with subtotal and storing in discount variable
 * 		totalWithoutTax = subtotal - discount;
 * 		taxCost = TAX*totalWithoutTax;
 * 		grandTotal = totalWithoutTax+(TAX*totalWithoutTax)
 * 
 * 	Using printf to display the users final output (grandTotal) with commas in number in 2 decimals
 * 
 * 	An ending statement with number of books and total cost, and thank you statement using printf
 * 
 * 	Three blank lines
 * 
 * Test Plan:
 * 	- 98338402.98234 32423 0 = 193,701,268.61
 * 	- 157.45 20.89 148.78 = 1,100.18
 */

import java.util.Scanner; //import the Scanner library

public class BookBuyers
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in); //Opens the Scanner 
		                                           //System.in is the keyboard
		//D&I
		double calculusBookCost = -1.0;
  		double englishBookCost = -1.0;
  		double historyBookCost = -1.0;
  		final double DISCOUNTFOR2 = 0.10;
  		double subtotal = -1.0;
 		double discount = -1.0;
  		double totalWithoutTax = -1.0;
  		final double TAX = 0.0925;
  		double taxCost = -1.0;
		double grandTotal = -1.0;
		
		int numOfStudents = 2;
		
		System.out.print("\n\n\n");
		
		//Input from user
		System.out.print("This program will calculate the cost for two "+
			"people. Please enter the costs for Calculus, English and "+
			"History for one person, seperated by tabs (only positive "+
			"numeral digits and decimals allowed): ");
		calculusBookCost = input.nextDouble();
		englishBookCost = input.nextDouble();
		historyBookCost = input.nextDouble();
		
		//Multiplying cost of books based on number of books
		calculusBookCost = (calculusBookCost*1)*numOfStudents;
		englishBookCost = (englishBookCost*5)*numOfStudents;
		historyBookCost = (historyBookCost*2)*numOfStudents;
		
		//calculating subtotal, discount, tax, grand total, etc.
		subtotal = (calculusBookCost + englishBookCost + historyBookCost);
		discount = DISCOUNTFOR2*subtotal;
		totalWithoutTax = subtotal-discount;
		taxCost = TAX*totalWithoutTax;
		grandTotal = totalWithoutTax+(TAX*totalWithoutTax);
		
		
		//output of bill
		System.out.printf("%n%-25s=  $ %,15.2f%n","Calculus books",calculusBookCost);
		System.out.printf("%-25s=  $ %,15.2f%n","English books",englishBookCost);
		System.out.printf("%-25s=  $ %,15.2f%n","History books",historyBookCost);
		System.out.printf("%-25s=  $ %,15.2f%n","Sub total",subtotal);
		System.out.printf("%-25s=  $ %,15.2f%n","Discount",discount);
		System.out.printf("%-25s=  $ %,15.2f%n","Total before tax",totalWithoutTax);
		System.out.printf("%-25s=  $ %,15.2f%n","Tax",taxCost);
		System.out.printf("%-25s=  $ %,15.2f%n","Grand total",grandTotal);
		
		//ending statemet
		System.out.printf("%nThe total cost for 16 books is $%,.2f. Thank you for shopping with BooksRUs.com.",grandTotal);
		
		System.out.print("\n\n\n");
	}
}
