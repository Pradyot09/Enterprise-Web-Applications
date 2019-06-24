<jsp:useBean 
  class="MyServletJSPBean.SumAvgBean"
  id="data" 
  scope="request"/>

<HTML>
<HEAD><TITLE>Results</TITLE></HEAD>
<BODY>

<P>
The sum of your numbers is 
<jsp:getProperty name="data" property="sum"/>.
</P>

<P>
The avergage of your numbers is
<jsp:getProperty name="data" property="avg"/>.
</P>

</BODY>
</HTML>

