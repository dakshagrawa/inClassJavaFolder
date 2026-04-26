// Daksh Agrawal
/* Period 7
* 03/30/2026
* PutItTogether.java
*/

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PutItTogether extends JFrame
{
    public static void main(String[] args)
    {
        PutItTogether pit = new PutItTogether();
        pit.run();
    }

    public void run()
    {
        JFrame frame = new JFrame("PutItTogether");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(0, 0);
        frame.setResizable(true);
        
        PutItTogetherHolder pith = new PutItTogetherHolder();
        frame.getContentPane().add(pith);
        frame.setVisible(true);
    }
}

class PutItTogetherHolder extends JPanel
{
    public PutItTogetherHolder()
    {
        CardLayout cards = new CardLayout();
        setLayout(cards);

        Information info = new Information();
        
        add(new FirstPagePanel(this, cards, info), "LoginCard");
        add(new HomePanel(this, cards, info), "Home");
        add(new BothPictPanel(this, cards, info), "Both");
        add(new MyPictPanel(this, cards, info), "My");
        add(new FriendPictPanel(this, cards, info), "Friend");
        add(new DrawPanel(this, cards, info), "Draw");
        add(new MasterpiecePanel(this, cards), "Masterpiece");

        cards.show(this, "LoginCard");
    }
}

class FirstPagePanel extends JPanel
{
    private PutItTogetherHolder panelCards;
    private CardLayout cards;
    private Information info;
    private JTextField tfName;
    private JCheckBox understandBox;
    private JLabel warningLabel;

    public FirstPagePanel(PutItTogetherHolder panelCardsIn, CardLayout cardsIn, Information infoIn)
    {
        panelCards = panelCardsIn;
        cards = cardsIn;
        info = infoIn;
        setLayout(null);
        String text = new String("""
        Welcome to PutItTogether!\n
        We're so glad you're here. This program was created to
        give you a simple, fun, and interactive experience where
        you can explore characters, customize visuals, and enjoy
        a bit of creativity along the way. As you move through
        the screens, you'll discover features that let you learn
        about two special characters, experiment with the appearance
        of a shape, and view a small but charming piece of digital art.\n\n
        After this introduction, you'll be taken to the home page
        of the program. There, you'll find three clearly labeled
        options, each represented by a JRadioButton, that guide you
        to a different part of the experience. To help you get familiar
        with what each one does, here's a quick overview:\n\n
        1. Character Information: This button takes you to a page dedicated
        to two unique characters. You'll be able to read about who they are,
        what makes them interesting, and why they're part of the program.
        It's a simple, friendly way to get to know them before exploring
        the rest of the features.\n\n
        2. Shape Customizer: If you enjoy experimenting with visuals,
        this is the place for you. Selecting this option brings you
        to a screen where you can change the color, size, and overall
        appearance of a shape. It's a light, creative activity that
        lets you play around and see instant results.\n\n
        3. Art Viewer: This button leads you to a small showcase
        featuring a piece of digital art. It's meant to be a calm,
        visually pleasing moment in the program, something you can
        simply look at and enjoy before moving on.\n
        Take your time, explore each section, and have fun putting
        everything together. That's what the program is all about.
        """);

        JTextArea intro = new JTextArea(text);
        intro.setLineWrap(true);
        intro.setWrapStyleWord(true);
        intro.setEditable(false);
        JScrollPane scroller = new JScrollPane(intro);
        scroller.setBounds(50, 50, 700, 300);
        add(scroller);

        tfName = new JTextField("Enter your name");
        tfName.setBounds(50, 380, 700, 30);
        add(tfName);

        understandBox = new JCheckBox("I understand the directions and what is to follow.");
        understandBox.setBounds(50, 420, 700, 30);
        add(understandBox);

        JButton enter = new JButton("Continue");
        enter.setBounds(340, 480, 120, 40);
        enter.addActionListener(new EnterHandler());
        add(enter);

        JPanel warningLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        warningLabel = new JLabel("");
        warningLabel.setForeground(Color.RED);
        warningLabel.setBounds(50, 530, 700, 30);
        warningLabelPanel.add(warningLabel);
        add(warningLabelPanel);
    }

