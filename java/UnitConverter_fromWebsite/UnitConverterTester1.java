//UnitConverterTester1.java 
//Used to call methods from UnitConvert1.java

public class UnitConverterTester1   // class header
{	
	/*public UnitConverterTester1()	  // Constructor - used to initialize field variables.
	{
		
	}*/
	
	public static void main (String [] args)	// main () method header
	{	
		UnitConverter1 uConverter1 = new UnitConverter1();
		
		
		
			
		double feet = -1.2;	
		double cm = -2.0;
		double yards = -3.0;
		
		uConverter1.getInches();
		feet = uConverter1.inchesToFeet ();  // call method
		cm = uConverter1.inchesToCm ();
		yards = uConverter1.feetToYards(feet);		// call method, parameter = feet
		uConverter1.print(feet, cm, yards);
	}
}
