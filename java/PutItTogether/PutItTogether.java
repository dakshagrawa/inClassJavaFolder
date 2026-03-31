// Daksh Agrawal
/* Period 7
* 03/30/2026
* PutItTogether.java
*/

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class PutItTogether extends JFrame
{	
	public PutItTogether()
	{
	}
	
	public static void main(String [] args)
	{
		PutItTogether pit = new PutItTogether();
		pit.run();
	}
	
	public void run()
	{
		JFrame frame = new JFrame("PutItTogether");
		frame.setSize( 800, 700);				
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); 
		frame.setLocation(0,0);
		frame.setResizable(true);
		PutItTogetherHolder pith = new PutItTogetherHolder(); 		
		frame.getContentPane().add( pith );		
		frame.setVisible(true);		
	}
}

// this panel holds the main cards/panel 
class PutItTogetherHolder extends JPanel 
{	
	public PutItTogetherHolder()
	{
		setBackground(Color.CYAN);

		CardLayout cards = new CardLayout();
		setLayout(cards);
		
		Information info = new Information();
		FirstPagePanel fpp = new FirstPagePanel(this, cards, info);
		FixedPanelHolder hph = new FixedPanelHolder(info);
		
		add(fpp, "First");
		add(hph, "Home");
		
		show("First");
	}
}

// First page to show up.  Gives information, asks for name.  Goes to Home page.
class FirstPagePanel extends JPanel
{
	private PutItTogetherHolder panelCards;
	private CardLayout cards;
	private Information info;
	private JTextField tfName;
	
	public FirstPagePanel(PutItTogetherHolder panelCardsIn, CardLayout cardsIn, Information infoIn)
	{
		panelCards = panelCardsIn;
		card = cardsIn;
		info = infoIn;
		setLayout(null);
		add(introText());
		add(nameField());
		add();
	}
	
	public JTextArea introText()
	{
		String text = new String("""
						Welcome to PutItTogether!\n
						We’re so glad you’re here. This program was created to 
						give you a simple, fun, and interactive experience where 
						you can explore characters, customize visuals, and enjoy 
						a bit of creativity along the way. As you move through 
						the screens, you’ll discover features that let you learn 
						about two special characters, experiment with the appearance 
						of a shape, and view a small but charming piece of digital art.\n\n

						After this introduction, you’ll be taken to the home page 
						of the program. There, you’ll find three clearly labeled 
						options—each represented by a JRadioButton—that guide you 
						to a different part of the experience. To help you get familiar 
						with what each one does, here’s a quick overview:\n\n

						1. Character Information: This button takes you to a page dedicated 
						to two unique characters. You’ll be able to read about who they are, 
						what makes them interesting, and why they’re part of the program. 
						It’s a simple, friendly way to get to know them before exploring 
						the rest of the features.\n\n

						2. Shape Customizer: If you enjoy experimenting with visuals, 
						this is the place for you. Selecting this option brings you 
						to a screen where you can change the color, size, and overall 
						appearance of a shape. It’s a light, creative activity that 
						lets you play around and see instant results.\n\n

						3. Art Viewer: This button leads you to a small showcase 
						featuring a piece of digital art. It’s meant to be a calm, 
						visually pleasing moment in the program, something you can 
						simply look at and enjoy before moving on.\n\n

						Take your time, explore each section, and have fun putting 
						everything together. That’s what the program is all about.
						""");
		JTextArea intro = new JTextArea(text);
		intro.setBounds(20,5,760,400);
		return intro;
	}
	
	public JTextField nameField()
	{
		tfName.setText("Enter your name");
		tfName.addActionListener(new NameListener());
		tfName.setBounds(20,5,760,400);
		return tfName;
	}
	
	class NameListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String name = e.getActionCommand();
			info.setName(name);
		}
	}
	
}

class FixedPanelHolder extends JPanel
{
	private Information info;
	private JButton homeButton;
	
	public FixedPanelHolder(info)
	{
		
	}
}

class HomePanelHolder extends JPanel
{
	private Image picture;
	private Information info;
	private String pictName;
	private CardLayout cards;
	
	public HomePanelHolder (Information infoIn)
	{
	}

	public CardLayout getCardLayout()
	{
		return cards;
	}
}

class HomePanel extends JPanel
{
	
	// Since the label for the name was created when the classes constructor was called
	// it needs to be updated after the user types in the name into the text field.
	// Update that label in paintComponent.
	public void paintComponent(Graphics g)
	{
	}
	
	
}

class BothPictPanel extends JPanel implements MouseListener
{
	
}

class MyPictPanel extends JPanel implements ActionListener
{
	
}


class FriendPictPanel extends JPanel implements ActionListener
{
	
}

class DrawPanel extends JPanel
{
	private RightPanel rp;
	private int amtRed, amtGreen, amtBlue;
	private int size;
	
	public class LeftPanel extends JPanel
	{
	}
	
	public class RightPanel extends JPanel
	{
	}
}

class Information
{
	private String name;
	
	public Information()
	{
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String nameIn)
	{
		name = nameIn;
	}
}

