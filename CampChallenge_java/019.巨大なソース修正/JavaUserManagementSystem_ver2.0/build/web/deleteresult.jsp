<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)request.getAttribute("delete");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
    <h1>削除確認</h1>
    <% if(udd.getDelete()==1){ %>
    削除しました。<br>
    <% }else{%>
    削除に失敗しました
    <% }%>
    <form action="SearchResult" method="POST">
      <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
      <input type="submit" name="NO" value="詳細画面に戻る"style="width:100px">
    </form>
    </body>
        <%=JumsHelper.getInstance().home()%>
</html>
