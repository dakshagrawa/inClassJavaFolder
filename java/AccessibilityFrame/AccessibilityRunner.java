// Daksh Agrawal
/* Period 7
* 01/06/2026
* 
* AccessibilityRunner.java
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
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AccessibilityRunner
{
	public AccessibilityRunner()
	{
	}
	
	public static void main(String[] args)
	{
		AccessibilityRunner acc = new AccessibilityRunner();
		acc.run();
	}
	
	public void run()
	{
		JFrame f = new JFrame("Accessibility");
		
		f.setSize(1000,800);
		f.setLocation(0,0);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBackground(Color.WHITE); //not required (useless)
		f.setResizable(true);
		Accessibility p = new Accessibility();
		f.setContentPane(p);
		f.setVisible(true);
	}
}

class Accessibility extends JPanel implements KeyListener, MouseListener
{
	private Color backgroundColor;
	private int fontSize;
	private int colorParameterVar;
	
	public Accessibility()
	{
		colorParameterVar = 100;
		backgroundColor = new Color(colorParameterVar,colorParameterVar,colorParameterVar);
		setBackground(backgroundColor);
		fontSize = 12;
		addKeyListener(this);
		addMouseListener(this);
	}
	
	public void drawRectangleWithLabels(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(10,65,100,20);
		g.fillRect(115,65,100,20);
		g.setColor(Color.BLACK);
		g.drawString("brighter",15,80);
		g.drawString("darker",115,80);
	}

	public void medicalPageContent(Graphics g){}
	
	public void writeDirections(Graphics g)
	{
		g.drawString("Press mouse on the panel.  To increase the font size, press the UP arrow. " +
			"To decrease the font size, press the DOWN arrow." +
			"To make the screen brighter, click the box labelled brighter" +
			"To make the screen darker, click the box labelled darker", 50, 300);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawRectangleWithLabels(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Serif", Font.PLAIN, fontSize));
		medicalPageContent(g);
		writeDirections(g);
	}
	public void keyPressed(KeyEvent evt)
	{
		if(evt.getKeyCode()==KeyEvent.VK_UP && fontSize < 80)
			fontSize += 5;
		if(evt.getKeyCode()==KeyEvent.VK_DOWN && fontSize > 8)
			fontSize -= 5;
		repaint();
	}
	public void keyReleased(KeyEvent evt){}
	public void keyTyped(KeyEvent evt){}
	
	public void mousePressed(MouseEvent evt)
	{
        requestFocusInWindow();
	}
	public void mouseClicked(MouseEvent evt)
	{
		int x = evt.getX();
		int y = evt.getY();
		
		if(x>10 && x<110 && y>65 && y<85 && colorParameterVar < 225)
			colorParameterVar += 3;
		if(x>115 && x<215 && y>65 && y<85 && colorParameterVar > 34)
			colorParameterVar -= 3;
		
		backgroundColor = new Color(colorParameterVar,colorParameterVar,colorParameterVar);
		setBackground(backgroundColor);
	}
	public void mouseReleased(MouseEvent evt){}
	public void mouseEntered(MouseEvent evt){}
	public void mouseExited(MouseEvent evt){}
}
