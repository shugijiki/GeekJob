<%-- 
    Document   : newjsp
    Created on : 2017/06/02, 14:17:42
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int num =4;
    if(num == 1){
    out.print("１です！");
    }else if(num ==2){
    out.print("プログラミングキャンプ！");
    }else{
        out.print("その他です！");
    }
%>