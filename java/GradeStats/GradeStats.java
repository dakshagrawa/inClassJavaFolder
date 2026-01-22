// Daksh Agrawal
/* Period 7
* 01/15/2026
* 
* GradeStats.java
* 
* >Objective:
*   Analyze a list of user‑entered grades and compute min, max, average, and median.
* 
* >Description:
*   Program repeatedly accepts scores until "Quit" is typed, stores them in an array,
*   prints them, identifies students scoring below 75%, and calculates statistics.
*
* >Learning:
*   Arrays, loops, Scanner input, dynamic array resizing, helper methods, selection logic.
*
* >Pseudocode:
*   class GradeStats
*       declare grades, numOfScores, minimum, maximum, average, median
*
*   constructor:
*       set grades to empty array
*
*   main:
*       GradeStats object
*       call calculateIt()
*
*   calculateIt:
*       print introduction
*       call getGrades()
*       call printScores()
*       call below75Percent()
*       set numOfScores = grades.length
*       set minimum = findMin(grades)
*       set maximum = findMax(grades)
*       set average = findAvg(grades)
*       set median = findMedian(grades)
*       call printCalculated()
*
*   getGrades:
*       Scanner
*       loop until user types "Quit":
*           temp array with size grades.length + 1
*           prompt user for input
*           if input is not "Quit":
*               COPY grades into temp
*               PARSE input into integer
*               store integer in last index of temp
*               set grades = temp
*
*   printScores:
*       for each index i:
*           print "Student i's score"
*
*   below75Percent:
*       set counters and flags
*       for each grade:
*           if grade < 75:
*               UPDATE counters and string list
*       if any below 75:
*           print list
*       else:
*           print none below 75
*
*   findMin:
*       set min = first element
*       for each remaining element:
*           UPDATE min if smaller
*       return min
*
*   findMax:
*       set max = first element
*       for each remaining element:
*           UPDATE max if larger
*       return max
*
*   findAvg:
*       SUM all elements
*       return sum / length
*
*   findMedian:
*       sorted array
*       for each position i:
*           find smallest remaining value in givenGrades
*           store it in sorted[i]
*           mark used value as 9999
*       if even length:
*           return average of middle two
*       else:
*           return middle element
*
*   printCalculated:
*       print number of scores, min, max, average, median
*
* >Testing:
*   - No scores
*   - All high scores
*   - All low scores
*   - Mixed scores
*   - Even/odd number of scores for median
*/

import java.util.Scanner;

public class GradeStats
{
	private int[] grades;        // stores all entered grades
	private int numOfScores;     // total number of scores entered
	private int minimum;         // lowest grade
	private int maximum;         // highest grade
	private double average;      // average of all grades
	private double median;       // median of all grades


	public GradeStats()
	{
		grades = new int[]{};    // start with an empty array
		//Set impossible values for each
		numOfScores = -1;
		minimum = -1;
		maximum = -1;
		average = -1;
		median = -1;
	}
	
	public static void main(String[] args)
	{
		GradeStats gs = new GradeStats();  // create object
		gs.calculateIt();                  // run main workflow
	}
	
	public void calculateIt()
	{
		// Intro formatting and explanation
		System.out.print("\n\n\n");
		System.out.println("=======================================================================");
		System.out.println("     Welcome to the Grade Statistics Calculator! (GradeStats.java)     ");
		System.out.println("=======================================================================");
		System.out.println("This program is designed to help you analyze class performance. Simply\n"
						+ "enter your scores one by one (as integers). "
						+ "Once you're done, it will \nautomatically calculate:");
		System.out.println("  - The Highest Scored Grade (Maximum)");
		System.out.println("  - The Lowest Scored Grade (Minimum)");
		System.out.println("  - The Class Average (Mean)");
		System.out.println("  - The Median Score of the Class");
		System.out.println("-----------------------------------------------------------------------\n");

		getGrades();        // collect user input

		printScores();      // display all entered scores

		below75Percent();   // print students scoring below 75%

		// compute statistics
		numOfScores = grades.length;
		minimum = findMin(grades);
		maximum = findMax(grades);
		average = findAvg(grades);
		median = findMedian(grades);

		printCalculated();  // print summary statistics

		System.out.print("\n\n\n"); 
	}

