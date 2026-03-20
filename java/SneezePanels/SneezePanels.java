// Daksh Agrawal (Period 7)
// date: 3/17/2026
// SneezePanels.java
/*  IDEA of this program:  PanelHolder, which is added to the frame, holds two panels,
LeftPanel and RightPanel, which are added to PanelHolder in a GridLayout. The 
LeftHolder has a BorderLayout and has two panels-a direction panel, with a FlowLayout 
that has a the button, and a textField panel that contains the textField.  When
the button is pressed, Achoo and a yellow oval are drawn on the Right Panel.  
When the user types in "Bless you" in the textField, the RightPanel is erased
and variables are reset.
*/
/// Testing:  Only clicking on the button will draw on the right panel.  Only typing 
/// in "Bless you" will clear it.
/// Try clicking anywhere other that the button.  This should will not change anything.  
/// Typing anything other than "Bless you" will not reset the panels.

import java.awt.event.ActionListener;	
import java.awt.event.ActionEvent;

import javax.swing.JFrame;	
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Color;		
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Dimension;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class SneezePanels
{	
	public static void main( String[] args )
	{
		SneezePanels sp = new SneezePanels();
		sp.run();
	}
	
	public SneezePanels()
	{	
	}

	public void run()
	{
		JFrame sneezeFrame = new JFrame ("Sneeze and Bless you.");
		
		sneezeFrame.setSize( 600, 400);				
		sneezeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		sneezeFrame.setLocation(400,50);
		sneezeFrame.setResizable(true);
		PanelHolder pHolder = new PanelHolder(); 
		sneezeFrame.add( pHolder );		

		sneezeFrame.setVisible(true);	
	}

	// This panel holds two panels-one on the left and one on the right, aptly named
	class PanelHolder extends JPanel
	{
		private RightPanel rp;	// these are field variables so the nested classes have access to them
		private boolean nosePressed;	// otherwise, we have to use getter-setter methods
		private Font font;
		
		public PanelHolder()
		{
			setLayout( new GridLayout(1, 2) );
			nosePressed = false;
			font = new Font("Serif", Font.PLAIN, 17);

			LeftPanel lp = new LeftPanel();
			add(lp);
			rp = new RightPanel();
			add( rp );
		}

		// This panel will have a BorderLayout
		//  It will have the directions panel in the center, and the 
		// textField panel in the south. 
		class LeftPanel extends JPanel
		{	
			public LeftPanel()
			{	
				setLayout(new BorderLayout());
				// setBackground( Color.MAGENTA );
			
				DirectionPanel dirP = new DirectionPanel ();
				TFPanel tfp = new TFPanel();
				
				add ( dirP, BorderLayout.CENTER );
				add ( tfp, BorderLayout.SOUTH );
			}
		
		}
		
		// DirectionPanel will print the directions and contain the 
		// nose button.  It has a FlowLayout.  It will use a 
		// ButtonHandler for actionPerformed.
		class DirectionPanel extends JPanel
		{
			public DirectionPanel()
			{
				setLayout(new FlowLayout(FlowLayout.CENTER, 0, 110));
				setBackground(new Color(195, 227, 237));
				
				JButton button1 = new JButton("Nose");
				button1.setPreferredSize(new Dimension(100,35));
				button1.addActionListener(new Button1Handler());
				add(button1);
				nosePressed = false;
			}	
			
			public void paintComponent( Graphics g )
			{
				super.paintComponent(g);
				
				g.setFont(font);
				g.setColor(Color.BLACK);
				g.drawString("Directions: Press button", 50,50);
				g.drawString("to tickle the nose", 50,70);
				
			}
		}

		// The TFPanel will have a FlowLayout and contain a text field
		// that will be on the left.  It uses a handler class for 
		// actionPerformed
		class TFPanel extends JPanel
		{
			public TFPanel()
			{
				this.setBackground(new Color(222, 232, 201));
				this.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
				JTextField textField1 = new JTextField("Type: Bless you.", 20);
				textField1.setEditable(true);
				textField1.setPreferredSize(new Dimension(350,35));
				textField1.addActionListener(new TextFieldHandler());
				add(textField1);
				textField1.requestFocusInWindow();
				repaint();
			}
		}
		
		// The RightPanel is used to draw "Achoo" and a yellow oval when the
		// button is pressed and cleared when "Bless you" is typed in
		// the textField
		class RightPanel extends JPanel
		{
			public RightPanel()
			{
				setBackground(new Color(245, 227, 225));
			}
			
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				if(nosePressed)
				{
					g.setColor(Color.BLACK);
					g.setFont(font);
					g.drawString("Achoo!",120,60);
					g.setColor(new Color(255, 251, 0));
					g.fillOval(100,110,90,100);
					g.setColor(Color.BLACK);
				}
			}

		}

		// When the button is pressed, the method actionPerformed is 
		// used to call paintComponent in RightPanel
		class Button1Handler implements ActionListener 
		{
			public void actionPerformed(ActionEvent e)
			{
				nosePressed = true;
				repaint();
			}
		}	// end class Button1Handler	

		// When the user types in "Bless you" in the textField, the 
		// boolean is reset	and RightPanel's paintComponent is called
		class TextFieldHandler implements ActionListener 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String command = e.getActionCommand();
				
				if(command.equalsIgnoreCase("Bless You."))
					nosePressed = false;
				repaint();
			}
		}	// end class TextFieldHandler
	}
}
