// Daksh Agrawal
/* Period 7
* 01/27/2026
* 
* Worksheet.java
* 
* >objective:
*     to generate a worksheet containing random addition and subtraction problems
*     based on user‑selected number ranges and question count.
*
* >description:
*     this program asks the user for the number of questions, the minimum and maximum
*     values allowed in each problem, and the name of the output file. it then creates
*     a worksheet file containing formatted math questions and an answer key.
*
* >learning:
*     practice using arrays, random number generation, user input, file output,
*     formatted printing.
*
* >pseudocode:
*     class header
*
*         declare int array num1
*         declare int array num2
*         declare int array answers
*         declare string filename
*         declare printwriter output
*
*         constructor:
*             initialize arrays as empty
*             initialize filename and output
*
*         main :
*             create worksheet object
*             call makeworksheet
*
*         makeworksheet:
*             print blank lines
*             get number of questions from user
*             get minimum value from user
*             get maximum value from user
*             get output filename from user
*             generate random values and answers
*             create output file
*             print all questions to file
*             print answer key to file
*             close file
*
*         getnumofquestions:
*             prompt user and return integer
*
*         getmin:
*             prompt user and return integer
*
*         getmax:
*             prompt user and return integer
*
*         getfilename:
*             prompt user and store filename
*
*         getrandomvalues(min, max, number of questions):
*             resize arrays to match number of questions
*             for each index
*                 generate random num1 value
*                 generate random num2 value
*                 randomly choose addition or subtraction
*                 compute answer and store it
*             end for
*
*         randomint(a, b):
*             return random integer between a and b inclusive
*
*         printquestions(min, max):
*             for each index
*                 build question string using generatequestions
*                 print formatted question to file
*             end for
*
*         generatequestions(index, n1, n2, answer):
*             determine operator based on answer
*             return formatted question string
*
*         makefile:
*             create printwriter using filename
*             print worksheet header
*
*         printanswers:
*             print answer key header
*             for each index
*                 print formatted answer
*             end for
*
*     end class
*
* >testing:
*     test with small and large question counts.
*     test with positive, negative, and mixed number ranges.
*     test multiple file names to ensure files are created correctly.
*     verify that questions and answers align and formatting appears as expected.
*/


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Worksheet
{
	// Arrays storing the first number, second number, and the computed answers
	private int[] num1;
	private int[] answers;
	private int[] num2;
	
	// File name and PrintWriter for writing the worksheet to a file
	private String fileName;
	private PrintWriter output; // PrintWriter obj to write to file
	
	public Worksheet()
	{
		// Initialize arrays as empty until user input determines their size
		num1 = new int[]{};
		answers = new int[]{};
		num2 = new int[]{};
		
		// Initialize file name and output writer
		fileName = new String();
		output = null;
	}
	
	public static void main(String[] args)
	{
		// Create a Worksheet object and run the program
		Worksheet ws = new Worksheet();
		ws.makeWorksheet();
	}
	
	public void makeWorksheet()
	{
		System.out.println("\n\n");
		
		// Ask user for worksheet settings
		int numOfQuestions = 20;
		numOfQuestions = getNumOfQuestions();
		int minNum = getMin();
		int maxNum = getMax();
		getFileName();
		System.out.println();
		
		// Generate random values and answers
		getRandomValues(minNum, maxNum, numOfQuestions);
		
		// Create the file and print questions + answers
		makeFile();
		printQuestions(minNum, maxNum);
		printAnswers();
		
		// Close the file writer
		output.close();
		System.out.println("\n\n");
	}
	
	public int getNumOfQuestions()
	{
		// Ask user how many questions they want
		Scanner in = new Scanner(System.in);
		System.out.print("Number of questions: ");
		return in.nextInt();    
	}
	
	public int getMin()
	{
		// Ask user for minimum number in problems
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the minimum number you want in the question: ");
		return in.nextInt();
	}
	
	public int getMax()
	{
		// Ask user for maximum number in problems
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the maximum number you want in the question: ");
		return in.nextInt();
	}
	
	public void getFileName()
	{
		// Ask user for output file name
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the file name where you want to save it: ");
		fileName = in.next();
	}
	
	public void getRandomValues(int min, int max, int numOfQs)
	{
		// Resize arrays to match number of questions
		num1 = new int[numOfQs];
		num2 = new int[numOfQs];
		answers = new int[numOfQs];
		
		// Generate random numbers and compute answers
		for(int i = 0; i < numOfQs; i++)
		{
			num1[i] = randomInt(min,max);
			num2[i] = randomInt(min,max);
			
			// Randomly choose addition or subtraction
			if (randomInt(0,1) == 0)
				answers[i] = num1[i] + num2[i];
			else
				answers[i] = num1[i] - num2[i];
		}
	}
	
	public int randomInt(int a, int b)
	{
		// Returns a random integer between a and b inclusive
		return ( (int)(Math.random() * (b - a + 1)) + a );
	}
	
	public void printQuestions(int min, int max)
	{
		// Print each question to the output file
		for(int i = 0; i < answers.length; i++)
		{
			// Build the question string
			String question = generateQuestions(i, num1[i], num2[i], answers[i]);
			
			// Add spacing every 4 questions
			if (i!=0 && i%4==0)
				output.println("\n");
			
			// Print formatted question
			output.printf("%-25s",question);
		}
	}
	
	public String generateQuestions(int index, int n1, int n2, int ans)
	{
		// Determine whether the operation was + or -
		char sign = '?';
		if (n1 + n2 == ans)
			sign = '+';
		else if (n1 - n2 == ans)
			sign = '-';
		
		// Return formatted question text
		return ((index+1)+". "+n1+" "+sign+" "+n2+" = ");
	}
	
	public void makeFile()
	{
		// Create the output file and attach PrintWriter
		File printFile = new File(fileName);
		try
		{
			output = new PrintWriter(printFile);
		}
		catch(IOException e)
		{
			// If file cannot be created, show error and exit
			System.err.println("\n\n\nERROR: Cannot create " + fileName +
				" file.\n\n\n");
			System.exit(1);
		}
		
		// Print worksheet header
		output.printf("%75sName:____________________%n","");
		output.printf("%-80sDate:_______________%n","Addition and subtraction practice using numbers -10 to 10");
	}
	
	public void printAnswers()
	{
		// Print answer key section
		output.println("\n\n\n\n");
		output.println("Answer Key");
		
		for(int i = 0; i < answers.length; i++)
		{
			// Add spacing every 4 answers
			if(i!=0 && i%4==0)
				output.println("\n");
			
			// Print answer in formatted column
			output.printf("%-25s",((i+1)+". "+answers[i]));
		}
	}
}
