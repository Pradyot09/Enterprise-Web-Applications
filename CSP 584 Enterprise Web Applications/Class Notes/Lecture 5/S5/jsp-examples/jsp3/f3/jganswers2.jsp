<HTML>

<BODY BGCOLOR="#FFFFFF">

<P>
You answered 
"<%= request.getParameter("met") %>"
when asked if you've met Mr. Gosling.
</P>


<P>
Given the chance, you would ask the following question:
<%= request.getParameter("question") %>
</P>


<P>
You heard him speak at a conference called
<%= request.getParameter("conferences") %>
</P>

</BODY>
</HTML>



