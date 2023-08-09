<%-- 
    Document   : AddQuestion
    Created on : Mar 5, 2023, 8:39:03 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add question</title>
        <link rel="stylesheet" type="text/css" href="button4.css">
    </head>
    <body>
        <style>
            .add{
                text-align: left;
                width: 350px;
            }
            body{
                font-family: arial;
            }

        </style>
        <a href="adminPanel?que=1"> back</a>
        <form action="questionController">
            <center>
                <div class="add">
                    <h1>Add question</h1>
                    <table>
                        <tr>
                            <td>Question ID:</td>
                            <td> <input  type="text" name="questionId" required=""></td>
                        </tr>

                        <tr>
                            <td>Subject ID:</td>
                            <td>
                                <select name="subjectId">
                                    <c:forEach items="${list}" var="s">
                                        <option value="${s.getSubjectId()}">${s.getSubjectId()}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td>Question:</td>
                            <td><textarea  name="question" rows="4" cols="20" required></textarea></td>
                        </tr>

                        <tr>
                            <td>Answer:</td>
                            <td><input  type="text" name="answer" required></td>
                        </tr>

                        <tr>
                            <td><button class="button-4" type="submit" name="add">Save</button></td>
                        </tr>
                    </table>
                </div>
                <h3 style="color: red">${requestScope.result}</h3>
            </center>
        </form>
    </body>
</html>
