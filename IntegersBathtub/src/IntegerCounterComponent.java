import java.awt.*;
import javax.swing.JComponent;
//import java.awt.event.*;

public class IntegerCounterComponent extends JComponent{

    //int i;
    private Color colorCounters;
    private int x1;
    private int y1;
    //private boolean doRepaint = true;


    public IntegerCounterComponent(Color colorCounters, int x1, int y1) {
        this.colorCounters = colorCounters;
        this.x1 = x1;
        this.y1 = y1;
    }


    public void paintComponent(Graphics g) {
        update(g);
    }

    public void update (Graphics g) {
        // Recover Graphics2D
        //if (!doRepaint) {
            //System.out.println("do not repaint with x1:" + x1 + " y1:" + y1);
            //doRepaint = true;
       // } else {
            Graphics2D g2 = (Graphics2D) g;
            System.out.println("repaint with x1:" + x1 + " y1:" + y1);
            g2.setColor(colorCounters);
            g2.setStroke(new BasicStroke(2));
            g2.drawLine(x1, y1 + 8, x1 + 16, y1 + 8);
            g2.drawLine(x1 + 8, y1, x1 + 8, y1 + 16);
            //doRepaint = false;
        //}

    }

    public void setx1y1(int xnew1, int ynew1){
        x1 = xnew1;
        y1 = ynew1;
        System.out.println("in set x1y1 with x1:" + x1 + "y1:" + y1 + "calling repaint");
        repaint();
    }

    public int getx1(){
        return x1;
    }

    public int gety1(){
        return y1;
    }
}


