// Daksh Agrawal
/* Period 7
* 01/06/2026
* 
* filename.java
* 
* >Description:
*
* >Learning:
*
* >Pseudocode:
* 		
*
* >Testing:
*
*   
*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Accessibilty
{
	public Accessibilty()
	{
	}
	
	public static void main(String[] args)
	{
		Accessibilty acc = new Accessibilty();
		acc.run();
	}
	
	public void run()
	{
		JFrame f = new JFrame("Accessibilty");
		
		f.setSize(1000,800);
		f.setLocation(0,0);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBackground(Color.WHITE);
		f.setResizable(true);
		Panel p = new Panel();
		f.setContentPane(p);
		f.setVisible(true);
	}
}

public Panel extends JPanel implements KeyListener, MouseListener
{
	private Color myRGB;
	
	public Panel()
	{
		myRGB = new Color();
		addKeyListener(this);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		
	}
	
	public void KeyClicked(KeyEvent evt){}
	public void KeyPressed(KeyEvent evt){}
	public void KeyReleased(KeyEvent evt){}
	
	public void MouseClicked(MouseEvent evt){}
	public void MousePressed(MouseEvent evt){}
	public void MouseReleased(MouseEvent evt){}
	public void MouseEntered(MouseEvent evt){}
	public void MouseExited(MouseEvent evt){}
	
	public void medicalPageContent(Graphics g)
	{
	}
	
	public void writeDirections(Graphics g)
	{
		g.drawString("Press mouse on the panel.  To increase the font size, press the UP arrow. +"
			"To decrease the font size, press the DOWN arrow." +
			"To make the screen brighter, click the box labelled brighter" +
			"To make the screen darker, click the box labelled darker", 50, 300);
	}
}