    public class EnterHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String name = tfName.getText();
            boolean nameChanged = !name.equals("Enter your name") && !name.trim().isEmpty();
            boolean checked = understandBox.isSelected();

            if (nameChanged && checked)
            {
                info.setName(name);
                cards.show(panelCards, "Home");
            }
            else
            {
                warningLabel.setText("You must change the name and check the box to continue!");
            }
        }
    }
}

class HomePanel extends JPanel
{
    private Information info;
    private CardLayout cards;
    private PutItTogetherHolder panelCards;

    public HomePanel(PutItTogetherHolder panelCardsIn, CardLayout cardsIn, Information infoIn)
    {
        info = infoIn;
        cards = cardsIn;
        panelCards = panelCardsIn;
        setLayout(new BorderLayout());

        String text = "Directions: Use the options below to navigate.\n" +
                "- Character Information: Meet the stars of Bikini Bottom.\n" +
                "- Shape Customizer: Experiment with colors and sizes.\n" +
                "- Masterpiece: View the blank masterpiece canvas.";
        String longDesc = "Welcome to PutItTogether!\n\n" +
                "You can do all sorts of stuff here: \n" +
                "1. Character Selection: View SpongeBob and Patrick together on the beach. " +
                "You can click on either character to view their specific stats.\n" +
                "2. SpongeBob's Info: Detailed statistics and a zoomed-in view of SpongeBob.\n" +
                "3. Patrick's Info: Detailed statistics and a zoomed-in view of Patrick.\n" +
                "4. Shape Customizer: An interactive tool using RGB sliders and a scrollbar. " +
                "Change the color and size of a central rectangle.\n\n";
        JTextArea homeText = new JTextArea(longDesc+text);
        homeText.setEditable(false);
        JScrollPane scroller = new JScrollPane(homeText);
        scroller.setBounds(50, 80, 700, 200);
        add(scroller);

        JLabel prompt = new JLabel("Please select which page you would like to see.");
        add(prompt, BorderLayout.SOUTH);

        JRadioButton infoBtn = new JRadioButton("To see information about a friend and me.");
        infoBtn.addActionListener(new NavHandler("Both"));

        JRadioButton drawBtn = new JRadioButton("To make some colors and draw some shapes.");
        drawBtn.addActionListener(new NavHandler("Draw"));

        JRadioButton masterpieceBtn = new JRadioButton("Masterpiece");
        masterpieceBtn.addActionListener(new NavHandler("Masterpiece"));

        ButtonGroup bg = new ButtonGroup();
        bg.add(infoBtn);
        bg.add(drawBtn);
        bg.add(masterpieceBtn);
        
        add(infoBtn, BorderLayout.SOUTH);
        add(drawBtn, BorderLayout.SOUTH);
        add(masterpieceBtn, BorderLayout.SOUTH);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 22));
        g.drawString("Welcome, " + info.getName(), 50, 50);
    }

    class NavHandler implements ActionListener
    {
        private String cardName;

        public NavHandler(String name) 
        { 
            cardName = name; 
        }

        public void actionPerformed(ActionEvent e) 
        { 
            cards.show(panelCards, cardName); 
        }
    }
}

class BothPictPanel extends JPanel
{
    private Information info;
    private CardLayout cards;
    private PutItTogetherHolder panelCard;

    public BothPictPanel(PutItTogetherHolder panelCards, CardLayout cardsIn, Information infoIn)
    {
        cards = cardsIn;
        info = infoIn;
        panelCard = panelCards;
        setLayout(new BorderLayout());
        
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel header = new JLabel("Click on a person to see their info.");
        headerPanel.add(header);
        add(headerPanel, BorderLayout.NORTH);

        addMouseListener(new MouseOnImgListener());

        JButton home = new JButton("Home");
        home.addActionListener(new HomeHandler(panelCards, cards));
        JPanel bottom = new JPanel();
        bottom.add(home);
        add(bottom, BorderLayout.SOUTH);
    }

