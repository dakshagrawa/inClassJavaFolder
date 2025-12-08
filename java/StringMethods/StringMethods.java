// Daksh Agrawal
/* Period 7
 * 12/02/2025
 * 
 * StringMethods.java
 * 
 * >Description: Program that remakes some common String methods
 *   (charAt, trim, toLowerCase, toUpperCase) using self-made logic.
 * 
 * >Learning: Practice with recursion, loops, ASCII values, and string manipulation.
 * 
 * >Pseudocode (all methods are public):
 *   - charAt: return character at index or '?' if out of bounds
 *   - trimAll: remove all spaces/tabs from string
 *   - trim: remove leading/trailing spaces/tabs
 *   - toLowerCase: convert uppercase letters to lowercase
 *   - toUpperCase: convert lowercase letters to uppercase
 * 
 * >Testing: 
 *  1. Try strings with spaces, tabs, uppercase, lowercase, and invalid indices in the tester class.
 * 
 */
public class StringMethods
{
	// Default constructor (not used here, but included for completeness)
	public StringMethods()
	{
		//blank
	}
	
	// charAt() method: returns character at given index
	public static char charAt(String str,int index)
	{
		if (index>=str.length()) // If index is out of bounds, returns '?'
			return '?';
		
		// Takes substring of one character, compares to space, then adds 32
		return (char)(str.substring(index,index+1).compareTo(" ")+32);
	}
	
	// Removes ALL spaces and tabs from the string
	public static String trimAll(String str)
	{
		return trimAllLoop(str,"",str.length(), -1);
	}
	
	// Recursive helper method for trimAll
	// str1 = original string
	// str2 = result string being built
	// length = total length of original string
	// i = current index (starts at -1 so first step increments to 0)
	public static String trimAllLoop(String str1,String str2,int length, int i)
	{
		// Base case: reached end of string (last index)
		if (i==(length-1))
			return str2;
		i++;
		
		// Skip spaces and tabs
		if ((int)charAt(str1,i)==(int)' ' || (int)charAt(str1,i)==(int)('\t'))
		{
			return trimAllLoop(str1,str2,length,i);
		}
		else
		{
			// Add non-space character to result
			str2 = str2.concat(""+((char)charAt(str1,i)));
			return trimAllLoop(str1,str2,length,i);
		}
	}
	
	// Removes leading and trailing spaces/tabs (like String.trim())
	public static String trim(String str)
	{
		// Remove leading spaces/tabs
		while ((int)charAt(str,0)==(int)' ' || (int)charAt(str,0)==(int)('\t'))
			str = str.substring(1);
			
		// Remove trailing spaces/tabs
		while ((int)charAt(str,str.length()-1)==(int)' ' || (int)charAt(str,str.length()-1)==(int)('\t'))
			str = str.substring(0,str.length()-1);
		
		return str;
	}
	
	// Converts all uppercase letters (A-Z) to lowercase (a-z)
	public static String toLowerCase(String str)
	{
		String finalStr = new String();
		int i = 0;
		char currentChar;
		while (i<str.length())
		{
			currentChar = charAt(str,i);
			// ASCII range for uppercase letters: 65–90
			if ((int)currentChar>=65 && (int)currentChar<=90)
				currentChar = (char)((int)currentChar+32); // Add 32 to convert to lowercase
			finalStr = finalStr.concat(""+currentChar);
			i++;
		}
		return finalStr;
	}
	
	// Converts all lowercase letters (a-z) to uppercase (A-Z)
	public static String toUpperCase(String str)
	{
		String finalStr = new String();
		int i = 0;
		char currentChar;
		while (i<str.length())
		{
			currentChar = charAt(str,i);
			// ASCII range for lowercase letters: 97–122
			if ((int)currentChar>=97 && (int)currentChar<=122)
				currentChar = (char)((int)currentChar-32); // Subtract 32 to convert to uppercase
			finalStr = finalStr.concat(""+currentChar);
			i++;
		}
		return finalStr;
	}

	// Replaces every given character with the other.
	public static String replace(String str, char givenChar, char finalChar)
	{
		String finalStr = new String();
		int i = 0;
		char currentChar;
		while (i<str.length())
		{
			currentChar = charAt(str,i);
			if (currentChar==givenChar)
				currentChar = finalChar;
			finalStr = finalStr.concat(""+currentChar);
			i++;
		}
		return finalStr;
	}

	// Checks if two String values are equal, checking without casing. Returns a boolean value.
	public static boolean equalsIgnoreCase(String str1, String str2)
	{
		return toLowerCase(str1).equals(toLowerCase(str2));
	}

	// Returns the last index of a character in a String, checking from the back
	public static int lastIndexOf(String str, char findChar)
	{
		for(int i = str.length()-1; i >= 0; i--)
			if (charAt(str,i)==findChar)
				return i;
		return -1;
	}

	// Returns the last index of a character in a String, checking from the number given by user
	public static int lastIndexOf(String str, char findChar, int i)
	{
		for(; i >= 0; i--)
			if (charAt(str,i)==findChar)
				return i;
		return -1;
	}

	// Returns the last index of a substring in a string.
	public static int lastIndexOf(String str, String findStr)
	{
		for (int i = str.length()-findStr.length(); i >= 0; i--)
			if (str.substring(i,i+findStr.length()).equals(findStr))
				return i;
		return -1;
	}

	// Returns the last index of a substring, starting from a given index.
	public static int lastIndexOf(String str, String findStr, int i)
	{
		if (i>str.length() || str.length()<findStr.length() || str.length()-i<findStr.length())
			return -1;

		for (; i >= 0; i--)
			if (str.substring(i,i+findStr.length()).equals(findStr))
				return i;
		return -1;
	}

	// Checks if a String ends with a given String
	public static boolean endsWith(String str, String endStr)
	{
		return str.substring(str.length()-endStr.length()).equals(endStr);
	}
}
