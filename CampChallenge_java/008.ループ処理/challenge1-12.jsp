<%-- 
    Document   : newjsp
    Created on : 2017/06/02, 14:17:42
    Author     : guest1Day
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String num = "A";

for (int i = 1; i < 30; i++){
    num = num + "A";
}
out.print(num);
%>