    public class MouseOnImgListener implements MouseListener
    {
        public void mouseClicked(MouseEvent e)
        {
            if (e.getX() < 400) 
                cards.show(panelCard, "My");
            else 
                cards.show(panelCard, "Friend");
        }

        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (info.getImg() != null)
        {
            g.drawImage(info.getImg(), 0, 50, 800, 600, this);
        }
        else
        {
            g.drawString("Image not found.",1,1);
        }
    }
}

class MyPictPanel extends JPanel
{
    private Information info;
    public MyPictPanel(PutItTogetherHolder panelCards, CardLayout cards, Information infoIn)
    {
        info = infoIn;
        setLayout(new BorderLayout());

        JPanel dirPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel dir = new JLabel("Information about SpongeBob");
        dirPanel.add(dir);
        add(dirPanel, BorderLayout.NORTH);

        JPanel infoPanel = new JPanel(new GridLayout(4, 1));
        infoPanel.add(new JLabel("Name: SpongeBob SquarePants"));
        infoPanel.add(new JLabel("DOB: July 14, 1986"));
        infoPanel.add(new JLabel("Age: 39"));
        infoPanel.add(new JLabel("Hobbies: Jellyfishing, Fry Cooking"));
        
        JPanel centerWrapper = new JPanel(new FlowLayout(FlowLayout.RIGHT, 40, 150));
        centerWrapper.add(infoPanel);
        add(centerWrapper, BorderLayout.CENTER);

        JButton switchBtn = new JButton("<html><center>See info for<br>the other person</center></html>");
        switchBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) { cards.show(panelCards, "Friend"); }
        });
        
        JPanel rightSide = new JPanel(new FlowLayout(FlowLayout.CENTER));
        rightSide.add(switchBtn);
        add(rightSide, BorderLayout.EAST);

        JButton home = new JButton("Home");
        home.addActionListener(new HomeHandler(panelCards, cards));
        JPanel bottom = new JPanel();
        bottom.add(home);
        add(bottom, BorderLayout.SOUTH);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (info.getImg() != null)
        {
            int mid = info.getImg().getWidth() / 2;
            int h = info.getImg().getHeight();
            g.drawImage(info.getImg(), 50, 100, 400, 600, 0, 0, mid, h, this);
        }
    }
}

class FriendPictPanel extends JPanel
{
    private Information info;
    public FriendPictPanel(PutItTogetherHolder panelCards, CardLayout cards, Information infoIn)
    {
        info = infoIn;
        setLayout(new BorderLayout());

        JPanel dirPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel dir = new JLabel("Information about Patrick");
        dirPanel.add(dir);
        add(dirPanel, BorderLayout.NORTH);

        JPanel infoPanel = new JPanel(new GridLayout(4, 1));
        infoPanel.add(new JLabel("Name: Patrick Star"));
        infoPanel.add(new JLabel("DOB: July 19, 1986"));
        infoPanel.add(new JLabel("Age: 39"));
        infoPanel.add(new JLabel("Hobbies: Sleeping, Eating"));
        
        JPanel centerWrapper = new JPanel(new FlowLayout(FlowLayout.RIGHT, 40, 150));
        centerWrapper.add(infoPanel);
        add(centerWrapper, BorderLayout.CENTER);

        JButton switchBtn = new JButton("<html><center>See info for<br>the other person</center></html>");
        switchBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) { cards.show(panelCards, "My"); }
        });
        
        JPanel rightSide = new JPanel(new FlowLayout(FlowLayout.CENTER));
        rightSide.add(switchBtn);
        add(rightSide, BorderLayout.EAST);

        JButton home = new JButton("Home");
        home.addActionListener(new HomeHandler(panelCards, cards));
        JPanel bottom = new JPanel();
        bottom.add(home);
        add(bottom, BorderLayout.SOUTH);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (info.getImg() != null)
        {
            int mid = info.getImg().getWidth() / 2;
            int w = info.getImg().getWidth();
            int h = info.getImg().getHeight();
            g.drawImage(info.getImg(), 50, 100, 400, 600, mid, 0, w, h, this);
        }
    }
}

