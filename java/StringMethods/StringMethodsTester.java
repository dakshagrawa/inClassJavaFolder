// Daksh Agrawal
// Period 7
// Date: 12/02/2025
// StringMethodsTester.java
// StringMethodsTester.java
// We are writing some of the String Methods.  This class runs StringMethods.java
// Here are examples of using at least three methods - charAt, ...., trim

public class StringMethodsTester
{	
	public StringMethodsTester()
	{
	}
	
	public static void main(String[] args)
	{
		StringMethodsTester smt = new StringMethodsTester();
		smt.runIt();
	}
	
	public void runIt()
	{
		System.out.println("\n\n\n");
		
		String str = "Java is awesome";
		String str2 = "Java is avesome";
		String strCap = "JaVa Is aWeSOME";
		System.out.println("\"Java is awesome\"");
		
		String strWithTab = "\t  Hello World!  \t";
		System.out.println("The string is \\t Hello World!   \\t");
		
		System.out.println("\nExample using the charAt() in my StringMethods.java class.");
		for (int i = 0; i < strWithTab.length(); i++)
			System.out.print("\nStringMethods.charAt(strWithTab, " + i + ") = " + 
				StringMethods.charAt(strWithTab, i) + " " );
		System.out.println("\n\nError charAt() out of bounds: "+StringMethods.charAt(strWithTab, 50)  ); // after it works, try this.  Record the response.
		
		System.out.println("\nExample using the toLowerCase(strCap) in my StringMethods.java class.");
 		System.out.println("\nStringMethods.toLowerCase(strCap) with parameters used = " + 
			StringMethods.toLowerCase(strCap));
			
		System.out.println("\n\nExample using the toUpperCase(strCap) in my StringMethods.java class.");
 		System.out.println("\nStringMethods.toUpperCase(strCap) with parameters used = " + 
			StringMethods.toUpperCase(strCap));

		System.out.println("\n\nExample using the replace(str,'a','b') in my StringMethods.java class.");
 		System.out.println("\nStringMethods.replace(str,'a','b') with parameters used = " + 
			StringMethods.replace(str,'a','b'));

		System.out.println("\n\nExample using the lastIndexOf(str,'a') in my StringMethods.java class.");
 		System.out.println("\nStringMethods.lastIndexOf(str,'a') with parameters used = " + 
			StringMethods.lastIndexOf(str,'a'));

		System.out.println("\n\nExample using the lastIndexOf(str,'a',4) in my StringMethods.java class.");
 		System.out.println("\nStringMethods.lastIndexOf(str,'a',4) with parameters used = " + 
			StringMethods.lastIndexOf(str,'a',4));

		System.out.println("\n\nExample using the lastIndexOf(str2,\"av\") in my StringMethods.java class.");
 		System.out.println("\nStringMethods.lastIndexOf(str2,\"av\") with parameters used = " + 
			StringMethods.lastIndexOf(str2,"av"));

		System.out.println("\n\nExample using the lastIndexOf(str2,\"av\",3) in my StringMethods.java class.");
 		System.out.println("\nStringMethods.lastIndexOf(str2,\"av\",3) with parameters used = " + 
			StringMethods.lastIndexOf(str2,"av",3));
			
		System.out.println("\n\nExample using trim(strWithTab), in my StringMethods.java class.");
		System.out.println("The string is \"\t Hello World!   \t\"");
		// Un-comment the following lines out after you write the trim method.
 		System.out.println("\nStringMethods.trim(strWithTab) = |" + 
 			StringMethods.trim(strWithTab) + "|\n\n" );
					
		System.out.println("\n\n\n");
	}
}	
