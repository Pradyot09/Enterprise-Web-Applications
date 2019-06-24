<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- 
Example of sharing beans. 
   
Taken from Core Servlets and JavaServer Pages 2nd Edition
from Prentice Hall and Sun Microsystems Press,
http://www.coreservlets.com/.
(C) 2003 Marty Hall; may be freely used or adapted.
-->
<HTML>
<HEAD>
<TITLE>Shared Access Counts: Page 2</TITLE>
<LINK REL=STYLESHEET
      HREF="JSP-Styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">
      Shared Access Counts: Page 2</TABLE>
<P>
<jsp:useBean id="counter" 
             class="mybean.AccessCountBean"
             scope="application">
  <jsp:setProperty name="counter" 
                   property="firstPage"
                   value="SharedCounts2.jsp" />
</jsp:useBean>
Of SharedCounts2.jsp (this page), 
<A HREF="SharedCounts1.jsp">SharedCounts1.jsp</A>, and
<A HREF="SharedCounts3.jsp">SharedCounts3.jsp</A>, 
<jsp:getProperty name="counter" property="firstPage" />
was the first page accessed.
<P>
Collectively, the three pages have been accessed 
<jsp:getProperty name="counter" property="accessCount" />
times. 
<jsp:setProperty name="counter" property="accessCountIncrement"
                 value="1" />        
</BODY></HTML>