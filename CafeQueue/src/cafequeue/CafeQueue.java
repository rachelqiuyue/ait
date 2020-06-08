/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafequeue;

import java.util.LinkedList;

/**
 *
 * @author rachelqiuyue
 */
public class CafeQueue {

    /**
     * @param args the command line arguments
     */
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
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
