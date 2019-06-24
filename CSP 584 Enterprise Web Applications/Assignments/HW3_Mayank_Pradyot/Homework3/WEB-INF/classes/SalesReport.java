import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@WebServlet("/SalesReport")

public class SalesReport extends HttpServlet {

	HashMap<String, Inventory> soldProducts=new HashMap<String, Inventory>();
	HashMap<String, Inventory> dailyTransaction=new HashMap<String, Inventory>();
	HashMap<String, Inventory> onSaleProducts=new HashMap<String, Inventory>();
    // HashMap<String, Inventory> allProducts=new HashMap<String, Inventory>();
	// HashMap<String, Inventory> allProducts=new HashMap<String, Inventory>();
	// HashMap<String, Inventory> allProducts=new HashMap<String, Inventory>();

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		
		
		soldProducts =MySqlDataStoreUtilities.getSoldProducts();		
		
		dailyTransaction=MySqlDataStoreUtilities.getDailyTransactions();		
		
		onSaleProducts=MySqlDataStoreUtilities.getAllProducts();		

		String name = "SalesReport";
		String CategoryName = request.getParameter("sales");
		
		Utilities utility = new Utilities(request, pw);
		utility.printHtml("Header.html");
		pw.print("<br></br>");
		utility.printHtml("LeftNavigationBar.html");
		
		
		
		
		if(CategoryName.equals("soldproducts"))
		{
			pw.print("<div id='content' style='overflow-y:auto';><div class='post'><h2 class='title meta'>");
			pw.print("<a style='font-size: 24px;'>Total Number of Products Sold</a>");
			pw.print("</h2><div class='entry'><table id='bestseller'>");
			for(Map.Entry<String, Inventory> entry : soldProducts.entrySet()){
			
			Inventory Inventory = entry.getValue();
			
			
			pw.print("<table style='width:100%'>"
					+"<tr><td><h3>Product Name</h3></td><td>"+Inventory.getName()+ "</td></tr>"
					+"<tr><td><h3>Product Price</h3></td><td>"+Inventory.getPrice()+ "</td></tr>"
					+"<tr><td><h3>Number of sold Products</h3></td><td>"+Inventory.getsoldItems()+ "</td></tr>"
					+"<tr><td><h3>Total sales of product</h3></td><td>"+Inventory.gettotalSales()+ "</td></tr>"
					+ "</td></tr></table>");
			}
			pw.print("</div></div></div>");
		}
		
		if(CategoryName.equals("barchart"))	
		{
			pw.print("Bar Chart with the product names and the total sales for every product");
            pw.println("<script type='text/javascript' src='https://www.gstatic.com/charts/loader.js'></script>");
            pw.println("<script type='text/javascript'>");
            pw.println("google.charts.load('current', {packages: ['corechart', 'bar']});");
            pw.println("google.charts.setOnLoadCallback(drawBasic);");
            pw.println("function drawBasic() {");
            pw.println("var data = google.visualization.arrayToDataTable([");
            pw.println("['Product Name', 'Total Sales'],");
               
				for(Map.Entry<String, Inventory> entry : soldProducts.entrySet()){
			
				Inventory Inventory = entry.getValue();
                   String productName = Inventory.getName();
                   double sales = (Inventory.gettotalSales());
                   pw.println("[' " +productName+ " ', "+sales+ "],");
                }
            pw.println("]);");
            pw.println("var options = {");
            pw.println("title: 'product names and the total sales',");
            pw.println("chartArea: {width: '50%', height: '50%'},");
            pw.println("hAxis: {");
            pw.println("title: 'Total Sales',");
            pw.println("minValue: 0");
            pw.println("},");
            pw.println("vAxis: {");
            pw.println("title: 'Product Name'");
            pw.println("}");
            pw.println("};");
            pw.println("var chart = new google.visualization.BarChart(document.getElementById('chart_div'));");
            pw.println("chart.draw(data, options);");
            pw.println("}");
            pw.println("</script>");
			pw.println("<div id='chart_div' style='width:900px; height:500px'></div>");
		}
		
		if(CategoryName.equals("dailytransaction"))
		{
			pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
			pw.print("<a style='font-size: 24px;'>Daily Transaction</a>");
			pw.print("</h2><div class='entry'><table id='bestseller'>");
			for(Map.Entry<String, Inventory> entry : dailyTransaction.entrySet()){
			
			Inventory Inventory = entry.getValue();
			
			
			pw.print("<table style='width:100%'>"
					+"<tr><td><h3>Date </h3></td><td>"+Inventory.getdayDate()+ "</td></tr>"
					+"<tr><td><h3>Total Sales of the product</h3></td><td>"+Inventory.gettotalSales()+ "</td></tr>"
					+ "</td></tr></table>");
			}
			pw.print("</div></div></div>");
		}
		
		utility.printHtml("Footer.html");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
