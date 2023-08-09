<%-- 
    Document   : AdminLogin
    Created on : Feb 27, 2023, 11:35:53 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
        <link rel="stylesheet" type="text/css" href="loginCss.css">
    </head>
    <body>
        
    <center>
        <h1>Admin login</h1>
        <form action="loginAdmin" class="login" method="post">
            <!--<form class="login">-->
                <input type="text" placeholder="Username" name="account">
                <input type="password" placeholder="Password" name="password">
                <button type="submit" value="Login">Login</button>
                <p style="color: red">${requestScope.error}</p>
            <!--</form>-->

            <!--<a href="https://codepen.io/davinci/" target="_blank">check my other pens</a>-->
        </form>
    </center>
</body>
</html>
