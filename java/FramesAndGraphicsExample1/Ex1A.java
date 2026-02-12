// Daksh Agrawal
/* Period 7
* 02/09/2026
* 
* Ex1A.java
*/
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;

public class Ex1A extends JFrame
{
	public static void main(String[] args) 
	{
		Ex1A ex = new Ex1A();
	}
	
	public Ex1A()
	{
		super("This is the Frame's Title");
		setSize(1000, 500);							// Frame is 400 (w) x 200 (h) 
		setLocation(100,100);						// Changes location of the JFrame
		boolean booleanValue = true;
		setResizable(booleanValue);					// Asks if JFrame is resizable or not
		setDefaultCloseOperation(EXIT_ON_CLOSE);	//press at X to close
		Panel panel1 = new Panel();					// create generic JPanel
		setContentPane(panel1);						// put panel in Frame
		setVisible(true);							// makes Frame show up
	}
}

class Panel extends JPanel
{
	public Panel()
	{
		setBackground(Color.red);			// Only picks background color
	}
	
	public void paintComponent(Graphics g)
	{
		int[] arr1 = {100,200,200};
		int[] arr2 = {200, 100, 200};
		
		super.paintComponent(g); 			// Calls the superclass' method: paints the background color 
		g.setFont(new Font("serif", Font.PLAIN, 60)); // requires to import Font at the top
		g.drawString("hello", 50, 100);
		g.drawLine(50,100,100,200);
		g.fillArc(40,10,100,60,-45,90);
		
		g.setColor(Color.black);
		g.drawPolygon(arr1,arr2,3);
		
	}
}
