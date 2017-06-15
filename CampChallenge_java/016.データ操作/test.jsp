<%-- 
    Document   : test
    Created on : 2017/06/15, 11:40:08
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>送信された結果</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            out.println("名前：" + request.getParameter("txtName") + "<br>");
            out.print("性別：" + request.getParameter("rdoSample") + "<br>");
            out.print("趣味：" + request.getParameter("mulText") + "<br>");
        %>
    </body>
</html>