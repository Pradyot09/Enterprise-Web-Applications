<jsp:useBean 
  class="MyServletJSPBean.SumAvgBean"
  id="data" 
  scope="request"/>

<HTML>
<HEAD><TITLE>Error</TITLE></HEAD>
<BODY>

<P>
I was unable to complete your request, because
<jsp:getProperty name="data" property="bad"/>
is not a number.
</P>

<FORM ACTION="http://localhost/jsp-to-servlet-to-jsp/servlets.SumAvgServlet" METHOD="POST">
<INPUT TYPE="TEXT" NAME="values"
  VALUE="<jsp:getProperty name="data" property="values"/>">
<INPUT TYPE="SUBMIT">
</FORM>

</BODY>
</HTML>

