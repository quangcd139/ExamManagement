<%-- 
    Document   : ListQuestion
    Created on : Mar 5, 2023, 8:38:48 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List question</title>
    </head>
    <body>

        <style>
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
    <center>

        <h1>All Question</h1>
        <c:set value="${1}" var="count">
        </c:set>
        <%int count=0;%>
        <table id="alter" style="margin: 40px;">
            <tr>
                <td class="title"><a style="text-decoration: none; color: black;" href="questionSubject?order=1">Question ID</a></td>
                <td class="title">Subject ID</td>
                <td class="title">Question</td>
                <td class="title">Answer</td>
            </tr>

            <c:forEach items="${listQuestion}" var="q">
                <tr>
                    <td><a href="questionSubject?queId=${q.getQuestionId()}&subId=${q.getSubjectId()}&up=1">
                            ${q.getQuestionId()}</a>
                    </td>

                    <td>${q.getSubjectId()}</td>
                    <td>${q.getQuestion()}</td>
                    <td>${q.getAnswer()}</td>
                </tr>
            </c:forEach>

        </table>
    </center>
    <br><br><br><br>
</body>
</html>
