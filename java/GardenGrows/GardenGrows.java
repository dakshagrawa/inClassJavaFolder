// Daksh Agrawal
/* Period 7
* 03/02/2026
* 
* GardenGrows.java
* 
* >Description:
*
* >Learning:
*
* >Pseudocode:
* 	import everything
* 
* 	GardenGrows class header
* 		1. main calls constructor and another method
* 		2. the next method:
* 			- makes a new JFrame with other required stuff (size, location, etc.)
* 			- calls Panel class (Garden.java)
* 			- setVisible
* 
* 	Garden.java class header extends JPanel and implements MouseListner and MouseMotionListner
* 		1. make FVs (include booleans for the sequence of the growing garden)
* 		2. make PaintComponent and call superclass also call all other methods
* 		3. draw a pink filled rectangle (1000x500) @(50,50) in a method
* 		4. in mouseClicked() includes calling another method that makes new flowers on the screen
* 		5.
*
* >Testing:
*
*   
*/
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

public class GardenGrows
{
	public GardenGrows()
	{
	}
	
	public static void main(String[] args)
	{
		GardenGrows gg = new GardenGrows();
		GardenGrows.gardenFrame();
	}
	
	public void gardenFrame()
	{
		JFrame f = new JFrame("Garden");
		
		f.setSize(1000,500);
		f.setDefaultCloseOperation(JFrame.SET_ON_CLOSE);
		f.setLocation(0,0);
		f.setResizable(false);
		Garden garden = new Garden();
		f.setContentPane(garden);
		f.setVisible(true);
	}
}
class Garden extends JPanel implements MouseListener
{
	public void paintComponent(Graphics g)
	{
		
	}
	
}
