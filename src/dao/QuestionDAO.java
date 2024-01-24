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
import pojo.Question;
import pojo.QuestionStore;


   


public class QuestionDAO {
    public static void addQuestions(QuestionStore qstore)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into questions values(?,?,?,?,?,?,?,?,?)");
        ArrayList<Question> questionsList=qstore.getAllQuestions();
        for(Question q:questionsList)
        {
            ps.setString(1, q.getExamId());
            ps.setInt(3,q.getQno());
            ps.setString(8,q.getQuestion());
            ps.setString(4,q.getAnswer1());
            ps.setString(5,q.getAnswer2());
            ps.setString(6,q.getAnswer3());
            ps.setString(7,q.getAnswer4());
            ps.setString(9,q.getCorrectAnswer());
            ps.setString(2,q.getLanguage());
            ps.executeUpdate();
           
        }
         System.out.println(questionsList);
        
    }
    
     public static ArrayList<Question> getQuestionsByExamId(String examId)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from Questions where examId=?");
        ps.setString(1, examId);
        System.out.println("Examid"+examId);
        ResultSet rs=ps.executeQuery();
        ArrayList<Question> questionList=new ArrayList<>();
       while(rs.next())
       {
           int qno=rs.getInt(3);
           String question=rs.getString(8);
           String option1=rs.getString(4);
           String option2=rs.getString(5);
           String option3=rs.getString(6);
           String option4=rs.getString(7);
           String correctAnswer=rs.getString(9);
           String language=rs.getString(2);
           Question obj=new Question(examId,language,qno,question,option1,option2,option3,option4,correctAnswer);
           questionList.add(obj);
           System.out.println("In DAO"+obj);
           //System.out.println("In DAO:"+obj);
       }
       return questionList;
    }
     public static void updateQuestion(QuestionStore qStore)throws SQLException
    {
       Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("update questions set question=? where qno=? and examid=?"); 
       ArrayList<Question> questionList=qStore. getAllQuestions();
       for(Question q:questionList)
       {
           System.out.println(q);
         ps.setString(1,q.getQuestion()); 
         ps.setInt(2, q.getQno());
         ps.setString(3,q.getExamId());
         ps.executeUpdate();      
       }
    }
}

