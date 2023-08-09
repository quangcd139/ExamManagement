<%-- 
    Document   : updateGrade
    Created on : Mar 7, 2023, 2:36:37 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update grade</title>
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

            .title{
                font-weight: bold;
            }
            th {
                border: 1px solid black;
                border-collapse: collapse;
            }

            th, td {
                padding: 10px;
            }
            table#alter tr:nth-child(even) {
                background-color: rgb(230,230,230);
            }
            table#alter tr:nth-child(odd) {
                background-color: rgb(217,217,217);
            }
            table#alter th {
                color: white;
                background-color: rgb(53,44,46);
            }


        </style>
        <a href="adminPanel?gra=1"> back</a>
        <form action="gradeController">
            <center>
                <h1>Update grade</h1>
                Enter subject id: <input type="text" name="subjectId" value="${q.getSubjectId()}"> <button type="submit" name="up1" value="OK"><div class="spinner"></div>Search</button><br><br>
                Enter student id: <input type="text" name="studentId" value="${q.getStudentId()}"> <button type="submit" name="up2" value="OK"><div class="spinner"></div>Search</button>
                <br><br><br>
            </center>
            <c:choose>
                <c:when test="${requestScope.result==0}">
                    <center>
                        <h3 style="color: red;">Grade not found</h3>
                    </center>
                </c:when>
                <c:when test="${requestScope.result==1}">
                    <center>
                        <table id="alter">
                            <tr>
                                <td class="title">Student ID</td>
                                <td class="title">Subject ID</td>
                                <td class="title">Student name</td>
                                <td class="title">Mark</td>
                                <td class="title">Time submit</td>
                            </tr>

                            <c:forEach items="${list}" var="q">
                                <tr>
                                    <td>${q.getStudentId()}</td>
                                    <td>${q.getSubjectId()}</td>
                                    <td>${q.getStudentName()}</td>
                                    <td>${q.getMark()}</td>
                                    <td>${q.getDateSubmit()}</td>
                                    <td>
                                        <a href="gradeSubject?stuId=${q.getStudentId()}&subId=${q.getSubjectId()}&mod=1">Update</a>
                                    </td>
                                    
                                </tr>
                            </c:forEach>

                        </table>

                    </center>
                </c:when>
            </c:choose>
        </form>
    <center><p style="color: red">${requestScope.update}</p></center>
</body>
</html>
