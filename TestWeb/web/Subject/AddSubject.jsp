<%-- 
    Document   : AddSubject
    Created on : Mar 4, 2023, 12:14:54 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Subject</title>
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
        <a href="adminPanel?sub=1"> back</a>
        <form action="subjectController">
            <center>
                <div class="add">
                    <h1>Add subject</h1>
                    Subject ID: <input style="margin-left: 23px;" type="text" name="id" required> <br/><br/>
                    Subject name: <input  type="text" name="name" required> <br/><br/>
                    Semester: <input style="margin-left: 31px;" type="text" name="semester" required> <br/><br/>
                    <button class="button-4" type="submit" name="add">Save</button><br/>
                </div>
                <h3 style="color: red">${requestScope.result}</h3>
            </center>
        </form>
    </body>
</html>
