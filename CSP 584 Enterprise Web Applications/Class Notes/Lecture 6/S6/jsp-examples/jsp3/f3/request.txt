<HTML>
<HEAD><TITLE>Request fields</TITLE></HEAD>

<BODY BGCOLOR="#FFFFFF">

<TABLE BORDER="1">

<TR>
  <TD>You are using this authorization type:</TD>
  <TD><%= request.getAuthType() %></TD>
</TR>

<TR>
  <TD>You are using this request method:</TD>
  <TD><%= request.getMethod() %></TD>
</TR>

<TR>
  <TD>Characters are encoded using this scheme:</TD>
  <TD><%= request.getCharacterEncoding() %></TD>
</TR>

<TR>
  <TD>The protocol used for this request was:</TD>
  <TD><%= request.getProtocol() %></TD>
</TR>

<TR>
  <TD>The scheme used for this request was:</TD>
  <TD><%= request.getScheme() %></TD>
</TR>

<TR>
  <TD>The server's name is:</TD>
  <TD><%= request.getServerName() %></TD>
</TR>

<TR>
  <TD>The server is running on port:</TD>
  <TD><%= request.getServerPort() %></TD>
</TR>

<TR>
  <TD>Your computer's address is:</TD>
  <TD><%= request.getRemoteAddr() %></TD>
</TR>

<TR>
  <TD>Your computer's name is:</TD>
  <TD><%= request.getRemoteHost() %></TD>
</TR>

<TR>
  <TD>The path info portion of the URL is:</TD>
  <TD><%= request.getPathInfo() %></TD>
</TR>

<TR>
  <TD>The translated path is:</TD>
  <TD><%= request.getPathTranslated() %></TD>
</TR>

<TR>
  <TD>The QUERY_STRING portion of the URL is:</TD>
  <TD><%= request.getQueryString() %></TD>
</TR>

<TR>
  <TD>You have signed into this server using the name:</TD>
  <TD><%= request.getRemoteUser() %></TD>
</TR>

<TR>
  <TD>The full request URI is:</TD>
  <TD><%= request.getRequestURI() %></TD>
</TR>


<TR>
  <TD>You are using a browser called:</TD>
  <TD><%= request.getHeader("User-Agent") %></TD>
</TR>


<TR>
  <TD>Your browser accepts the following types of files:</TD>
  <TD><%= request.getHeader("Accept") %></TD>
</TR>


</TABLE>

</BODY>
</HTML>
