<%-- 
    Document   : newjsp
    Created on : 2017/06/02, 14:17:42
    Author     : guest1Day
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
long num = 1;

for (int i = 1; i <= 20; i++){
    num = num * 8;
}
out.print(num);
%>