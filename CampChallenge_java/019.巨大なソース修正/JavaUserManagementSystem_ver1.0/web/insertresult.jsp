<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.*" %>
<%
    UserDataBeans udb=(UserDataBeans)request.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        名前<%= udb.getName() %><br>
        生年月日:<%= udb.getYear() %>年<%= udb.getMonth() %>月<%= udb.getDay() %>日<br>
        種別:<%= udb.getType2() %><br>
        電話番号:<%= udb.getTell() %><br>
        自己紹介:<%= udb.getComment() %><br>
        以上の内容で登録しました。<br>
    </body>
        <br>
        <%=JumsHelper.getInstance().home()%>
</html>
