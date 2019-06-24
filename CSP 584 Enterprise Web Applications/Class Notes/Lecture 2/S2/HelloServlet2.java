/*
 * HelloServlet2.java
 *
 */
 
     

import javax.servlet.*;
import javax.servlet.http.*;


public class HelloServlet2 extends HttpServlet {
   
    protected String bgcolor = null;
    protected String fgcolor = null;


    /** 
     * init gets initialization parameters from web.xml file
     */    
    public void init() { 
        bgcolor = getInitParameter("bgcolor");
        fgcolor = getInitParameter("fgcolor");
    }

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
    
        if (bgcolor != null) { 
            out.println("<body bgcolor=\"" + bgcolor + "\">");
        } else { 
            out.println("<body>");
        }
        
        if (fgcolor != null) { 
            out.println("<h1><font color=\"" + fgcolor 		
                + "\"> Hello World!</font></h1>"); 
        } else { 
            out.println("<h1>Hello World!</h1>");
        }
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    } 
}
