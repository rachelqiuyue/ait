/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclasses;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
/**
 *
 * @author rachelqiuyue
 */
public class JavaClasses {

    /**
     * @param args the command line arguments
     */
    int w;
    public static void main(String[] args) {
        // TODO code application logic here
        A a = new A();
        a.myfunc();
        //change w to be 100;
        JavaClasses var = new JavaClasses();
        var.w = 100;
        JButton jb = new JButton("Press Me!");
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JButton b = (JButton) e.getSource();
                b.setText("I was Pressend!");
            }
        }})
    }
    
}


// B has access to A's functions and metods

class A{
    private int x;
    static int y;
    A(){
        x = 0;
    }
    class B{
        final static int t=100;
        B(){x++;System.out.println(y);}
        
    }
    void myfunc(){
        B b;
        for(int i = 0; i < 100; ++i){
            b = new B();
          //  System.out.println(x);
         class D{
             public void innerfunc(){
                 // a class inside a function inside a class
                 System.out.println("inside the funcgton myfunc");
             }
         }
         D d = new D();
         d.innerfunc();
        }
    }
        abstract class Thing{
            int var = 30;
        }
        //Anonymous class
        void thirdFunc(){
            int var = 30;
            Thing t;
            t = new Thing(){
                void thingFunc(){
                System.out.println("I'm a thing"+var);
                }
            };
           // t.thingFunc();
//            new Thing(){
//                void thingFunc(){
//                System.out.println("I'm a thing"+var);
//            }
////.thingFunc();
//                    }
//                    }
    // static function cannot access a non static class
//    public static void otherFunc(){
//        B b = new B();
//    }
    B getB(){return new B();}
    static class C{
        A myA;
    C(A newa){
        myA=newa;
        y = 100;
    }
}
}

class Z{
    class B{}
    class C{}
}