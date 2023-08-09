<%-- 
    Document   : updateSubject
    Created on : Mar 4, 2023, 12:15:39 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update subject</title>
        <link rel="stylesheet" type="text/css" href="searchButton.css">
        <link rel="stylesheet" type="text/css" href="button4.css">
    </head>
    <body>
        <style>
            .update{
                width: 360px;
                text-align: left;
            }
            body{
                font-family: arial;
            }


        </style>
        <a href="adminPanel?sub=1"> back</a>
        <form action="subjectController">
            <center>
                <h1>Update subject</h1>
                Enter subject id: <input type="text" name="id" value="${s.getSubjectId()}"> <button type="submit" name="up" value="OK"><div class="spinner"></div>Search</button>
                <br><br><br>
            </center>
                <c:choose>
                <c:when test="${requestScope.result==0}">
                    <center>

                        <h3 style="color: red;">Subject not found</h3>
                    </center>
                </c:when>
                <c:when test="${requestScope.result==1}">
                    <center>
                        <div class="update">
                            Subject ID: <input style="margin-left: 38px;" type="text" name="id" value="${s.getSubjectId()}" readonly> <br/><br/>
                            Subject Name: <input style="margin-left: 13px;" type="text" name="name" value="${s.getSubjectName()}"> <br/><br/>
                            Semester: <input style="margin-left: 45px;" type="text" name="semester" value="${s.getSemester()}"> <br/><br/>
                            <center><button class="button-4" type="submit" name="update">Update</button></center><br/>
                        </div>
                    </center>
                </c:when>

            </c:choose>
        </form>
    <center><p style="color: red">${requestScope.update}</p></center>
</body>
</html>
