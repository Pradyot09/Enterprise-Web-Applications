<HTML>

<HEAD><TITLE>A simple calculator: results</TITLE></HEAD>

<BODY>

<P>
The sum of your two numbers is 
<%= Integer.parseInt(request.getParameter("value1")) +
    Integer.parseInt(request.getParameter("value2")) %>
</P>

</BODY>
</HTML>
