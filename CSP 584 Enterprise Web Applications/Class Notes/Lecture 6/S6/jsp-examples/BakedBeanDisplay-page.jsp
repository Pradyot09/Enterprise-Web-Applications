<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Baked Bean Values: page-based Sharing</TITLE>
<LINK REL=STYLESHEET
      HREF="JSP-Styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<H1>Baked Bean Values: page-based Sharing</H1>
<jsp:useBean id="pageBean" class="SharedBeans.BakedBean" />
<jsp:setProperty name="pageBean" property="*" />
<H2>Bean level: 
<jsp:getProperty name="pageBean" property="level" /></H2>
<H2>Dish bean goes with:
<jsp:getProperty name="pageBean" property="goesWith" /></H2>
</BODY></HTML>