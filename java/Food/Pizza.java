public class Pizza extends Food
{
	// Constructor for the Pizza class, initializing with a baked state and given ingredient
	// this is there for when FoodTester and FoodTester2 calls it
	public Pizza(String ingredient)
	{
		super("baked", ingredient, "pizza");
	}

	// Overloaded constructor for the Pizza class, initializing with ingredient and type
	// for DeepDishPizza, so the type of pizza can entered (deep dish pizza)
	public Pizza (String ingredient, String pizzaType)
	{
		super("baked", ingredient, pizzaType);
	}
}
