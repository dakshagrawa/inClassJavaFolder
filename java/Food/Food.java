//Daksh Agrawal
/* 10/21/2025 
 * Period 7
 * Food.java
 * 
*/

public class Food
{
	protected String str;
	
	// Private variable of the line printed, allowing all 
	// subclasses access it (through "protected" access specifier)
	public Food ()
	{
		str = new String("");
	}
	
	// Overloaded constructor for the Food class that creates a 
	// descriptive string about a food item to accommodate multiple parameters
	public Food (String prepMethod, String ingredient, String name)
	{	
		str = "At the sale: " + name + " " + prepMethod + " with " + ingredient;
	}

	// Prints the value of 'str' to the user as the output
	public void printForSale()
	{
		System.out.println(str);
	}
}


/*
In FoodTester's main method
		Food food1 = new Food ("baked", "banana", "muffins");
		food1.printForSale();
		Food food2 = new Food ("fried", "yam", "fritters");
		food2.printForSale();
		Pizza pizza = new Pizza ("pepperoni");
		pizza.printForSale();
*/
