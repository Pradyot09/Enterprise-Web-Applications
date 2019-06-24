package com.awl.jspbook.ch04;

import javax.servlet.*;
import javax.servlet.http.*;

public class UserInfoBean implements java.io.Serializable {
  private String name;
  private HttpServletRequest request;

  public void setRequest(HttpServletRequest request) {
    this.request = request;
    name         = "user from " + request.getRemoteHost();
  }

  public String getName() {return name;}
}
