<%@page import="java.util.ArrayList"
        import="javax.servlet.http.HttpSession"
        import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)request.getAttribute("updateData");
    ArrayList<String> chkList = udd.chkproperties();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <%if(chkList.isEmpty()){%>
    <body>
        <h1>変更結果</h1><br>
        名前:<%= udd.getName()%><br>
        生年月日:<%= new java.sql.Date(udd.getBirthday().getTime())%><br>
        種別:<%= jh.exTypenum(udd.getType())%><br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<%= udd.getComment()%><br>
        以上の内容で登録しました。<br>
        <% }else{ %>
            <h1>入力が不完全です</h1>
            <%=jh.chkinput(chkList) %>
            <form action="Update" method="POST">
                <input type="submit" name="no" value="登録画面に戻る">
                <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            </form>
        <%}%>
    </body>
    <%=jh.home()%>
    </body>
</html>
