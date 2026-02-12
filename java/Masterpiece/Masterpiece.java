// Daksh Agrawal
/* Period 7
* 02/12/2026
* 
* Masterpiece.java
* 
* >Objective:
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

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;

public class Masterpiece
{
	public void runIt()
	{
		JFrame f = new JFrame("Daksh's Masterpiece");
		
		f.setSize(1000,500);
		f.setResizable(true);
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
		
		g.setColor(Color.GREEN);
		g.fillRect(0,400,1000,100);
		g.setFont(new Font("roboto", Font.BOLD, 20));
		g.setColor(Color.BLACK);
		g.drawString("Mountain Night", 400, 425);
		
		g.setColor(Color.YELLOW);
		g.fillOval(400,200,200,200);
		g.setColor(Color.BLACK);
		g.drawOval(400,200,200,200);
		
		g.setColor(Color.GREEN);
		g.fillOval(100,300,50,50);
		
		g.setColor(Color.darkGray);
		g.fillRect(122,325,6,100);
		
		
		g.setColor(Color.darkGray);
		int[] mount_x = new int[]{225,300,325,400,500,525,600};
		int[] mount_y = new int[]{400,300,325,200,325,300,400};
		g.fillPolygon(mount_x,mount_y,7);
		
		//Outline
		g.setColor(Color.BLACK);
		g.drawPolygon(mount_x,mount_y,7);
		
	}
}
