// Daksh Agrawal
/* Period 7
* 02/12/2026
* 
* Masterpiece.java
* 
* >Objective:
*   Create an original graphics scene using Java’s Graphics class, combining
*   shapes, colors, and drawing methods to form a cohesive “masterpiece.”
* 
* >Description:
*   This program draws a nighttime mountain landscape. It includes a moon,
*   stars, clouds, mountains, trees, and a grassy ground layer. The scene is
*   built using rectangles, ovals, polygons, arcs, and text.
*
* >Learning:
*   - How to organize a graphics program into multiple drawing methods.
*   - How to use coordinates, colors, and shape dimensions effectively.
*   - How to layer shapes to create depth and detail in a scene.
*
* >Pseudocode:
*   - Set up window and panel.
*   - Paint background sky.
*   - Draw ground rectangle.
*   - Draw stars and title text.
*   - Draw moon, trees, and cloud using ovals.
*   - Draw mountains using polygon arrays.
*   - Add cloud outline using arcs.
*   - Draw tree trunks using rectangles.
*
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Masterpiece
{
	public void runIt()
	{
		JFrame f = new JFrame("Daksh's Masterpiece");
		
		f.setSize(1000,500);
		f.setResizable(false);
		f.setLocation(0,0);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		Panel panel1 = new Panel();
		f.setContentPane(panel1);
		f.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		Masterpiece mp = new Masterpiece();
		mp.runIt();
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

		drawRects1(g);
		drawStrings(g);
		drawOvals(g);
		drawPolygons(g);
		drawArcs(g);
		drawRects2(g);
	}

	/*  Draw the ground rectangle */
	public void drawRects1(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.fillRect(0,400,1000,100);
	}

	/*  Draw the title and stars */
	public void drawStrings(Graphics g)
	{
		// Title on bottom
		g.setFont(new Font("roboto", Font.BOLD, 20));
		g.setColor(Color.BLACK);
		g.drawString("Mountain Night", 400, 435);

		// Stars
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Serif",Font.PLAIN, 40));
		g.drawString("*",100,100);
		g.drawString("*",150,225);
		g.drawString("*",200,150);
		g.drawString("*",550,50);
		g.drawString("*",650,175);
		g.drawString("*",800,250);
		g.drawString("*",825,125);
		g.drawString("*",900,200);
	}

	/*  Draw moon, trees, and cloud using ovals */
	public void drawOvals(Graphics g)
	{
		// Moon
		g.setColor(Color.YELLOW);
		g.fillOval(400,200,200,200);

		// Moon outline
		g.setColor(Color.BLACK);
		g.drawOval(400,200,200,200);
		
		// Trees
		g.setColor(Color.GREEN);
		g.fillOval(100,300,50,50);
		g.fillOval(900,300,60,60);
		g.fillOval(700,325,50,50);

		// Tree outlines
		g.drawOval(100,300,50,50);
		g.drawOval(900,300,60,60);
		g.drawOval(700,325,50,50);

		// Cloud
		g.setColor(Color.WHITE);
		g.fillOval(400,100,100,50);
		g.fillOval(400,125,100,50);
		g.fillOval(385,120,30,35);
		g.fillOval(485,120,30,35);

	}

	/*  Draw mountains as a filled polygon and outline */
	public void drawPolygons(Graphics g)
	{
		// Mountains
		g.setColor(Color.darkGray);
		int[] mount_x = new int[]{225,300,325,400,500,525,600};
		int[] mount_y = new int[]{400,300,325,200,325,300,400};
		g.fillPolygon(mount_x,mount_y,7);
	
		// Mountains' outline
		g.setColor(Color.BLACK);
		g.drawPolygon(mount_x,mount_y,7);
	}
	
	/*  Draw cloud outline using arcs */
	public void drawArcs(Graphics g)
	{
		// Cloud Outline
		g.setColor(Color.BLACK);
		g.drawArc(400,100,100,50,170,-165);
		g.drawArc(400,125,100,50,-170,160);
		g.drawArc(385,120,30,35,85,195);
		g.drawArc(485,120,30,35,-100,200);
		
	}

	/*  Draw tree trunks and their outlines */
	public void drawRects2(Graphics g)
	{
		// Trees' trunks
		g.setColor(Color.darkGray);
		g.fillRect(122,325,6,100);
		g.fillRect(927,325,6,100);
		g.fillRect(722,350,6,100);

		// Tree trunk's outlines
		g.setColor(Color.BLACK);
		g.drawRect(122,325,6,100);
		g.drawRect(927,325,6,100);
		g.drawRect(722,350,6,100);
	}
}
