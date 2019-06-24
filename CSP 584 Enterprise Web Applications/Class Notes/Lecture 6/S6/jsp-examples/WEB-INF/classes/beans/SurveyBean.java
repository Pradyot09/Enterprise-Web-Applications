package com.awl.jspbook.ch04;

public class SurveyBean implements java.io.Serializable {
  private String met;
  private String conferences[] = new String[0];
  private String question;


  public String getMet()         {return met;}
  public void setMet(String met) {this.met = met;}

  public String getQuestion()              {return question;}
  public void setQuestion(String question) {this.question = question;}

  public String[] getConferences()          {return conferences;}
  public void setConferences(String[] conf) {conferences = conf;}
}
