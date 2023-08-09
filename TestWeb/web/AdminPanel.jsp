<%-- 
    Document   : AdminPanel
    Created on : Feb 27, 2023, 11:44:42 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="button4.css">
    </head>
    <body>
        <style>
            body{
                font-family: arial;
                background-image:url("image/back1.jpg");
            }
            .button-4{
                height: 70px;
                width: 300px;
            }
            h1{
                color: white;
            }
            
        </style>
    <Center>
        <h1>Welcome Admin</h1>

        <form action="adminPanel" method="post">
            <input class="button-4" type="submit" name="check" value="Interact with students">
            <input class="button-4" type="submit" name="check" value="Interact with grades">
            <br><br>
            <input class="button-4" type="submit" name="check" value="Interact with subjects">
            <input class="button-4" type="submit" name="check" value="Interact with questions">
            <br><br>
        </form>

    </Center>


</body>
</html>
