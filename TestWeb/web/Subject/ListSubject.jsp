<%-- 
    Document   : ListSubject
    Created on : Mar 4, 2023, 12:14:19 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List subject</title>
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
        <a href="adminPanel?sub=1"> back</a>
    <center>

        <h1>All Subject</h1>
        <table id="alter">
            <tr>
                <td class="title">Subject ID</td>
                <td class="title">Subject Name</td>
                <td class="title">Semester</td>
            </tr>

            <c:forEach items="${listSubject}" var="s">
                <tr>
                    <td>${s.getSubjectId()}</td>
                    <td>${s.getSubjectName()}</td>
                    <td>${s.getSemester()}</td>
                </tr>
            </c:forEach>

        </table>
    </center>
    <br><br><br><br>
</body>
</html>
