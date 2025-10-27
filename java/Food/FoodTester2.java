public class FoodTester2
{
	//Nothing in constructor because it is never called
	public FoodTester2()
	{
		//blank
		//no argument
	}
	
	//Code starts running from Main
	public static void main(String[] args)
	{
		// Creating and printing details of two food items: baked banana muffins and fried yam fritters
		Food food1 = new Food ("baked", "bananas", "muffins");
		food1.printForSale();
		Food food2 = new Food ("fried", "yams", "fritters");
		food2.printForSale();

		// Creates a new Pizza object with "pepperoni" and prints it for sale 
		Pizza pizza = new Pizza ("pepperoni");
		pizza.printForSale();

		// DeepDishPizza is called, which extends Pizza which extends Food
		DeepDishPizza deepDish = new DeepDishPizza("rotten bug");
		deepDish.printForSale();
	}
}
