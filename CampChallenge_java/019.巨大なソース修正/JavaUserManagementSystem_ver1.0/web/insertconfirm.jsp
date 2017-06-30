<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.*" %>
<jsp:setProperty name="UserDataBeans" property="*" />
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb=(UserDataBeans)hs.getAttribute("UserDataBeans");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    <% if(hs.getAttribute("msg").equals("OK")){ %>
        <h1>登録確認</h1>
        名前:<%= udb.getName() %><br>
        生年月日:<%= udb.getYear() %>年
        <%= udb.getMonth() %>月
        <%= udb.getDay() %>日<br>
        種別:<%= udb.getType2() %><br>
        電話番号:<%= udb.getTell() %><br>
        自己紹介:<%= udb.getComment() %><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
    <h1>入力が不完全です</h1><br>
    <%= hs.getAttribute("msg")%>欄を入力してください
    <% } %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form><br>
    <%=JumsHelper.getInstance().home()%>
    </body>
</html>
