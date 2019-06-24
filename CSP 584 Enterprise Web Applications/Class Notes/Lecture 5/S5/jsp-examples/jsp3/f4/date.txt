<jsp:useBean id="date" class="com.awl.jspbook.ch04.DateBean"/>

<HTML>

<HEAD><TITLE>The Date Bean</TITLE></HEAD>

<BODY BGCOLOR="#FFFFFF">

<P>Here is the current date, in a few different formats</P>

<UL>

<jsp:setProperty name="date" property="format"
 value="EEEE, MMMM dd yyyy 'at' hh:mm"/>

<LI><jsp:getProperty name="date" property="currentTime"/>


<jsp:setProperty name="date" property="format"
 value="hh:mm:ss MM/dd/yy"/>

<LI><jsp:getProperty name="date" property="currentTime"/>


<jsp:setProperty name="date" property="format"
 value="yyyyy.MMMMM.dd GGG hh:mm aaa"/>

<LI><jsp:getProperty name="date" property="currentTime"/>

</UL>

</BODY>
</HTML>
