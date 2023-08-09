<%-- 
    Document   : updateDetail
    Created on : Mar 18, 2023, 2:12:32 PM
    Author     : TLC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="button4.css">

    </head>
    <body>
        <style>
            body{
                font-family: arial;
            }
            .grade{
                margin-left: 20px;
            }
            .answer{
                margin-left: 30px;
            }
        </style>
        <a href="adminPanel?gra=1"> back</a>
        <h1>Grade detail</h1>
        <form action="gradeSubject" method="post">

            <table>
                <tr>
                    <td>Student ID:</td>
                    <td><input value="${g.getStudentId()}" type="text" name="studentID" readonly></td>
                </tr>
                <tr>
                    <td>Subject ID:</td>
                    <td><input value="${g.getSubjectId()}" type="text" name="subjectId" readonly></td>
                </tr>
                <tr>
                    <td>Mark:</td>
                    <td><input type="text" name="mark" value="${g.getMark()}" required=""></td>
                </tr>
                <tr>
                    <td>Date submit:</td>
                    <td><input type="date" value="${g.getDateSubmit()}" name="time" required></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button class="button-4" type="submit" name="update">Update</button></td>
                </tr>
            </table> 

        </form>
    </body>
</html>
