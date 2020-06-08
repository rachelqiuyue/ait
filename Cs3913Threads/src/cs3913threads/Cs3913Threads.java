/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3913threads;

/**
 *
 * @author rachelqiuyue
 */
public class Cs3913Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //started the thread but the main is done is printed first. The thread is waiting for the main thread to finaish
//        Thread t = new MyThread();
//        t.start();
//        System.out.println("GThread started");
//        for (int i = 0; i<1000;++i){
//            System.out.println('.');
//        }
//         System.out.println("Main is done...");
//        for (int i = 0; i<5;++i){
//            new Printer(i).start();
//        }
        for (int i = 0; i<5;++i){
            new B(i).run();
        }
    }
}


class MyThread extends Thread{
    @Override 
    public void run(){
        for (int i = 0; i<100;++i){
            System.out.println("i="+i);
        }
    }
}

class Printer extends Thread{
    int myId;
    Printer(int id){
        myId =id;
    }
    public void run(){
        for (int i = 0;i < 1000;i++){
            for (int j = 0; j < myId;j++)
                System.out.print("\t");
            System.out.println(myId);
//            try{
//                sleep(200);
//            }catch(InterruptedException ex){}
            //yield();

        }
    }
}

class A{}
class B extends A implements Runnable{
    int myId;
    B(int id){
        myId = id;
    }
    public void run(){
        for(int i = 0;i<100;i++){
            System.out.println(myId);
            Thread.currentThread().yield();
        }
    }
}


//