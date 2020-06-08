/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csuy3913spring2020window1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author dkatz
 */
public class CSUY3913Spring2020Window1 {
    static JLabel text;
    static int val;
    public static void main(String[] args) {
        text = new JLabel("2",SwingConstants.CENTER);
        val=2;
        JFrame jf = new JFrame("My First frame! :)");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400,400);
        JButton jb = new JButton("PRESS ME, please");
        jb.addActionListener(new ButtonListener());
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(3,3,4,4));
        jp.add(new JLabel("1",SwingConstants.CENTER));
        jp.add(text);
        jp.add(new JLabel("3",SwingConstants.CENTER));
        jp.add(new JLabel("left",SwingConstants.CENTER));
        JPanel jp2 = new JPanel();
        jp2.setLayout(new BorderLayout());
        jp2.setBackground(Color.red);
        jp2.add(new JLabel("North",SwingConstants.CENTER), BorderLayout.NORTH);
        jp2.add(new JLabel("South",SwingConstants.CENTER), BorderLayout.SOUTH);
        jp2.add(new JLabel("East",SwingConstants.CENTER), BorderLayout.EAST);
        jp2.add(new JLabel("West",SwingConstants.CENTER), BorderLayout.WEST);
        jp2.add(jb,BorderLayout.CENTER);
        jp.add(jp2);
        
        jp.add(new JLabel("right",SwingConstants.CENTER));
        jp.add(new JLabel("7",SwingConstants.CENTER));
        jp.add(new JLabel("8",SwingConstants.CENTER));
        jp.add(new JLabel("9",SwingConstants.CENTER));
        
        jf.add(jp);
        jf.setVisible(true);
        
        return ;
        /*Base b = new Derived();
        b.someFunc();
        Base.s = 0;
        Derived.s=100;
        System.out.println("S="+Base.s);
        Derived d;
        d = (Derived) b;
        d.anotherFunc();
        */
    }
}
class ButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent arg0) {
        CSUY3913Spring2020Window1.val+=1;
        CSUY3913Spring2020Window1.text.setText(""+CSUY3913Spring2020Window1.val);
    }
    
}

class Base{
    int val;
    static int s;
    Base(){
        //val = 100; //Can't have code before this()
        this(0); //Call to 1 argument constructor
    }
    Base(int newval){
        val =newval;
    }
    public void someFunc(){
        System.out.println("Val="+val);
    }
}
class Derived extends Base{
    double d;
    Derived(){
        this(42,5.5);
    }
    Derived(int newval){
        this(newval, 5.5);
    }
    Derived(int newval, double newd){
        super(newval);
        d=newd;
    }
    @Override
    public void someFunc(){
        super.someFunc();
        System.out.println("D="+d);
    }
    public void anotherFunc(){
      System.out.println("This is another func!");  
    }
}