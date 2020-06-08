/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buttoncolor;

/**
 *
 * @author rachelqiuyue
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class ButtonColor {
    static int n = 8;
    static JButton[] buttons = new JButton[n];
    static JFrame jf = new JFrame("Homework 2");
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
            button.addActionListener(new ButtonListener());
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


class ButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent arg0) {
        JButton b = (JButton) arg0.getSource();
        for (int i = 0; i < ButtonColor.buttons.length;++i){
            if (b != ButtonColor.buttons[i]){
                Color c= ButtonColor.newColor();
                ButtonColor.buttons[i].setBackground(c);
            }
        }
        
    }
}