// Daksh Agrawal
/* Period 7
* 01/27/2026
* 
* Worksheet.java
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

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Worksheet
{
	private int[] num1;
	private int[] answers;
	private int[] num2;
	
	private String fileName;
	private PrintWriter output; // PrintWriter obj to write to file
	
	public Worksheet()
	{
		num1 = new int[]{};
		answers = new int[]{};
		num2 = new int[]{};
		fileName = new String();
		output = null;
	}
	
	public static void main(String[] args)
	{
		Worksheet ws = new Worksheet();
		ws.makeWorksheet();
	}
	
	public void makeWorksheet()
	{
		System.out.println("\n\n");
		
		int numOfQuestions = 20;
		numOfQuestions = getNumOfQuestions();
		int minNum = getMin();
		int maxNum = getMax();
		getFileName();
		System.out.println();
		
		getRandomValues(minNum, maxNum, numOfQuestions);
		makeFile();
		printQuestions(minNum, maxNum);
		
		printAnswers();
		
		output.close();
		System.out.println("\n\n");
	}
	
	public int getNumOfQuestions()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Number of questions: ");
		return in.nextInt();	
	}
	
	public int getMin()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the minimum number you want in the question: ");
		return in.nextInt();
	}
	
	public int getMax()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the maximum number you want in the question: ");
		return in.nextInt();
	}
	
	public void getFileName()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the file name where you want to save it: ");
		fileName = in.next();
	}
	
	public void getRandomValues(int min, int max, int numOfQs)
	{
		num1 = new int[numOfQs];
		num2 = new int[numOfQs];
		answers = new int[numOfQs];
		
		for(int i = 0; i < numOfQs; i++)
		{
			num1[i] = randomInt(min,max);
			num2[i] = randomInt(min,max);
			if (randomInt(0,1) == 0)
				answers[i] = num1[i] + num2[i];
			else
				answers[i] = num1[i] - num2[i];
		}
	}
	
	public int randomInt(int a, int b)
	{
		return ( (int)(Math.random() * (b - a + 1)) + a );
	}
	
	public void printQuestions(int min, int max)
	{
		for(int i = 0; i < answers.length; i++)
		{
			String question = generateQuestions(i, num1[i], num2[i], answers[i]);
			if (i!=0 && i%4==0)
				output.println("\n");
			output.printf("%-25s",question);
		}
	}
	
	public String generateQuestions(int index, int n1, int n2, int ans)
	{
		char sign = '?';
		if (n1 + n2 == ans)
			sign = '+';
		else if (n1 - n2 == ans)
			sign = '-';
			
		return ((index+1)+". "+n1+" "+sign+" "+n2+" = ");
		
	}
	
	public void makeFile()
	{
		File printFile = new File(fileName);
		try
		{
			output = new PrintWriter(printFile);
		}
		catch(IOException e)
		{
			System.err.println("\n\n\nERROR: Cannot create " + fileName +
				" file.\n\n\n");
			System.exit(1);
		}
		output.printf("%75sName:____________________%n","");
		output.printf("%-80sDate:_______________%n","Addition and subtraction practice using numbers -10 to 10");
	}
	
	public void printAnswers()
	{
		output.println("\n\n\n\n");
		output.println("Answer Key");
		for(int i = 0; i < answers.length; i++)
		{
			if(i!=0 && i%4==0)
				output.println("\n");
			output.printf("%-25s",((i+1)+". "+answers[i]));
		}
	}
}
