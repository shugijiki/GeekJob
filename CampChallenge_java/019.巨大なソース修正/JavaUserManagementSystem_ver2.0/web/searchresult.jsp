<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO"
        import="java.util.ArrayList"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    ArrayList<UserDataDTO> uddArray = (ArrayList<UserDataDTO>)hs.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <% if(uddArray.size()>0){ %>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <% for(UserDataDTO udd : uddArray){ %>
            <tr>
                <td nowrap><a href="ResultDetail?id=<%= udd.getUserID()%>"><%= udd.getName()%></a></td>
                <td><%= udd.getBirthday()%></td>
                <td><%= jh.exTypenum(udd.getType())%></td>
                <td><%= udd.getNewDate()%></td>
            </tr>
            <% } %>
        </table>
        <% }else{ %>
        検索したデータは見つかりませんでした。<br>
        内容をご確認の上、もう一度検索してください。<br><% } %>
        <form action="Search" method="POST">
            <input type="submit" name="backBtn" value="検索ページに戻る">
        </form>
        <br>
    </body>
    <%=jh.home()%>
</html>
