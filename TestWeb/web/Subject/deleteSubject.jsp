<%-- 
    Document   : deleteSubject
    Created on : Mar 4, 2023, 12:15:56 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Subject</title>
        <link rel="stylesheet" type="text/css" href="searchButton.css">
        <link rel="stylesheet" type="text/css" href="button4.css">
    </head>
    <body>
        <style>
            .delete{
                width: 320px;
                text-align: left;
            }
            body{
                font-family: arial;
            }
            
        </style>
        <a href="adminPanel?sub=1"> back</a>
        <form action="subjectController">
            <center>
                <h1>Delete Subject</h1>
                Enter subject id: <input type="text" name="id" value="${s.getSubjectId()}"> <button type="submit" name="de" value="OK"><div class="spinner"></div>Search</button>
                <br><br>
            </center>
            <c:if test="${(requestScope.x==0)}">
                <center>

                    <h3 style="color: red;">Subject not found</h3>
                </center>
            </c:if>

            <c:if test="${(requestScope.x==1)}">
                <center>
                    <h3>Subject detail information</h3>
                    <div class="delete">
                        Subject ID: <input style="margin-left: 38px;" type="text" name="id" value="${s.getSubjectId()}" readonly> <br/><br/>
                        Subject Name: <input style="margin-left: 13px;" type="text" name="name" value="${s.getSubjectName()}" readonly> <br/><br/>
                        Semester: <input style="margin-left: 45px;" type="text" name="semester" value="${s.getSemester()}" readonly> <br/><br/>
                        <center><button class="button-4" type="submit" name="delete">Delete</button></center><br/>
                    </div>

                </center>
            </c:if>


            <center><p style="color: red">${requestScope.delete}</p></center>
        </form>

    </body>
</html>
