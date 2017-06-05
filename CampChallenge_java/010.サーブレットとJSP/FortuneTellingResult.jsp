<%-- 
    Document   : FortuneTellingResult
    Created on : 2017/06/05, 16:10:37
    Author     : guest1Day
--%>

<%@page import="org.camp.servlet.ResultData" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
  <%
    ResultData data = (ResultData)request.getAttribute("DATA");
  %>
  <meta http-equiv="content-Type" content="text/html: charset=UTF-8">
  <title>JSP Page</title>
  </head>
  <body>
  <%
    if(data != null){
      out.print("あなたの" + data.getD() + "の運勢は、" + data.getLuck() + "です");
    }
  %>
  </body>
</html>

