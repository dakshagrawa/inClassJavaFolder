// Daksh Agrawal
/* Period 7
* 01/06/2026
* 
* Encrypt.java
* 
* >Objective: To use string methods and character operators to modify a sentence.
* 
* >Description: 
*
* >Learning:
*
* >Pseudocode:
* 		
* 	Import Scanner
* 	
* 	Class header
* 	
* 	Make a field variable to store the input in
* 
* 	Constructor and initialization of FVs
* 
* 	Main:
* 		D&I constructor and call encryptIt()
* 	
* 	rotate13Times:
* 		call getString() to get user input for the string
* 		call encryptString() and run it 13 times, set the loop's index as the parameter here
* 
* 	getString:
* 		take user input and store in the FV
* 
* 	encryptString:
* 		make a loop of the string's length and check for each character
* 		change each character's ascii value by calling string methods, length() and charAt()
* 			and add 2 to each character's ascii value and store it into the string
* 		
* 
* 	printString (take in the index and make it encryption numbering):
* 		Print encryption label and which place it is at (e.g. "Encryption 1", "Encryption 2", etc.) 
* 		Print the string each time
* 		
*
* >Testing:
*
*   
*/

import java.util.Scanner;

public class Encrypt
{
	private String unencrypted;
	private String encrypted;
	
	public Encrypt()
	{
		unencrypted = new String();
		encrypted = new String();
	}
	
	public static void main(String[] args)
	{
		Encrypt encrypt = new Encrypt();
		encrypt.rotate13Times();
	}
	
	public void rotate13Times()
	{
		getString();
		for(int i = 0; i < 13; i++)
		{
			encryptString();
			printString(i);
		}
	}
	
	public void getString()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("\n\n\n");
		System.out.println("Welcome to Encrypt.java. Please enter a word, " 
					   + "phrase, or sentence.");
		System.out.print("\n->\t");
		unencrypted = in.nextLine();
	}
	
	public void encryptString()
	{
		if (!encrypted.equals(""))
		{
			unencrypted = encrypted;
			encrypted = new String();
		}
		for(int i = 0; i < unencrypted.length(); i++)
		{
			char currentChar = unencrypted.charAt(i);
			
			if ((int)currentChar>90 && (int)currentChar<97)
				currentChar = (char)((int)currentChar-65);
			
			if ((int)currentChar>122)
				currentChar = (char)((int)currentChar-97);
			
			if (!((int)currentChar>122) && !((int)currentChar>90 && (int)currentChar<97))
				currentChar = (char)((int)currentChar+2);
			
			encrypted = encrypted+""+currentChar;
			
		}
	}
	
	public void printString(int index)
	{
		System.out.println("Encrytion "+index+":");
		System.out.println(encrypted+"\n");
	}
}
