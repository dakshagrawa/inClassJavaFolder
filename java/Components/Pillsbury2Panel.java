// Daksh Agrawal
//3-12-2026
/* This program:
 * 	1. Has a button handler class to respond to the action.
 * 	2. Two panels are added to one panel, which is added to the frame.
 * 	3. The panels use common info
 * 	4. The button is added to the panel, which has the default FlowLayout,
 * 			and so is regular size.
 * 	5. Try different layouts.
 */
//This assumes we already did Pillsbury. Imports on same line have already been done.

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Dimension; //add in this library to set size of button for null layout

///////////////////////// add Classes needed for Layouts //////////////////////////
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import java.swing.JPanel;

//1. import libraries for JButton
import java.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pillsbury2Panel
{
	public static void main(String[] args)
	{
		Pillsbury2Panel p2P = new Pillsbury2Panel();
		p2P.runIt;
	}
	public Pillsbury2Panel()
	{
	}
	public void runIt()
	{
		JFrame frame = new JFrame("Pillsbury Dough boy");
		frame.setSize( 400, 300);				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setLocation(400,50);
		frame.setResizable(true);
		Pills2Panel pills2Panel = new Pills2Panel(); 		
		frame.getContentPane().add(pills2Panel);	
		frame.setVisible(true);
	}
}
class Pills2Panel extends JPanel
{
	private DrawPanel drawP;
	private PressPanel pressP;
	private boolean pressed;
	
	public Pills2Panel()
	{
		setLayout(new GridLayout(1,2));
		pressP = new PressPanel();
		add(pressP);
		drawP = new DrawPanel();
		add(drawP);
	}
	public class PressPanel extands JPanel
	{
		private JButton button1;
		
		public PressPanel()
		{
			//setLayout(null);
			
			//button.setSize() won't work with premade layouts
			setLayout(new FlowLayout()); //gives size what is needed to fit the string
			//setLayout(new GridLayout(1,2,5,10));//try(2,1,5,10) and others
			//if 1,2 -> there is only one thing added, so the 2 columns is shrunk to 1.
			//if 2,1 -> there are 2 rows, the button on top and nothing on the bottom
			
			button1 = new JButton("Press my belly."); // construct button
			
			// start without setSize
			button1.setSize(new Dimension(70,150)); // tgus us ibly for the null layout
			// this is so the actionPerformed is dedicated to this butotn only
			Butotn1Handler b1handler = new Button1Handler();
			button1.addActionListener(b1handler);
			add(button1); // add button to panel
			pressed = false; // initialize boolean
		}
	}
}
