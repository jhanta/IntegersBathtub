import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
//import java.awt.event.*;

public class IntegerCounterComponent extends JComponent {

    //int i;
    private Color colorCounters;
    private int x1;
    private int y1;
    private Point offset;


    public IntegerCounterComponent(Color colorCounters, int x1, int y1) {
        this.colorCounters = colorCounters;
        this.x1 = x1;
        this.y1 = y1;
    }

    public void addMouseListenerCounter() {

        System.out.println("add listener on this: "+this);

        addMouseListener(new MouseAdapter() {

            public void mousePressed (MouseEvent e){
                System.out.println("mousePressed on this: " + this);
                int xmouse = e.getX();
                int ymouse = e.getY();
                System.out.println("xmouse" + xmouse);
                System.out.println("ymouse" + ymouse);
                System.out.println("ymouse - 23 " + (ymouse - 23));
                ymouse = ymouse - 23;
                offset = new Point();
                offset.x = xmouse - (int) x1;
                offset.y = ymouse - (int) y1;
            } // end mousePressed

            /*public void mouseReleased (MouseEvent e){
                System.out.println("mouseReleased");
                //hitCounter = null;
            }

            public void mouseClicked (MouseEvent e){
                System.out.println("mouseClicked");
            }

            public void mouseEntered (MouseEvent e){
                System.out.println("mouseEntered");
            }

            public void mouseExited (MouseEvent e){
                System.out.println("mouseExited");
            }*/

        }); // end MouseAdapter

        addMouseMotionListener(new MouseMotionListener() {
            public void mouseMoved (MouseEvent e){ }

            public void mouseDragged (MouseEvent e){
                Point mp = e.getPoint();
                setx1y1(mp.x - 8, mp.y - 23);
            }

        });
    }

    public void paintComponent(Graphics g) {
        update(g);
    }

    public void update (Graphics g) {
        // Recover Graphics2D
        Graphics2D g2 = (Graphics2D) g;
        System.out.println("repaint with x1:" + x1 + " y1:" + y1);
        g2.setColor(colorCounters);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(x1, y1 + 8, x1 + 16, y1 + 8);
        g2.drawLine(x1 + 8, y1, x1 + 8, y1 + 16);
    }

    public void setx1y1(int xnew1, int ynew1){
        x1 = xnew1;
        y1 = ynew1;
        System.out.println("in set x1y1 with x1:" + x1 + "y1:" + y1 + "calling repaint on this: "+this);
        repaint();
    }

    public int getx1(){
        return x1;
    }

    public int gety1(){
        return y1;
    }
}


