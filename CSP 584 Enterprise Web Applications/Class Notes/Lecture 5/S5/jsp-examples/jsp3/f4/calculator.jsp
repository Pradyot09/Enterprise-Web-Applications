<jsp:useBean id="calc" class="calculatorBean.CalcBean"/>

<jsp:setProperty name="calc" property="*"/>

<HTML>
<HEAD><TITLE>A simple calculator: results</TITLE></HEAD>
<BODY>

<P>
The sum of your two numbers is 
<jsp:getProperty name="calc" property="sum"/>
</P>

</BODY>
</HTML>
