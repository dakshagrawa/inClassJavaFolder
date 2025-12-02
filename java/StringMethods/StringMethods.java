// Daksh Agrawal
/* Period 7
 * 12/02/2025
 * 
 * >Description: 
 * 
 * >Learning: 
 * 
 * >Pseudocode (all methods are void (except main) and are public):
 * 
 * 
 * >Testing: 
 * 	1. 
 * 
 */
public class StringMethods
{
	public StringMethods()
	{
		
	}
	
	public static char charAt(String str,int index)
	{
		return (char)(str.substring(index,index+1).compareTo(" ")+32);
	}
	
	public static String trim(String str)
	{
		return trimLoop(str,"",(str.length()-1));
	}
	
	public static String trimLoop(String str1,String str2,int num)
	{
		if (num==0)
			return str2;
		else if (((str1.substring(num,num+1).compareTo(" ")+32)==32) || (str1.substring(num,num+1).compareTo(" ")+32)==9)
			return trimLoop(str1,str2,(num-1));
		else
			str2.concat(""+(char)(str1.substring(num,num+1).compareTo(" ")+32));
			return trimLoop(str1,str2,(num-1));
	}
}
