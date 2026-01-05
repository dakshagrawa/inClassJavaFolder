// Daksh Agrawal
/* Period 7
* 01/05/2026
* 
* ExpandContraction.java
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
        do
        {
			boolean nextRun = true;
            getInput();
            processString();
            printResult();
            System.out.println("\nWould you like to expand another contraction? Type quit to stop");
            if (kb.next().equalsIgnoreCase("quit"))
				nextRun = false;
				
        }
        while (nextRun);
		System.out.print("\n\n\n");
    }

    public void getInput()
    {
        System.out.println("What contraction would you like to expand?");
        contracted = kb.next();
    }

    public void processString()
    {
		if (contracted.equalsIgnoreCase("shant"))
			expanded = "shall not";
		else if (contracted.equalsIgnoreCase("won't"))
			expanded = "would not";
		else if (contracted.equalsIgnoreCase("can't"))
			expanded = "can not";
		else 
		{
			int contractedLength = contracted.length()-1;
			if (contracted.substring(contractedLength-2).equalsIgnoreCase("n't"))
				{
					String wordWithoutContraction = new String(contracted.substring(0,contractedLength-2));
					expanded = wordWithoutContraction + " not";
				}
			else
				System.out.println("The specified contraction is invalid.");
		}
    }

    public void printResult()
    {
		System.out.println("The expanded form of "+contracted+" is "+expanded+".");
    }
} // closes class

