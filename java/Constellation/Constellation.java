// Daksh Agrawal
/* Period 7
* 02/24/2026
*
* Constellation.java
*
* >Objective: 
* 	To create a night sky scene using Java Swing and Graphics 
* 	classes, focusing on coordinate-based shape drawing.
*
* >Description: 
* 	This program renders a 630x450 window featuring the Big Dipper 
* 	constellation, a crescent moon, a ground arc, and a rocket ship 
* 	with a trajectory path.
*
* >Learning: 
*	- basic Java Graphics methods like drawPolygon, fillOval, and fillArc.
* 	- manage layers by drawing the background elements before foreground ones.
*
* >Pseudocode:
* 	1. Initialize a JFrame and add a custom JPanel.
* 	2. Set the background to BLUE in the Panel constructor.
* 	3. Override paintComponent to call specific methods for each scene element.
* 	4. Use pixel coordinates to draw lines for the handle and a polygon for the bowl.
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Constellation
{
	public void runIt()
	{
		JFrame f = new JFrame("The Big Dipper");

		f.setSize(630,450);
		f.setResizable(false);
		f.setLocation(0,0);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		Panel panel1 = new Panel();
		f.setContentPane(panel1);
		f.setVisible(true);
	}

	public static void main(String[] args)
	{
		Constellation cons = new Constellation();
		cons.runIt();
	}
}

class Panel extends JPanel
{
	public Panel()
	{
		setBackground(Color.BLUE);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		// drawGrid(g);

		label(g);
		moon(g);
		constellation(g);
		ground(g);
		rocket(g);
	}

	public void label(Graphics g)
	{
		//Label: "The Big Dipper"
		g.setColor(Color.WHITE);
		g.setFont(new Font("serif", Font.ITALIC, 50));
		g.drawString("The Big Dipper",150,80);
		//Label Outline rectangle
		g.drawRect(140,35,340,65);
	}

	public void moon(Graphics g)
	{
		//Moon
		g.setColor(Color.YELLOW);
		g.fillOval(-5,-5,120,120);
		g.setColor(Color.BLUE);
		g.fillOval(-20,-20,115,115);
	}

	public void constellation(Graphics g)
	{
		//Constellation
		g.setColor(Color.WHITE);
		g.drawLine(40,240,180,180);
		g.drawLine(180,180,240,200);
		g.drawLine(240,200,360,220);
		int[] dip_x = new int[]{360,540,560,400};
		int[] dip_y = new int[]{220,140,240,300};
		g.drawPolygon(dip_x,dip_y,4);
		g.fillOval(35,235,10,10);
		g.fillOval(175,175,10,10);
		g.fillOval(235,195,10,10);
		g.fillOval(355,215,10,10);
		g.fillOval(535,135,10,10);
		g.fillOval(555,235,10,10);
		g.fillOval(395,295,10,10);
	}

	public void ground(Graphics g)
	{
		//Ground
		g.setColor(new Color(135, 65, 9));
		g.fillArc(0,380,630,100,0,180);
	}

	public void rocket(Graphics g)
	{
		//Rocket
		g.setColor(Color.RED);
		int[] rocket_x = new int[]{58,110,140,120,65};
		int[] rocket_y = new int[]{345,335,350,370,380};
		g.drawPolygon(rocket_x,rocket_y,5);

		//Rocket fuel streak
		g.fillArc(30,325,60,55,190,20);
		g.fillArc(32,340,60,55,190,20);

		//Rocket curve
		g.drawArc(0,340,650,100,20,105);
	}

/* 
	public void drawGrid(Graphics g)
	{
		int size = 20;
		g.setFont(new Font("serif", Font.PLAIN, 15));
		for(int x = 0; x <= 640; x += size)
		{
			g.setColor(new Color(165, 200, 233));
			g.drawLine(x, 0, x, 440);
			if(x%100 == 0)
			{
				g.setColor(Color.BLACK);
				g.drawString(x + "", x-12, 12);
			}
		}

		for(int y = 0; y <= 450; y += size)
		{
			g.setColor(new Color(165, 200, 233));
			g.drawLine(0, y, 640, y);
			if(y%100 == 0)
			{
				g.setColor(Color.BLACK);
				g.drawString(y + "", 0, y+3);
			}
		}
	}*/
}
