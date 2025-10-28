//Daksh Agrawal
/* 10/28/2025 
 * Period 7
 * BuckleMyShoe.java
 * 
 * Get int from the user, use conditional statements to determine and print 
 * 	the associated line from "Buckle My Shoe."
 * 
 * Working on: If-else statements
 * 
 * Testing: ONly integers btween 1&4 (inclusive) should give a line,
 * 	everything else gives an error message 
 * 	try 1-4, and -2, 14
 * 
 * Pseudocode: 
	 * FV - line
	 * 
	 * main()
	 * 		create an instance of class, use it to call findIt
	 * 
	 * findIt()
	 * 		D&I variable byte - input num
	 * 		var = call getInput()
	 * 		call decideWhich (pass in var)
	 * 		call print()
	 * 
	 * getInput()
	 * 		Welcome/prompt 
	 * 		D&I Scanner
	 * 		read input
	 * 		return input
	 * 
	 * decideWhich (recieves parameters byte = line numberR)
	 * 		use if-else sttement to see which line entered
	 * 		save to FV 
	 * 
	 * print()
	 * 		print the line & 3 BLs
*/

import java.util.Scanner;

public class BuckleMyShoe
{
	private String line;
	
	public BuckleMyShoe()
	{
		line = new String();
	}
	
	public static void main(String[] args)
	{
		BuckleMyShoe bms = new BuckleMyShoe();
		bms.findIt();
	}
	
	public void findIt()
	{
		byte num = -1; //D&I num as byte
		num = getInput(); 		// call get input
		decideWhich(num); 		// call decideWhich and pass in num
		print(); 		//call print
	}
	
	public byte getInput()
	{
		System.out.print("\n\n\nHello, please enter integers from 1-4: "); //prompt
		Scanner input = new Scanner(System.in); //D&I Scanner
		return input.nextByte();		//return input
	}
	
	public void decideWhich(byte num)
	{
		if (num == 1 || num == 2)
		{
			line = "1, 2 Buckle my shoes";
		}
		else if (num == 3 || num == 4)
		{
			line = "3, 4 Shut the door";
		}
		else
		{
			line = "You're Wrong. Please enter an integer (1-4).";
		}
	}
	
	public void print()
	{
		System.out.print(line+"\n\n\n");
	}
}	
