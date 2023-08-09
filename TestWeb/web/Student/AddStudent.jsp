<%-- 
    Document   : AddStudent
    Created on : Feb 28, 2023, 1:43:30 PM
    Author     : TLC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student</title>
        <link rel="stylesheet" type="text/css" href="button4.css">
    </head>
    <body>
        <style>
            .add{
                text-align: left;
                width: 350px;
            }
            body{
                font-family: arial;
            }
            


        </style>
        <a href="adminPanel?stu=1"> back</a>
        <form action="studentController">
            <center>
                <div class="add">
                    <h1>Add student</h1>
                    ID: <input style="margin-left: 88px;" type="text" name="id" required> <br/><br/>
                    Account: <input style="margin-left: 46px;" type="text" name="account" required> <br/><br/>
                    Password: <input style="margin-left: 34px;" type="text" name="password" required> <br/><br/>
                    Full name: <input style="margin-left: 35px;" type="text" name="name" required> <br/><br/>
                    Phone number: <input  type="text" name="phone" required> <br/><br/>
                    <button class="button-4" type="submit" name="add">Save</button><br/>
                </div>
                <h3 style="color: red">${requestScope.result}</h3>
            </center>
        </form>


    </body>
</html>
