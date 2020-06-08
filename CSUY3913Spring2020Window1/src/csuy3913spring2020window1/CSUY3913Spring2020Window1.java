/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csuy3913spring2020window1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author rachelqiuyue
 */
public class CSUY3913Spring2020Window1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        Base b = new Derived();
        //polymorphism will call the derived function
        b.someFunc();
        Base.s = 0;
        Derived.s = 100;
        System.out.println("S="+Base.s);
        //cannot assgin derived = base; but can do casting
        Derived d;
        d = (Derived) b;
        d.anotherFunc();*/
        JFrame jf = new JFrame("My first frame!:");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400,400);
        jf.setVisible(true);
        JButton jb = new JButton("Press Me");
        jb.addActionListener(new ButtonListener());
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(3,3,4,4));
        jp.add(new JLabel("1"));
        jp.add(new JLabel("2"));
        jp.add(new JLabel("3"));
        jp.add(new JLabel("left"));
        JPanel jp2 = new JPanel();
        jf.add(jb);
        jp2.setLayout(new BorderLayout());
        
        jp2.add(new JLabel("North"),BorderLayout.NORTH);
        jp2.add(new JLabel("South"),BorderLayout.SOUTH);
        jp2.add(new JLabel("East"),BorderLayout.EAST);
        jp2.add(new JLabel("West"),BorderLayout.WEST);
        jp.add(jp2);
        jp.add(new JLabel("right"));
        jp.add(new JLabel("7"));
        jp.add(new JLabel("8"));
        jp.add(new JLabel("9"));
        jf.add(jp);
        jf.setVisible(true);
        //the program will still be running unless clicking close window
        
        return;
        
        //border layout
        
    }
    
}

//No default paramenter

class Base{
    static int s;
    int val; //val is stored in object. 100 instances would have 100 vals
    Base(){
        //val = 100; //Can't have code before this()
        this(0); //call to 1 argument constructor; //this call has to be the first 
    }
    Base(int newval){
        val = newval;
    }
    public void someFunc(){
        System.out.println("Val="+val);
    }
}

//Cannot derived from multiple base classes
class Derived extends Base{
    double d;
    Derived(){
        //call the base's 1 argument constructor
//        super(90);
//        d = 5.5;
        this(42,5.5);
    }
    @Override
    public void someFunc(){
        super.someFunc();
        //System.out.print("Val="+val);// val is package public
        System.out.print("d="+d);
    }
    Derived(int newval){
        this(newval,5.5);
    }
    Derived(int newval, double newd){
        super(newval);
        d=newd;
    }
    void anotherFunc(){
        System.out.print("Anotehr");
    }
}   


class ButtonListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent,arg0){
        CSUY3913Spring2020Window1.val+=1;
        CSUY3913Spring2020Window1.text.setText(""+)
    }
}
//procedrual programming
//Event driven programming
