<%-- 
    Document   : ListGrade
    Created on : Mar 7, 2023, 2:36:02 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List grade</title>
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
        <a href="adminPanel?gra=1"> back</a>
    <center>

        <h1>All Grade</h1>
        <!--        <form action="search">
                    <table>
                        <tr>
                            <td><input type="submit" name="studentId" value="List all student grade by student ID"></td>
                            
                        </tr>
                        <tr>
                            <td><input type="submit" name="subjectId" value="List all student grade by subject ID"></td>
                        </tr>
                    </table>
                </form>-->
        <table id="alter">
            <tr>
                <td class="title">Subject ID</td>
                <td class="title">Student ID</td>
                <td class="title">Student name</td>
                <td class="title">Time</td>
                <td class="title">Mark</td>
            </tr>

            <c:forEach items="${listGrade}" var="g">
                <tr>
                    <td>${g.getSubjectId()}</td>
                    <td>${g.getStudentId()}</td>
                    <td>${g.getStudentName()}</td>
                    <td>${g.getDateSubmit()}</td>
                    <td>${g.getMark()}</td>
                    
                </tr>
            </c:forEach>

        </table>
    </center>
    <a href="excel">Xuat sang file excel</a>
    <p style="color: red">${err}</p>
    <br><br><br><br>
</body>
</html>
