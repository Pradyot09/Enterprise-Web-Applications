/*
 * DebugHelloServlet.java
 *
 */
 
        

import javax.servlet.*;
import javax.servlet.http.*;


public class DebugHelloServlet extends HttpServlet {
   
    /** Processes requests for HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        java.io.PrintWriter out = response.getWriter();
        out.println("Hello World");
        out.close();

	// debug info
	System.out.println("DebugHelloServlet : This is the trace to stdout in doget");
	log("trace inside the doget in DebugHelloServlet");
    } 


}
