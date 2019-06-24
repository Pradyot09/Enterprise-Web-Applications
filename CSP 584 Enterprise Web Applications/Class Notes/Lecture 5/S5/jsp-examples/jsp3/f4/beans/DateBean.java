package com.awl.jspbook.ch04;

import java.text.*;
import java.util.*;

public class DateBean implements java.io.Serializable {
  SimpleDateFormat sdf;

  public void setFormat(String format) {
    sdf = new SimpleDateFormat(format);
  }

  public String getCurrentTime() {
    return sdf.format(new Date());
  }
}
