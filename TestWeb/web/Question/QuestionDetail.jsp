<%-- 
    Document   : QuestionDetail
    Created on : Mar 5, 2023, 9:41:44 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Question detail</title>
        <link rel="stylesheet" type="text/css" href="button4.css">
    </head>
    <body>
        <style>
            body{
                font-family: arial;
            }
            .question{
                margin-left: 20px;
            }
            .answer{
                margin-left: 30px;
            }
        </style>
        <a href="adminPanel?que=1"> back</a>
        <h1>Question detail</h1>
        <form action="questionSubject" method="post">
            Question ID: <input value="${q.getQuestionId()}" type="text" name="questionId" readonly> <br/><br/>
            Subject ID: <input value="${q.getSubjectId()}" style="margin-left: 10px;" type="text" name="subjectId" readonly> <br/><br/>
            Question: <textarea class="question" name="question" rows="3" cols="20" required="">${q.getQuestion()}</textarea><br/><br/>
            Answer: <textarea class="answer" name="answer" rows="3" cols="20" required="">${q.getAnswer()}</textarea><br/><br/>
            <button class="button-4" type="submit" name="update">Update</button><br/>
        </form>
    </body>
</html>
