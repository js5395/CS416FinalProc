<%-- 
    Document   : Logout
    Created on : Dec 1, 2015, 9:27:43 AM
    Author     : Steve
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      
        <%
              String redirectPage = "LogoutServlet";
              response.sendRedirect(redirectPage);
        %>
    </body>
</html>
