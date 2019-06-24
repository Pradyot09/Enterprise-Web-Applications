package servlets;

import java.util.StringTokenizer;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
import  MyServletJSPBean.SumAvgBean;


public class SumAvgServlet extends HttpServlet {
    public void doPost(HttpServletRequest req,
		       HttpServletResponse res)
        throws IOException,ServletException
    {
	RequestDispatcher rd;
        ServletContext sc = getServletContext();
        String values     = req.getParameter("values");
	SumAvgBean data   = new SumAvgBean();
	int num           = 0;
	int sum           = 0;
	double avg        = 0;
	int count         = 0;

	/* Add the bean to the request scope */
	req.setAttribute("data",data);

	data.setValues(values);

	if(values == null) {
	    rd = sc.getRequestDispatcher("/jsp-to-servlet-to-jsp/jsp3/f13/sumavgform.jsp");
	    rd.forward(req,res);
	    return;
		
	} else {
	    StringTokenizer st = new StringTokenizer(values,",");
	    String token;

	    while(st.hasMoreTokens()) {
	        token = st.nextToken();
		try {
		    num = Integer.parseInt(token);
		} catch (NumberFormatException e) {
		    data.setBad(token);
		    rd = sc.getRequestDispatcher(
                         "/jsp-to-servlet-to-jsp/jsp3/f13/sumavgerror.jsp");
		    rd.forward(req,res);
		    return;
		}

		count++;
		sum = sum + num;
	    }
	}

	data.setSum(sum);
	data.setAvg(sum/count);
	rd = sc.getRequestDispatcher("/jsp-to-servlet-to-jsp/jsp3/f13/sumavgresults.jsp");
	rd.forward(req,res);
    }
}
