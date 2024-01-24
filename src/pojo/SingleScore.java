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
public class SingleScore {

    public SingleScore() {
        //To change body of generated methods, choose Tools | Templates.
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public SingleScore(String language, Double percent) {
        this.language = language;
        this.percent = percent;
    }
  private String language;
  private Double  percent;
  
}
