/*
 * HelloServlet.java
 *
 */
 
        

import javax.servlet.*;
import javax.servlet.http.*;


public class HelloServlet extends HttpServlet {
   
    /** Processes requests for HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        java.io.PrintWriter out = response.getWriter();
        out.println("Hello World");
        out.close();
    } 


}
