//Daksh Agrawal
/* 10/23/2025 
 * Period 7
 * Food3.java
*/

public class Food3
{
	// Private variable of the line printed, allowing all 
	// subclasses access it (through "protected" access specifier)
	protected String str;
	
	// Constructor that initializes the str variable with an empty string.
	public Food3 ()
	{
		str = new String(""); //initializes String str when constructor is called.
	}
	
	// Overloaded constructor for the Food class that creates a 
	// descriptive string about a food item to accommodate multiple parameters
	public Food3 (String prepMethod, String ingredient, String name, int pieces, double costPerPiece) 
	{	
		str = String.format(("At the sale: %s %s with %s will be sold for"
			+ " %.2f cents each. With %d %s(s), $%.2f can be made."), name, 
			prepMethod, ingredient, (costPerPiece*100), pieces, name, 
			(pieces*costPerPiece)); //String.format() is used to convert
									//a printf style statement into a String, this helps print out the result
	}
	
	// Prints the value of 'str' to the user as the output
	public void printForSale() 
	{	
		System.out.println(str);
	}
}
