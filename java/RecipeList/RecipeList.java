// Daksh Agrawal
/* Period 7
* 01/06/2026
* 
* RecipeList.java
* 
* >Objective:
* 
* >Description:
*
* >Learning:
*
* >Pseudocode:
* 		
*
* >Testing:
*
*   
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RecipeList
{
	private PrintWriter outList;
	private String[] userRecipes;
	private String outFileName;
	private String[] recipeDirections;
	private String[] allIngredients;
	
	public RecipeList()
	{
		outList = null;
		userRecipes = new String[]{};
		recipeDirections = new String[]{};
		allIngredients = new String[]{};
		outFileName = new String("ShoppingList.txt");
	}
	
	public static void main(String[] args)
	{
		RecipeList rl = new RecipeList();
		rl.makeList();
	}
	
	public void makeList()
	{
		System.out.println("\n\n");
		
		makeShoppingList();
		getStaples();
		
		getUserRecipes();
		
		// Finds the ingredients for each recipe
		for (int i = 0; i < userRecipes.length; i++)
		{
			getIngredientsAndRecipe(userRecipes[i],i);
		}
		
		// Print the ingredients in ShoppingList
		printShoppingList();
		
		outList.close();
		System.out.println("\n\n");
	}
	
	/* Creates a ShoppingList.txt PrintWriter*/
	public void makeShoppingList()
	{
		try
		{
			outList = new PrintWriter(new File(outFileName));
		}
		catch (IOException e)
		{
			System.err.println("Cannot create "+outFileName+" file to be written to.");
			System.exit(1);
		}
	}
	
	/* Gets the staples from staples.txt and put it in the ShoppingList.txt*/
	public void getStaples()
	{
		String inFileName = new String("Staples.txt");
		Scanner staples = null;
		try 
		{
			staples = new Scanner(new File(outFileName));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("The "+outFileName+" file does not exist.");
		}
		
		while(staples.hasNextLine())
		{
			String nextIngredient = staples.nextLine().trim(); // This is the next ingredient
			String[] temp = allIngredients;
			allIngredients = new String[temp.length+1];
			for(int i = 0; i < allIngredients.length; i++)
			{
				if (i < temp.length)
					allIngredients[i] = temp[i]; 
				else
					allIngredients[i] = nextIngredient;		
			}
		}
		
		staples.close();
	}
	
	/* Ask user for recipes*/
	public void getUserRecipes()
	{
		Scanner input = new Scanner(System.in);
		String enteredRecipe = new String();
		userRecipes = new String[1];
		
		System.out.println("Enter the recipes you want to make today (write \"Quit\" when you are done):");
		while(!enteredRecipe.equalsIgnoreCase("quit"))
		{
			System.out.print("\t=> ");
			enteredRecipe = input.nextLine().trim();
			
			if(!enteredRecipe.equalsIgnoreCase("quit"))
			{
				String[] temp = userRecipes;
				userRecipes = new String[temp.length+1];
				for(int i = 0; i < userRecipes.length; i++)
				{
					if (i < temp.length)
						userRecipes[i] = temp[i]; 
					else
						userRecipes[i] = enteredRecipe;
				}
			}
			
			recipeDirections = new String[userRecipes.length];
		}
	}

	/* Finds the recipe and stores its ingredients in ShoppingList.txt */
	public void getIngredientsAndRecipe(String recipe, int recipeIndex)
	{
		String inFileName = new String("Recipes.txt");
		Scanner recipes = null;
		try 
		{
			recipes = new Scanner(new File(inFileName));
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Cannot find "+inFileName+" file.");
			System.exit(2);
		}

		String nextTerm = new String();
		if (recipes.hasNext())
			nextTerm = recipes.next();
		while(recipes.hasNext())
		{
			// Get all the recipe of the dish
			if(nextTerm.equalsIgnoreCase("Recipe:"))
			{
				recipeDirections[recipeIndex] += (""+nextTerm);
				nextTerm = recipes.nextLine(); // Takes in the rest of the line and separates the recipe name
				recipeDirections[recipeIndex] += (""+nextTerm);
				String recipeName = nextTerm.substring(0, nextTerm.indexOf(" -")).trim();
				if(recipeName.equalsIgnoreCase(recipe))
				{
					boolean startIngredients = false; // To check if the Ingredients section started or not
					while(recipes.hasNext() && !startIngredients)
					{
						nextTerm = recipes.nextLine();
						if (nextTerm.trim().equalsIgnoreCase("ingredients:"))
							startIngredients = true;
					}
					// Get all the ingredients for the recipe
					if (startIngredients)
					{
						boolean startDirections = false; // To check if Directions section started yet or not
						while(recipes.hasNext() && !startDirections)
						{
							nextTerm = recipes.nextLine();
							String nextIngredient = nextTerm.trim(); // This is the next ingredient
							if (nextIngredient.equalsIgnoreCase("directions:"))
								startDirections = true;
							else
							{
								String[] temp1 = allIngredients;
								allIngredients = new String[temp1.length+1];
								for(int i = 0; i < allIngredients.length; i++)
								{
									if (i < temp1.length)
										allIngredients[i] = temp1[i]; 
									else
										allIngredients[i] = nextIngredient;		
								}
							}
						}
						if (startDirections)
						{
							recipeDirections[recipeIndex] += (""+nextTerm);
							boolean startNextRecipe = false; // To check if the Ingredients section started or not
							while(recipes.hasNext() && !startNextRecipe)
							{
								nextTerm = recipes.nextLine();
								if (nextTerm.trim().equalsIgnoreCase("recipe:"))
									startNextRecipe = true;
								else
								{
									recipeDirections[recipeIndex] += (""+nextTerm);
								}
							}
						}
					}
				}
			}
			else
			{
				nextTerm = recipes.next();
			}
		}
	}

	public void printShoppingList()
	{
		
	}
}
