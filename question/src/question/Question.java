/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author rachelqiuyue
 */
public class Question {

    /**
     * @param args the command line arguments
     */
    String question;
    String left;
    String right;
    Question(String question){
        left = "True";
        right = "false";
        this.question = question;
    }
    Question(String question, String left,String right){
        this(question);
        this.left = left;
        this.right = right;
    }
    public static void main(String[] args) {
        String[] response = new String[5];
        JFrame jf = new JFrame("Midterm");
        for (int i = 0; i < 5;++i){
            response[i] = "No response";
        }
        jf.setSize(400, 400);
        Question q1 = new Question("Favourite Ice Cream","Vanilla","Chocolate");
        Question q2 = new Question("Which season is better","Winter","Summer");
        Question q3 = new Question("Which pet is better","Cat","dog");
        Question q4 = new Question("Unicorns are real");
        Question q5 = new Question("Text or call","Text","Call");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,3));
        
        JLabel text = new JLabel(q1.question,SwingConstants.CENTER);
        panel.add(text);
        JLabel text2 = new JLabel();
        for (int i = 0; i<8;++i){
            JLabel text3 = new JLabel();
            panel.add(text3);
        }
        JButton b1 = new JButton(q1.left);
        ButtonListener l = new ButtonListener(b1);
        b1.addActionListener(l);
        JButton b2 = new JButton(q1.right);
        panel.add(b1);
        panel.add(text2);
        panel.add(b2);
        jf.add(panel);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // TODO code application logic here
    }
    
}

class ButtonListener extends Thread implements ActionListener{
    JButton b;
    ButtonListener(JButton button){
        b = button;
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        JButton b = (JButton) arg0.getSource();
        String command = b.getText();
        response[num] = command;
        num++;
        if(num == 5){}
        else{
            b.setText("ok");
        }
    }
}
