//Daksh Agrawal
//9-2-2025 Per7
//Schedule.java
/* Prints a schedule of a School day.
 * 
 * 
 * 
 * Working on:
 * Format.method(variableFormatted, fieldWidth, decimalPlaces),
 * printf(), field width, double, String, byte, etc.
 */

public class Schedule
{
	public static void main(String[] args)
	{
		System.out.println("\n\n\n");
		
		//initializing double amount:
		String bill = new String("Outstanding bill:");
		double amount = 34.56789;
		
				
		//initializing table variables
		byte period = 1;
		String course = "Advanced Drama";
		
		// center titles
		System.out.println(Format.center("Course Schedule for:",50));
		System.out.println(Format.center("Daksh Agrawal",50));
		
		//start of table
		System.out.printf("%n%-25s", "Period");
		System.out.printf("%25s%n", "Course");
		
		//Period 1
		System.out.printf("%-25d", period);
		System.out.printf("%25s%n", course);
		
		course = "AP Physics 1"; //Period 2
		period++;
		System.out.printf("%-25d", period);
		System.out.printf("%25s%n", course);
		
		course = "PreCalculus Honors"; //Period 3
		period++;
		System.out.printf("%-25d", period);
		System.out.printf("%25s%n", course);
		
		course = "World Literature"; //Period 4
		period++;
		System.out.printf("%-25d", period);
		System.out.printf("%25s%n", course);
		
		course = "World History"; //Period 5
		period++;
		System.out.print(Format.left(period,25));
		System.out.println(Format.right(course,25));
		
		course = "Spanish 2"; //Period 6
		period++;
		System.out.print(Format.left(period,25));
		System.out.println(Format.right(course,25));
		
		course = "Java Programming"; //Period 7
		period++;
		System.out.print(Format.left(period,25));
		System.out.println(Format.right(course,25));
		
		//outstanding bill
		System.out.printf("%s %s%.2f", bill, '$', amount);
		
		System.out.println("\n\n\n");
	}
}
