// Daksh Agrawal
/* Period 7
 * 11/10/2025
 * 
 * Pseudocode (all methods are void (except main) and are public):
 * 	
 * 	import Scanner
 * 	class header
 * 
 * 	private field variables: addingConstant (int), userPattern(String), correctAnswer (int), userNextNum (int)
 * 
 * 	constructor:
 * 		addingConstant (int), userPattern (String), correctAnswer (int), userInput (int) = 0
 * 		
 * 	main: 
 * 		call NumberSequence
 * 		call runGame
 * 	
 * 	runGame:
 * 		print 3 BLs
 * 		print out welcome statement 
 * 		call newSequence
 * 		call getNum
 * 		call getPattern
 * 		print 3 BLs
 * 		
 * 	newSequence:
 * 		startNum (int) = using Math.random(), make a random number between 0-10
 * 		also make another random number (1-2) to make a an if statement, if number is 1 multiply startNum by -1 
 * 		
 * 		addingConstant = random number between 1-10
 * 		using a for loop print the first number and print 2nd, 3rd, 4th, 5th numbers that are
 * 		 incrementing in the variable called i (int) using this formula- startNum + (addingConstant*i)
 * 		
 * 		correctAnswer = startNum + (addingConstant*5) since it is the 6th number in the sequence
 * 		
 * 	getNum: 
 * 		instantiate Scanner
 * 		
 * 		prompt user for next number and store value in userInput
 * 		for loop that ends when it has ran 3 times or when userNextNum==correctAnswer
 * 			prompt user for next number after saying try again and store value in userInput
 * 	
 * 	getPattern:
 * 		instantiate Scanner
 * 
 * 		D&I userStringPattern (String)
 * 
 * 		prompt user for pattern	
 * 		input a String in userStringPattern
 * 		
 * 		check if userStringPattern equals "increment by"+addingConstant 
 * 			and print "Correct. It was increment by"+addingConstant
 * 
 * 		or else if userStringPattern equals "add "+addingConstant 
 * 			and print "Correct. It was add "+addingConstant
 * 
 * 		or else if userStringPattern equals "add by"+addingConstant 
 * 			and print "Correct. It was add by "+addingConstant
 * 
 * 		or else if userStringPattern equals "plus "+addingConstant 
 * 			and print "Correct. It was plus "+addingConstant
 * 
 * 		or else
 * 			print "Incorrect. It was add "+addingConstant
 * 
 * 		
 * 
 * 
 * Testing: 
 * 
 */
import java.util.Scanner;

public class NumberSequence
{
	private int addingConstant;
	private String userPattern;
	private int correctAnswer;
	private int userNextNum;
	
	public NumberSequence()
	{
		addingConstant = 0;
		userPattern = "?";
		correctAnswer = 0;
		userNextNum = 0;
	}
	
	public static void main(String[] args)
	{
		NumberSequence ns = new NumberSequence();
		ns.runGame();
	}
	
	public void runGame()
	{
		System.out.println("\n\n\nWelcome to the Sequence Finder 🔍! "
						 + " Where you will have to find the next number"
						 + " in a linear sequence!! And then find the its "
						 + "pattern!!!");
   		newSequence();
  		getNum();
  		getPattern();
  		System.out.println("\n");
	}
	
	public void newSequence()
	{
		int startNum = (int)(Math.random()*11);
  		if ((int)(Math.random()*2)==1)
  		{
			startNum = startNum*-1;
		}
  		
  		addingConstant = (int)(Math.random()*10+1);
  		
		for(int i=0;i<5;i++)
		{
			System.out.print((startNum+(i*addingConstant))+", ");
		}
		System.out.print("_");
  		
  		correctAnswer = startNum + (addingConstant*5);
	}
	
	public void getNum()
	{
		Scanner input = new Scanner(System.in);
		
  		System.out.print("\nWhat's the next number? ");
  		userNextNum = input.nextInt();
  		
  		for(int i=1; ((i<3) || (userNextNum==correctAnswer)); i++)
  		{
			System.out.print("Try again. What's the next number? ");
			userNextNum = input.nextInt();
		}
	}
	
	public void getPattern()
	{
		
  		Scanner input = new Scanner(System.in);
  
  		String userStringPattern = new String();
 
		System.out.print("\nWhat's the pattern? ");
		userPattern = input.nextLine();
 		
		if (userPattern.equalsIgnoreCase("increment by"+addingConstant))
			System.out.println("Correct. It was increment by"+addingConstant);
 
 		else if (userPattern.equalsIgnoreCase("add "+addingConstant))
 			System.out.println("Correct. It was add "+addingConstant);

 		else if (userPattern.equalsIgnoreCase("add by"+addingConstant))
			System.out.println("Correct. It was add by "+addingConstant);

		else if (userPattern.equalsIgnoreCase("plus "+addingConstant))
			System.out.println("Correct. It was plus "+addingConstant);
		else
			System.out.println("Incorrect. It was add "+addingConstant);
 		
	}
}
