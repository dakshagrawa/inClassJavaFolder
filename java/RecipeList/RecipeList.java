// Daksh Agrawal
/* Period 7
* 02/02/2026
*
* RecipeList.java
*
* > Objective:
*   Build a shopping list by combining:
*     - Staples from Staples.txt
*     - Ingredients from user-selected recipes in Recipes.txt
*   Also print each recipe’s directions to the console.
*
* > Description:
*   This program:
*     1. Creates/opens ShoppingList.txt for output
*     2. Loads staple ingredients
*     3. Prompts the user for recipes they want to cook
*     4. For each recipe:
*          - Reads its ingredients from Recipes.txt
*          - Reads its directions
*          - Adds ingredients to a master list
*     5. Combines duplicate ingredients and sums their quantities
*     6. Prints a formatted shopping list to the output file
*     7. Prints all recipe directions to the console
*
* > Learning:
*   - File input/output using Scanner and PrintWriter
*   - Dynamic array resizing through manual copying
*   - String parsing and substring extraction
*   - Multi-step file parsing using markers ("Recipe:", "Ingredients:", "Directions:")
*   - Data aggregation and formatted output
*
* > Pseudocode:
*
*   MAIN:
*     create RecipeList object
*     call makeList()
*
*   makeList():
*     print spacing
*     create output file
*     load staples
*     ask user for recipe names
*     for each recipe:
*         read ingredients and directions
*     print shopping list to file
*     print directions to console
*     close output file
*
*   getStaples():
*     open Staples.txt
*     for each line:
*         ensure ingredient has "(1)"
*         append to allIngredients
*
*   getUserRecipes():
*     repeatedly ask user for recipe names until "quit"
*     dynamically grow userRecipes array
*     reset recipeDirections array to match size
*
*   getIngredientsAndRecipe(recipe, index):
*     extract user quantity if recipe contains "(x)"
*     strip parentheses from recipe name
*     open Recipes.txt
*     scan until matching "Recipe:" section found
*     when found:
*         read ingredients until "Directions:"
*         add each ingredient to allIngredients
*         read directions until next "Recipe:"
*         store directions in recipeDirections[index]
*     if recipe not found:
*         add recipe name as ingredient with user quantity
*
*   printShoppingList():
*     combine duplicate ingredients
*     sum quantities
*     format table with columns:
*         Item | Quantity
*     print each ingredient and its combined quantity
*
*   printDirections():
*     print each recipe’s directions to the console
*
*
* > Testing:
*   - Test with no Staples.txt
*   - Test with multiple recipes
*   - Test with recipes that include quantities (e.g., "Pasta (3)")
*   - Test with missing recipe in Recipes.txt
*   - Test duplicate ingredients across recipes
*
*/


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RecipeList
{
	private PrintWriter outList;          // output file writer
	private String[] userRecipes;         // stores recipes user wants
	private String outFileName;           // name of output file
	private String[] recipeDirections;    // stores directions for each recipe
	private String[] allIngredients;      // master list of all ingredients
	
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
		RecipeList rl = new RecipeList();  // create object
		rl.makeList();                     // run main workflow
	}
	
	public void makeList()
	{
		System.out.println("\n\n");        // spacing for readability
		
		makeShoppingList();                // open output file
		getStaples();                      // load staple ingredients
		
		getUserRecipes();                  // ask user for recipes
		
		// Finds the ingredients for each recipe
		for (int i = 0; i < userRecipes.length; i++)
		{
			getIngredientsAndRecipe(userRecipes[i],i);  // read ingredients + directions
		}
		
		printShoppingList();               // write shopping list to file
		printDirections();                 // print directions to console
		
		outList.close();                   // close output file
		System.out.println("\n\n");
	}
	
	/* Creates a ShoppingList.txt PrintWriter*/
	public void makeShoppingList()
	{
		try
		{
			outList = new PrintWriter(new File(outFileName));  // create output file
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
			staples = new Scanner(new File(inFileName));  // open staples file
		}
		catch (FileNotFoundException e)
		{
			System.out.println("The "+inFileName+" file does not exist. So no staples were added.");
		}

		if (staples != null)
		{
			while(staples.hasNextLine())
			{
				String nextIngredient = staples.nextLine().trim();  // read line

				if(nextIngredient.equals("")) continue;             // skip blanks

				if(!nextIngredient.contains("("))
					nextIngredient += " (1)";                       // default quantity

				// add staple to allIngredients
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
			enteredRecipe = input.nextLine().trim();   // read user input
			
			if(!enteredRecipe.equalsIgnoreCase("quit"))
			{
				// grow userRecipes array
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
			
			// reset directions array to match recipe count
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
		int userQty = 1;  // default quantity
		
		// extract quantity from "(x)" if present
		if(recipe.contains("(") && recipe.contains(")"))
		{
			try
			{
				String num = recipe.substring(recipe.indexOf("(")+1, recipe.indexOf(")")).trim();
				userQty = Integer.parseInt(num);
			}
			catch(Exception e)
			{
				userQty = 1;  // fallback
			}
		}

		// remove "(x)" from recipe name
		if(recipe.contains("("))
			recipe = recipe.substring(0, recipe.indexOf("(")).trim();

		String inFileName = new String("Recipes.txt");
		Scanner recipes = null;
		try 
		{
			recipes = new Scanner(new File(inFileName));  // open recipes file
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Cannot find "+inFileName+" file.");
			System.exit(2);
		}

		boolean foundRecipe = false;
		String nextTerm = new String();

		if (recipes.hasNext())
			nextTerm = recipes.next();  // read first token

		while(recipes.hasNext())
		{
			// Get all the recipe of the dish
			if(nextTerm.equalsIgnoreCase("Recipe:"))
			{
				nextTerm = recipes.nextLine();  // read recipe title line
				String recipeName = nextTerm.substring(0, nextTerm.indexOf(" -")).trim();
				
				if(recipeName.equalsIgnoreCase(recipe))
				{
					recipeDirections[recipeIndex] += ("\nRecipe: "+nextTerm.trim());  // store title
					foundRecipe = true;
					
					boolean startIngredients = false;
					
					// move to "Ingredients:" section
					while(recipes.hasNext() && !startIngredients)
					{
						nextTerm = recipes.nextLine();
						if (nextTerm.trim().equalsIgnoreCase("ingredients:"))
							startIngredients = true;
					}
					// Get all the ingredients for the recipe
					if (startIngredients)
					{
						boolean startDirections = false;

						// read ingredients until "Directions:"
						while(recipes.hasNext() && !startDirections)
						{
							nextTerm = recipes.nextLine();
							String nextIngredient = nextTerm.trim();

							if(nextIngredient.equals("")) continue;  // skip blanks

							if (nextIngredient.equalsIgnoreCase("directions:"))
								startDirections = true;
							else
							{
								if(!nextIngredient.contains("("))
									nextIngredient += " (1)";  // default quantity

								// SCALING FIX: add ingredient userQty times
								for(int r = 0; r < userQty; r++)
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
						}

						// read directions
						if (startDirections)
						{
							recipeDirections[recipeIndex] += ("\n"+nextTerm);
							boolean startNextRecipe = false; // To check if the Ingredients section started or not
							while(recipes.hasNext() && !startNextRecipe)
							{
								nextTerm = recipes.nextLine();

								if (nextTerm.trim().toLowerCase().startsWith("recipe:"))
									break;

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
				nextTerm = recipes.next();  // keep scanning
			}

			if (!recipes.hasNext()) break;
			nextTerm = recipes.next();
		}

		// if recipe not found, add placeholder ingredient
		if (!foundRecipe)
		{
			String[] temp1 = allIngredients;
			allIngredients = new String[temp1.length+1];
			for(int i = 0; i < allIngredients.length; i++)
			{
				if (i < temp1.length)
					allIngredients[i] = temp1[i]; 
				else
					allIngredients[i] = recipe + " (" + userQty + ")";      
			}
		}

		recipes.close();
	}

	public void printShoppingList()
	{
		String[] temp = allIngredients;               // copy ingredients
		allIngredients = new String[temp.length];     // new array for cleaned list
		String[] tempQuantity = new String[allIngredients.length];

		// combine duplicates
		for (int i = 0; i < temp.length; i++)
		{
			String item = temp[i];
			int qty = 1;

			// extract quantity from "(x)"
			if(item != null && item.contains("(") && item.contains(")"))
			{
				try
				{
					String num = item.substring(item.indexOf("(")+1, item.indexOf(")")).trim();
					qty = Integer.parseInt(num);
				}
				catch(NumberFormatException e)
				{
					qty = 1;
				}
			}

			tempQuantity[i] = "(" + qty + ")";

			// merge duplicates
			for (int j = 1 + i; j < temp.length && temp[i] != null; j++)
			{
				if (temp[i].equalsIgnoreCase(temp[j]))
				{
					temp[j] = null;
					tempQuantity[i] = "(" + tempQuantity[i].substring(1, tempQuantity[i].length()-1) + " + " + qty + ")";
				}
			}
		}

		String[] quantity = new String[allIngredients.length];
		for(int i = 0; i < quantity.length; i++) quantity[i] = "";
		int nullAndBlankCounter = 0;

		// remove nulls and blanks
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

		// print table header
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

		// print each ingredient row
		for (int i = 0; i < allIngredients.length-nullAndBlankCounter; i++)
		{
			outList.printf("%-40s| %s%n", allIngredients[i], quantity[i]);
		}
	}

	public void printDirections()
	{
		System.out.println("\n");
		
		// print stored directions
		for(int i = 0; i < recipeDirections.length; i++)
		{
			System.out.print(recipeDirections[i]+"\n");
		}
	}
}
