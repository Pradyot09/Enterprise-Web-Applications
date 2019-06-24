import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VoiceAssistantList")

public class VoiceAssistantList extends HttpServlet {

	/* VoiceAssistant Page Displays all the VoiceAssistants and their Information in Game Speed */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		/* Checks the VoiceAssistant maker whether it is microsft or sony or nintendo 
		   Add the respective product value to hashmap  */

		String name = null;
		String ProductName = request.getParameter("maker");
		
		HashMap<String, VoiceAssistant> hm = new HashMap<String, VoiceAssistant>();
		if(ProductName==null)
		{
			hm.putAll(SaxParserDataStore.voiceassistants);
			name = "";
		}
		else
		{
			if(ProductName.equals("amazon"))
			{
				for(Map.Entry<String,VoiceAssistant> entry : SaxParserDataStore.voiceassistants.entrySet())
				{	
					if(entry.getValue().getRetailer().equals("Amazon"))
					{
					 hm.put(entry.getValue().getId(),entry.getValue());
					}
				}
				name = "Amazon";
				
			}
			else if(ProductName.equals("google"))
			{	
				for(Map.Entry<String,VoiceAssistant> entry : SaxParserDataStore.voiceassistants.entrySet())
				{	
				  if(entry.getValue().getRetailer().equals("Google"))
				 { 
					hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
				name = "Google";
			}
			else if(ProductName.equals("samsung"))
			{	
				for(Map.Entry<String,VoiceAssistant> entry : SaxParserDataStore.voiceassistants.entrySet())
				{	
				  if(entry.getValue().getRetailer().equals("Samsung"))
				 { 
					hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
				name = "Samsung";
			}
			else if(ProductName.equals("motorolla"))
			{	
				for(Map.Entry<String,VoiceAssistant> entry : SaxParserDataStore.voiceassistants.entrySet())
				{	
				  if(entry.getValue().getRetailer().equals("Motorolla"))
				 { 
					hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
				name = "Motorolla";
			}
			else if(ProductName.equals("nexus"))
			{	
				for(Map.Entry<String,VoiceAssistant> entry : SaxParserDataStore.voiceassistants.entrySet())
				{	
				  if(entry.getValue().getRetailer().equals("Nexus"))
				 { 
					hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
				name = "Nexus";
			}
		}
		Utilities utility = new Utilities(request,pw);
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>"+ name+" VoiceAssistants</a>");
		pw.print("</h2><div class='entry'><table id='bestseller'>");
		int i = 1;
		int size = hm.size();
		for (Map.Entry<String, VoiceAssistant> entry : hm.entrySet()) {
			VoiceAssistant voiceassistant = entry.getValue();
			if (i % 3 == 1)
				pw.print("<tr>");
			pw.print("<td><div id='shop_item'>");
			pw.print("<h3>" + voiceassistant.getName() + "</h3>");
			pw.print("<strong>$" + voiceassistant.getPrice() + "</strong><ul>");
			pw.print("<li id='item'><img src='images/voiceassistants/"+ voiceassistant.getImage() + "' alt='' style='width:150px;height:150px;' /></li>");
			pw.print("<ul><li><form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='voiceassistants'>"+
					"<input type='hidden' name='maker' value='"+name+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='submit' class='btnbuy' value='Buy Now'></form></li></ul>");
			pw.print("<ul><li><form method='post' action='WriteReview'>"+"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='voiceassistants'>"+
					"<input type='hidden' name='maker' value='"+name+"'>"+
					"<input type='hidden' name='price' value='"+voiceassistant.getPrice()+"'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='WriteReview' class='btnreview'></form></li></ul>");
			pw.print("<ul><li><form method='post' action='ViewReview'>"+"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='voiceassistants'>"+
					"<input type='hidden' name='maker' value='"+name+"'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='ViewReview' class='btnreview'></form></li></ul>");
			pw.print("</ul></div></td>");
			if (i % 3 == 0 || i == size)
				pw.print("</tr>");
			i++;
		}
		pw.print("</table></div></div></div>");
		utility.printHtml("Footer.html");
	}
}
