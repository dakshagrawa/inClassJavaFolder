// Daksh Agrawal
/* Period 7
* 03/30/2026
* PutItTogether.java
*/

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;

public class PutItTogether{
    public PutItTogether() {
    }

    public static void main(String[] args) {
        PutItTogether pit = new PutItTogether();
        pit.run();
    }

    public void run() {
        JFrame frame = new JFrame("PutItTogether");
        frame.setSize(800, 700);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocation(0, 0);
        frame.setResizable(true);
        PutItTogetherHolder pith = new PutItTogetherHolder();
        frame.getContentPane().add(pith);
        frame.setVisible(true);
    }
}

// this panel holds the main cards/panel
class PutItTogetherHolder extends JPanel {
    public PutItTogetherHolder() {
        setBackground(Color.CYAN);

        CardLayout cards = new CardLayout();
        setLayout(cards);

        Information info = new Information();
        FirstPagePanel fpp = new FirstPagePanel(this, cards, info);
        FixedPanelHolder hph = new FixedPanelHolder(this, info, cards);
        p1PictPanel p1Panel = new p1PictPanel(cards, this);
        p2PictPanel p2Panel = new p2PictPanel(cards, this);
        PageSix p6 = new PageSix(cards, this);

        add(fpp, "First");
        add(hph, "Home");
        add(p1Panel, "Panel1");
        add(p2Panel, "Panel2");
        add(p6, "PageSix");
    }
}

// First page to show up. Gives information, asks for name. Goes to Home page.
class FirstPagePanel extends JPanel {
    private PutItTogetherHolder panelCards;
    private CardLayout cards;
    private Information info;
    private JTextField tfName;
    private JCheckBox checkBox1;

    public FirstPagePanel(PutItTogetherHolder panelCardsIn, CardLayout cardsIn, Information infoIn) {
        setLayout(null);
        this.cards = cardsIn;
        this.panelCards = panelCardsIn;

        // textfield
        JTextField jtf1 = new JTextField("Enter your name");
        jtf1.setBounds(200,300,100,25);
        TFListener jtfListen= new TFListener(infoIn);
        jtf1.addActionListener(jtfListen);
        add(jtf1);

        //textArea
        JTextArea textArea1 = new JTextArea("This is a JTextArea", 5, 5);
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        textArea1.setText("Welcome to PutItTogether program! This program" +
                " includes six different pages or cards. On the first page, please enter" +
                "your name in the text field below. Here's a brief overview of what" +
                " you can expect from each of the other pages:\n\n" +
                "Page 2 (Home Page): Once you've entered your name, you'll be taken" +
                "to the home page where you can select which page to visit next. You'll" +
                " see a welcome message with your name, as well as directions for" +
                " each of the options available. \n\n" +
                "Page 3 (Picture Page): This page features a picture of two people. " +
                "Click on one of the people to learn more about them.\n\n" +
                "Page 4 and 5 (Person Pages): These pages provide more information " +
                "about the person you selected on the Picture Page. You'll see a picture" +
                "of just that person along with their name, date of birth, age, and hobbies.\n\n" +
                "Page 6 (Drawing Page): This page features two panels side by side, " +
                "with components on the left and a drawing area on the right. You can " +
                "select a color using the sliders and adjust the size of the" +
                " shape using the scroll bar.\n\n" +
                "Please make sure to check the box at the bottom of this page to confirm" +
                " that you understand the directions and what to expect from this program. Enjoy!");
        textArea1.setBounds(100, 100, 400, 100);
        JScrollPane scroller = new JScrollPane(textArea1);
        scroller.setBounds(100, 100, 400, 100);
        add(scroller);

        // Cechck BOx O@koefioewfioewjfwefw >:)))) :OELDKJK#IO@J@
        checkBox1 = new JCheckBox("I read the directions");
        CheckBoxListener cblistener = new CheckBoxListener(checkBox1, this.panelCards, cards);
        checkBox1.addActionListener(cblistener);
        checkBox1.setSelected(false);
        checkBox1.setBackground(Color.YELLOW);
        checkBox1.setBounds(100, 500, 200, 50);
        add(checkBox1);

    }

}
class TFListener implements ActionListener
{
    private String baba2;
    private Information ninfo;
    public TFListener(Information infoIn)
    {
        ninfo = infoIn;
        //return baba1;
    }
    public void actionPerformed(ActionEvent evt)
    {
        baba2= evt.getActionCommand();
        System.out.println( baba2);
        ninfo.setName(baba2);
        //JTextField jtextf = (JTextField) evt.getSource();
        //baba1 = jtextf.getText();

    }


}
class CheckBoxListener implements ActionListener {

