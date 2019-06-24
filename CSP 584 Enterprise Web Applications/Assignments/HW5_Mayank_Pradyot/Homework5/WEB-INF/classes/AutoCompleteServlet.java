import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import java.util.*;
import java.text.*;


import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

import java.util.*;
import java.io.*;


@WebServlet("/autocomplete")

public class AutoCompleteServlet extends HttpServlet {

    private ServletContext context;
   
  String searchId=null;	

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();

	    }

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException 
	{
		try
		{	
			String action = request.getParameter("action");
			searchId = request.getParameter("searchId");
			StringBuffer sb = new StringBuffer();
			if (searchId != null && action.equals("complete")) {
				searchId = searchId.trim().toLowerCase();
			} 
			if(searchId==null)	
			{
				context.getRequestDispatcher("/Error").forward(request, response);
			}
			boolean namesAdded = false;
			if (action.equals("complete")) 
			{	
			// check if user sent empty string
				if (!searchId.equals("")) 
				{
					AjaxUtility a=new AjaxUtility();
					sb=a.readdata(searchId);
					if(sb!=null || !sb.equals(""))
					{
						namesAdded=true;
					}
					if (namesAdded) 
					{
						response.setContentType("text/xml");
						response.getWriter().write("<products>" + sb.toString() + "</products>");
					} 
					else 
					{
						//nothing to show
						response.setStatus(HttpServletResponse.SC_NO_CONTENT);
					}
				}
			}
			if (action.equals("lookup"))
			{
				
				HashMap<String,Product> data=AjaxUtility.getData();     	
				if ((searchId != null) && data.containsKey(searchId.trim())) 
				{
					request.setAttribute("data",data.get(searchId.trim()));	
					RequestDispatcher rd=context.getRequestDispatcher("/ProductData");
					rd.forward(request,response);
				}
			}
		}
		catch(Exception e)
		{
		}
    }
}
