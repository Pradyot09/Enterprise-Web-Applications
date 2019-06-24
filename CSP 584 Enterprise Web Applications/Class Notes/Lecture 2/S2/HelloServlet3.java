/*
 * HelloServlet3.java
 *
 */
 
         

import javax.servlet.*;
import javax.servlet.http.*;


public class HelloServlet3 extends HttpServlet {
   
    /** Processes requests for HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello Servlet</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World!</h1>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    } 
}
