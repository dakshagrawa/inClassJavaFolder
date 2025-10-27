public class FoodTester3
{
	//Nothing in constructor because it is never called
	public FoodTester3()
	{
		//blank
		//no argument
	}
	
	//Code starts running from Main
	public static void main(String[] args)
	{ 
		// Creating and printing details of two food items: baked banana muffins and fried yam fritters
		Food3 food1 = new Food3 ("baked", "bananas", "muffins", 12, 0.60); //12 is number of pieces
		food1.printForSale();											   ///0.60 is cost per piece
		Food3 food2 = new Food3 ("fried", "yams", "fritters", 3, 1.25); //3 is number of pieces
		food2.printForSale();											///1.25 is cost per piece
		
		// Creates a new Pizza object with "pepperoni" and prints it for sale 
		Pizza3 pizza = new Pizza3 ("pepperoni", 8, 2.50); //8 is number of pieces
		pizza.printForSale();							  ///2.50 is cost per piece
		
		// DeepDishPizza3 is called, which extends Pizza3 which extends Food3
		DeepDishPizza3 ddPizza = new DeepDishPizza3 ("rotten bug", 8, 2.50); //8 is number of pieces
		ddPizza.printForSale();												 ///2.50 is cost per piece
	}
}
