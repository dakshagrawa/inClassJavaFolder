// Daksh Agrawal
/* Period 7
* 02/24/2026
*
* Constellation2.java
*
* >Objective: 
* 	To create a scalable version of the Big Dipper scene that can be 
* 	tiled across the screen using mathematical offsets and scaling.
*
* >Description: 
* 	This program uses nested loops and a SCALE FACTOR to render a 4x4 
* 	grid of the constellation scene. Each method (moon, rocket, etc.) 
* 	calculates its position based on passed x/y offsets.
*
* >Learning: 
* 	- how to translate polygons by adding offsets to coordinate arrays.
*
* >Pseudocode:
* 	1. Set JFrame size to accommodate multiple tiles.
* 	2. Use nested loops to iterate through x and y "tile" positions.
* 	3. Pass a scale factor (0.25) and loop offsets to drawing methods.
* 	4. Multiply original coordinates by scale and add offsets for placement.
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Constellation2
{
	public void runIt()
	{
		JFrame f = new JFrame("The Big Dipper");

		f.setSize(630+(50*4),450+(50*4));
		f.setResizable(true);
		f.setLocation(0,0);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		Panel panel1 = new Panel();
		f.setContentPane(panel1);
		f.setVisible(true);
	}

	public static void main(String[] args)
	{
		Constellation2 cons = new Constellation2();
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
		final double SCALEFACTOR = 1.0/4.0;

		super.paintComponent(g);
		// drawGrid(g);

		for(int i = 0; i < 4*(int)(SCALEFACTOR*630+50); i+=(int)(SCALEFACTOR*630+50))
		{
			for(int j = 0; j < 4*(int)(SCALEFACTOR*450+50);j+=(int)(SCALEFACTOR*450+50))
			{
				label(g,SCALEFACTOR,i,j);
				moon(g,SCALEFACTOR,i,j);
				constellation(g,SCALEFACTOR,i,j);
				ground(g,SCALEFACTOR,i,j);
				rocket(g,SCALEFACTOR,i,j);
			}
		}
	}
	public void label(Graphics g, double F, int x, int y)
	{
		//Label: "The Big Dipper"
		g.setColor(Color.WHITE);
		g.setFont(new Font("serif", Font.ITALIC, (int)(F*50)));
		g.drawString("The Big Dipper",x+(int)(F*150),y+(int)(F*80));
		
		//Label Outline rectangle
		g.drawRect(x+(int)(F*140),y+(int)(F*35),(int)(F*340),(int)(F*65));
	}

	public void moon(Graphics g, double F, int x, int y)
	{
		//Moon
		g.setColor(Color.YELLOW);
		g.fillOval(x+(int)(F*-5),y+(int)(F*-5),(int)(F*120),(int)(F*120));
		g.setColor(Color.BLUE);
		g.fillOval(x+(int)(F*-20),y+(int)(F*-20),(int)(F*115),(int)(F*115));
	}

	public void constellation(Graphics g, double F, int x, int y)
	{
		//Constellation
		g.setColor(Color.WHITE);
		g.drawLine(x+(int)(F*40),y+(int)(F*240),x+(int)(F*180),y+(int)(F*180));
		g.drawLine(x+(int)(F*180),y+(int)(F*180),x+(int)(F*240),y+(int)(F*200));
		g.drawLine(x+(int)(F*240),y+(int)(F*200),x+(int)(F*360),y+(int)(F*220));
		int[] dip_x = new int[]{x+(int)(F*360),x+(int)(F*540),x+(int)(F*560),x+(int)(F*400)};
		int[] dip_y = new int[]{y+(int)(F*220),y+(int)(F*140),y+(int)(F*240),y+(int)(F*300)};
		g.drawPolygon(dip_x,dip_y,4);
		g.fillOval(x+(int)(F*35),y+(int)(F*235),(int)(F*10),(int)(F*10));
		g.fillOval(x+(int)(F*175),y+(int)(F*175),(int)(F*10),(int)(F*10));
		g.fillOval(x+(int)(F*235),y+(int)(F*195),(int)(F*10),(int)(F*10));
		g.fillOval(x+(int)(F*355),y+(int)(F*215),(int)(F*10),(int)(F*10));
		g.fillOval(x+(int)(F*535),y+(int)(F*135),(int)(F*10),(int)(F*10));
		g.fillOval(x+(int)(F*555),y+(int)(F*235),(int)(F*10),(int)(F*10));
		g.fillOval(x+(int)(F*395),y+(int)(F*295),(int)(F*10),(int)(F*10));
	}

	public void ground(Graphics g, double F, int x, int y)
	{
		//Ground
		g.setColor(new Color(135, 65, 9));
		g.fillArc(x+(int)(F*0),y+(int)(F*380),(int)(F*630),(int)(F*100),0,180);
	}

	public void rocket(Graphics g, double F, int x, int y)
	{
		//Rocket
		g.setColor(Color.RED);
		int[] rocket_x = new int[]{x+(int)(F*58),x+(int)(F*110),x+(int)(F*140),x+(int)(F*120),x+(int)(F*65)};
		int[] rocket_y = new int[]{y+(int)(F*345),y+(int)(F*335),y+(int)(F*350),y+(int)(F*370),y+(int)(F*380)};
		g.drawPolygon(rocket_x,rocket_y,5);

		//Rocket fuel streak
		g.fillArc(x+(int)(F*30),y+(int)(F*325),(int)(F*60),(int)(F*55),190,20);
		g.fillArc(x+(int)(F*32),y+(int)(F*340),(int)(F*60),(int)(F*55),190,20);

		//Rocket curve
		g.drawArc(x+(int)(F*0),y+(int)(F*340),(int)(F*650),(int)(F*100),20,105);
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
