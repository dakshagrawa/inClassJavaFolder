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

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RecipeList
{
	private PrintWriter outList;
	private String[] userRecipes;
	
	public RecipeList()
	{
		outList = null;
		userRecipes = new String[]{};
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
			getIngredients(userRecipes[i]);
		}
		
		outList.close();
		System.out.println("\n\n");
	}
	
	/* Creates a ShoppingList.txt PrintWriter*/
	public void makeShoppingList()
	{
		String outFileName = new String("ShoppingList.txt");
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
		String outFileName = new String("Staples.txt");
		Scanner staples = null;
		try 
		{
			staples = new Scanner(new File(outFileName));
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Cannot find "+outFileName+" file.");
			System.exit(2);
		}
		
		while(staples.hasNextLine())
		{
			outList.print(Staples.nextLine());
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
		}
		
		/* Finds the recipe and stores its ingredients in ShoppingList.txt */
		public void getIngredients(String recipe)
		{
			
		}
	}
}
