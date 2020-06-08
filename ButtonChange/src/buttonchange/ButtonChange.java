/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buttonchange;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author rachelqiuyue
 */



public class ButtonChange {
    static int n = 8;
    static JButton[] buttons = new JButton[n];
    static JFrame jf = new JFrame("Homework 3");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        jf.setSize(400, 400);

        // Create JButton and JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,2));
        for (int i = 1 ; i < n+1;++i){
            JButton button = new JButton();
            buttons[i-1] = button;
            button.setOpaque(true);
            panel.add(button);
            button.setBorderPainted(false);
            final Random r=new Random();
            Color c= newColor();
            button.setBackground(c);
            AutoChanger thread = new AutoChanger(button);
            thread.start();
            button.addActionListener(thread);
            
            
        }
        jf.add(panel);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    static Color newColor(){
        final Random r=new Random();
        Color c=new Color(r.nextFloat(),r.nextFloat(),r.nextFloat());
        return c;
    }
}




class AutoChanger extends Thread implements ActionListener{
    boolean pressed = false;
    JButton b;
    AutoChanger(JButton button){
        b = button;
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        JButton b = (JButton) arg0.getSource();
        if (!pressed){
            b.setText("Pressed");
        }
        else{
            
            b.setText("");
        }
        pressed = !pressed;
    }
    public void run(){
        try{
            while (true){
                if (pressed == false){
                    Color c= ButtonChange.newColor();
                    b.setBackground(c);
                    sleep(1000);
                }else{
                    yield();
                }
            }
        }catch (InterruptedException e){}
        
    }
}


