<%-- 
    Document   : Login
    Created on : Nov 18, 2015, 11:42:16 AM
    Author     : Steve
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <a href="index.xhtml">Back to home</a><br/>
        <h2>Login</h2>
        <form action="j_security_check" method="POST">
            Username<input type="text" name="j_username"/><br/>
            Password<input type="password" name="j_password"/><br/>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
