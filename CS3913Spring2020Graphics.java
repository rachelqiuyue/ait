/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3913spring2020graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * @author dkatz
 */
class MyPoint{
    int x;
    int y;
    MyPoint(int newx, int newy){x = newx; y=newy;}
    MyPoint(){this(0,0);}
}
public class CS3913Spring2020Graphics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame jf = new JFrame("My Window");
        jf.setSize(400,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawingPanel mp = new DrawingPanel();
        jf.add(mp);
        //mp.addMouseListener(new MouseListener(){)
        mp.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent m){
                //System.out.println("MOUSE CLICKED!!!"); //DEBUG
                if (m.getButton()==MouseEvent.BUTTON1){
                    MyPoint p = new MyPoint(m.getX(),m.getY());
                    mp.addPoint(p);
                    mp.repaint();
                }
                else
                    mp.clearList();
            }
        });
        jf.setVisible(true);
    }
    
}
class DrawingPanel extends JPanel{
    ArrayList<MyPoint> al;
    final int size=20;
    DrawingPanel(){
        super();
        al = new ArrayList<MyPoint>();
    }
    void addPoint(MyPoint p){ al.add(p);}
    void clearList(){al.clear(); this.repaint();}
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        for (MyPoint p: al){
            g.fillOval(p.x-(size/2), p.y-(size/2), size, size);
        }
    }
    
}



class MyPanel extends JPanel{
    int i;
    MyPanel(){
        super();
        i=0;
        
    }
    protected void paintComponent(Graphics g){
        i++;
        int height = this.getSize().height;
        int width = this.getSize().width;
        g.setColor(Color.GRAY);
        g.fillRect(0,0,width,height);
        g.setColor(Color.RED);
        g.fillRect(width/2-50,height/2,100,100);
        g.setColor(new Color(34,139,34));
        g.setFont(new Font("Arial Bold",Font.PLAIN,40));
        g.drawString("i="+i, width/2-100, height/2-2);
    }
}