class DrawPanel extends JPanel
{
    private int r = 255, gVal = 0, b = 255, size = 100;
    private RightPanel rp;
	private JScrollBar sb;

    public DrawPanel(PutItTogetherHolder panelCards, CardLayout cards, Information info)
    {
        setLayout(new BorderLayout());
        
        rp = new RightPanel();
        JPanel left = new JPanel(new GridLayout(8, 2));
        left.setPreferredSize(new Dimension(350, 800));
        
        JSlider rs = makeSlider(255);
        JSlider gs = makeSlider(0);
        JSlider bs = makeSlider(255);
        sb = new JScrollBar(JScrollBar.HORIZONTAL, 0, 10, 0, 110);

        ColorHandler ch = new ColorHandler(rs, gs, bs);
        rs.addChangeListener(ch);
        gs.addChangeListener(ch);
        bs.addChangeListener(ch);
        
        sb.addAdjustmentListener(new ScrollAdjustmentListener());

        left.add(new JLabel("Red Slider:")); left.add(rs);
        left.add(new JLabel("Green Slider:")); left.add(gs);
        left.add(new JLabel("Blue Slider:")); left.add(bs);
        left.add(new JLabel("Shape Size:")); left.add(sb);
        
        add(left, BorderLayout.WEST);
        add(rp, BorderLayout.CENTER);
        
        JButton home = new JButton("Home");
        home.addActionListener(new HomeHandler(panelCards, cards));
        JPanel bottom = new JPanel();
        bottom.add(home);
        add(bottom, BorderLayout.SOUTH);
    }

	public class ScrollAdjustmentListener implements AdjustmentListener
	{
		public void adjustmentValueChanged(AdjustmentEvent e)
		{
			size = 100 + sb.getValue();
			rp.repaint();
		}
	}

    private JSlider makeSlider(int val)
    {
        JSlider s = new JSlider(0, 255, val);
        s.setMajorTickSpacing(50);
        s.setPaintTicks(true);
        s.setPaintLabels(true);
        return s;
    }

    class ColorHandler implements ChangeListener
    {
        private JSlider rs, gs, bs;
        
		public ColorHandler(JSlider r, JSlider g, JSlider b) 
		{ 
			rs = r; gs = g; bs = b; 
		}
        
		public void stateChanged(ChangeEvent e)
        {
            r = rs.getValue();
            gVal = gs.getValue();
            b = bs.getValue();
            rp.repaint();
        }
    }

    class RightPanel extends JPanel
    {
        public void paintComponent(Graphics g2)
        {
            super.paintComponent(g2);
            g2.setColor(new Color(r, gVal, b));
            g2.fillRect((getWidth() - size) / 2, (getHeight() - size) / 2, size, size);
        }
    }
}

class MasterpiecePanel extends JPanel
{
    public MasterpiecePanel(PutItTogetherHolder panelCards, CardLayout cards)
    {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        JPanel masterPanel = new JPanel(new BorderLayout());
        masterPanel.add(new Masterpiece());
        add(masterPanel);
        
        JButton home = new JButton("Home");
        home.addActionListener(new HomeHandler(panelCards, cards));
        JPanel bottom = new JPanel();
        bottom.add(home);
        add(bottom, BorderLayout.SOUTH);
    }
}

class HomeHandler implements ActionListener
{
    private PutItTogetherHolder p;
    private CardLayout c;
    public HomeHandler(PutItTogetherHolder panel, CardLayout layout) 
    { 
        p = panel; 
        c = layout; 
    }
    public void actionPerformed(ActionEvent e) 
    { 
        c.show(p, "Home"); 
    }
}

class Information
{
    private String name;
    private BufferedImage img;

    public Information()
    {
		String image = "image.jpg";
        try { img = ImageIO.read(new File(image)); }
        catch (IOException e) { System.out.println(image+" not found"); }
    }

    public void setName(String n) 
	{ 
		name = n; 
	}

    public String getName() 
	{ 
		return name; 
	}

    public BufferedImage getImg() 
	{ 
		return img; 
	}
}