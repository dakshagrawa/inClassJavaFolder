// Daksh Agrawal
/* Period 7
* 01/15/2026
* 
* GradeStats.java
* 
* >Objective:
* 
* >Description:
*
* >Learning:
*
* >Pseudocode:
* 	Import Scanner
* 	Class Header
*
* >Testing:
*
*   
*/

import java.util.Scanner;

public class GradeStats
{
	private int[] grades;
	private int numOfScores;
	private int minimum;
	private int maximum;
	private double average;
	private double median;


	public GradeStats()
	{
		grades = new int[]{};
	}
	
	public static void main(String[] args)
	{
		GradeStats gs = new GradeStats();
		gs.calculateIt();
	}
	
	public void calculateIt()
	{
		System.out.print("\n\n\n");
		System.out.println("=======================================================================");
		System.out.println("     Welcome to the Grade Statistics Calculator! (GradeStats.java)     ");
		System.out.println("=======================================================================");
		System.out.println("This program is designed to help you analyze class performance. Simply\n"
						 + "enter your scores one by one. "
						 + "Once you're done, it will automatically\ncalculate:");
		System.out.println("  - The Highest Scored Grade (Maximum)");
		System.out.println("  - The Lowest Scored Grade (Minimum)");
		System.out.println("  - The Class Average (Mean)");
		System.out.println("  - The Median Score of the Class");
		System.out.println("-----------------------------------------------------------------------\n");

		getGrades();

		printScores();

		below75Percent(); //? is it okay to print in this method?

		numOfScores = grades.length;
		minimum = findMin(grades);
		maximum = findMax(grades);
		average = findAvg(grades);
		median = findMedian(grades);

		printCalculated();

		System.out.print("\n\n\n"); 
	}

	public void getGrades()
	{
		String input;
		do
		{
			Scanner in = new Scanner(System.in);
			//String input;
			int[] temp = new int[grades.length+1];
			
			System.out.print("Type in the score. Type \"Quit\" to end the program --> ");
			input = in.next();
			if (!input.equalsIgnoreCase("quit"))
			{
				if(!(grades.length==0))
					for(int i = 0; i < grades.length; i++)
					{
						temp[i] = grades[i];
					}
				temp[temp.length-1] = Integer.parseInt(input);
				grades = temp;
			}

		}while(!input.equalsIgnoreCase("quit"));
	}
	
	public void printScores()
	{
		System.out.println("\nHere is the data you entered:");

		for(int i = 0; i < grades.length; i++)
			System.out.println("Student "+(i+1)+"'s score: "+grades[i]);
	}

	public void below75Percent()
	{
		int totalBelow75 = 0;
		String studentBelow75 = new String();

		for(int i = 0; i < grades.length; i++)
		{
			if (grades[i]<75)
			{
				totalBelow75++;
				studentBelow75 += ("student "+(i+1)+", ");
			}
		}

		System.out.println("\nThere were " + totalBelow75
						 + " students who scored below 75%: "
						 + studentBelow75.substring(0,studentBelow75.length()-2)
						 + ".");
	}

	public int findMin(int[] givenGrades)
	{
		int min = givenGrades[0];
		for (int i = 1; i < givenGrades.length ; i++)
			min = Math.min(givenGrades[i],min);
		return min;
	}

    public int findMax(int[] givenGrades) 
	{
		int max = givenGrades[0];
		for (int i = 1; i < givenGrades.length ; i++)
			if (max < givenGrades[i])
				max = givenGrades[i];
		return max;
	}

    public double findAvg(int[] givenGrades)
	{
		double sum = 0.0;
		for (int i = 0; i < givenGrades.length ; i++)
			sum += givenGrades[i];
		return (sum/givenGrades.length);
    }

	public double findMedian(int[] givenGrades) 
	{
		int[] sorted = new int[givenGrades.length];
		
		for (int i = 0; i < givenGrades.length; i++)
		{
			int minIndex = 0;
			
			for(int j = 1; j < givenGrades.length; j++)
				if (givenGrades[minIndex] > givenGrades[j])
					minIndex = j;
					
			sorted[i] = givenGrades[minIndex];
			givenGrades[minIndex] = 9999;
		}
		
		System.out.println("\n\nSorted length: "+sorted.length);
		System.out.println("\n\nSorted String");
		for(int z = 0; z < sorted.length; z++)
		{
			System.out.print(sorted[z]+", ");
		}
		System.out.println();
		
		if (sorted.length%2==0)
			return (sorted[sorted.length/2]+sorted[(sorted.length/2) - 1])/2.0;
		else
			return sorted[sorted.length/2];
    }

	public void printCalculated()
	{
		System.out.printf("%n%-20s%d","Number of scores:", numOfScores);
		System.out.printf("%n%-20s%d","Minimum:", minimum);
		System.out.printf("%n%-20s%d","Maximum:", maximum);
		System.out.printf("%n%-20s%.1f","Average:", average);
		System.out.printf("%n%-20s%.1f","Median:", median);
	}
}
