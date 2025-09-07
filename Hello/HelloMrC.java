//Daksh Agrawal
//8-25-2025 Per7
//HelloMrC.java
/* This is our first program! This prints a simple message. It shows
 * formatting -- Allman style ALWAYS!! We will format every program this way. 
 * working on: Using print, println, and escape sequences for tab\t and 
 * new line \n. 
 * */

public class HelloMrC
{
	public static void main(String[] args)
	{//Allman style means to put the brace below the header
		System.out.println("\n\n\n"); //Always include 3 blank lines (3 BLs)
		System.out.println("Hello Mr. C");
		
		System.out.print("I am printing on ");
		System.out.print("the same line, then going ");
		System.out.print("to the next line. ");
		
		System.out.println("Here is another eay to combine two lines. " + "Always indent the 2nd and following lines.");
		
		System.out.println("\n\"Escape sequences\"");
		System.out.println("\tBackslash t gives a tab.");
		System.out.print("Backslash n gives a new line.\n");
		System.out.println("\nBackslash n gives a new line.");
		
		System.out.println("\n\n\n\\");
	}
}
