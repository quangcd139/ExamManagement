<%-- 
    Document   : taoDe
    Created on : Mar 22, 2023, 2:10:02 PM
    Author     : TLC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="taoDe">
            Nhap so cau hoi <input type="text" name="num">
            Nhap mon hoc <input type="text" name="subject">
            <input type="submit">
        </form>
        <%int count=1;%>
        <c:forEach items="${list}" var="q">
            <h3><%=count++%>. ${q.getQuestion()}</h3>
            <p>${q.getAnswer()}</p>
        </c:forEach>

    </body>
</html>
