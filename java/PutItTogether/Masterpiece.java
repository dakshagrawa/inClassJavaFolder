import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Masterpiece extends JPanel 
{
   public Masterpiece() 
   {
      this.setBackground(Color.BLUE);
   }

   public void paintComponent(Graphics g) 
   {
      super.paintComponent(g);
      this.drawRects1(g);
      this.drawStrings(g);
      this.drawOvals(g);
      this.drawPolygons(g);
      this.drawArcs(g);
      this.drawRects2(g);
   }

   public void drawRects1(Graphics g) 
   {
      g.setColor(Color.GREEN);
      g.fillRect(0, 400, 1000, 100);
   }

   public void drawStrings(Graphics g) 
   {
      g.setFont(new Font("roboto", 1, 20));
      g.setColor(Color.BLACK);
      g.drawString("Mountain Night", 400, 435);
      g.setColor(Color.YELLOW);
      g.setFont(new Font("Serif", 0, 40));
      g.drawString("*", 100, 100);
      g.drawString("*", 150, 225);
      g.drawString("*", 200, 150);
      g.drawString("*", 550, 50);
      g.drawString("*", 650, 175);
      g.drawString("*", 800, 250);
      g.drawString("*", 825, 125);
      g.drawString("*", 900, 200);
   }

   public void drawOvals(Graphics g) 
   {
      g.setColor(Color.YELLOW);
      g.fillOval(400, 200, 200, 200);
      g.setColor(Color.BLACK);
      g.drawOval(400, 200, 200, 200);
      g.setColor(Color.GREEN);
      g.fillOval(100, 300, 50, 50);
      g.fillOval(900, 300, 60, 60);
      g.fillOval(700, 325, 50, 50);
      g.drawOval(100, 300, 50, 50);
      g.drawOval(900, 300, 60, 60);
      g.drawOval(700, 325, 50, 50);
      g.setColor(Color.WHITE);
      g.fillOval(400, 100, 100, 50);
      g.fillOval(400, 125, 100, 50);
      g.fillOval(385, 120, 30, 35);
      g.fillOval(485, 120, 30, 35);
   }

   public void drawPolygons(Graphics g) 
   {
      g.setColor(Color.darkGray);
      int[] var2 = new int[]{225, 300, 325, 400, 500, 525, 600};
      int[] var3 = new int[]{400, 300, 325, 200, 325, 300, 400};
      g.fillPolygon(var2, var3, 7);
      g.setColor(Color.BLACK);
      g.drawPolygon(var2, var3, 7);
   }

   public void drawArcs(Graphics g) 
   {
      g.setColor(Color.BLACK);
      g.drawArc(400, 100, 100, 50, 170, -165);
      g.drawArc(400, 125, 100, 50, -170, 160);
      g.drawArc(385, 120, 30, 35, 85, 195);
      g.drawArc(485, 120, 30, 35, -100, 200);
   }

   public void drawRects2(Graphics g) 
   {
      g.setColor(Color.darkGray);
      g.fillRect(122, 325, 6, 100);
      g.fillRect(927, 325, 6, 100);
      g.fillRect(722, 350, 6, 100);
      g.setColor(Color.BLACK);
      g.drawRect(122, 325, 6, 100);
      g.drawRect(927, 325, 6, 100);
      g.drawRect(722, 350, 6, 100);
   }
}