	public void getGrades()
	{
		Scanner in = new Scanner(System.in);  // scanner for user input
		String input;
		do
		{
			// create a new array one element larger
			int[] temp = new int[grades.length+1];
			
			System.out.print("Type in the score (as an integer). Type \"Quit\" to end the program --> ");
			input = in.next();

			// only add to array if user didn't quit
			if (!input.equalsIgnoreCase("quit"))
			{
				// copy old grades into new array
				if(!(grades.length==0))
					for (int i = 0; i < grades.length; i++)
						temp[i] = grades[i];

				// add new grade to last position
				temp[temp.length-1] = Integer.parseInt(input);

				// update grades array
				grades = temp;
			}

		}while(!input.equalsIgnoreCase("quit"));  // loop until user quits
	}
	
	public void printScores()
	{
		System.out.println("\nHere is the data you entered:");

		// print each student's score
		for(int i = 0; i < grades.length; i++)
			System.out.println("Student "+(i+1)+"'s score: "+grades[i]);
	}

	public void below75Percent()
	{
		int totalBelow75 = 0;                 // count of low scores
		String studentBelow75 = new String(); // list of students below 75
		boolean isBelow75 = false;            // flag for any low scores

		// check each grade
		for(int i = 0; i < grades.length; i++)
		{
			if (grades[i]<75)
			{
				totalBelow75++;
				studentBelow75 += ("student "+(i+1)+", ");
				isBelow75 = true;
			}
		}

		// print results
		if(isBelow75)
			System.out.println("\nThere were " + totalBelow75
							+ " students who scored below 75%: "
							+ studentBelow75.substring(0,studentBelow75.length()-2)
							+ ".");
		else
			System.out.println("\nNo student scored below 75%.");
	}

	public int findMin(int[] givenGrades)
	{
		int min = givenGrades[0];  // start with first grade
		for (int i = 1; i < givenGrades.length ; i++)
			min = Math.min(givenGrades[i],min);  // update minimum
		return min;
	}

	public int findMax(int[] givenGrades) 
	{
		int max = givenGrades[0];  // start with first grade
		for (int i = 1; i < givenGrades.length ; i++)
			if (max < givenGrades[i])
				max = givenGrades[i];  // update maximum
		return max;
	}

	public double findAvg(int[] givenGrades)
	{
		double sum = 0.0;  // accumulate total
		for (int i = 0; i < givenGrades.length ; i++)
			sum += givenGrades[i];
		return (sum/givenGrades.length);  // compute mean
	}

	public double findMedian(int[] givenGrades) 
	{
		// create array to store sorted values
		int[] sorted = new int[givenGrades.length];
		
		// selection-sort-like approach
		for (int i = 0; i < givenGrades.length; i++)
		{
			int minIndex = 0;  // index of smallest value
			
			// find smallest remaining value
			for(int j = 1; j < givenGrades.length; j++)
				if (givenGrades[minIndex] > givenGrades[j])
					minIndex = j;
					
			sorted[i] = givenGrades[minIndex];  // place smallest into sorted array
			givenGrades[minIndex] = 9999;       // mark used value
		}
		
		// compute median depending on even/odd length
		if (sorted.length%2==0)
			return (sorted[sorted.length/2]+sorted[(sorted.length/2) - 1])/2.0;
		else
			return sorted[sorted.length/2];
	}

	public void printCalculated()
	{
		// formatted output of computed statistics
		System.out.printf("%n%-20s%d","Number of scores:", numOfScores);
		System.out.printf("%n%-20s%d","Minimum:", minimum);
		System.out.printf("%n%-20s%d","Maximum:", maximum);
		System.out.printf("%n%-20s%.1f","Average:", average);
		System.out.printf("%n%-20s%.1f","Median:", median);
	}
}
