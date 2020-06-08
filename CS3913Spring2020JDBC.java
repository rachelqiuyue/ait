/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3913spring2020jdbc;
import java.sql.*;
import java.io.*;

/**
 *
 * @author dkatz
 */
public class CS3913Spring2020JDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conn = null;
        try{
            //Class.forName("org.mariadb.jdbc.Driver").newInstance();
            String url = "jdbc:mariadb://127.0.0.1:3306/cs3913";
            String dbuser="cs3913";
            String password = "abc123";
            conn = DriverManager.getConnection(url,dbuser,password);
            //System.out.println("GOT HERE!");
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from review3;");
            
            while (rs.next()){
                int id = rs.getInt(1); // Get the ID number
                String name = rs.getString("Name");
                int price = rs.getInt("Price");
                String thoughts = rs.getString("Thoughts");
                System.out.println(id+","+name+","+price+","+thoughts);
            }
            rs.close();
            s.close();
            conn.close();
            
        }
        catch (Exception e){System.out.println("Error: "+e.toString());}
    }
    
}
