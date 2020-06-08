/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture2;

/**
 *
 * @author rachelqiuyue
 */
public class Lecture2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        a1.setFirst(100);
        a1.setSecond(100);
        a2.setFirst(50);
        a2.setSecond(75);
        System.out.println("Object A1:");
        System.out.println("First = "+a1.getFirst());
        System.out.println("Second = "+a2.getSecond());
        System.out.println("Object A2:");
        System.out.println("First = "+a2.getFirst());
        System.out.println("Second = "+a2.getSecond());
        B.third = 9;
        C.printSomething();
    }
    
}
class B{
    static int third;
}

class A{
    int first;
    static double second;
    public void setFirst(int n){
        first = n;
    }
    public int getFirst(){
        return first;
    }
    public void setSecond(double n){
        second = n;
    }
    public double getSecond(){
        return second;
    }
}

/* output
Object A1:
First = 100
Second = 75.0
Object A2:
First = 50
Second = 75.0
*/

// static the varibla is stored once for each class
// Java creates a new object for every class that we make. The object datatype is class. Every class I make, Java makes an object for the class I'm creating. The class stores static.
// First and Second are not private. They are default or package private
// protected derived class can access.


//Print stream class has static out so we don't need instanciation of class

class C{
    int first;
    static int second;
    public static void printSomething(){
        System.out.println("Hello,world");
        //System.out.println("First" + first);
        System.out.println("Second"+second);
    }
    
    //Static function cannot access static variables
}

//final class stops deriving
//purely virtual function. abstract class. Must list the class 

abstract class D{
    abstract public void someFunc();
}
//No destructor in java. But have finalizer
// Gabage collector comes periodically. Finalizer works as a component of gabage collection.
// Java doesn't have operator overload.


//Exception Try Throw Catch
