<%-- 
    Document   : AddGrade
    Created on : Mar 7, 2023, 2:36:12 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="button4.css">
        <title>Add grade</title>
    </head>
    <body>
        <style>
            body{
                font-family: arial;
            }
        </style>
        <a href="adminPanel?gra=1"> back</a>
    <center>
        <h1>Add grade</h1>
        <form action="gradeController">
            <table>
                <tr>
                    <td>Subject ID:</td>
                    <td> <select name="subjectId">
                            <c:forEach items="${list}" var="s">
                                <option value="${s.getSubjectId()}">${s.getSubjectId()}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Student ID:</td> 
                    <td><input type="text" name="studentId" required></td>
                </tr>
                <tr>
                    <td>Mark:</td>
                    <td><input type="text" name="mark" required></td>
                </tr>
                <tr>
                    <td>Time submit:</td>
                    <td><input type="date" name="time" required></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input class="button-4" type="submit" name="add" value="ADD"></td>
                </tr>
            </table>
        </form>
        <p style="color: red">${result}</p>
    </center>
</body>
</html>
