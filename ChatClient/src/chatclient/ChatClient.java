/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

/**
 *
 * @author rachelqiuyue
 */


import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.io.*;
import static java.lang.Thread.sleep;
import java.net.*;
import java.util.*;

public class ChatClient {

    /**
     * @param args the command line arguments
     */
    static JFrame jf = new JFrame("Chat");
    static JPanel lp = new JPanel();
    static JPanel cp = new JPanel();
    static String messages = "";
    static JTextArea history ;
    static JTextArea message;
    static JButton send;
    static JPanel panel4;
    static JPanel panel3;
    static JButton log;
    static JTextField ip;
    static JTextField username;
    static Scanner sin;
    static PrintStream sout;
    public static void main(String[] args) {
        jf.setSize(400, 400);
        lp.setLayout(new GridLayout(3, 1));
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel3.setLayout(new GridLayout(1,2));
        panel4.setLayout(new GridLayout(1,2));
        JLabel q1 = new JLabel("server you want to connect:");
        ip = new JTextField();
        JLabel q2 = new JLabel("Username");
        username = new JTextField();
        panel3.add(q1);
        panel3.add(ip);
        panel4.add(q2);
        panel4.add(username);
        log = new JButton("login");
        lp.add(panel3);
        lp.add(panel4);
        ButtonListener bt = new ButtonListener();
        log.addActionListener(bt);
        lp.add(log);
        jf.add(lp);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        cp.setLayout(new GridLayout(2, 1));
        JPanel panel1 = new JPanel();
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        panel1.setLayout(new GridLayout(1,1));
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,2));
        send = new JButton("send");
        message = new JTextArea("Type your message here");
        message.setBorder(border);
        history = new JTextArea("Welcome to the chat room!The Messages will be displayed here.");
        history.setBorder(border);
        history.setEditable(false);
        panel1.add(history);
        panel2.add(message);
        panel2.add(send);
        send.addActionListener(new ButtonListener());
        cp.add(panel1);
        cp.add(panel2);
        cp.setVisible(false);
        jf.add(cp);
    }

    static class ButtonListener extends Thread implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            JButton b = (JButton) arg0.getSource();
            String command = b.getText();
            if (command.equals("login")){
                try{
                    Socket s = new Socket(ip.getText(),5190);
                    if (s.isConnected()){
                        lp.setVisible(false);
                        cp.setVisible(true);
                        sin = new Scanner(s.getInputStream());
                        sout = new PrintStream(s.getOutputStream());

                        sout.print(username.getText()+"\r\n");
                        Connection c = new Connection(sin);
                        c.start();
                
                    }
                    else{
                        System.out.println("Socket COnnection Failed!");
                    }
                }
                catch(IOException e){
                    System.out.println("Welp... that didn't work!");
                }
            }
            if (command.equals("send")){
                sout.print(message.getText()+"\r\n");
                message.setText("");
            }
        }
        static class Connection extends Thread{
            Scanner sin;
            Connection(Scanner ssin){sin = ssin;}
            public void run(){
                while (sin.hasNext()){
                    messages += sin.nextLine()+"\n";
                    history.setText(messages);
                }
            }
        }
    }
}





