/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analogclock;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math; 
import java.awt.geom.Line2D;
import java.awt.Graphics2D;
/**
 *
 * @author rachelqiuyue
 */
public class AnalogClock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame jf = new JFrame("My Clock");
        jf.setSize(400,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
            Socket s = new Socket("time-a-g.nist.gov",13);
            if (s.isConnected()){
                Scanner sin = new Scanner(s.getInputStream());
            sin.nextLine();
            
            String time = sin.nextLine().split(" ")[2];
            int hour = Integer.parseInt(time.substring(0,2));
            int minute = Integer.parseInt(time.substring(3,5));
            int second = Integer.parseInt(time.substring(6,8));
            if (hour >= 12){
                hour -= 12;
            }
            DrawingPanel mp = new DrawingPanel(hour,minute,second);
            jf.add(mp);
            jf.setVisible(true);
            try{
                while (true){
                    if (second <= 60){
                        Thread.sleep(1000);
                        second ++;
                        mp.second += 1;
                        mp.repaint();
                    }else{
                        try{
                            s = new Socket("time-a-g.nist.gov",13);
                            if (s.isConnected()){
                            sin = new Scanner(s.getInputStream());
                            sin.nextLine();     
                            time = sin.nextLine().split(" ")[2];
                            hour = Integer.parseInt(time.substring(0,2));
                            minute = Integer.parseInt(time.substring(3,5));
                            second = Integer.parseInt(time.substring(6,8));
                            if (hour >= 12){
                                hour -= 12;
                            }
                            }
                            mp.second = second;
                            mp.hour = hour;
                            mp.minute = minute;
                            mp.repaint();
                        }catch(IOException e){
                            System.out.println("Welp... that didn't work!");
                        }
                    }}
            }catch (InterruptedException e){}
            }
            else{
                System.out.println("Socket COnnection Failed!");
            }
        }
        catch(IOException e){
            System.out.println("Welp... that didn't work!");
        }

        
    }
}


class DrawingPanel extends JPanel{
    int hour;
    int minute;
    int second;
    DrawingPanel(int newhour,int newMin, int newSec){
        hour = newhour;
        minute = newMin;
        second = newSec;
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int height = this.getSize().height;
        int width = this.getSize().width;
        //g.fillRect(0,0,width,height);
        g.setColor(Color.LIGHT_GRAY);
        g.drawOval(width/2-150,height/2-150,300,300);
        g.fillOval(width/2-150,height/2-150,300,300);
        //draw the circle
        g.setColor(Color.BLACK);
        Graphics2D g2 = (Graphics2D) g;
        //draw ticks
        for (int i = 0; i < 12; ++i){
            g2.draw(new Line2D.Double(width/2+150*Math.sin(Math.toRadians(30*i)),height/2-150*Math.cos(Math.toRadians(30*i)),width/2+140*Math.sin(Math.toRadians(30*i)),height/2-140*Math.cos(Math.toRadians(30*i))));
        }
        int ls = 120;
        int lm = 90;
        int lh = 60;
        g2.draw(new Line2D.Double(width/2,height/2,width/2+ls*Math.sin(Math.toRadians(second*360/60)),height/2-ls*Math.cos(Math.toRadians(second*360/60))));
        g2.draw(new Line2D.Double(width/2,height/2,width/2+lm*Math.sin(Math.toRadians(minute*360/60)),height/2-lm*Math.cos(Math.toRadians(minute*360/60))));
        double angle = hour*30+0.5*minute;
        g2.draw(new Line2D.Double(width/2,height/2,width/2+lh*Math.sin(Math.toRadians(angle)),height/2-lh*Math.cos(Math.toRadians(angle))));
        
    }
}
