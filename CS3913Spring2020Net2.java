/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3913spring2020net2;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Dkatz
 */
public class CS3913Spring2020Net2 {

    /**
     * @param args the command line arguments
     */
    static int portNum=6543;
    public static void main(String[] args) {
        ServerSocket ss = null;
        int id=0;
        try{
            ss = new ServerSocket(portNum);
            System.out.println("Waiting for connections on port number: "+portNum);
            while (true){
                Socket client = ss.accept(); //Program will wait here for a LONG time!
                new ProcessConnection(id++,client).start();
            }
            
        }
        catch(IOException e){ System.out.println("IOError: "+e.toString());}
    }
    
}

class ProcessConnection extends Thread{
    int id;
    Socket client;
    ProcessConnection(int newid, Socket newclient){id=newid; client=newclient;}
    public void run(){
        try{
            System.out.println("Connection from: " +client.getInetAddress().toString()+" client "+id);
            PrintStream sout = new PrintStream(client.getOutputStream());
            Scanner sin = new Scanner(client.getInputStream());
            sout.print("Welcome to my echo server!\r\n");
            String line="";
            while (!line.equalsIgnoreCase("EXIT")){
                line = sin.nextLine();
                System.out.println("Client ("+id+") Said: "+line);
                sout.print(line+"\r\n");
            }
            sout.print("Goodbye!\r\n");
            System.out.println("Client ("+id+" Disconnected");
            client.close();
        }
        catch(IOException e){
            
        }
    }
}
