// Daksh Agrawal
/* Period 7
* 01/29/2026
* Worksheet2.java
*/

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Worksheet2
{
	// Arrays to store the first number, second number, and the computed answers
	private int[] num1;
	private double[] answers;
	private int[] num2;
	
	// Tracks which problems were division (so answers can be formatted differently)
	private boolean[] isDivision;
	
	// File output fields
	private String fileName;
	private PrintWriter output; // PrintWriter obj to write to file
	
	public Worksheet2()
	{
		// Initialize arrays as empty until the user chooses number of questions
		num1 = new int[]{};
		answers = new double[]{};
		num2 = new int[]{};
		isDivision = new boolean[]{};
		
		// Empty filename placeholder
		fileName = new String();
	}
	
	public static void main(String[] args)
	{
		// Create a Worksheet2 object and run the worksheet generator
		Worksheet2 ws2 = new Worksheet2();
		ws2.makeWorksheet();
	}
	
	public void makeWorksheet()
	{
		System.out.println("\n\n");
		
		// Ask user for number of questions and number range
		int numOfQuestions = 20;
		numOfQuestions = getNumOfQuestions();
		int minNum = getMin();
		int maxNum = getMax();
		getFileName();
		System.out.println();
		
		// Generate random problems and answers
		getRandomValues(minNum, maxNum, numOfQuestions);
		
		// Create the output file and print questions + answers
		makeFile();
		printQuestions(minNum, maxNum);
		printAnswers();
		
		// Close the file writer
		output.close();
		System.out.println("\n\n");
	}
	
	public int getNumOfQuestions()
	{
		// Ask user how many problems they want
		Scanner in = new Scanner(System.in);
		System.out.print("Number of questions: ");
		return in.nextInt();    
	}   
	
	public int getMin()
	{
		// Ask user for minimum random number
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the minimum number you want: ");
		return in.nextInt();
	}
	
	public int getMax()
	{
		// Ask user for maximum random number
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the maximum number you want: ");
		return in.nextInt();
	}
	
	public void getFileName()
	{
		// Ask user for the output filename
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the file name: ");
		fileName = in.next();
	}
	
	public void getRandomValues(int min, int max, int numOfQs)
	{
		// Resize arrays to match number of questions
		num1 = new int[numOfQs];
		num2 = new int[numOfQs];
		answers = new double[numOfQs];
		isDivision = new boolean[numOfQs];
		
		// Generate random numbers and random operations
		for(int i = 0; i < numOfQs; i++)
		{
			isDivision[i] = false; // default: not division
			
			// Random operands
			num1[i] = randomInt(min,max);
			num2[i] = randomInt(min,max);
			
			// Randomly choose operation: 1=+, 2=-, 3=×, 4=÷
			int randSymbol = randomInt(1,4);
			
			if (randSymbol == 1)
				answers[i] = num1[i] + num2[i];
			else if (randSymbol == 2)
				answers[i] = num1[i] - num2[i];
			else if (randSymbol == 3)
				answers[i] = num1[i] * num2[i];
			else
			{
				// Division case
				answers[i] = (double)num1[i] / num2[i];
				isDivision[i] = true; // mark this as division
			}
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
			// Build the formatted question string
			String question = generateQuestions(i, num1[i], num2[i], answers[i]);
			
			// Add a blank line every 4 questions
			if (i!=0 && i%4==0)
				output.println("\n");
			
			// Print question in a fixed-width column
			output.printf("%-25s",question);
		}
	}
	
	public String generateQuestions(int index, int n1, int n2, double ans)
	{
		// Determine which operator was used by comparing answer values
		char sign = '?';
		if (n1 + n2 == ans)
			sign = '+';
		else if (n1 - n2 == ans)
			sign = '-';
		else if (n1 * n2 == ans)
			sign = '×';
		else
			sign = '÷';
		
		// Return formatted question string
		return ((index+1)+". "+n1+" "+sign+" "+n2+" = ");
	}
	
	public void makeFile()
	{
		// Create the file and attach PrintWriter to it
		File printFile = new File(fileName);
		try
		{
			output = new PrintWriter(printFile);
		}
		catch(IOException e)
		{
			// If file cannot be created, show error and stop program
			System.err.println("\n\n\nERROR: Cannot create " + fileName +
				" file.\n\n\n");
			System.exit(1);
		}
		
		// Print header lines
		output.printf("%75sName:____________________%n","");
		output.printf("%-80sDate:_______________%n",("Addition, "
							+ "subtraction, multiplication, and division "
							+ "practice using numbers -10 to 10"));
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
			
			// Print integer answers for +, -, ×
			if(!isDivision[i])
				output.printf("%-4s%-21d",((i+1)+". "),(int)answers[i]);
			else
			{
				// Print decimal answers for division
				output.printf("%-4s%-21.3f",((i+1)+". "),answers[i]);
			}
		}
	}
}
