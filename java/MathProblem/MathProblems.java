//Daksh Agrawal
//9-4-2025 Per7
//MathProblems.java
/* This program solves the math problems assigned in class.
 * This prrogram declares and intitializes variable, stores the result of an 
 * expression in a variable, then prints the variable using println as well as 
 * printf anf Format to print a fouble to two places and a char.
 * 
 * 
 * Working on: Declare & Initialize variables, formatting using printf & Format,
 * Order of operations, math functions [+, -, *, /, %], 
 * creating differnet variable types like: float, char, , etc.
 */

public class MathProblems
{
	public static void main(String[] args)
	{
		System.out.println("\n\n\n");
		
		//declaring and initializing variables
		double prob1 = -1.0; //declare and intiazes as -1.0 (something it can't be equal to))
		int prob2 = -1;
		char prob3 = '?';
		double prob4 = -10.0;
		double prob5 = -1.0;
		
		//initializing variables
		prob1 = 5.6*17/3-49%11/2;
		
		prob2 = 16-17*(5%6/3);
		
		prob3 = (char)(56/2+17*3-9%9);
		
		prob4 = (int)(double)9/12*3-6.5;
		
		prob5 = (int)('g')+(double)('2')/7;
		
		
		//printing results
		
		//problem 1
		System.out.println("1) 5.6*17/3-49%11/2 = " + Format.left(prob1,5,2));
		
		System.out.printf("1) 5.6*17/3-49%%11/2 = %-5.2f%n%n",prob1);
		
		//problem 2
		System.out.printf("2) 16-17*(5%%6/3) = %-5d%n%n",prob2);
		
		//problem 3
		System.out.println("3) (char)(56/2+17*3-9%9) = " + Format.left(("'"+prob3+"'"),5));
		
		System.out.printf("3) (char)(56/2+17*3-9%%9) = %s%n%n",prob3);
		
		//problem 4
		System.out.println("4) (int)(double)9/12*3-6.5 = " + Format.left(prob4,5,2)); 
		
		//problem 5
		System.out.println("\n5) (int)('g')+(double)('2')/7 = " + Format.left(prob5,5,2));
		
		System.out.printf("5) (int)('g')+(double)('2')/7 = %5.2f",prob5);
		
		System.out.println("\n\n\n");
	}
}
