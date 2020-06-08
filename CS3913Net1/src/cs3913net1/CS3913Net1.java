/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3913net1;

/**
 *
 * @author rachelqiuyue
 */
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Base64.Encoder;
//
///**
// *
// * @author dkatz
// */
public class CS3913Net1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String sender = "wzgsj_2006@126.com";
        String password = "computer";
        String user = new BASE64Encoder().encode(sender.substring(0, sender.indexOf("@")).getBytes()); 
        String pass = new BASE64Encoder().encode(password.getBytes());
        try{
        Socket s = new Socket("smtp.126.com",25);
            if (s.isConnected()){
                Scanner sin = new Scanner(s.getInputStream());
                PrintStream sout = new PrintStream(s.getOutputStream());
                String line = sin.nextLine();
                System.out.println("Server said: "+line);
                sout.print("HELO dkatz\r\n");
                line = sin.nextLine();
                sout.println("auth login"); 
                line = sin.nextLine();
                System.out.println("Server said: "+line);
                sout.println(sender); 
                line = sin.nextLine();
                System.out.println("Server said: "+line);
                sout.println(password); 
                System.out.println("Server said: "+line);
                sout.print("MAIL FROM:<wzgsj_2006@163.com>\r\n");
                line = sin.nextLine();
                System.out.println("Server said: "+line);
                sout.print("RCPT TO:<wzgsj_2006@163.com>\r\n");
                line = sin.nextLine();
                System.out.println("Server said: "+line);
                sout.print("DATA\r\n");
                line = sin.nextLine();
                System.out.println("Server said: "+line);
                sout.print("Subject: This is a test !\r\n\r\n How did it go?\r\n.\r\n");
            }
            else{
                System.out.println("Socket COnnection Failed!");
            }
        }
        catch(IOException e){
            System.out.println("Welp... that didn't work!");
        }
    }
}

