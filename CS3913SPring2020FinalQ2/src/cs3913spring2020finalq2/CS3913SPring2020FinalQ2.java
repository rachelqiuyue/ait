/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3913spring2020finalq2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author rachelqiuyue
 */
public class CS3913SPring2020FinalQ2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashMap<Integer,String> idName = new HashMap<>(); 
        ArrayList<Integer> ids = new ArrayList<Integer>();
        TreeMap<Double, Product> map2 = new TreeMap<Double, Product>(Collections.reverseOrder());
        try{
            Connection conn = null;
            String url = "jdbc:mariadb://localhost";
            String dbuser="Username:CS3913";
            String password = "Password:GettingAnA+";
            conn = DriverManager.getConnection(url,dbuser,password);
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("Select * from Products;");
            while(rs.next()){
                int pid = rs.getInt("PID");
                String name = rs.getString("ProductName");
                idName.put(pid,name);
                ids.add(pid);
            }
            for (int id:ids){
                String pid = String.valueOf(id);
                rs = s.executeQuery("Select Rating from Reviews where PID="+pid);
                int count = 0;
                int sum = 0;
                while (rs.next()){
                    int rate = rs.getInt("Rating");
                    sum +=rate;
                    count++;
                }
                double average = sum/count;
                Product p1= new Product(id,idName.get(id),average);
                map2.put(p1.getRate(), p1);
            }
        }
        catch (Exception e){System.out.println("Error: "+e.toString());}
        for (Product p: map2.values()){
            System.out.println(p.getName());
        }
    }
}


class Product implements Comparable<Product>{
    Product(int newpid,String newName,double newRate){
        pid = newpid;
        name = newName;
        rate = newRate;
    }
    int pid;
    String name;
    double rate;
    @Override
    public int compareTo(Product p){
        return (int)(this.rate - p.getRate());
    }
    public double getRate(){
        return rate;
    }
    public String getName(){
        return name;
    }
}
