<jsp:useBean id="jg" class="com.awl.jspbook.ch04.SurveyBean"/>

<jsp:setProperty name="jg" property="*"/>

<HTML>

<BODY BGCOLOR="#FFFFFF">

<P>
You answered 
"<jsp:getProperty name="jg" property="met"/>"
when asked if you've met Mr. Gosling.
</P>


<P>
Given the chance, you would ask the following question:
<jsp:getProperty name="jg" property="question"/>
</P>

<% String confs[] = jg.getConferences(); %>

<% if (confs.length == 0) { %>
  <P>You have never heard him speak at a conference.</P>
<% } else { %>
  <P>You have heard him speak at the following conferences.</P>

  <UL>

  <% for(int i=0;i<confs.length;i++) { %>
    <LI><%= confs[i] %>
  <% } %>

  </UL>

<% } %>

</BODY>
</HTML>



