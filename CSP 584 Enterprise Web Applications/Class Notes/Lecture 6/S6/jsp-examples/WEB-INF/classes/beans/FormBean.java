package com.awl.jspbook.ch04;

public class FormBean {
  private String a;
  private String b;
  private String[] c = new String[0];
  private String d;


  public void setA(String a) {this.a = a;}
  public String getA() {return a;}

  public void setD(String d) {this.d = d;}
  public String getD() {return d;}

  public void setC(String[] c) {this.c = c;}
  public String[] getC() {return c;}

  public void setB(String b) {this.b = b;}
  public String getB() {return b;}
}
