//Daksh Agrawal
/* Period 7
 * 10/14/2025
 * Roll.java
 */
public class Roll
{
	public Roll()
	{
		//empty
    }
    public char rollStave()
    {
		char randomRoll;
		randomRoll = (char)((int)(Math.random()*2)+35);
		return randomRoll;
	}
}
