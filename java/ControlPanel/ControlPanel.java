// Daksh Agrawal (Period 7)
// 03/23/2026
// ControlPanel.java
// This program gives an example of using several components in order to change the
// different components and/or images.

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Image;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;	
import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControlPanel
{
	public static void main(String[] args) 
	{
		ControlPanel ce = new ControlPanel();
		ce.run();
	}
	
	public void run() 
	{
		JFrame frame = new JFrame ("Control Panel for Picture");
		frame.setSize(800, 600);
		frame.setLocation(10, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		CpPanelHolder cph = new CpPanelHolder();
		frame.getContentPane().add(cph);
		frame.setVisible(true);
	}
}

class CpPanelHolder extends JPanel
{
	private int selected;  // the index for the picture selected to draw
	private JTextArea tAComponentInfo;	// text area in the PictPanel, but changed in RightControlPanel2
	private JLabel welcome;	// label in the PictPanel, but changed in RightControlPanel2
	private Font font;  // most fonts are the same, so there is one
	private PictPanel pp; // the variables in the RightControlPanel2 need access to use repaint
	private int val; // value of the slider to change the picture size
	private int width;
	private int height;
	private int [] widthOfImages;  // stores the width of each image
	private int [] heightOfImages;  // stores the height of each image
	
	public CpPanelHolder()
	{
		selected = 0;
		font = new Font("Serif", Font.BOLD, 20);
		tAComponentInfo = new JTextArea("What the component changed will show here ",10,400);
		welcome = new JLabel("Welcome");
		welcome.setForeground(Color.BLACK);
		welcome.setFont(font);
		pp = new PictPanel();
		val = 0;

		setLayout(new BorderLayout());
		
		add(pp,BorderLayout.CENTER);
		add(new RightControlPanel(),BorderLayout.EAST);
	}
	
	
	/* PictPanel, which has a border layout,  has a label and a text area, both declared above.
	*	most of the code for loading the images is given.  add the rest for the images
	*	plus add the code for the text area, label and font (not necessarily in that order).
	*	the fonts, unless otherwise stated are size 20, bold and Serif.  
	*/
	class PictPanel extends JPanel
	{
		private String[] names;	// the names of the pictures
		private Image[] images;	// array of images to be drawn
		
		public PictPanel()
		{
			setLayout(new BorderLayout());
			names = new String[] {"mountains.jpg", "shanghai.jpg", "trees.jpg", "water.jpg"};
			images = new Image[names.length];
			widthOfImages = new int[names.length];
				// create the array for the heights
			
			// load all of the pictures
			for (int i = 0; i < names.length; i++)
			{ // since all of the images are in a directory called pictures, each file
			  // name needs the following before the file name:   "pictures/" + 
			  // e.g. it could be:  pictures/mountains.jpg
				images[i] = getMyImage("pictures/" + names[i]);

				widthOfImages[i] = images[i].getWidth(this);
				// find the heights of each picture
			}
			
			add(new GetLabel(), BorderLayout.NORTH);
			add(new GetTextArea(), BorderLayout.SOUTH);
		}
		
		// this has been started for you
		public Image getMyImage(String pictName) 
		{
			Image picture = null;
			try
			{
				picture = ImageIO.read(new File(pictName));
			}
			catch(IOException e)
			{
				System.err.println("\n\n"+pictName+ "can't be found.\n\n");
				e.printStackTrace();
			}
			
			return picture;
		}
		
		// draw the image on a blank screen with the top left corner at (20,20)
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);

			g.drawImage(images[selected], 20, 55, 300,
					(int)(images[selected].getHeight(this)*(300.0 / images[selected].getWidth(this))),
					this);
				
			
		}
		
		class GetLabel extends JPanel
		{
			public GetLabel()
			{
				setLayout(new FlowLayout(FlowLayout.CENTER));
				add(welcome);
			}
		}
		
		class GetTextArea extends JPanel
		{
			public GetTextArea()
			{
				setLayout(new BorderLayout());
				add(tAComponentInfo);
			}
		}
	}	
		
	/* Make all panels on the right be cyan.
	* RightControlPanel has a border layout.
	* On this panel are:  label, which font size already done, the text field, the menu,
	* the radio buttons and the slider.
	* You will have to determine the layouts in order to make them show up like the sample
	* run provided.
	*/
	class RightControlPanel extends JPanel
	{
		private JTextField tfName; // text field for user to type in their name
		private ButtonGroup bg;	// to select the color so only one is selected
		private JRadioButton color1, color2, color3;	// color choices
		private JSlider sSize;	// slider for changing the size of the picture
		
		public RightControlPanel()
		{
			setLayout(new BorderLayout(0, 0));
			setPreferredSize(new Dimension(300,getHeight()));

			add(new EnterName(),BorderLayout.NORTH);

			add(new PictureMenu(),BorderLayout.CENTER);
		}
		
		public void paintComponent(Graphics g) // not needed in this class
		{
			super.paintComponent(g);
		}
	
		// There are a some more classes that you will need here to add to RightControlPanel
		// You will need to figure them out based on the directions/prompt and the 
		// sample run in the prompt.  You can figure them out based on your drawing of the
		// layout, i.e. your pseudocode for this.
		class EnterName extends JPanel {
			public EnterName() 
			{
				setLayout(new FlowLayout(FlowLayout.CENTER, 200, 10));
				setBackground(Color.CYAN);
				setPreferredSize(new Dimension(100, 80));

				panelLabel();
				panelTextField();
			}

			public void panelLabel() 
			{
				JLabel controlLabel = new JLabel("Control Panel");
				controlLabel.setFont(font);
				controlLabel.setForeground(Color.BLACK);
				add(controlLabel);
			}

			public void panelTextField() 
			{
				tfName = new JTextField("Enter your Name");
				tfName.setPreferredSize(new Dimension(130,20));
				tfName.setEditable(true);
				tfName.addActionListener(new TfNameHandler());
				add(tfName);
			}

			public void paintComponent(Graphics g) 
			{
				super.paintComponent(g);
			}
		}

		class PictureMenu extends JPanel
		{
			public PictureMenu()
			{
				setBackground(Color.CYAN);
				setPreferredSize(new Dimension(65,20));
				setLayout(new FlowLayout(FlowLayout.LEFT,40,5));
				add(makePictureMenuBar());
			}
		}

		
		public JMenuBar makePictureMenuBar()
		{
			JMenuBar bar = new JMenuBar();
			JMenu pictures = new JMenu("Picture");
			
			JMenuItem img1 = new JMenuItem("Mountains");
			JMenuItem img2 = new JMenuItem("Shanghai");
			JMenuItem img3 = new JMenuItem("Trees");
			JMenuItem img4 = new JMenuItem("Water");

			PictureMenuHandler pmh = new PictureMenuHandler();
			img1.addActionListener(pmh);
			img2.addActionListener(pmh);
			img3.addActionListener(pmh);
			img4.addActionListener(pmh);

			pictures.add(img1);
			pictures.add(img2);
			pictures.add(img3);
			pictures.add(img4);

			bar.add(pictures);
			return bar;
		}
	
		
		// Write the Listener/Handler class for the menu
		class PictureMenuHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent evt)
			{
				String pictureInMenu = evt.getActionCommand();
				if(pictureInMenu.equals("Mountains"))
					selected = 0;
				else if(pictureInMenu.equals("Shanghai"))
					selected = 1;
				else if(pictureInMenu.equals("Trees"))
					selected = 2;
				else if(pictureInMenu.equals("Water"))
					selected = 3;

				tAComponentInfo.append("\nThe picture \""+pictureInMenu.toLowerCase()+".jpg\" was selected. ");
			}
		}
		
	
		// write the Listener/Handler class for the text field
		class TfNameHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent evt)
			{
				String tfNameValue = evt.getActionCommand().trim();
				
				if(!tfNameValue.equalsIgnoreCase("Enter your Name"))
				{
					welcome.setText("Welcome " + tfNameValue);
					
					tAComponentInfo.setText("\"" + tfNameValue + "\" was entered in the text field ");

					//! do repaint or something to make the value reflect on PictPanel
					pp.repaint();
				}
			}
		}
		
		

		// write the Listener/Handler class for the slider
	
		// write Listener/Handler class for the JRadioButtons
		
	}
}	// end class ControlPanel
