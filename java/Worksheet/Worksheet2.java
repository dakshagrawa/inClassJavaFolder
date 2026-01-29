// Daksh Agrawal
/* Period 7
* 01/29/2026
* Worksheet2.java
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;

public class Worksheet2
{
	private int numOfQuestions;
	
	private int[] num1;
	private double[] answers;
	private int[] num2;
	
	private boolean[] isDivision;
	
	private String fileName;
	private PrintWriter output; // PrintWriter obj to write to file
	
	public Worksheet2()
	{
		numOfQuestions = 20;
		num1 = new int[]{};
		answers = new double[]{};
		num2 = new int[]{};
		fileName = new String();
		isDivision = new boolean[]{false};
		
	}
	
	public static void main(String[] args)
	{
		Worksheet2 ws2 = new Worksheet2();
		ws2.makeWorksheet();
	}
	
	public void makeWorksheet()
	{
		System.out.println("\n\n");
		
		int minNum = getMin();
		int maxNum = getMax();
		getFileName();
		System.out.println();
		
		getRandomValues(minNum, maxNum);
		makeFile();
		printQuestions(minNum, maxNum);
		
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
	
	public void getRandomValues(int min, int max)
	{
		num1 = new int[numOfQuestions];
		num2 = new int[numOfQuestions];
		answers = new double[numOfQuestions];
		isDivision = new boolean[numOfQuestions];
		
		for(int i = 0; i < numOfQuestions; i++)
		{
			num1[i] = random(min,max);
			num2[i] = random(min,max);
			int randSymbol = random(1,4);
			if (randSymbol == 1)
				answers[i] = num1[i] + num2[i];
			else if (randSymbol == 2)
				answers[i] = num1[i] + num2[i];
			else if (randSymbol == 3)
				answers[i] = num1[i] * num2[i];
			else
			{
				answers[i] = (double)num1[i] / num2[i];
				isDivision[i] = true;
			}
		}
	}
	
	public int random(int a, int b)
	{
		return ( (int)(Math.random() * (b - a + 1)) + a );
	}
	
	public void printQuestions(int min, int max)
	{
		for(int i = 0; i < numOfQuestions; i++)
		{
			String question = new String(generateQuestions(i, num1[i], num2[i], answers[i]));
			if (i%4==0)
				output.println("\n");
			output.printf("%-25s",question);
		}
	}
	
	public String generateQuestions(int index, int n1, int n2, double ans)
	{
		char sign = '?';
		if (n1 + n2 == ans)
			sign = '+';
		else if (n1 - n2 == ans)
			sign = '-';
		else if (n1 * n2 == ans)
			sign = '×';
		else
			sign = '÷';
			
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
		output.printf("%-80sDate:_______________","Addition and subtraction practice using numbers -10 to 10");
	}
	
	public void printAnswers()
	{
		output.println("\n\n\n\n");
		output.println("Answer Key");
		for(int i = 0; i < numOfQuestions; i++)
		{
			if(i!=0 && i%4==0)
				output.println("\n");
			
			if(!isDivision[i])
				output.printf("%-4s%-21d",((i+1)+". "),(int)answers[i]);
			else
			{
				output.printf("%-4s%-21.3f",((i+1)+". "),answers[i]);
			}
		}
	}
}
