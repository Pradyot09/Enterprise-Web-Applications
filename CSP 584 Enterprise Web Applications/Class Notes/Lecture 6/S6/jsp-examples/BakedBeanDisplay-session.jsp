<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Baked Bean Values: session-based Sharing</TITLE>
<LINK REL=STYLESHEET
      HREF="JSP-Styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<H1>Baked Bean Values: session-based Sharing</H1>
<jsp:useBean id="sessionBean" class="SharedBeans.BakedBean"
             scope="session" />
<jsp:setProperty name="sessionBean" property="*" />
<H2>Bean level: 
<jsp:getProperty name="sessionBean" property="level" /></H2>
<H2>Dish bean goes with:
<jsp:getProperty name="sessionBean" property="goesWith" /></H2>
</BODY></HTML>