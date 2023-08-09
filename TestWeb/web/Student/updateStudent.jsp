<%-- 
    Document   : updateStudent
    Created on : Mar 2, 2023, 6:40:49 PM
    Author     : TLC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update student</title>
        <link rel="stylesheet" type="text/css" href="searchButton.css">
        <link rel="stylesheet" type="text/css" href="button4.css">
    </head>
    <body>
        <style>
            .update{
                width: 320px;
                text-align: left;
            }
            body{
                font-family: arial;
            }
            
            
        </style>
        <a href="adminPanel?stu=1"> back</a>
        <form action="studentController">
            <center>
                <h1>Update student</h1>
                Enter student id: <input type="text" name="id" value="${s.getId()}"> <button type="submit" name="up" value="OK"><div class="spinner"></div>Search</button>
                <br><br>
            </center>
            <c:choose>
                <c:when test="${requestScope.result==0}">
                    <center>

                        <h3 style="color: red;">Student not found</h3>
                    </center>
                </c:when>
                <c:when test="${requestScope.result==1}">
                    <center>
                        <div class="update">
                            Account: <input style="margin-left: 49px;" type="text" name="account" value="${s.getAccount()}" readonly> <br/><br/>
                            Password: <input style="margin-left: 37px;" type="text" name="password" value="${s.getPassword()}"> <br/><br/>
                            Full name: <input style="margin-left: 38px;" type="text" name="name" value="${s.getName()}"> <br/><br/>
                            Phone number: <input style="margin-left: 4px;" type="text" name="phone" value="${s.getPhone()}"> <br/><br/>
                            <center><button class="button-4" type="submit" name="update">Update</button></center><br/>
                        </div>
                    </center>
                </c:when>

            </c:choose>
        </form>
    <center><p style="color: red">${requestScope.update}</p></center>

</body>
</html>
