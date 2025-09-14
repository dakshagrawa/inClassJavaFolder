//Daksh Agrawal
//9-11-2025 Per7
//CalculatePi.java
/* What program does:
 * Approximates pi 2 different ways. It prints each result 2, then 
 * 6 decimal place. Each result is compared to 3.141592 and the 
 * difference is printed.
 * 
 * Working on: 
 * Using prinf and the Format class to format the decimals
 * Declare and initializing variables (D&I). A final constant.
 * 
 * Pseudocode: the plan
 * 	class header
 * 		D&I a final constant for pi
 * 	main header 
 * 			make an instance of the class
 * 			use the instance to call firstApprox
 * 			use the instnce to call secondApprox
 * 	firstApprox header
 * 			declare approx1 as a float 
 * 			initialize approx1 to 0.0f
 * 			D&I diff1, set to -100.0f
 * 	
 * 			set approx1 to 22/7
 * 			set diff1 to difference between approx1 and pi
 * 			print 3 BLs(blank lines), then the intro sent using pi
 * 			print approx1 to 2 places, then 6, then diff1 to 6 places
 * 	
 * 	secondApprox header
 * 			D&I approx 2 as a float, initialize approx2 to 0.0f
 * 			D&I diff2, set to -100.0f
 * 	
 * 			set approx2 to ((4+100)*8+62000) all divided by 20000
 * 			set diff2 to difference between approx2 and pi
 * 			print approx2 to 2 places, then 6, then diff2 to 6 places 
 */
public class CalculatePi
{
	final float PI = 3.141592f; //this is the final constant for Pi
	
	public static void main(String[] args)
	{
		CalculatePi calcPi = new CalculatePi(); //we'll worry about this later
		
		calcPi.firstApprox();
		calcPi.secondApprox();		
	}
		
	public void firstApprox()
	{
		float approx1 = 0.0f;
		float diff1 = -100.0f;
	
		approx1 = 22/7.0f;
		
		diff1 = approx1 - PI;
		
		float Pi = -100.0f;
		Pi = PI;
		
		System.out.println("\n\n\n");
		System.out.println("I am approximating pi (a bit more than "+Pi+").\n");
		
		System.out.printf("The calculation 22/7 yields %.2f or more " + 
			"specifically %.6f shown to 6 places. It is %.6f " + 
			"different from %.6f%n%n",approx1,approx1,diff1,approx1);
	}
	public void secondApprox()
	{
		float approx2 = 0.0f;
		float diff2 = -100.0f;
		
		approx2 = ((4+100)*8+62000)/20000.0f;
		diff2 = approx2 - PI;
		System.out.printf("The calculation ((4+100)*8+62000) all " + 
			"divided by 20000 yields %.2f or more " + 
			"specifically %.6f shown to 6 places. It is %.6f " + 
			"different from %.6f. ",approx2,approx2,diff2,approx2);
		System.out.println("Using Format(): It is " + diff2 + " different from " + approx2 + ".");
		System.out.println("\n\n\n");
	}
}
