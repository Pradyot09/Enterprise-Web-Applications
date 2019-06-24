import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WearableTechList")

public class WearableTechList extends HttpServlet {

	/* Wearable Techs Page Displays all the Wearable Techs and their Information in Smart Poratables */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = null;
		String ProductName = request.getParameter("maker");
        

		/* Checks the Tablets type whether it is microsft or sony or nintendo */

		HashMap<String, WearableTech> hm = new HashMap<String, WearableTech>();
		if(ProductName==null){
			hm.putAll(SaxParserDataStore.wearabletechs);
			name = "";
		}
		else
		{
		   if(ProductName.equals("dell"))
		   {
			 for(Map.Entry<String,WearableTech> entry : SaxParserDataStore.wearabletechs.entrySet())
			 {
				if(entry.getValue().getRetailer().equals("Dell"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
			 }
				name = "Dell";
		   }
		   else if(ProductName.equals("xiomi"))
		    {
			for(Map.Entry<String,WearableTech> entry : SaxParserDataStore.wearabletechs.entrySet())
				{
				 if(entry.getValue().getRetailer().equals("Xiomi"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
				 name = "Xiomi";
			}
			else if(ProductName.equals("sony"))
			{
				for(Map.Entry<String,WearableTech> entry : SaxParserDataStore.wearabletechs.entrySet())
				{
				 if(entry.getValue().getRetailer().equals("Sony"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			   	 name = "Sony";
			}
			else if(ProductName.equals("samsung"))
			{
				for(Map.Entry<String,WearableTech> entry : SaxParserDataStore.wearabletechs.entrySet())
				{
				 if(entry.getValue().getRetailer().equals("Samsung"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			   	 name = "Samsung";
			}
			else if(ProductName.equals("microsoft"))
			{
				for(Map.Entry<String,WearableTech> entry : SaxParserDataStore.wearabletechs.entrySet())
				{
				 if(entry.getValue().getRetailer().equals("Microsoft"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			   	 name = "Microsoft";
			}
		}
	
		/* Header, Left Navigation Bar are Printed.

		All the WearableTech and WearableTech information are dispalyed in the Content Section

		and then Footer is Printed*/

		Utilities utility = new Utilities(request,pw);
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>"+name+" WearableTechs</a>");
		pw.print("</h2><div class='entry'><table id='bestseller'>");
		int i = 1; int size= hm.size();
		for(Map.Entry<String, WearableTech> entry : hm.entrySet())
		{
			WearableTech WearableTech = entry.getValue();
			if(i%3==1) pw.print("<tr>");
			pw.print("<td><div id='shop_item'>");
			pw.print("<h3>"+WearableTech.getName()+"</h3>");
			pw.print("<strong>$" +WearableTech.getPrice()+"</strong><ul>");
			pw.print("<li id='item'><img src='images/wearabletechs/"+WearableTech.getImage()+"' alt='' style='width:150px;height:150px;'/></li>");
			
			pw.print("<ul><li><form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='wearabletechs'>"+
					"<input type='hidden' name='maker' value='"+name+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='submit' class='btnbuy' value='Buy Now'></form></li></ul>");
			pw.print("<ul><li><form method='post' action='WriteReview'>"+
					"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='wearabletechs'>"+
					"<input type='hidden' name='maker' value='"+name+"'>"+
					"<input type='hidden' name='price' value='"+WearableTech.getPrice()+"'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='WriteReview' class='btnreview'></form></li></ul>");
			pw.print("<ul><li><form method='post' action='ViewReview'>"+"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='wearabletechs'>"+
					"<input type='hidden' name='maker' value='"+name+"'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='ViewReview' class='btnreview'></form></li></ul>");
			pw.print("</ul></div></td>");
			if(i%3==0 || i == size) pw.print("</tr>");
			i++;
		}	
		pw.print("</table></div></div></div>");
   
		utility.printHtml("Footer.html");
		
	}
}
