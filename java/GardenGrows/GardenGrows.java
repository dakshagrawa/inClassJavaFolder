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
* 	Garden.java class header extends JPanel and implements MouseListener and KeyListener
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
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GardenGrows
{
	public GardenGrows()
	{
	}
	
	public static void main(String[] args)
	{
		GardenGrows gg = new GardenGrows();
		gg.gardenFrame();
	}
	
	public void gardenFrame()
	{
		JFrame f = new JFrame("Garden");
		
		f.setSize(1100,600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocation(0,0);
		f.setResizable(true);
		Garden garden = new Garden();
		f.setContentPane(garden);
		f.setVisible(true);
	}
}

class Garden extends JPanel implements MouseListener, KeyListener
{
	private boolean isWatered_mouseClicked;
	private boolean isWatered_keyTyped;
	private boolean isSun_mouseClicked;
	private boolean isSun_keyTyped;

	public Garden()
	{
		isWatered_mouseClicked = false;
		isWatered_keyTyped = false;
		isSun_mouseClicked = false;
		isSun_keyTyped = false;

		addMouseListener(this);
		addKeyListener(this);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		if(isWatered_mouseClicked && isWatered_keyTyped)
		{
			g.setColor(Color.GREEN);
			g.fillRect(50,50,1000,500);
		}
		else
		{
			g.setColor(Color.PINK);
			g.fillRect(50,50,1000,500);
		}

		if(isSun_mouseClicked && isSun_keyTyped)
		{
			Color[] colors = new Color[]{Color.YELLOW,Color.MAGENTA, Color.PINK, Color.ORANGE, Color.BLUE, Color.RED, Color.WHITE};
			for(int x = 100; x < 1050; x+=250)
			{
				for(int y = 100; y < 550; y+=250)
				{
					g.setColor(colors[(int)(Math.random()*7)]);
					g.fillOval(x,y,50,50);
				}
			}
		}
		
		requestFocusInWindow();
	}

	public void mouseClicked(MouseEvent evt)
	{
		int xMouse = evt.getX();
		int yMouse = evt.getY();
		boolean inGarden = (xMouse>50 && xMouse<1050 && yMouse>50 && yMouse<550);

		if(!isWatered_mouseClicked && inGarden)
			isWatered_mouseClicked = true;

		if(!isSun_mouseClicked && inGarden && isWatered_keyTyped)
			isSun_mouseClicked = true;
	}

	public void mousePressed(MouseEvent evt){}
	public void mouseReleased(MouseEvent evt){}
	public void mouseEntered(MouseEvent evt){}
	public void mouseExited(MouseEvent evt){}

	public void keyTyped(KeyEvent evt)
	{
		if(evt.getKeyChar()=='%' && !isWatered_keyTyped && isWatered_mouseClicked)
		{
			isWatered_keyTyped = true;
			repaint();
		}
	}
	
	public void keyPressed(KeyEvent evt)
	{
		if(!isSun_keyTyped && evt.getKeyCode()==KeyEvent.VK_UP && isSun_mouseClicked)
		{	isSun_keyTyped = true;
			repaint();
		}
	}

	public void keyReleased(KeyEvent evt)
	{
		if(evt.getKeyCode()==KeyEvent.VK_SPACE)
		{
			isWatered_mouseClicked = false;
			isWatered_keyTyped = false;
			isSun_mouseClicked = false;
			isSun_keyTyped = false;
			repaint();
		}
	}
}
