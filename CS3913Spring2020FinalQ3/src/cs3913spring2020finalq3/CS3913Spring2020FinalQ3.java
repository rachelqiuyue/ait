/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3913spring2020finalq3;
import java.util.*; 
import java.util.Random; 
/**
 *
 * @author rachelqiuyue
 */
public class CS3913Spring2020FinalQ3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // This is testing the CafeQueue class works whem multiple threads call on the same class
        CafeQueue q = new CafeQueue();
        for (int i = 0; i < 5;++i){
            Try t =new Try(q);
            t.start();
        }
    }
    
}

class CafeQueue{
    static LinkedList<String> storage;
    CafeQueue(){storage = new LinkedList<String>();}
    static synchronized void enterQueue(String c){
        synchronized(storage){
            storage.add(c);
        }
    }
    static synchronized String serveCostumer(){
            if (storage.size() == 0){
                return "No costumer to serve";
            }
            return storage.remove();
    }
}

class Try extends Thread{
    CafeQueue q;
    
    Try(CafeQueue newq){
         q = newq;
    }
    public void run(){
        Random rand = new Random(); 
        int i = rand.nextInt(1000); 
        if (i%2 == 0){
            q.serveCostumer();
        }else{
            q.enterQueue(String.valueOf(i));
        }
    }

}