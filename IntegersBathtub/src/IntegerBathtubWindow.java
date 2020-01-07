import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;


public class IntegerBathtubWindow extends JFrame{

    private IntegerCounterComponent myIntegersCounters[] = new IntegerCounterComponent[3];
    private IntegerCounterComponent hitCounter;
    private Point offset;

    public IntegerBathtubWindow() {

        super("Integer Bathtub");

        myIntegersCounters[0] = new IntegerCounterComponent(Color.red, 0, 0);
        myIntegersCounters[0].addMouseListenerCounter();
        myIntegersCounters[1] = new IntegerCounterComponent(Color.blue, 10, 0);
        myIntegersCounters[1].addMouseListenerCounter();
        myIntegersCounters[2] = new IntegerCounterComponent(Color.green, 20, 0);
        myIntegersCounters[2].addMouseListenerCounter();
        //MouseAdapter handler;

        setLayout(null);
        myIntegersCounters[0].setBounds(0, 0, 500, 500);
        add(myIntegersCounters[0]);
        myIntegersCounters[1].setBounds(10, 0, 500, 500);
        add(myIntegersCounters[1]);
        myIntegersCounters[2].setBounds(20, 0, 500, 500);
        add(myIntegersCounters[2]);

    }

}


