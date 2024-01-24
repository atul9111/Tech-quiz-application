/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author hp
 */
public class StudentReg{
    public  StudentReg()
    {
        
    }

    public StudentReg(String userid, String password, String repassword) {
        this.userid = userid;
        this.password = password;
        this.repassword = repassword;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
  private String userid;
  private String password;
  private String repassword;
  
    
}
