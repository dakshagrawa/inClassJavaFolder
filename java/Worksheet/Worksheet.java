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

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;

public class Worksheet
{
	private int numOfQuestions;
	
	private int[] num1;
	private char[] symbol;
	private int[] num2;
	
	private String fileName;
	private PrintWriter output; // PrintWriter obj to write to file
	
	public Worksheet()
	{
		numOfQuestions = 20;
		fileName = new String();
		output = null;
	}
	
	public static void main(String[] args)
	{
		Worksheet ws = new Worksheet();
		ws.getWorksheet();
	}
	
	public void getWorksheet()
	{
		System.out.println("\n\n");
		
		int minNum = getMin();
		int maxNum = getMax();
		getFileName();
		System.out.println();
		
		getRandomValues(minNum, maxNum);
		makeFile();
		generateQuestions(minNum, maxNum);
		
		makeAnswers();
		printAnswers();
		
		output.close();
	}
	
	public int getMin()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the minimum number you want: ");
		return in.nextInt();
	}
	
	public int getMax()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the maximum number you want: ");
		return in.nextInt();
	}
	
	public void getFileName()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the file name: ");
		fileName = in.next();
	}
	
	public void generateQuestions(int min, int max)
	{
		for(int i = 0; i < numOfQuestions; i++)
			printQuestions(i, num1[i], num2[i], symbol[i]);
	}
	
	public void getRandomValues(int min, int max)
	{
		num1 = new int[numOfQuestions];
		num2 = new int[numOfQuestions];
		symbol = new char[numOfQuestions];
		
		for(int i = 0; i < numOfQuestions; i++)
		{
			num1[i] = random(min,max);
			num2[i] = random(min,max);
			int symbolChoose = random(0,1);
			if (symbolChoose == 0)
				symbol[i] = '-';
			else
				symbol[i] = '+';
		}
	}
	
	public int random(int a, int b)
	{
		return ( (int)(Math.random() * (b - a + 1)) + a );
	}
	
	public void printQuestions(int index, int n1, int n2, char sign)
	{
		String question = new String((index+1)+". "+n1+" "+sign+" "+n2+" = ");
		if (index%4==0)
		{
			output.println("\n");
		}
		output.printf("%-20s",question);
		
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
		output.printf("%55sName:_______________%n","");
		output.printf("%-60sDate:__________","Addition and subtraction practice using numbers -10 to 10");
	}
}
