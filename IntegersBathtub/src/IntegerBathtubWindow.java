import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;


public class IntegerBathtubWindow extends JFrame{

    private IntegerCounterComponent myIntegersCounters[] = new IntegerCounterComponent[2];
    private IntegerCounterComponent hitCounter;
    private Point offset;

    public IntegerBathtubWindow() {

        super("Integer Bathtub");

        myIntegersCounters[0] = new IntegerCounterComponent(Color.red, 0, 0);
        myIntegersCounters[1] = new IntegerCounterComponent(Color.blue, 10, 0);
        MouseAdapter handler;

        setLayout(null);
        myIntegersCounters[0].setBounds(0, 0, 500, 500);
        add(myIntegersCounters[0]);
        myIntegersCounters[1].setBounds(10, 0, 500, 500);
        add(myIntegersCounters[1]);

        addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                System.out.println("mousePressed");
                int xmouse = e.getX();
                int ymouse = e.getY();
                double xmin;
                double xmax;
                double ymin;
                double ymax;
                System.out.println("xmouse" + xmouse);
                System.out.println("ymouse" + ymouse);
                System.out.println("ymouse - 23 " + (ymouse - 23));
                ymouse = ymouse - 23;
                for (IntegerCounterComponent counter : myIntegersCounters) {
                    System.out.println("counter: " + counter);
                    System.out.println("counter.getBounds(): " + counter.getBounds());
                    xmin = counter.getx1();
                    xmax = xmin + 16;
                    ymin = counter.gety1();
                    ymax = ymin + 16;
                    System.out.printf("xmin: "+xmin);
                    System.out.println("xmax: "+xmax);
                    System.out.println("ymin: "+ymin);
                    System.out.println("ymax: "+ymax);
                    if (((xmouse >= xmin) && (xmouse <= xmax)) && ((ymouse >= ymin) && (ymouse <= ymax))){
                        System.out.println("hit on counter: " + counter);
                        hitCounter = counter;
                        System.out.println("hitCounter: " + hitCounter);
                        offset = new Point();
                        offset.x = xmouse - (int)xmin;
                        offset.y = ymouse - (int)ymin;
                        break;
                    }
                }
            } // end mousePressed

            public void mouseReleased(MouseEvent e) {
                System.out.println("mouseReleased");
                hitCounter = null;
            }


            public void mouseClicked(MouseEvent e) {
                System.out.println("mouseClicked");
            }

            public void mouseEntered(MouseEvent e) {
                System.out.println("mouseEntered");
            }

            public void mouseExited(MouseEvent e) {
                System.out.println("mouseExited");
            }



        }); // end MouseAdapter

        addMouseMotionListener(new MouseMotionListener() {
            public void mouseMoved(MouseEvent e) {
                //System.out.println("mouseMoved");
            } //mousemotion listener

            public void mouseDragged(MouseEvent e) { //mousemotion listener
                //System.out.println("mouseDragged");
                //System.out.println("Mouse Drag hitCounter: " + hitCounter);
                //System.out.println("Mouse Drag offset " + offset);
                if (hitCounter != null) {
                    Point mp = e.getPoint();;
                    //hitCounter.setx1y1(mp.x - offset.x,mp.y - offset.y);
                    hitCounter.setx1y1(mp.x ,mp.y-23);
                }
            }

        });

    }

}


