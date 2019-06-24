/*
 * SurveyServlet.java
 *
 */
 
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;

public class SurveyServlet extends HttpServlet {
   

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Survey Servlet</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<table>");
        /* get the parameters and list them, with their values */
        Enumeration parameters = request.getParameterNames();
        if(parameters.hasMoreElements()) {
            out.println("<tr><th>Parameter Name</th><th>Parameter Value</th></tr>");
        }
        while(parameters.hasMoreElements()) {
            String parameter = (String)parameters.nextElement();
            // get the parameter values
            String[] values = request.getParameterValues(parameter);
            if(values != null) {
                for(int i = 0; i < values.length; i++) {
                    out.println("<tr><td><b><font color=\"blue\">" + parameter + "</font></b></td>" +
                            "<td>" + values[i] + "</td></tr>");
                }
            }
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    } 

    /** Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    } 

    /** Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    }

}
