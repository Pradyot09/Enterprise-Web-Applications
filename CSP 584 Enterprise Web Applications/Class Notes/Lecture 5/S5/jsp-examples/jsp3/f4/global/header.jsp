<jsp:useBean id="user" class="com.awl.jspbook.ch04.UserInfoBean"/>

<jsp:setProperty name="user" property="request"
 value="<%= request %>" />

<%-- Begin Header --%>

<H1>Welcome To Java News Today</H1>

<P>Your on-line home for up to the minute
Java news</P>

<CENTER>
  <FONT SIZE="-1">
    Welcome back,
    <jsp:getProperty name="user" property="name"/>!
  </FONT>
</CENTER>
<%-- End Header --%>
