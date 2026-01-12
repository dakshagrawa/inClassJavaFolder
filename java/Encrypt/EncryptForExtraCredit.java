// Daksh Agrawal
/* Period 7
 * 01/06/2026
 *
 * EncryptForExtraCredit.java
 *
 * Objective:
 *     Demonstrate simple encryption by repeatedly shifting letters in a string
 *     using a Caesar‑style character rotation.
 *
 * Description:
 *     The program prompts the user for a word, phrase, or sentence, then asks
 *     for a shift amount. It applies that shift to every alphabetical character,
 *     wrapping around the alphabet when necessary. After each rotation, the
 *     newly encrypted text becomes the input for the next rotation. The process
 *     continues until the encrypted text cycles back to the original input.
 *
 * Learning:
 *     - Using Scanner for console input
 *     - Accessing and modifying characters with ASCII values
 *     - Applying loops and conditionals
 *     - Using String methods such as length() and charAt()
 *
 * Testing:
 *     - Try uppercase, lowercase, and mixed-case strings
 *     - Include punctuation and spaces (which should remain unchanged)
 *     - Verify wraparound behavior (e.g., Y → A, z → b)
 */

import java.util.Scanner;

public class EncryptForExtraCredit
{
    private String original;      // Stores the original user input
    private String unencrypted;   // Stores the current text before shifting
    private String encrypted;     // Stores the most recently encrypted result
    private int addCase;          // Number of characters to shift by

    public EncryptForExtraCredit()
    {
        // Initialize all strings as empty and default shift to 2
        original = new String();
        unencrypted = new String();
        encrypted = new String();
        addCase = 2;
    }
    
    public static void main(String[] args)
    {
        // Create an EncryptForExtraCredit object and begin the rotation process
        EncryptForExtraCredit encrypt = new EncryptForExtraCredit();
        encrypt.rotationTimes();
    }
    
    public void rotationTimes()
    {
        // Get user input before starting the encryption cycle
        getString();
        
        // Continue encrypting until the text returns to the original
        for(int i = 0; !encrypted.equals(original); i++)
        {
            encryptString();   // Apply the shift to each character
            printString(i);    // Display the result for this rotation
        }
    }
    
    public void getString()
    {
        // Scanner for reading user input
        Scanner in = new Scanner(System.in);
        
        System.out.print("\n\n\n");
        System.out.println("Welcome to Encrypt.java. Please enter a word, " 
                         + "phrase, or sentence.");
        System.out.print("\n->\t");
        
        // Read the user's text and store it
        unencrypted = in.nextLine();
        original = unencrypted;   // Save the original for cycle detection

        System.out.println("\nBy how many characters do you want the text"
                         + " to be encrypted by? (Enter a whole number)");
        System.out.print("\n->\t");

        // Normalize the shift to the range 0–25
        addCase = in.nextInt() % 26;

        System.out.println();
    }
    
    public void encryptString()
    {
        // If this is not the first rotation, move the previous encrypted
        // result into unencrypted and clear encrypted for the next build
        if (!encrypted.equals(""))
        {
            unencrypted = encrypted;
            encrypted = new String();
        }

        // Process each character in the current unencrypted string
        for(int i = 0; i < unencrypted.length(); i++)
        {
            char currentChar = unencrypted.charAt(i);  // Current character
            
            // Shift uppercase letters A–Z
            if (currentChar >= 'A' && currentChar <= 'Z')
            {
                currentChar = (char)(currentChar + addCase);   // Apply shift
                if (currentChar > 'Z')                         // Wrap around
                    currentChar = (char)(currentChar - 26);
            }

            // Shift lowercase letters a–z
            if (currentChar >= 'a' && currentChar <= 'z')
            {
                currentChar = (char)(currentChar + addCase);   // Apply shift
                if (currentChar > 'z')                         // Wrap around
                    currentChar = (char)(currentChar - 26);
            }

            // Add the shifted character to the encrypted string
            encrypted += currentChar;
        }
    }
    
    public void printString(int index)
    {
        // Print the rotation number and the encrypted text
        System.out.println("Encrytion " + (index + 1) + ":");
        System.out.println(encrypted + "\n");
    }
}
