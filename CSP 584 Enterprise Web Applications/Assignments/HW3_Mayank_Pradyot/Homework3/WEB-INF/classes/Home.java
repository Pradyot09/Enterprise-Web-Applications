import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Home")

/* 
	Home class uses the printHtml Function of Utilities class and prints the Header,LeftNavigationBar,
	Content,Footer of Game Speed Application.

*/

public class Home extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		//Loading all the items in the database 
		
		
		
		Utilities utility = new Utilities(request,pw);
		utility.printHtml("Header.html");
		pw.print("<br></br>");
		utility.printHtml("LeftNavigationBar.html");
		utility.printHtml("Content.html");
		utility.printHtml("Footer.html");
				
	}

}
