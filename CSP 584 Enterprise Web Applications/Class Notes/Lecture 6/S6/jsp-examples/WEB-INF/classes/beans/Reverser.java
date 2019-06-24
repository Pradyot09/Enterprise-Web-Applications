package com.awl.jspbook.ch04;

public class Reverser implements java.io.Serializable {
  private String hostName;
  private String reversedHostName;

  public void setHostName(String hostName) {
    this.hostName    = hostName;
    int len          = hostName.length();
    StringBuffer tmp = new StringBuffer(len);

    for(int i=0;i<len;i++) 
      tmp.append(hostName.charAt(len-1-i));

    reversedHostName = tmp.toString();
  }

  public String getReversedHostName() {
    return reversedHostName;
  }
}
