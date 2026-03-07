// Daksh Agrawal
/* Period 7
* 03/02/2026
* 
* GardenGrows.java
* 
* >Description:
*   This program creates a JFrame and displays a Garden panel that reacts to
*   mouse clicks and keyboard input. The garden starts pink, becomes green
*   after watering, and grows flowers after sun is applied. Space resets it.
*
* >Learning:
*   - How to use JFrame and JPanel together
*   - How to implement MouseListener and KeyListener
*   - How to track state using booleans
*   - How to draw shapes using Graphics
*   - How to update graphics with repaint()
*
* >Pseudocode:
*   import needed libraries
*
*   GardenGrows class:
*     main:
*       - make GardenGrows object
*       - call method to build frame
*
*     gardenFrame():
*       - create JFrame
*       - set size, close operation, location, resizable
*       - make Garden panel
*       - add panel to frame
*       - set visible
*
*   Garden.java class (extends JPanel, implements MouseListener, KeyListener):
*     - make booleans for watering and flowering sequence
*     - constructor:
*         initialize booleans
*         add mouse + key listeners
*
*     paintComponent():
*       - call super
*       - if watered: draw green garden
*         else: draw pink garden
*       - if flower conditions met: draw circles in a loop
*       - request focus for key events
*
*     mouseClicked():
*       - check if click is inside garden
*       - update watering or flower booleans
*
*     keyTyped():
*       - if '%' typed and watering started: finish watering
*
*     keyPressed():
*       - if UP arrow pressed and flower click happened: finish flowering
*
*     keyReleased():
*       - if space pressed: reset all booleans
*
* >Testing:
*   - Click inside garden → type '%' → garden turns green
*   - Click inside garden → press UP → flowers appear
*   - Clicking outside garden does nothing
*   - Pressing space resets everything to pink
*/
import javax.swing.JFrame;

public class GardenGrows
{
	public GardenGrows()
	{
	}
	
	public static void main(String[] args)
	{
		GardenGrows gg = new GardenGrows();		// create object
		gg.gardenFrame();                  		// build frame
	}
	
	public void gardenFrame()
	{
		JFrame f = new JFrame("Garden"); 	// window
		
		f.setSize(1100,600);      	// size fits garden
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocation(0,0);
		f.setResizable(true);
		Garden garden = new Garden();    	// panel
		f.setContentPane(garden);        	// add panel
		f.setVisible(true);             	// show window
	}
}

