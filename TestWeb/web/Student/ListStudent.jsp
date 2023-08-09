<%-- 
    Document   : ListStudent
    Created on : Feb 27, 2023, 2:21:34 PM
    Author     : TLC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List student</title>
    </head>
    <body>
        <a href="adminPanel?stu=1"> back</a>
        <style>

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
    <center>

        <h1>All Student</h1>
        <table id="alter">
            <tr>
                <td class="title">ID</td>
                <td class="title">Account</td>
                <td class="title">Password</td>
                <td class="title">Name</td>
                <td class="title">Email</td>
                <td class="title">Phone</td>
            </tr>

            <c:forEach items="${listStudent}" var="s">
                <tr>
                    <td>${s.account}</td>
                    <td>${s.id}</td>
                    <td>${s.password}</td>
                    <td>${s.name}</td>
                    <td>${s.email}</td>
                    <td>${s.phone}</td>
                </tr>
            </c:forEach>

        </table>
    </center>
<br><br><br><br>
</body>
</html>
