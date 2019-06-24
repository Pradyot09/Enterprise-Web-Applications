<jsp:useBean id="rev" class="com.awl.jspbook.ch04.Reverser"/>

<HTML>

<HEAD><TITLE>Mirror image</TITLE></HEAD>

<BODY BGCOLOR="#FFFFFF">

<P>Here is the name of your computer,
and its mirror image</P>

<TABLE BORDER="0">

  <TR>
    <TH>Name</TH><TH>Mirror Image</TH>
  </TR>

  <TR>
    <TD><%= request.getRemoteHost() %></TD>

    <TD>
      <jsp:setProperty name="rev" property="hostName"
       value="<%= request.getRemoteHost() %>"/>

      <jsp:getProperty name="rev" property="reversedHostName"/>
    </TD>
  </TR>
</TABLE>
</BODY>
</HTML>
