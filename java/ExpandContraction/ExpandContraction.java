// Daksh Agrawal
/* Period 7
* 01/05/2026
* 
* ExpandContraction.java
* 
* >Description: In the English Language, words can be combined together 
* 				to form contractions. This program takes in contractions 
* 				and gives out the expanded version of the contraction.
*
* >Learning: String Methods, do-while loops, complex if-else statements, etc.
* 		
*
* >Testing:
*
*   
*/

import java.util.Scanner;

public class ExpandContraction
{
    private String contracted;
    private String expanded;
    private Scanner kb;

    public ExpandContraction() // this is the constructor
    {
		contracted = new String();
		expanded = new String();
		kb = new Scanner(System.in);
    }

    public static void main(String[] args)
    {
        ExpandContraction ec = new ExpandContraction();
        ec.expandIt();
    }

    public void expandIt()
    {
		System.out.print("\n\n\n");
		System.out.println("In the English Language, words can be combined"
						 + " together to form contractions. This program "
						 + "takes in contractions and gives out the expanded"
						 + " version of the contraction. So...");
		boolean nextRun = true;
        do
        {
            getInput();
            boolean shouldPrint = processString();
            printResult(shouldPrint);
            System.out.println("\nWould you like to expand another contraction? "
							 + "Type quit to stop.");
            if (kb.next().equalsIgnoreCase("quit"))
				nextRun = false;
				
        }
        while (nextRun);
		System.out.print("\n\n\n");
    }

    public void getInput()
    {
        System.out.println("\nWhat contraction would you like to expand?");
        contracted = kb.next();
    }

    public boolean processString()
    {
		if (contracted.equalsIgnoreCase("shant"))
			expanded = "shall not";
		else if (contracted.equalsIgnoreCase("won't"))
			expanded = "will not";
		else if (contracted.equalsIgnoreCase("can't"))
			expanded = "cannot";
		else 
		{
			int contractedLength = contracted.length()-1;
			if (contractedLength<=1 || !contracted.substring(contractedLength-2).equalsIgnoreCase("n't"))
			{
				System.out.println("The specified contraction is invalid.");
				return false;
			}
			else
			{
				String wordWithoutContraction = new String(contracted.substring(0,contractedLength-2));
				expanded = wordWithoutContraction + " not";
			}
		}
		return true;
    }

    public void printResult(boolean printing)
    {
		if(printing)
			System.out.println("The expanded form of "+contracted+" is "+expanded+".");
    }
} // closes class

