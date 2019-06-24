<HTML>
<HEAD><TITLE>Java News Today: Quiz Result</TITLE>

<BODY BGCOLOR="#FFFFFF">

<TABLE BORDER="0" WIDTH="100%">

  <TR>
    <TD BGCOLOR="#0000FF" ALIGN="CENTER" COLSPAN="2">
      <%@include file="global/header.jsp"%>
    </TD>
  </TR>

  <TR>
    <TD ALIGN="LEFT" WIDTH="20%" BGCOLOR="#000077">
      <%@include file="global/navigation.jsp"%>
    </TD>

    <TD VALIGN="TOP">
      <P>
      The question was: What is the Apache/JSP project called?
      </P>

      <P>
      You responded "<%= request.getParameter("guess") %>"
      </P>
    </TD>
  </TR>

</TABLE>
</BODY>
</HTML>