    private JCheckBox checkBox1;
    private PutItTogetherHolder hehe;
    private CardLayout cards;

    public CheckBoxListener(JCheckBox checkBox1, PutItTogetherHolder heheIn, CardLayout cards) {
        this.hehe = heheIn;
        this.checkBox1 = checkBox1;
        this.cards = cards;
    }

    public void actionPerformed(ActionEvent evt) {
        String cmd = evt.getActionCommand();
        if (cmd.equals("I read the directions")) {
            if (checkBox1.isSelected()) {
                checkBox1.setSelected(false);
            }
            JPopupMenu JpM = new JPopupMenu("hmmmmm... did you reeely read the direction>!>!?!111");
            JMenuItem yesItem = new JMenuItem("yes");
            JMenuItem noItem = new JMenuItem("no");
            yesItem.addActionListener(new MenuItemListener(hehe, cards));
            noItem.addActionListener(new MenuItemListener(hehe, cards));
            JpM.add(yesItem);
            JpM.add(noItem);
            JpM.show(checkBox1, checkBox1.getY()+10, checkBox1.getX() + 10);
        }
    }
}

class MenuItemListener implements ActionListener {
    private CardLayout cards;
    private PutItTogetherHolder ptth;

    public MenuItemListener(PutItTogetherHolder ptth, CardLayout cards) {
        this.ptth = ptth;
        this.cards = cards;
    }

    public void actionPerformed(ActionEvent evt) {
        String cmd = evt.getActionCommand();
        if (cmd.equals("yes")) {
            cards.show(ptth, "Home");
        }
    }
}


class FixedPanelHolder extends JPanel {
    private Information info;
    private PutItTogetherHolder pepe;
    private JButton homeButton;
    private String name;

    public FixedPanelHolder(PutItTogetherHolder putIn, Information infoIn, CardLayout cardsIn) {
        setBackground(Color.RED);

        // send cardLayout into the listener
        pg2Listener pp2= new pg2Listener(cardsIn, putIn);

        FlowLayout fs = new FlowLayout(FlowLayout.CENTER, 500, 20);
        setLayout(fs);
        //TFListener bee = new TFListener();
        Font font = new Font("Arial", Font.BOLD, 40);
        this.info = infoIn;
        name = info.getName();
        JLabel je = new JLabel("Welcome " + name + "!!");
        je.setFont(font);
        add(je);

        //directions jtextarea
        JTextArea jtx = new JTextArea();
        jtx.setSize(200,50);
        jtx.setWrapStyleWord(true);
        jtx.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(jtx);
        jtx.setText("Radio button 1: To see information about a friend and me."+
                "\n\nRadio button 2: To make some colors and draw some shapes.");
        add(scrollPane);

        //JBuTONNS
        JRadioButton radioButton1 = new JRadioButton("button 1");
        JRadioButton radioButton2 = new JRadioButton("button 2");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        add(radioButton1);
        add(radioButton2);

        //REEL BUTTOn (HOME PAGE)
        JButton littleE = new JButton("HOME");
        littleE.setFont(font);
        add(littleE);


        //actiomnlitsner can be saME?
        radioButton1.addActionListener(pp2);
        radioButton2.addActionListener(pp2);
        littleE.addActionListener(pp2);
    }

}
class pg2Listener implements ActionListener
{
    private String grrr;
    private CardLayout cars;
    private PutItTogetherHolder ppp;
    private MenuItemListener memu;
    public pg2Listener(CardLayout cardsIn, PutItTogetherHolder peepIn)
    {
        cars = cardsIn;
        ppp = peepIn;
    }
    public void actionPerformed(ActionEvent evt)
    {
        grrr = evt.getActionCommand();
        if(grrr.equalsIgnoreCase("button 1"))
        {
            cars.show(ppp,"Panel1" );
        }
        if(grrr.equalsIgnoreCase("button 2"))
        {
            cars.show(ppp,"Panel2" );
        }
        if(grrr.equalsIgnoreCase("HOME"))
        {
            cars.first(ppp);
        }
    }
}

