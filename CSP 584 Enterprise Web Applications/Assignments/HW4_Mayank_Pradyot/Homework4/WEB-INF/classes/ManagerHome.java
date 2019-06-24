import java.io.*;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ManagerHome")

public class ManagerHome extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		displayLogin(request, response, pw, false);
	}


	/*  Login Screen is Displayed, Registered User specifies credentials and logins into the Game Speed Application. */
	protected void displayLogin(HttpServletRequest request,
			HttpServletResponse response, PrintWriter pw, boolean error)
			throws ServletException, IOException {

		Utilities utility = new Utilities(request, pw);
		utility.printHtml("Header.html");
		pw.print("<br></br>");
		utility.printHtml("LeftNavigationBar.html");
		// pw.print("</div>");
		// pw.print("<div class='post' style='float: none; width: 100%'>");
		
		pw.print("<div id='content'style='float: none; width: 100%'>");
		
		//pw.print("<h2 class='title meta'><a style='font-size: 24px;'>Login</a></h2>"
			//	+ "<div class='entry'>"
			//	+ "<div style='width:400px; margin:25px; margin-left: auto;margin-right: auto;'>");
		pw.print("<div id='content'><div class='post'><h2 class='title meta'>"+"<br></br>");
		pw.print("<form method='get' action='ProductModify'>"
				
				+"<table style='width:100%'><tr>"
				// + "<td>"
				// + "<input type='submit' class='btnbuy' name='button' value='Inventory'style = 'width:200px'></input>"
				// + "</td>"
				+ "<td>"
				+"Inventory"
				+"<ul>"
					+"<li><a href=InventoryReport?inventoryreport=allproducts>All Products</a></li>"
					+"<li><a href=InventoryReport?inventoryreport=barchart>Generate Bar Chart</a></li>"
					+"<li><a href=InventoryReport?inventoryreport=productsonsale>Products Currently on sale</a></li>"
					+"<li><a href=InventoryReport?inventoryreport=productsonrebate>Products Currently have manufacturer rebate</a></li>"
				+"</ul>"
				// +"</li>"
				+ "</td>"
				+ "<td>"
				+"Sales Rerport"
				+"<ul>"
					+"<li><a href=SalesReport?sales=soldproducts>Sold Products</a></li>"
					+"<li><a href=SalesReport?sales=barchart>Generate Bar Chart</a></li>"
					+"<li><a href=SalesReport?sales=dailytransaction>Daily Transaction</a></li>"
				+"</ul>"
				// +"</li>"
				+ "</td>"
				+"Data Exploration"
				+"<ul>"
					+"<li><a href=DataExplorationUtility?dataexplore=avgproductprices>Average product prices</a></li>"
					+"<li><a href=DataExplorationUtility?dataexplore=totalproductsprices>Total price of products sold</a></li>"
					+"<li><a href=DataExplorationUtility?dataexplore=productsboughtperstate>Total Number of Products Bought</a></li>"
				+"</ul>"
				// +"</li>"
				+ "</td>"
				+ "</tr>"
				+"<tr><td>"
				+ "<input type='submit' class='btnbuy' name='button' value='Add Product'style = 'width:200px'></input>"
				+"</td>"
				+"<td>"
				+ "<input type='submit' class='btnbuy' name='button' value='Update Product' style = 'width:200px'></input>"
				+ "</td></tr>"
				+"<tr><td>"
				+ "<input type='submit' class='btnbuy' name='button' value='Delete Product' style = 'width:200px'></input>"
				+ "</td><td>"
				+ "<input type='submit' class='btnbuy' name='button' value='Trending' style = 'width:200px'></input>"
				+ "</td></tr></table>"
				+ "</form>" + "</ul></div></nav></div></div></div>");
		// pw.print("</ul></div></nav></div></div>");
		utility.printHtml("Footer.html");
		
	}
}