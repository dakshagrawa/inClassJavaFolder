// Daksh Agrawal
/* Period 7
 * 11/10/2025
 * 
 * >Description: Generates a random arithmetic sequence, asks the user to guess
 *              the next number in the sequence, and then asks them to identify
 *              the pattern used.
 * 
 * >Learning: Using recursions, if statements, etc. 
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

public class NumberSequenceExtraCredit
{
    // Field variables to store the increment constant and the correct answer
    private int addingConstant;
    private int correctAnswer;
    
    // Constructor initializes fields to 0
    public NumberSequenceExtraCredit()
    {
        addingConstant = 0;
        correctAnswer = 0;
    }
    
    // Main method: entry point of the program
    public static void main(String[] args)
    {
        NumberSequenceExtraCredit nsec = new NumberSequenceExtraCredit(); // create an object
        nsec.runGame(); // start the game
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
        newSequenceLoop(startNum, NUMOFTERMS, 0);
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
        userNextNum = checkNextNumLoop(userNextNum,3);

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
        userPattern = checkPatternLoop(userPattern); // This is calling the recursion method

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

/*RECURSION METHODS: */

    public void newSequenceLoop(int start, int TERMS, int counter)
    {
        if (counter==TERMS)
        {}
        else 
        {
            System.out.print((start+(counter*addingConstant))+", ");
            counter++;
            newSequenceLoop(start,TERMS,counter);
        }

    }

    // Allow up to 2 retries if user enters an incorrect answer each time
    public int checkNextNumLoop(int userNextNumInLoop, int counter)
    {
        Scanner input = new Scanner(System.in);
        
        if (userNextNumInLoop==correctAnswer || counter==1) 
            return userNextNumInLoop; // exit early if correct
        else
        {
            System.out.print("Try again. What could the next number be? ");
            counter--;
            return checkNextNumLoop(input.nextInt(),counter); //? Why does counter-- not work when put into method values?
        }
    }

    
    // Ensure user enters a non-empty string when entering pattern
    public String checkPatternLoop(String userPatternInLoop)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("What's the pattern between each of the numbers (example answer: add 8)? ");
        userPatternInLoop = input.next() + " " +input.next();
        if (userPatternInLoop.equalsIgnoreCase("increment by")) 
        {
            userPatternInLoop += " "+input.next();
        }
        if (userPatternInLoop.equals(""))
            return checkPatternLoop(userPatternInLoop);
        else
            return userPatternInLoop;
    }
    
}
