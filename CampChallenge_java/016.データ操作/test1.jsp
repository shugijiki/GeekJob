<%-- 
    Document   : test1
    Created on : 2017/06/15, 14:12:54
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Page</title>
    </head>
    <body>
        <%
        request.setCharacterEncoding("UTF-8");
        int num1 = request.getParameter("total");
        int num2 = request.getParameter("count");
        int num3 = request.getParameter("type");
        
        out.print("商品種別：");
        switch(num3){
            case 1
            out.print("雑貨");
            break;
            case 2
            out.print("生鮮食品");
            break;
            case 3
            out.print("その他");
            break;
        } 
        out.print("<br>");
        out.print("1個当たりの値段："+ num1/num2 + "円<br>");
        if(total >= 5000){
            out.print("ポイント＋5%");
        }else if(total >= 3000){
            out.print("ポイント＋4%");
        }
        %>
    </body>
</html>
