

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/** A variation of the RepeatVisitor servlet that uses
 *  CookieUtilities.getCookieValue and LongLivedCookie
 *  to simplify the code.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages 2nd Edition
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2003 Marty Hall; may be freely used or adapted.
 */

public class RepeatVisitor2 extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    boolean newbie = true;
    String value =
      CookieUtilities.getCookieValue(request, "repeatVisitor2",
                                     "no");
    if (value.equals("yes")) {
      newbie = false;
    }
    String title;
    if (newbie) {
      LongLivedCookie returnVisitorCookie =
        new LongLivedCookie("repeatVisitor2", "yes");
      response.addCookie(returnVisitorCookie);
      title = "Welcome Aboard";
    } else {
      title = "Welcome Back";
    }
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "</BODY></HTML>");
  }
}
