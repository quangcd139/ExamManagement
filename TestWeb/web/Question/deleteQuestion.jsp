<%-- 
    Document   : deleteQuestion
    Created on : Mar 5, 2023, 8:39:27 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete question</title>
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
        <a href="adminPanel?que=1"> back</a>
        <form action="questionController">
            <center>
                <h1>Delete question</h1>
                Enter subject id: <input type="text" name="subjectId" value="${q.getSubjectId()}"> <button type="submit" name="de" value="OK"><div class="spinner"></div>Search</button>
                <br><br><br>
            </center>
            <c:choose>
                <c:when test="${requestScope.result==0}">
                    <center>
                        <h3 style="color: red;">Question not found</h3>
                    </center>
                </c:when>
                <c:when test="${requestScope.result==1}">
                    <center>
                        <table id="alter">
                            <tr>
                                <td class="title">Question ID</td>
                                <td class="title">Subject ID</td>
                                <td class="title">Question</td>
                                <td class="title">Answer</td>
                            </tr>
                            <c:forEach items="${list}" var="q">
                                <tr>
                                    <td>${q.getQuestionId()}</td>
                                    <td>${q.getSubjectId()}</td>
                                    <td>${q.getQuestion()}</td>
                                    <td>${q.getAnswer()}</td>
                                    <td><a href="questionSubject?queId=${q.getQuestionId()}&subId=${q.getSubjectId()}&de=1">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </center>
                </c:when>
            </c:choose>
        </form>
    <center><p style="color: red">${requestScope.delete}</p></center>
</body>
</html>
