public class Pizza extends Food
{
	public Pizza(String ingredient)
	{
		super("baked", ingredient, "pizza");
	}
	public Pizza (String ingredient, String pizzaType)
	{
		super("baked", ingredient, pizzaType);
	}
}
