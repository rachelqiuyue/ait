/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3913spring2020finalq1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.text.*; 
/**
 *
 * @author rachelqiuyue
 */

class MyPoint{
    int x;
    int y;
    MyPoint(int newx,int newy){x = newx;y = newy;}
    MyPoint(){this(0,0);}
}
public class CS3913SPring2020FinalQ1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame jf = new JFrame("Coordinates");
        jf.setSize(400,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawingPanel jp = new DrawingPanel();
        jp.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent m){
                MyPoint p = new MyPoint(m.getX(),m.getY());
                jp.addPoint(p);
                jp.repaint();
            }
        });
        jf.add(jp);
        jf.setVisible(true);
    }
    
}

class DrawingPanel extends JPanel{
    ArrayList<MyPoint> points;
    DrawingPanel (){
        super();
        points = new ArrayList<MyPoint>();
    }
    void addPoint(MyPoint p){
        points.add(p);
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int h = this.getSize().height/10;
        int w = this.getSize().width/10;
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 10;i++){
            for (int j = 0; j < 10;++j){
                g.drawLine((i+1)*w,j*h,(i+1)*w,(j+1)*h);
                g.drawLine(i*w,(j+1)*h,(i+1)*w,(j+1)*h);
            }
        }
        g.setColor(Color.RED);
        if (points.size() > 0){
            for (int i = 0; i < points.size()-1;++i){
                MyPoint p =  points.get(i);
                MyPoint p2 = points.get(i+1);
                g.fillOval(p.x-10/2, p.y-10/2, 10, 10);
                g.drawString("("+String.valueOf(p.x)+","+String.valueOf(p.y)+")", p.x, p.y);
                g.drawLine(p.x, p.y, p2.x, p2.y);
                double length = Math.sqrt(Math.pow((p.x-p2.x),2)+Math.pow((p.y-p2.y),2));
                NumberFormat formatter = new DecimalFormat("#0.00");
                g.drawString(formatter.format(length),(p.x+p2.x)/2, (p.y+p2.y)/2);
            }
            MyPoint last = points.get(points.size()-1);
            g.fillOval(last.x-10/2, last.y-10/2, 10, 10);
            g.drawString("("+String.valueOf(last.x)+","+String.valueOf(last.y)+")", last.x, last.y);
        }
        
        
    }
}
