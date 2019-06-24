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

@WebServlet("/InventoryReport")

public class InventoryReport extends HttpServlet {

	HashMap<String, Inventory> allProducts=new HashMap<String, Inventory>();
	HashMap<String, Inventory> onRebateProducts=new HashMap<String, Inventory>();
	HashMap<String, Inventory> onSaleProducts=new HashMap<String, Inventory>();
    // HashMap<String, Inventory> allProducts=new HashMap<String, Inventory>();
	// HashMap<String, Inventory> allProducts=new HashMap<String, Inventory>();
	// HashMap<String, Inventory> allProducts=new HashMap<String, Inventory>();

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		
		
		allProducts =MySqlDataStoreUtilities.getAllProducts();		
		
		onRebateProducts=MySqlDataStoreUtilities.getOnRebateProducts();		
		
		onSaleProducts=MySqlDataStoreUtilities.getOnSaleProducts();		

		String name = "InventoryReport";
		String CategoryName = request.getParameter("inventoryreport");
		
		Utilities utility = new Utilities(request, pw);
		utility.printHtml("Header.html");
		pw.print("<br></br>");
		utility.printHtml("LeftNavigationBar.html");
		
		
		
		
		if(CategoryName.equals("allproducts"))
		{
			pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
			pw.print("<a style='font-size: 24px;'>Inventory</a>");
			pw.print("</h2><div class='entry'><table id='bestseller'>");
			for(Map.Entry<String, Inventory> entry : allProducts.entrySet()){
			
			Inventory Inventory = entry.getValue();
			
			
			pw.print("<table style='width:100%'>"
					+"<tr><td><h3>Product Name</h3></td><td>"+Inventory.getName()+ "</td></tr>"
					+"<tr><td><h3>Product Price</h3></td><td>"+Inventory.getPrice()+ "</td></tr>"
					+"<tr><td><h3>No of Products Available</h3></td><td>"+Inventory.getproductQuantity()+"</td></tr>"
					+ "</td></tr></table>");
			}
			pw.print("</div></div></div>");
		}
		
		if(CategoryName.equals("productsonrebate"))
		{
			pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
			pw.print("<a style='font-size: 24px;'>Products On Rebate</a>");
			pw.print("</h2><div class='entry'><table id='bestseller'>");
			
			for(Map.Entry<String, Inventory> entry : onRebateProducts.entrySet()){
			
			Inventory Inventory = entry.getValue();
			
			
			pw.print("<table style='width:100%'>"
					+"<tr><td><h3>Product Name</h3></td><td>"+Inventory.getName()+ "</td></tr>"
					+"<tr><td><h3>Product Price</h3></td><td>"+Inventory.getPrice()+ "</td></tr>"
					+ "</td></tr></table>");
			}
			pw.print("</div></div></div>");
		}
		
		if(CategoryName.equals("productsonsale"))
		{
			pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
			pw.print("<a style='font-size: 24px;'>Products On Sale</a>");
			pw.print("</h2><div class='entry'><table id='bestseller'>");
			for(Map.Entry<String, Inventory> entry : onSaleProducts.entrySet()){
			
			Inventory Inventory = entry.getValue();
			
			
			pw.print("<table style='width:100%'>"
					+"<tr><td><h3>Product Name</h3></td><td>"+Inventory.getName()+ "</td></tr>"
					+"<tr><td><h3>Product Price</h3></td><td>"+Inventory.getPrice()+ "</td></tr>"
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
               
				for(Map.Entry<String, Inventory> entry : allProducts.entrySet()){
					
				Inventory Inventory = entry.getValue();
                   
				   String productName = Inventory.getName();
                   int quantity = Inventory.getproductQuantity();
                   pw.println("[' " +productName+ " ', "+quantity+ "],");
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
		
		utility.printHtml("Footer.html");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
