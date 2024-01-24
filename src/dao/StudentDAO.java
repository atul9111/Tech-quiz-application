/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbutil.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pojo.StudentReg;
import pojo.Password;

/**
 *
 * @author hp
 */
public class StudentDAO {
    public static int Studentreg(StudentReg reg) throws SQLException{
         Connection conn=DBConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("insert into users values(?,?,?)");
         ps.setString(1,reg.getUserid());
          ps.setString(2,reg.getPassword());
      ps.setString(3,"Student");
         int ji=ps.executeUpdate();
         if(ji==1)
         {
             JOptionPane.showMessageDialog(null,"succesfully inserted the record");
         }
        return ji;
             }
         
     public static int Studentpassword(Password pass) throws SQLException{
         Connection conn=DBConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("update users set userpassword=? where userid=?");
         ps.setString(1,pass.getUserpassword());
          ps.setString(2,pass.getUserid());

         int ji=ps.executeUpdate();
         if(ji==1)
         {
             JOptionPane.showMessageDialog(null,"succesfully updated the record");
         }
        return ji;
             }
 }
