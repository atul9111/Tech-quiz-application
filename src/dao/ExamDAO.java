/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbutil.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pojo.Exam;

/**
 *
 * @author hp
 */
public class ExamDAO {
    public static String getExamId() throws SQLException
    {
    Connection conn=DBConnection.getConnection();

PreparedStatement ps=conn.prepareStatement("Select count(*) from exam");
int count;

ResultSet rs=ps.executeQuery();
rs.next();
count=rs.getInt(1);
String newid="EX-"+count;
return newid;

    }
    public static boolean addQuestion(Exam ex)throws SQLException
    {
        Connection conn=
                DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("insert into Exam values(?,?,?)");
            ps.setString(1,ex.getExamId());
            ps.setString(2,ex.getLanguage());
            ps.setInt(3,ex.getTotalQuestions());
            int co=ps.executeUpdate();
            if(co!=1)
            {
                return false;
                
            }
            return true;
    }
    public static ArrayList<String>  getExamIdBySubject(String subject) throws SQLException
    {
         Connection conn=DBConnection.getConnection();
         
            PreparedStatement ps=conn.prepareStatement("Select examid from exam where language=?");
           
            ps.setString(1,subject);
            ResultSet rs=ps.executeQuery();
            ArrayList<String> examidlist=new ArrayList<String>();
            
            while(rs.next())
            {
                examidlist.add(rs.getString(1));
                
                
            }
            
            return examidlist;
    }

    /**
     *
     * @param examid
     * @return
     * @throws SQLException
     */
    public static int getQuestionCountByExam(String examtid) throws SQLException
    { Connection conn=
                DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("Select totalquestions from exam where examid=?");
            ps.setString(1,examtid);
            
              ResultSet rs=ps.executeQuery();
             
        
            int re=0;
            while(rs.next())
            {re=rs.getInt(1);
                
            }
            
            return re;
    }
    public static boolean isPaperSet(String subject) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("select examid from exam where language=?");
     ps.setString(1,subject);
     ResultSet rs=ps.executeQuery();
     return rs.next();
    }
    public static ArrayList<String> getExamIdBySubject(String userid,String subject) throws SQLException
    {
        Connection conn=
                DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select examid from exam where language=? minus select examid from performance where userid=?");
            ps.setString(1,subject);
            ps.setString(2,userid);
              ResultSet rs=ps.executeQuery();
             
        
             ArrayList<String> examlist=new ArrayList<String>();
            while(rs.next())
            {examlist.add(rs.getString(1));
                
            }
            
            return examlist;
    }
            
            
            
                 
            
            
            
            
}
