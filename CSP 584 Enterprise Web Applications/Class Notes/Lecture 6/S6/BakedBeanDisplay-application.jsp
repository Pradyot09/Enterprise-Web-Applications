<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Baked Bean Values: application-based Sharing</TITLE>
<LINK REL=STYLESHEET
      HREF="JSP-Styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<H1>Baked Bean Values: application-based Sharing</H1>
<jsp:useBean id="applicationBean" class="SharedBeans.BakedBean"
             scope="application" />
<jsp:setProperty name="applicationBean" property="*" />
<H2>Bean level: 
<jsp:getProperty name="applicationBean" property="level" /></H2>
<H2>Dish bean goes with:
<jsp:getProperty name="applicationBean" property="goesWith" /></H2>
</BODY></HTML>