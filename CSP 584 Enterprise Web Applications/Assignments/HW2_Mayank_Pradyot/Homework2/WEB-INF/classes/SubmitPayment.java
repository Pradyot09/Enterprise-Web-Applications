import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SubmitPayment")

public class SubmitPayment extends HttpServlet {
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		

		Utilities utility = new Utilities(request, pw);
		if(!utility.isLoggedin())
		{
			HttpSession session = request.getSession(true);				
			session.setAttribute("login_msg", "Please Login to Pay");
			response.sendRedirect("Login");
			return;
		}
		// get the payment details like credit card no address processed from cart servlet	

		String userAddress=request.getParameter("userAddress");
		String creditCardNo=request.getParameter("creditCardNo");
		int orderId=utility.getOrderPaymentSize()+1;
		//iterate through each order

		for (OrderItem oi : utility.getCustomerOrders())
		{

			//set the parameter for each column and execute the prepared statement

			utility.storePayment(orderId,oi.getName(),oi.getPrice(),userAddress,creditCardNo);
		
		}

		//remove the order details from cart after processing
			
		OrdersHashMap.orders.remove(utility.username());	
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
	    pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>Order</a>");
		pw.print("</h2><div class='entry'>");
        pw.print("<h2>Your Order");
        pw.print("&nbsp&nbsp");  
        pw.print("is stored ");
        pw.print("<br>Your Order No is "+(orderId));
		pw.print("</h2></div></div></div>");		
		utility.printHtml("Footer.html");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(request, pw);
		
		
	}
}
