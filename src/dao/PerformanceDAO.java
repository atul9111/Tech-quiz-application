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
import java.sql.Statement;
import java.util.ArrayList;
import pojo.Performance;
import pojo.SingleScore;

/**
 *
 * @author hp
 */
public class PerformanceDAO {
    public static void addperformance(Performance p) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into performance values(?,?,?,?,?,?,?)");
        ps.setString(1,p.getUserid());
        ps.setString(2,p.getExamid());
        ps.setInt(3,p.getRight());
        ps.setInt(4,p.getWrong());
        ps.setInt(5,p.getUnattempted());
        ps.setDouble(6,p.getPer());
        ps.setString(7,p.getLanguage());
        int rs=ps.executeUpdate();
    }
    public static ArrayList<Performance> getAlldata() throws SQLException
    {
         Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from performance");
        ResultSet rs=ps.executeQuery();
        ArrayList<Performance> pr=new ArrayList<Performance>();
        while(rs.next())
        {
            String user=rs.getString(1);
            String exam=rs.getString(2);
            int rig=rs.getInt(3);
            int wro=rs.getInt(4);
            int unat=rs.getInt(5);
            double pe=rs.getDouble(6);
            String la=rs.getString(7);
            Performance prt;
             prt = new Performance(exam,la,user,rig,wro,unat,pe);
            pr.add(prt);
            }
        return pr;
       }
     public static ArrayList<String>getAllStudentId()throws SQLException
    {
        String qry="select distinct userid from performance";
        ArrayList<String>studentIdList=new ArrayList<>();
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        while(rs.next())
        {
            String id=rs.getString(1);
            studentIdList.add(id);
        }
        return studentIdList;                      
     }
    public static ArrayList<String>getAllExamId(String studentId)throws SQLException
    {
        String qry="select examid from performance where userid=? order by examid ";
        ArrayList<String>examIdList=new ArrayList<>();
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1, studentId);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            String id=rs.getString(1);
            examIdList.add(id);
        }
        return examIdList;                      
     }
    public static SingleScore getsinglescore(String examid,String studentid) throws SQLException
    {    System.out.println("exam id in the database is the =="+examid);
        System.out.println("studentid in the database is the =="+studentid);
        String qry="Select language,per from Performance where userid=? and examid=?";
         Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,studentid);
        ps.setString(2,examid);
        ResultSet rs=ps.executeQuery();
           SingleScore scoreObj=new SingleScore();
        while(rs.next())
        {
     
        scoreObj.setLanguage(rs.getString(1));
        scoreObj.setPercent(rs.getDouble(2));
        }
         return scoreObj;
        
    }
     
}
