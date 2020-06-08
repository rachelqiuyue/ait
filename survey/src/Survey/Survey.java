/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survey;

import java.awt.*;
import java.awt.event.*;
import static java.lang.Thread.sleep;
import static java.lang.Thread.yield;
import javax.swing.*;

/**
 *
 * @author rachelqiuyue
 */
class Question {
    /**
     * @param args the command line arguments
     */
    String question;
    String left;
    String right;
    Question(String question){
        left = "True";
        right = "False";
        this.question = question;
    }
    Question(String question, String left,String right){
        this(question);
        this.left = left;
        this.right = right;
    }
}

public class Survey {
    static JFrame jf = new JFrame("Midterm");
    static String[] response = new String[5];
    static int num = 0;
    static Question[] questions = new Question[5];
    static JButton b1;
    static JButton b2;
    static JLabel text;
    static ButtonListener l = new ButtonListener();
    static class ButtonListener extends Thread implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
                JButton b = (JButton) arg0.getSource();
                String command = b.getText();
                response[num] = command;
                num++;
                if(num == 5){
                    text.setText(show());
                    l.yield();
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                }
                else{
                    b1.setText(questions[num].left);
                    b2.setText(questions[num].right);
                    text.setText(questions[num].question);
                    l.interrupt();
                    l = new ButtonListener();
                    l.start();
                }
        }
        public void run(){
            try{
                while (true){
                    sleep(5000);
                    text.setText(show());
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                }
            }catch (InterruptedException e){}
        }
    }

    static String show(){
        String s = "";
        for (int i = 0; i < 5;++i){
            s += response[i]+",";
        }
        return s.substring(0, s.length()-1);
    }
    public static void main(String[] args) {
        for (int i = 0; i < 5;++i){
            response[i] = "NO RESPONSE";
        }
        questions[0] = new Question("Favourite Ice Cream","Vanilla","Chocolate");
        questions[1] = new Question("Which season is better","Winter","Summer");
        questions[2] = new Question("Which pet is better","Cat","Dog");
        questions[3] = new Question("Unicorns are real");
        questions[4] = new Question("Text or call","Text","Call");
        jf.setSize(800, 800);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,3));
        text = new JLabel(questions[0].question,SwingConstants.CENTER);
        panel.add(text);
        JLabel text2 = new JLabel();
        for (int i = 0; i<8;++i){
            JLabel text3 = new JLabel();
            panel.add(text3);
        }
        b1 = new JButton(questions[0].left);
        b1.addActionListener(l);
        b2 = new JButton(questions[0].right);
        b2.addActionListener(l);
        panel.add(b1);
        panel.add(text2);
        panel.add(b2);
        jf.add(panel);
        jf.setVisible(true);
        l.start();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // TODO code application logic here
    }
}




