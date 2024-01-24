/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbutil;

import java.util.*;
import java.sql.*;
import java.math.*;
import javax.swing.*;
public class DBConnection {
private static Connection conn;
    static
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "techquiz", "goldy");
            JOptionPane.showMessageDialog(null, "Connected successfully to the DB");
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Connection Cannot be open");
            ex.printStackTrace();
        }
    }
        public static Connection getConnection()
        {
            return conn;
        }
          public static void closeConnection()
          {
        try
        {
        conn.close();
         JOptionPane.showMessageDialog(null, "Disconnected successfully to the DB");
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Cannot disconnect with the DB");
            ex.printStackTrace();       
            
        }
    }
    }
