public class FoodTester
{
	public FoodTester()
	{
		
	}
	
	public static void main(String[] args)
	{
		Food food1 = new Food ("baked", "banana", "muffins");
		food1.printForSale();
		Food food2 = new Food ("fried", "yam", "fritters");
		food2.printForSale();
		Pizza pizza = new Pizza ("pepperoni");
		pizza.printForSale();
		DeepDishPizza deepDish = new DeepDishPizza("rotten bug");
		deepDish.printForSale();
	}
}
