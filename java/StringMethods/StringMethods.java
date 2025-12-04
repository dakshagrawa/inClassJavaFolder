// Daksh Agrawal
/* Period 7
 * 12/02/2025
 * 
 * >Description: Utility class that reimplements some common String methods
 *   (charAt, trim, toLowerCase, toUpperCase) using custom logic.
 * 
 * >Learning: Practice with recursion, loops, ASCII values, and string manipulation.
 * 
 * >Pseudocode (all methods are void (except main) and are public):
 *   - charAt: return character at index or '?' if out of bounds
 *   - trimAll: remove all spaces/tabs from string
 *   - trim: remove leading/trailing spaces/tabs
 *   - toLowerCase: convert uppercase letters to lowercase
 *   - toUpperCase: convert lowercase letters to uppercase
 * 
 * >Testing: 
 *  1. Try strings with spaces, tabs, uppercase, lowercase, and invalid indices.
 * 
 */
public class StringMethods
{
	// Default constructor (not used here, but included for completeness)
	public StringMethods()
	{
		
	}
	
	// Custom charAt method: returns character at given index
	// If index is out of bounds, returns '?'
	// NOTE: Implementation uses substring + compareTo, which is unusual
	public static char charAt(String str,int index)
	{
		if (index>=str.length())
			return '?';
		
		// Takes substring of one character, compares to space, then adds 32
		// This does not behave like normal charAt, but is a custom approach
		return (char)(str.substring(index,index+1).compareTo(" ")+32);
	}
	
	// Removes ALL spaces and tabs from the string
	public static String trimAll(String str)
	{
		return trimAllLoop(str,"",str.length(), -1);
	}
	
	// Recursive helper method for trimAll
	// str1 = original string, str2 = result string
	// length = total length, i = current index
	public static String trimAllLoop(String str1,String str2,int length, int i)
	{
		// Base case: reached end of string
		if (i==(length-1))
		{
			return str2;
		}
		i++;
		
		// Skip spaces and tabs
		if ((int)str1.charAt(i)==(int)' ' || (int)str1.charAt(i)==(int)('\t'))
		{
			return trimAllLoop(str1,str2,length,i);
		}
		else
		{
			// Add non-space character to result
			str2 = str2.concat(""+((char)str1.charAt(i)));
			return trimAllLoop(str1,str2,length,i);
		}
	}
	
	// Removes leading and trailing spaces/tabs (like String.trim())
	public static String trim(String str)
	{
		// Remove leading spaces/tabs
		while ((int)str.charAt(0)==(int)' ' || (int)str.charAt(0)==(int)('\t'))
			str = str.substring(1);
			
		// Remove trailing spaces/tabs
		while ((int)str.charAt(str.length()-1)==(int)' ' || (int)str.charAt(str.length()-1)==(int)('\t'))
			str = str.substring(0,str.length()-1);
		
		return str;
	}
	
	// Converts all uppercase letters (A-Z) to lowercase (a-z)
	public static String toLowerCase(String str)
	{
		String finalStr = "";
		int i = 0;
		char currentChar;
		while (i<str.length())
		{
			currentChar = str.charAt(i);
			// ASCII range for uppercase letters: 65–90
			if ((int)currentChar>=65 && (int)currentChar<=90)
			{
				// Add 32 to convert to lowercase
				currentChar = (char)((int)currentChar+32);
			}
			finalStr = finalStr.concat(""+currentChar);
			i++;
		}
		return finalStr;
	}
	
	// Converts all lowercase letters (a-z) to uppercase (A-Z)
	public static String toUpperCase(String str)
	{
		String finalStr = "";
		int i = 0;
		char currentChar;
		while (i<str.length())
		{
			currentChar = str.charAt(i);
			// ASCII range for lowercase letters: 97–122
			if ((int)currentChar>=97 && (int)currentChar<=122)
			{
				// Subtract 32 to convert to uppercase
				currentChar = (char)((int)currentChar-32);
			}
			finalStr = finalStr.concat(""+currentChar);
			i++;
		}
		return finalStr;
	}
}
