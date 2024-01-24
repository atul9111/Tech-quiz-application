/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbutil.DBConnection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.*;
import pojo.User;

/**
 *
 * @author hp
 */
public class UserDAO {
  public static boolean validateUser(User user)throws SQLException
    {
               
        
 Connection conn=DBConnection.getConnection();
String qry="Select * from Users where userid=? and userpassword=? and usertype=?";
PreparedStatement ps=conn.prepareStatement(qry);
ps.setString(1,user.getUsername());
ps.setString(2,user.getUserpassword());
ps.setString(3,user.getUsertype());
ResultSet rs=ps.executeQuery();
       return rs.next();

    }
  
}