class HomePanelHolder extends JPanel {
    private Image picture;
    private Information info;
    private String pictName;
    private CardLayout cards;

    public HomePanelHolder(Information infoIn) {
    }

    public CardLayout getCardLayout() {
        return cards;
    }
}

class HomePanel extends JPanel {

    // Since the label for the name was created when the classes constructor was
    // called
    // it needs to be updated after the user types in the name into the text field.
    // Update that label in paintComponent.
    public void paintComponent(Graphics g) {
    }

}

class PageSix extends JPanel implements ActionListener
{

    private JPanel leftPanel;
    private JPanel rightPanel;
    private JSlider sizeSlider;
    private JSlider colorSlider;
    private Color color;
    private int shapeSize;
    private CardLayout cards;
    private PutItTogetherHolder pphehe;

    public PageSix(CardLayout cIn, PutItTogetherHolder pInn)
    {
        cards = cIn;
        pphehe = pInn;


        setLayout(new GridLayout(1, 2));

        // Create the left panel for color and size selection
        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(2, 2));
        leftPanel.setPreferredSize(new Dimension(200, 400));
        leftPanel.add(new JLabel("Shape size:"));
        sizeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        sizeSlider.setMajorTickSpacing(20);
        sizeSlider.setMinorTickSpacing(5);
        sizeSlider.setPaintTicks(true);
        sizeSlider.setPaintLabels(true);
        sizeSlider.addChangeListener(new SizeListener());
        leftPanel.add(sizeSlider);

        leftPanel.add(new JLabel("Shape color:"));
        colorSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
        colorSlider.setMajorTickSpacing(50);
        colorSlider.setMinorTickSpacing(10);
        colorSlider.setPaintTicks(true);
        colorSlider.setPaintLabels(true);
        colorSlider.addChangeListener(new ColorListener());
        leftPanel.add(colorSlider);

        // Create the right panel for displaying the shape with the selected color
        rightPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(color);
                g.fillRect(0, 0, shapeSize, shapeSize);
            }
        };
        rightPanel.setPreferredSize(new Dimension(100, 100));

        // Add the panels to the main panel
        add(leftPanel);
        add(rightPanel);

        // Set initial values for color and size
        color = Color.BLUE;
        shapeSize = 50;

        //home button
        JButton littleE2 = new JButton("HOME");
        add(littleE2,BorderLayout.SOUTH);
        littleE2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getActionCommand().equalsIgnoreCase("HOME"))
            cards.first(pphehe);
    }
    class SizeListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider) e.getSource();
            if (!source.getValueIsAdjusting()) {
                shapeSize = source.getValue();
                rightPanel.repaint();
            }
        }
    }

    class ColorListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider) e.getSource();
            if (!source.getValueIsAdjusting()) {
                int red = colorSlider.getValue();
                color = new Color(red, 0, 255 - red);
                rightPanel.repaint();
            }
        }
    }
}

