<HTML>

<HEAD><TITLE>A simple calculator: results</TITLE></HEAD>

<BODY>

<P>
The sum of your two numbers is 
<%= request.getParameter("value1") +
    request.getParameter("value2") %>
</P>

</BODY>
</HTML>
