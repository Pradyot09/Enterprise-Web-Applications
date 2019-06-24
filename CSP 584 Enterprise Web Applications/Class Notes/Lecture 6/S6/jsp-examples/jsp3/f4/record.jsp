<jsp:useBean id="album" beanName="tinderbox"
 type="com.awl.jspbook.ch04.AlbumInfo"/>

<HTML>
<BODY
  BGCOLOR="<jsp:getProperty name="album" property="bgColor"/>"
  TEXT="<jsp:getProperty name="album" property="textColor"/>">

<H1><jsp:getProperty name="album" property="name"/></H1>

<P>Artist: <jsp:getProperty name="album" property="artist"/></P>
<P>Year: <jsp:getProperty name="album" property="year"/></P>

</UL>

</BODY>
</HTML>

