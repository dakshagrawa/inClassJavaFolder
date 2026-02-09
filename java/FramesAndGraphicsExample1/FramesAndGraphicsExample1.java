// Daksh Agrawal
/* Period 7
* 02/09/2026
* 
* FramesAndGraphicsExample1.java
*/
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FramesAndGraphicsExample1 extends JFrame
{
	public static void main(String[] args) 
	{
		FramesAndGraphicsExample1 e1 = new FramesAndGraphicsExample1();
	}
	
	public FramesAndGraphicsExample1()
	{
		super("This is the Frame's Title");
		setSize(200, 300);					// Frame is 400 (w) x 200 (h) 
		setLocation(400,400);				// Changes location of the JFrame
		boolean booleanValue = true;
		setResizable(booleanValue);			// Asks if JFrame is resizable or not
		setDefaultCloseOperation(EXIT_ON_CLOSE);	//press at X to close
		Panel panel1 = new Panel();		// create generic JPanel
		setContentPane(panel1);				// put panel in Frame
		setVisible(true);					// makes Frame show up
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
		super.paintComponent(g); // Calls the superclass' method: paints the background color 
	}
}
