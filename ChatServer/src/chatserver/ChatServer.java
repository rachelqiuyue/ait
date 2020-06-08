/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

/**
 *
 * @author rachelqiuyue
 * 
 * 
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    /**
     * @param args the command line arguments
     */
    static int portNum=5190;
    static ArrayList<Socket> clients;
    public static void main(String[] args) {
        ServerSocket ss = null;
        String name = "";
        clients = new ArrayList();
        try{
            ss = new ServerSocket(portNum);
            System.out.println("Waiting for connections on port number: "+portNum);
            while (true){
                Socket client = ss.accept(); //Program will wait here for a LONG time!
                
                clients.add(client);
//                PrintStream sout = new PrintStream(client.getOutputStream());
//                Scanner sin = new Scanner(client.getInputStream());
//                String username = sin.nextLine();
//                sout.print("Welcome to my echo server!"+username+"\r\n");
                new ProcessConnection(client).start();
            }
            
        }
        catch(IOException e){ System.out.println("IOError: "+e.toString());}
    }
    
    static class ProcessConnection extends Thread{
        Socket client;
        String username;
        ProcessConnection(Socket newclient){client = newclient;}
        public void run(){
            try{
    //            System.out.println("Connection from: " +client.getInetAddress().toString());

                String line="";
                PrintStream sout = new PrintStream(client.getOutputStream());
                Scanner sin = new Scanner(client.getInputStream());
                username = sin.nextLine();
                sout.print("Welcome\r\n");
                System.out.println(client.getInetAddress());
                while (sin.hasNext()){
                    System.out.println("here");
                    line = sin.nextLine();
                    if (line.equalsIgnoreCase("EXIT")){client.close();}
                    System.out.println("Client ("+username+") Said: "+line);
                       for (Socket c : clients){ 
                        PrintStream ssout = new PrintStream(c.getOutputStream());
                        ssout.print(username+":"+line+"\r\n");
                    }
                }
                System.out.println("there");
            }
            catch(Exception e){

            }
        }
    }
}
