/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread2;

/**
 *
 * @author rachelqiuyue
 */
public class Thread2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Print.o = new Object();
        for (int i = 0; i < 5; i++){
            new Print(i).start();
        }
    }

    
    
}
class Print extends Thread{
    int id;
    //static Object o;
    Print(int newid){id = newid;}
    public void run(){
        for (int i = 0; i < 100; i++){
            //doesn't work, this sychronize different objectx
            //System.out.println(id);
            printline(id);
        }
        }
    static synchronized void printline(int id){
        // implicit call to class.wait()
        // static synchronized meanse we're using the class
        for (int i = 0; i < 100; i++){
            for (int j = 0; j < id ;j++){
                System.out.print("\t");
            }
            System.out.println(id);
        }
        //implicit cal to class.notify
    }
}
