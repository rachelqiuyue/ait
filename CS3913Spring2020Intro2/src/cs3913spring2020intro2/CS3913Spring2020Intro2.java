/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//int,char,boolean,double,float
//int 4 bytes
//long 8 bytes
//A double(8 bytes) variable can provide precision up to 15 to 16 decimal points as compared to float(4 bytes) precision of 6 to 7 decimal digits.
//long 
//char unicode 2 bytes 0 char 0 char 0 char
package cs3913spring2020intro2;

/**
 *
 * @author rachelqiuyue
 */
//include in c++ are the files takes the text and pareses 
//import from python is importing a library
//java import is a short cut 
//java.lang is automatically imported

import java.util.*;
public class CS3913Spring2020Intro2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MyException {
        // TODO code application logic here
        //**System.out.println("Hello");
        //input
        /*
         Scanner cin = new Scanner(System.in);
         System.out.println("What's your name");
         String s =cin.nextLine();
         System.out.println("What's your age");
         int age = cin.nextInt();
         //InputMismatchExcetption if not an int
         System.out.println(s+String.valueOf(age));
         //i, i2 are references to objects. They are exactly the same thing
         Integer i = new Integer(age);
         Integer i2 = age;
         //https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
         //Every single class derives from Objects;
         CS3913Spring2020Intro2  myobj = new CS3913Spring2020Intro2();
         // Polymorphism
         Object o = myobj;
         // while, if, switch are the same in c++;
         //length of string: string.length()
         //array is not an object but it has the capacity, nondynamic
         int argc = args.length;
         int[] arr = new int[100];
         //cannot change the size of an arr
         for (int index = 0; index < arr.length;index++){
             arr[index] = index*10; 
         }
         //final in java can only be changed once when it's set
         final int USER_AGE;
         USER_AGE = age;
         */
         Thing t1 = new Thing();
         System.out.println("T1="+t1.toString());
         Thing[] tarr = new Thing[100];
         //got a hundred of references
 
         for (int i =0; i < 100; i++){
             tarr[i] = new Thing();
         }
//         for (int i = 0; i < 100; ++i){
//             System.out.print(i+"="+tarr[i]);
//         }
        //t is a reference to a thing

         for (Thing t :tarr){
             System.out.println(t);
             t.setVal(t.getVal()+1);
         }
         //polyphism
         for (Object o:tarr){
             System.out.println(o);
         }
         Thing t = new Thing();
         t.runme();
         
    }
    
}


class Thing{
    int val;
    Thing(){
        val = 100;
    }
    int getVal(){
        return val;
    }
    void setVal(int newval){
        val = newval;
    }
    //overriding the tostring method from Object
    @Override
    public String toString(){
        return ""+val;
    }
    public void func()throws MyException{
        //int x = 5/0;
        //throw new MyException();
        int numerator =  5;
        int divisor = 0;
        assert divisor!=0: "Divisor cannot ne zero!";
    }
    
    public void runme()throws MyException{
        try{
            func();
        } catch (MyException ex){
            System.out.println("I caught that exception");
        }
        finally{
            System.out.println("This cannot be skipped");
        }
    }
}
class MyException extends Throwable{}


// A class is a frame work, is a design idea. What we use to create an object.
// An object is an instanciation of a class.


//Disable assert?
