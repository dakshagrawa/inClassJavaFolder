// Daksh Agrawal
/* Period 7
* 01/06/2026
*
* EncryptForExtraCredit.java
*
* Objective:
*     Use string methods and character operations to repeatedly shift letters
*     in a sentence, demonstrating simple encryption logic.
*
* Description:
*     This program asks the user for a word, phrase, or sentence, then applies
*     a Caesar‑style shift of +2 to each alphabetical character. It repeats
*     this encryption 13 times, printing the result after each rotation.
*
* Learning:
*     - Using Scanner for input
*     - Manipulating characters with ASCII values
*     - Using loops, conditionals, and String methods (length, charAt)
*
* Testing:
*     - Enter various strings (uppercase, lowercase, mixed, punctuation)
*     - Verify wraparound behavior (Y to A, z to b, etc.)
*/

import java.util.Scanner;

public class EncryptForExtraCredit
{
	private String original;
	private String unencrypted;   // Stores the current unencrypted text
	private String encrypted;     // Stores the most recent encrypted result
	private int addCase;

	public EncryptForExtraCredit()
	{
		// Initialize both strings as empty
		original = new String();
		unencrypted = new String();
		encrypted = new String();
		addCase = 2;
	}
	
	public static void main(String[] args)
	{
		// Create Encrypt object and begin the 13‑rotation encryption process
		EncryptForExtraCredit encrypt = new EncryptForExtraCredit();
		encrypt.rotationTimes();
	}
	
	public void rotationTimes()
	{
		// Read user input first
		getString();
		
		// Perform encryption 13 times
		for(int i = 0; !encrypted.equals(original); i++)
		{
			encryptString();   // Apply +2 shift to each character
			printString(i);    // Print result for this rotation
		}
	}
	
	public void getString()
	{
		// Scanner for user input
		Scanner in = new Scanner(System.in);
		
		System.out.print("\n\n\n");
		System.out.println("Welcome to Encrypt.java. Please enter a word, " 
						 + "phrase, or sentence.");
		System.out.print("\n->\t");
		
		// Store user input in unencrypted field variable
		unencrypted = in.nextLine();

		original = unencrypted;

		System.out.println("\nBy how many characters do you want the text"
						 + " to be encrypted by? (Enter a whole number)");
		System.out.print("\n->\t");

		addCase = in.nextInt()%26;

		System.out.println();
	}
	
	public void encryptString()
	{
		// If encrypted already has content, move it into unencrypted
		if (!encrypted.equals(""))
		{
			unencrypted = encrypted;
			encrypted = new String();  // Reset encrypted string
		}

		// Loop through each character of the unencrypted string
		for(int i = 0; i < unencrypted.length(); i++)
		{
			char currentChar = unencrypted.charAt(i);  // Get current character
			
			// Uppercase A–Z shifting
			if (currentChar>='A' && currentChar<='Z')
			{
				currentChar = (char)(currentChar+addCase);   // Shift by +2
				if (currentChar>'Z')                   // Wrap around if needed
					currentChar = (char)(currentChar-26);
			}

			// Lowercase a–z shifting
			if (currentChar>='a' && currentChar<='z')
			{
				currentChar = (char)(currentChar+addCase);   // Shift by +2
				if (currentChar>'z')                   // Wrap around if needed
					currentChar = (char)(currentChar-26);
			}

			// Append shifted character to encrypted string
			encrypted += currentChar;
		}
	}
	
	public void printString(int index)
	{
		// Print encryption number (index + 1) and the encrypted text
		System.out.println("Encrytion "+(index+1)+":");
		System.out.println(encrypted+"\n");
	}
}
