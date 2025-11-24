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
    private int changingConstant;
    private int correctAnswer;
    
    // Constructor initializes fields to 0
    public NumberSequenceExtraCredit()
    {
        changingConstant = 0;
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

        // Generate random increment constant between 1–10
        changingConstant = (int)(Math.random()*10+1);

        // Randomly decide if changingConstant should be adding or subtracting
        boolean subtracting = false;
        if ((int)(Math.random()*2)==1)
        {
            subtracting = true;
            changingConstant = changingConstant*-1;
        }
        
        // Generate random starting number between 0–10
        int startNum = (int)(Math.random()*11);

        // Randomly decide if startNum should be negative
        if ((int)(Math.random()*2)==1 && !subtracting)
        {
            startNum = startNum*-1;
        }
        
        // Print first 5 terms of the sequence
        newSequenceLoop(startNum, NUMOFTERMS, 0);
        System.out.println("_"); // placeholder for the missing 6th term
        
        // Store the correct 6th term
        correctAnswer = startNum + (NUMOFTERMS*changingConstant);
}
    
    // Prompts user to guess the next number in the sequence
    public void checkNextNum()
    {
        Scanner input = new Scanner(System.in);
        int userNextNum = 0;
        
        // First attempt
        System.out.print("What's the next number in this sequence (answer only as an integer)? ");
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
        //do
        //{
        System.out.print("What's the pattern between each of the numbers (example answer: add 8)? ");
        userPattern = input.next();
        if (!(userPattern.equalsIgnoreCase("+"+changingConstant) || userPattern.equalsIgnoreCase(""+changingConstant)))
        {
            userPattern += " "+input.next();
        }
        if (userPattern.equalsIgnoreCase("increment by") || userPattern.equalsIgnoreCase("decrement by")) 
        {
            userPattern += " "+input.next();
        }
        //} while (userPattern.equals(""));

        userPattern = userPattern.trim();

        // Check multiple possible correct phrasings
        if (userPattern.equalsIgnoreCase("increment by " + changingConstant) && changingConstant > 0) 
        {
            System.out.println("Correct. It was increment by " + changingConstant);
        } 
        else if (userPattern.equalsIgnoreCase("add " + changingConstant) && changingConstant > 0) 
        {
            System.out.println("Correct. It was add " + changingConstant);
        }
        else if (userPattern.equalsIgnoreCase("add by " + changingConstant) && changingConstant > 0) 
        {
            System.out.println("Correct. It was add by " + changingConstant);
        }
        else if (userPattern.equalsIgnoreCase("plus " + changingConstant) && changingConstant > 0) 
        {
            System.out.println("Correct. It was plus " + changingConstant);
        }
        else if (userPattern.equalsIgnoreCase("+" + changingConstant) && changingConstant > 0) 
        {
            System.out.println("Correct. It was +" + changingConstant);
        }
        else if (userPattern.equalsIgnoreCase("+ " + changingConstant) && changingConstant > 0) 
        {
            System.out.println("Correct. It was + " + changingConstant);
        }
        
        // --- Subtraction Phrasings (Only check if changingConstant is negative) ---
        // Note: We use absConstant for the number in the phrase (e.g., "subtract 5")
        else if (userPattern.equalsIgnoreCase("decrement by " + -changingConstant) && changingConstant < 0) 
        {
            System.out.println("Correct. It was decrement by " + -changingConstant);
        } 
        else if (userPattern.equalsIgnoreCase("subtract " + -changingConstant) && changingConstant < 0) 
        {
            System.out.println("Correct. It was subtract " + -changingConstant);
        }
        else if (userPattern.equalsIgnoreCase("subtract by " + -changingConstant) && changingConstant < 0) 
        {
            System.out.println("Correct. It was subtract by " + -changingConstant);
        }
        else if (userPattern.equalsIgnoreCase("minus " + -changingConstant) && changingConstant < 0) 
        {
            System.out.println("Correct. It was minus " + -changingConstant);
        }
        else if (userPattern.equalsIgnoreCase("-" + -changingConstant) && changingConstant < 0) 
        {
            System.out.println("Correct. It was -" + -changingConstant);
        } 
        else if (userPattern.equalsIgnoreCase("- " + -changingConstant) && changingConstant < 0) 
        {
            System.out.println("Correct. It was - " + -changingConstant);
        } 
        
        // --- Fallback/Incorrect Answers (Retaining original structure) ---
        else if (changingConstant > 0)
            System.out.println("Close! It was actually, add "+changingConstant);

        else if (changingConstant < 0)
            System.out.println("Close! It was actually, subtract "+-changingConstant);

        else
            System.out.println("\n\n~ERROR~\n"); // If all statements are untrue, it will be an error
        
    }

/*RECURSION METHODS: */

    public void newSequenceLoop(int start, int TERMS, int counter)
    {
        if (counter==TERMS)
        {}
        else 
        {
            System.out.print((start+(counter*changingConstant))+", ");
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
}