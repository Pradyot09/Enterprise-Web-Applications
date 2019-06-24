<jsp:useBean id="bean1" class="mybean.Bean1"/>

<HTML>

<HEAD><TITLE>Beans!</TITLE></HEAD>

<BODY BGCOLOR="#FFFFFF">

<P>Here is some data that came from bean1:</P>

<UL>

<LI>The name of this bean is:
<jsp:getProperty name="bean1" property="name"/>

<LI>The 7th prime number is:
<jsp:getProperty name="bean1" property="seventhPrimeNumber"/>

<LI>The current time is:
<jsp:getProperty name="bean1" property="currentTime"/>

</UL>

<CENTER>

<TABLE BORDER="0">
<TR>
<TD BGCOLOR="<jsp:getProperty name="bean1" property="color"/>">

<P>The information from a bean can be used
anywhere on the page!</P>

</TD>
</TR>
</TABLE>

</BODY>
</HTML>
