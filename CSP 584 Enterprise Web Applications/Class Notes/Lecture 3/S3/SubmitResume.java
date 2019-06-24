

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

/** Servlet that handles previewing and storing resumes
 *  submitted by job applicants.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages 2nd Edition
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2003 Marty Hall; may be freely used or adapted.
 */

public class SubmitResume extends HttpServlet {
  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    if (request.getParameter("previewButton") != null) {
      showPreview(request, out);
    } else {
      storeResume(request);
      showConfirmation(request, out);
    }
  }

  /** Shows a preview of the submitted resume. Takes
   *  the font information and builds an HTML
   *  style sheet out of it, then takes the real
   *  resume information and presents it formatted with
   *  that style sheet.
   */
  
  private void showPreview(HttpServletRequest request,
                          PrintWriter out) {
    String headingFont = request.getParameter("headingFont");
    headingFont = replaceIfMissingOrDefault(headingFont, "");
    int headingSize =
      getSize(request.getParameter("headingSize"), 32);
    String bodyFont = request.getParameter("bodyFont");
    bodyFont = replaceIfMissingOrDefault(bodyFont, "");
    int bodySize =
      getSize(request.getParameter("bodySize"), 18);
    String fgColor = request.getParameter("fgColor");
    fgColor = replaceIfMissing(fgColor, "BLACK");
    String bgColor = request.getParameter("bgColor");
    bgColor = replaceIfMissing(bgColor, "WHITE");
    String name = request.getParameter("name");
    name = replaceIfMissing(name, "Lou Zer");
    String title = request.getParameter("title");
    title = replaceIfMissing(title, "Loser");
    String email = request.getParameter("email");
    email =
      replaceIfMissing(email, "contact@hot-computer-jobs.com");
    String languages = request.getParameter("languages");
    languages = replaceIfMissing(languages, "<I>None</I>");
    String languageList = makeList(languages);
    String skills = request.getParameter("skills");
    skills = replaceIfMissing(skills, "Not many, obviously.");
    out.println
      (ServletUtilities.DOCTYPE + "\n" +
       "<HTML><HEAD><TITLE>Resume for " + name + "</TITLE>\n" +
       makeStyleSheet(headingFont, headingSize,
                      bodyFont, bodySize,
                      fgColor, bgColor) + "\n" +
       "</HEAD>\n" +
       "<BODY>\n" +
       "<CENTER>\n"+
       "<SPAN CLASS=\"HEADING1\">" + name + "</SPAN><BR>\n" +
       "<SPAN CLASS=\"HEADING2\">" + title + "<BR>\n" +
       "<A HREF=\"mailto:" + email + "\">" + email +
           "</A></SPAN>\n" +
       "</CENTER><BR><BR>\n" +
       "<SPAN CLASS=\"HEADING3\">Programming Languages" +
       "</SPAN>\n" +
       makeList(languages) + "<BR><BR>\n" +
       "<SPAN CLASS=\"HEADING3\">Skills and Experience" +
       "</SPAN><BR><BR>\n" +
       skills + "\n" +
       "</BODY></HTML>");
  }

  /** Builds a cascading style sheet with information
   *  on three levels of headings and overall
   *  foreground and background cover. Also tells
   *  Internet Explorer to change color of mailto link
   *  when mouse moves over it.
   */
  
  private String makeStyleSheet(String headingFont,
                                int heading1Size,
                                String bodyFont,
                                int bodySize,
                                String fgColor,
                                String bgColor) {
    int heading2Size = heading1Size*7/10;
    int heading3Size = heading1Size*6/10;
    String styleSheet =
      "<STYLE TYPE=\"text/css\">\n" +
      "<!--\n" +
      ".HEADING1 { font-size: " + heading1Size + "px;\n" +
      "            font-weight: bold;\n" +
      "            font-family: " + headingFont +
                     "Arial, Helvetica, sans-serif;\n" +
      "}\n" +
      ".HEADING2 { font-size: " + heading2Size + "px;\n" +
      "            font-weight: bold;\n" +
      "            font-family: " + headingFont +
                     "Arial, Helvetica, sans-serif;\n" +
      "}\n" +
      ".HEADING3 { font-size: " + heading3Size + "px;\n" +
      "            font-weight: bold;\n" +
      "            font-family: " + headingFont +
                     "Arial, Helvetica, sans-serif;\n" +
      "}\n" +
      "BODY { color: " + fgColor + ";\n" +
      "       background-color: " + bgColor + ";\n" +
      "       font-size: " + bodySize + "px;\n" +
      "       font-family: " + bodyFont +
                    "Times New Roman, Times, serif;\n" +
      "}\n" +
      "A:hover { color: red; }\n" +
      "-->\n" +
      "</STYLE>";
    return(styleSheet);
  }

  /** Replaces null strings (no such parameter name) or
   *  empty strings (e.g., if textfield was blank) with
   *  the replacement. Returns the original string otherwise.
   */
  
  private String replaceIfMissing(String orig,
                                  String replacement) {
    if ((orig == null) || (orig.trim().equals(""))) {
      return(replacement);
    } else {
      return(orig);
    }
  }

  // Replaces null strings, empty strings, or the string
  // "default" with the replacement.
  // Returns the original string otherwise.
  
  private String replaceIfMissingOrDefault(String orig,
                                           String replacement) {
    if ((orig == null) ||
        (orig.trim().equals("")) ||
        (orig.equals("default"))) {
      return(replacement);
    } else {
      return(orig + ", ");
    }
  }

  // Takes a string representing an integer and returns it
  // as an int. Returns a default if the string is null
  // or in an illegal format.
    
  private int getSize(String sizeString, int defaultSize) {
    try {
      return(Integer.parseInt(sizeString));
    } catch(NumberFormatException nfe) {
      return(defaultSize);
    }
  }

  // Given "Java,C++,Lisp", "Java C++ Lisp" or
  // "Java, C++, Lisp", returns
  // "<UL>
  //   <LI>Java
  //   <LI>C++
  //   <LI>Lisp
  //  </UL>"

  private String makeList(String listItems) {
    StringTokenizer tokenizer =
      new StringTokenizer(listItems, ", ");
    String list = "<UL>\n";
    while(tokenizer.hasMoreTokens()) {
      list = list + "  <LI>" + tokenizer.nextToken() + "\n";
    }
    list = list + "</UL>";
    return(list);
  }

  /** Show a confirmation page when they press the
   *  "Submit" button.
   */
  
  private void showConfirmation(HttpServletRequest request,
                                PrintWriter out) {
    String title = "Submission Confirmed.";
    out.println(ServletUtilities.headWithTitle(title) +
                "<BODY>\n" +
                "<H1>" + title + "</H1>\n" +
                "Your resume should appear online within\n" +
                "24 hours. If it doesn't, try submitting\n" +
                "again with a different email address.\n" +
                "</BODY></HTML>");
  }

  /** Why it is bad to give your email address to
   *  untrusted sites.
   */
  
  private void storeResume(HttpServletRequest request) {
    String email = request.getParameter("email");
    putInSpamList(email);
  }
  
  private void putInSpamList(String emailAddress) {
    // Code removed to protect the guilty.
  }
}
