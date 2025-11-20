// Daksh Agrawal
/* Period 7
 * 11/10/2025
 * 
 * >Description: Generates a random arithmetic sequence, asks the user to guess
 *              the next number in the sequence, and then asks them to identify
 *              the pattern used.
 * 
 * >Learning: Using loops, if statements, etc. 
 * 
 * >Pseudocode (all methods are void (except main) and are public):
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
 * 		also make another random number (1-2) to make a an if statement, if the number 
 * 		 is 1, multiply startNum by -1 
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
 * >Testing: 
 * 	1. Try incorrect answers for the next number in the sequence, that are a clear 
 * 		wrong answer and try until the program gives the right answers after 3 tries. 
 * 		Then also check for the next number in sequence value by just typing in the 
 * 		right answer and see if it accepts it.  
 * 	2. For testing the pattern statement, start by entering random strings and seeing
 * 		if the user's answers are valid or not and work through the if statements by it.
 * 
 */

import java.util.Scanner;

public class NumberSequence
{
    // Field variables to store the increment constant and the correct answer
    private int addingConstant;
    private int correctAnswer;
    
    // Constructor initializes fields to 0
    public NumberSequence()
    {
        addingConstant = 0;
        correctAnswer = 0;
    }
    
    // Main method: entry point of the program
    public static void main(String[] args)
    {
        NumberSequence ns = new NumberSequence(); // create an object
        ns.runGame(); // start the game
    }
    
    // Runs the game: prints welcome message, generates sequence, checks answers
    public void runGame()
    {
        System.out.println("\n\n\nWelcome to the Sequence Finder!\t"
                         + "Where you will have to find the next number"
                         + " in a linear sequence!! And then find the its "
                         + "pattern!!!");
        newSequence();     // generate and display sequence
        checkNextNum();    // ask user to guess next number
        checkPattern();    // ask user to guess the pattern
        System.out.println("\n");
    }
    
    // Generates a random arithmetic sequence and stores the correct answer
    public void newSequence()
    {
        final int NUMOFTERMS = 5; // number of terms to display

        // Generate random starting number between 0–10
        int startNum = (int)(Math.random()*11);

        // Randomly decide if startNum should be negative
        if ((int)(Math.random()*2)==1)
        {
            startNum = startNum*-1;
        }
        
        // Generate random increment constant between 1–10
        addingConstant = (int)(Math.random()*10+1);
        
        // Print first 5 terms of the sequence
        for(int i=0;i<NUMOFTERMS;i++)
        {
            System.out.print((startNum+(i*addingConstant))+", ");
        }
        System.out.println("_"); // placeholder for the missing 6th term
        
        // Store the correct 6th term
        correctAnswer = startNum + (addingConstant*NUMOFTERMS);
    }
    
    // Prompts user to guess the next number in the sequence
    public void checkNextNum()
    {
        Scanner input = new Scanner(System.in);
        int userNextNum = 0;
        
        // First attempt
        System.out.print("What's the next number in this sequence (answer only as integers)? ");
        userNextNum = input.nextInt();
        
        // Allow up to 2 retries if incorrect
        for(int i=1;i<3; i++)
        {
            if (userNextNum==correctAnswer) 
                i=3; // exit loop early if correct
            else
            {
                System.out.print("Try again. What could the next number be? ");
                userNextNum = input.nextInt();
            }
        }

        // Final check after attempts
        if (userNextNum==correctAnswer)
        {
            System.out.println("Correct! The next number is "+correctAnswer+".");
        }
        else
        {
            System.out.println("Try again next time, the next number in this sequence is actually "+correctAnswer+".");
        }
    }
    
    // Prompts user to guess the pattern used in the sequence
    public void checkPattern()
    {
        Scanner input = new Scanner(System.in);

        String userPattern = new String("?");

        // Ensure user enters a non-empty string
        do
        {
            System.out.print("What's the pattern between each of the numbers (example answer: add 8)? ");
            userPattern = input.next() + " " +input.next();
            if (userPattern.equalsIgnoreCase("increment by")) 
            {
				userPattern += " "+input.next();
			}
        } while (userPattern.equals(""));

        // Check multiple possible correct phrasings
        if (userPattern.equalsIgnoreCase("increment by "+addingConstant))
            System.out.println("Correct. It was increment by "+addingConstant);
 
        else if (userPattern.equalsIgnoreCase("add "+addingConstant))
            System.out.println("Correct. It was add "+addingConstant);

        else if (userPattern.equalsIgnoreCase("add by"+addingConstant))
            System.out.println("Correct. It was add by "+addingConstant);

        else if (userPattern.equalsIgnoreCase("plus "+addingConstant))
            System.out.println("Correct. It was plus "+addingConstant);

        else if (userPattern.equalsIgnoreCase(""+addingConstant))
            System.out.println("Correct. It was adding "+addingConstant+" to each number!");
        
        else if (userPattern.equalsIgnoreCase("+"+addingConstant))
            System.out.println("Correct. It was +"+addingConstant);

        else
            System.out.println("Close! It was actually, add "+addingConstant);
        
    } 
}
