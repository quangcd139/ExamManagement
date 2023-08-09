<%-- 
    Document   : subject
    Created on : Feb 27, 2023, 12:04:04 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subject management</title>
        <link rel="stylesheet" type="text/css" href="button4.css">
        <link rel="stylesheet" type="text/css" href="searchButton.css">
    </head>
    <body>
        <style>
            body{
                font-family: arial;
                margin: 0px;
                width: 100%;
                background-image:url("image/back1.jpg");
                /*background-position-y: -300px;*/

                color: white;
            }
            .button-4{
                width: 176px;
                height: 60px;
                margin-left: 5px;


            }

            .container{
                display: flex;
            }
            .mot{
                width: 270px;
                /*margin-top: 27px;*/
                padding-top: 25px;
                padding-bottom:32%;
                background-color: rgb(25,42,54);
            }
            .mot a{
                margin-left: 0px;
                color: white;
                font-size: 18px;
                text-decoration: none;
            }
            .hai{
                width: 550px;
                padding-top: 100px;
                padding-left: 50px;
            }
            .ba{
                width: 350px;
                margin-top: 165px;
                margin-bottom: 100%;
                text-align: left;
                padding-left: 15px;
                background-color: rgb(255, 255, 204);
                border-radius: 6px;
                /*                padding-top: 100px;*/
            }
            .ba p{
                color: black;
            }
            .ba h4{
                color: black;
            }
            .mot img{
                /*padding-top: -50px;*/
                margin-left: 20px;
                width: 170px;
                height: 90px;
                margin-bottom: 40px;
                border-radius: 6px;

            }
            .quang1{
                padding-top: 20px;
                padding-bottom: 10px;
                width: 270px;
                height: 30px;
                border: 2px solid;
                /*border-style: solid;*/
                /*background: gray;*/
                border-right: 0;
                border-left: 0;
                border-left-color: 908E8E;
                border-right-color: 908E8E;
            }
            .quang2{
                padding-top: 20px;
                padding-bottom: 10px;
                width: 270px;
                height: 30px;
                border: 2px solid;
                /*background: gray;*/
                border-right: 0;
                border-left: 0;
                border-top: 0;
                border-left-color: rgba(144, 142, 142, 1);
                border-right-color: rgba(144, 142, 142, 1);
            }
            .quang3{
                padding-top: 20px;
                padding-bottom: 10px;
                width: 270px;
                height: 30px;
                border: 2px solid;
                /*background: gray;*/
                border-right: 0;
                border-left: 0;
                border-top: 0;
                border-left-color: rgba(144, 142, 142, 1);
                border-right-color: rgba(144, 142, 142, 1);
            }
        </style>
        <div class="container">
            <div class="mot">
                <!--<a href="AdminPanel.jsp">Home</a><br><br><br>-->
                <center>
                    <a href="AdminPanel.jsp"><img src="image/fptLogo.png" /></a>
                </center>
                <div class="quang1">
                    <center>
                        <a href="adminPanel?sendPage=1">Grade Management</a><br><br><br>
                    </center>
                </div>
                <div class="quang2">
                    <center>
                        <a href="adminPanel?sendPage=3">Question Management</a><br><br><br>
                    </center>
                </div>
                
                <div class="quang3">
                    <center>
                        <a href="adminPanel?sendPage=2">Student Management</a><br><br><br>
                    </center>
                </div>

            </div>

            <div class="hai">
                <h1>Subject Management</h1>
                <form action="subjectController" method="post">
                    Enter subject ID: <input type="text" name="tim"/> <button type="submit" name="check" value="Search"><div class="spinner"></div>Search</button> <br><br>
                    <input class="button-4" type="submit" name="check" value="List all subject">
                    <input class="button-4" type="submit" name="check" value="Add subject">
                    <br><br>
                    <input class="button-4" type="submit" name="check" value="Update subject">
                    <input class="button-4" type="submit" name="check" value="Delete subject">
                </form>
            </div>

            <c:if test="${check==1}">
                <div class="ba">
                    <h4>Subject information</h4>
                    <p>Subject ID: ${s1.getSubjectId()}</p>
                    <p>Subject name: ${s1.getSubjectName()}</p>
                    <p>Semester: ${s1.getSemester()}</p>
                </div>
            </c:if>

            <c:if test="${check<0}">
                <div class="ba">
                    <center>

                        <h3 style="color: red;">Subject not found</h3>
                    </center>
                </div
            </c:if>

        </div>

    </body>
</html>
