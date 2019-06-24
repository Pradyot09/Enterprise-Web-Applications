<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
</head>
<body>
    <%-- import any packages needed by the page --%>
    <%@ page import="business.*, data.*, java.util.Date, java.io.*" %>

    <%! 
        // declare an instance variable for the page
        int globalCount = 0;  // this is not thread-safe
    %>
    <%!
        // declare a method for the page
        public void add(User user, String filename)
                throws IOException
        {
            PrintWriter out = new PrintWriter(
                    new FileWriter(filename, true));
            out.println(user.getEmailAddress()+ "|"
                    + user.getFirstName() + "|"
                    + user.getLastName());
            out.close();
        }
    %>
    <%
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");

        ServletContext sc = getServletContext();
        String path = sc.getRealPath("/WEB-INF/EmailList.txt");

        User user = new User(firstName, lastName, emailAddress);

        // use the declared method
        this.add(user, path);

        // update the instance variable
        globalCount++;  // this is not thread-safe
    %>

    <h1>Thanks for joining our email list</h1>

    <p>Here is the information that you entered:</p>

    <table cellspacing="5" cellpadding="5" border="1">
        <tr>
            <td align="right">First name:</td>
            <td><%= user.getFirstName() %></td>
        </tr>
        <tr>
            <td align="right">Last name:</td>
            <td><%= user.getLastName() %></td>
        </tr>
        <tr>
            <td align="right">Email address:</td>
            <td><%= user.getEmailAddress() %></td>
        </tr>
    </table>

    <p>To enter another email address, click on the Back <br>
    button in your browser or the Return button shown <br>
    below.</p>

    <form action="join_email_list.html" method="get">
        <input type="submit" value="Return">
    </form>

    <p>
        This email address was added to our list on <%= new Date() %><br>
        This page has been accessed <%= globalCount %> times.
    </p>

</body>
</html>