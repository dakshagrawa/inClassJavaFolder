import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class Garden extends JPanel implements MouseListener, KeyListener
{
	private boolean isWatered_mouseClicked;   // clicked inside garden
	private boolean isWatered_keyTyped;       // '%' typed
	private boolean isFlower_mouseClicked;    // clicked for sun
	private boolean isFlower_keyTyped;        // UP arrow pressed

	public Garden()
	{
		isWatered_mouseClicked = false;
		isWatered_keyTyped = false;
		isFlower_mouseClicked = false;
		isFlower_keyTyped = false;

		addMouseListener(this);               // enable mouse input
		addKeyListener(this);                 // enable keyboard input
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);              // clear panel

		// draw garden color
		if(isWatered_mouseClicked && isWatered_keyTyped)
		{
			g.setColor(Color.GREEN);          // watered
			g.fillRect(50,50,1000,500);
		}
		else
		{
			g.setColor(Color.PINK);           // default
			g.fillRect(50,50,1000,500);
		}

		// draw flowers if sun + water
		if(isFlower_mouseClicked && isFlower_keyTyped)
		{
			Color[] colors = new Color[]{Color.YELLOW,Color.MAGENTA, Color.PINK, Color.ORANGE, Color.BLUE, Color.RED, Color.WHITE};
			for(int x = 50+100; x <= 1000; x+=250) // added extra pixels in starting x value to make garden look neat
			{
				for(int y = 50+100; y <= 500; y+=250) // added extra pixels in starting y value to make garden look neat
				{
					g.setColor(colors[(int)(Math.random()*7)]);
					g.fillOval(x,y,50,50);    // flower
				}
			}
		}
		
		requestFocusInWindow();               // keep key input active
	}

	public void mouseClicked(MouseEvent evt)
	{
		int xMouse = evt.getX();
		int yMouse = evt.getY();
		boolean inGarden = (xMouse>50 && xMouse<1050 && yMouse>50 && yMouse<550);

		if(!isWatered_mouseClicked && inGarden)
			isWatered_mouseClicked = true;    // first watering step

		if(!isFlower_mouseClicked && inGarden && isWatered_keyTyped)
			isFlower_mouseClicked = true;     // first sun step
	}

	public void mousePressed(MouseEvent evt){}
	public void mouseReleased(MouseEvent evt){}
	public void mouseEntered(MouseEvent evt){}
	public void mouseExited(MouseEvent evt){}

	public void keyTyped(KeyEvent evt)
	{
		if(evt.getKeyChar()=='%' && !isWatered_keyTyped && isWatered_mouseClicked)
		{
			isWatered_keyTyped = true;        // finish watering
			repaint();
		}
	}
	
	public void keyPressed(KeyEvent evt)
	{
		if(!isFlower_keyTyped && evt.getKeyCode()==KeyEvent.VK_UP && isFlower_mouseClicked)
		{
			isFlower_keyTyped = true;         // finish sun
			repaint();
		}
	}

	public void keyReleased(KeyEvent evt)
	{
		if(evt.getKeyCode()==KeyEvent.VK_SPACE)
		{
			// reset everything
			isWatered_mouseClicked = false;
			isWatered_keyTyped = false;
			isFlower_mouseClicked = false;
			isFlower_keyTyped = false;
			repaint();
		}
	}
}