class p1PictPanel extends JPanel implements ActionListener
{
    CardLayout cards;
    PutItTogetherHolder pphehe;
    public p1PictPanel(CardLayout cardsIn, PutItTogetherHolder pIn) {
        setBackground(Color.pink);
        cards = cardsIn;
        pphehe = pIn;

        // Set layout
        setLayout(new BorderLayout());

        // Create picture panel and add to top
        PicturePanel1 picturePanel1 = new PicturePanel1();
        picturePanel1.setBackground(Color.blue);
        // Add picture to panel
        add(picturePanel1, BorderLayout.CENTER);

        JButton littleE2 = new JButton("HOME");
        add(littleE2,BorderLayout.SOUTH);
        littleE2.addActionListener(this);

        JButton p2find = new JButton("See info for the other person");
        add(p2find,BorderLayout.NORTH);
        p2find.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getActionCommand().equalsIgnoreCase("HOME"))
            cards.first(pphehe);
        if(evt.getActionCommand().equalsIgnoreCase("See info for the other person"))
            cards.show(pphehe, "Panel2");
    }

    public class PicturePanel1 extends JPanel {
        private Image imagex;

        public PicturePanel1() {
            setBackground(Color.blue);
            try {
                imagex = ImageIO.read(new File("image1.png"));// swap each time
            } catch (IOException e) {
                // Handle the error
                System.out.println("Error loading image: " + e.getMessage());
                imagex = null;
            }
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imagex, 0, 0, this.getWidth(), this.getHeight(), this);
            Font font1 = new Font("Arial", Font.BOLD, 20);
            g.setFont(font1);
            g.setColor(Color.blue);
            g.drawString("Hello, my name is Thomas the Train", 10, 50);
            g.drawString("Date of Birth: January 4, 1946", 10, 80);
            g.drawString("Age: 79", 10, 110);
            g.drawString("Hobbies: Pulling Freight Cars, Helping Friends, Exploring", 10, 140);
            g.drawString("Favorite Phrase: 'I think I can!'", 10, 170);
            g.drawString("Motto: 'Really Useful Engine'", 10, 200);

        }
    }


}



class p2PictPanel extends JPanel implements ActionListener{
    CardLayout cards;
    PutItTogetherHolder pphehe;

    public p2PictPanel(CardLayout carIn, PutItTogetherHolder pIn)
    {
        cards = carIn;
        pphehe = pIn;
        setBackground(Color.green);

        // Set layout
        setLayout(new BorderLayout());

        // Create picture panel and add to center
        PicturePanel2 picturePanel2 = new PicturePanel2();
        add(picturePanel2, BorderLayout.CENTER);

        // Add home button to south
        JButton littleE3 = new JButton("HOME");
        add(littleE3,BorderLayout.SOUTH);
        littleE3.addActionListener(this);

        JButton p2find = new JButton("Go to shapes, they change colors and size");
        add(p2find,BorderLayout.NORTH);
        p2find.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getActionCommand().equalsIgnoreCase("HOME"))
            cards.first(pphehe);
        if(evt.getActionCommand().equalsIgnoreCase("Go to shapes, they change colors and size"))
            cards.show(pphehe, "PageSix");
    }

    public class PicturePanel2 extends JPanel {
        private Image imagex;

        public PicturePanel2() {
            setBackground(Color.green);
            try {
                imagex = ImageIO.read(new File("image2.png"));// change to your image file name
            } catch (IOException e) {
                // Handle the error
                System.out.println("Error loading image: " + e.getMessage());
                imagex = null;
            }
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imagex, 0, 0, this.getWidth(), this.getHeight(), this);
            Font font1 = new Font("Arial", Font.BOLD, 20);
            g.setFont(font1);
            g.setColor(Color.green);
            g.drawString("Oh boy! Hi, I'm Mickey Mouse!", 10, 50);
            g.drawString("Date of Birth: November 18, 1928", 10, 80);
            g.drawString("Age: 94", 10, 110);
            g.drawString("Hobbies: Playing Music, Dancing, Spending Time with Friends", 10, 140);
            g.drawString("Favorite Phrase: 'Hot dog!'", 10, 170);
            g.drawString("Motto: 'Oh, boy!'", 10, 200);
        }
    }
}


class Information {
    private String name;

    public Information() {

    }

    public String getName() {
        return name;
    }

    public void setName(String nameIn) {
        name = nameIn;
    }
}