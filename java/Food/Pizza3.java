public class Pizza3 extends Food3
{
	// Constructor for the Pizza class, initializing with a baked state and given ingredient,
	// this is there for when FoodTester3 calls it
	public Pizza3(String ingredient, int numOfPieces, double piecesCost)
	{	
		super("baked", ingredient, "pizza", numOfPieces, piecesCost);
	}
	
	// Overloaded constructor for the Pizza class, initializing with ingredient and type
	// for DeepDishPizza, so the type of pizza can entered (deep dish pizza)
	public Pizza3(String ingredient, String typeOfPizza, int numOfPieces, double piecesCost)
	{	
		super("baked", ingredient, typeOfPizza, numOfPieces, piecesCost);
	}
}
