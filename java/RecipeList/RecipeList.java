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
		userRecipes = new String[0];
		recipeDirections = new String[0];
		allIngredients = new String[0];
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

		// Print the Directions to the screen
		printDirections();
		
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
			staples = new Scanner(new File(inFileName));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("The "+inFileName+" file does not exist. So no staples were added.");
		}

		if (staples != null)
		{
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
	}
	
	/* Ask user for recipes*/
	public void getUserRecipes()
	{
		Scanner input = new Scanner(System.in);
		String enteredRecipe = new String();
		userRecipes = new String[0];
		
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
			for(int i = 0; i < recipeDirections.length; i++)
			{
				recipeDirections[i] = "";
			}
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

		boolean foundRecipe = false;
		String nextTerm = new String();
		if (recipes.hasNext())
			nextTerm = recipes.next();
		while(recipes.hasNext())
		{
			// Get all the recipe of the dish
			if(nextTerm.equalsIgnoreCase("Recipe:"))
			{
				nextTerm = recipes.nextLine(); // Takes in the rest of the line and separates the recipe name
				String recipeName = nextTerm.substring(0, nextTerm.indexOf(" -")).trim();
				if(recipeName.equalsIgnoreCase(recipe))
				{
					recipeDirections[recipeIndex] += ("\nRecipe: "+nextTerm.trim());
					foundRecipe = true;
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
							recipeDirections[recipeIndex] += ("\n"+nextTerm);
							boolean startNextRecipe = false; // To check if the Ingredients section started or not
							while(recipes.hasNext() && !startNextRecipe)
							{
								nextTerm = recipes.nextLine();
								if (nextTerm.trim().equalsIgnoreCase("recipe:"))
									startNextRecipe = true;
								else
								{
									recipeDirections[recipeIndex] += ("\n"+nextTerm);
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

		if (!foundRecipe)
		{
			String[] temp1 = allIngredients;
			allIngredients = new String[temp1.length+1];
			for(int i = 0; i < allIngredients.length; i++)
			{
				if (i < temp1.length)
					allIngredients[i] = temp1[i]; 
				else
					allIngredients[i] = recipe;		
			}
		}

		recipes.close();
	}

	public void printShoppingList()
	{
		String[] temp = allIngredients;
		allIngredients = new String[temp.length];
		int[] tempQuantity = new int[allIngredients.length];
		// To look for repeating ingredients
		for (int i = 0; i < temp.length; i++)
		{
			tempQuantity[i] = 1;
			for (int j = 1 + i; j < temp.length && temp[i] != null; j++)
			{
				if (temp[i].equalsIgnoreCase(temp[j]))
				{
					temp[j] = null;
					tempQuantity[i]++;
				}
			}
			if (temp[i] == null)
				tempQuantity[i] = 0;
		}

		// To put all null values at the end of the array
		int[] quantity = new int[allIngredients.length];
		int nullAndBlankCounter = 0;
		for (int i = 0; i < temp.length; i++)
		{
			if(temp[i] != null && !temp[i].equals(""))
			{
				allIngredients[i-nullAndBlankCounter] = temp[i];
				quantity[i-nullAndBlankCounter] = tempQuantity[i];
			}
			else
			{
				nullAndBlankCounter ++;
			}
		}

		// Put all the extra empty values in the array
		outList.printf("%-40s|%15s%n","Item","Quantity");
		for (int i = 0; i < 40; i++)
		{
			outList.print("-");
		}
		outList.print("|");
		for (int i = 0; i < 15; i++)
		{
			outList.print("-");
		}
		outList.println();

		// temp = allIngredients;
		// tempQuantity = quantity;
		// quantity = new int[tempQuantity.length-nullCounter];
		// allIngredients = new String[temp.length-nullCounter];
		for (int i = 0; i < allIngredients.length-nullAndBlankCounter; i++)
		{
			// allIngredients[i] = temp[i];
			// quantity[i] = tempQuantity[i];
			//!if(allIngredients[i].endsWith(")"))
			outList.printf("%-40s|%15d%n",allIngredients[i],quantity[i]);
		}
	}

	public void printDirections()
	{
		System.out.println("\n");
		for(int i = 0; i < recipeDirections.length; i++)
		{
			System.out.print(recipeDirections[i]+"\n");
		}
	}
}
