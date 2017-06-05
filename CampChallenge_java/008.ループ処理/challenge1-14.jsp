<%-- 
    Document   : newjsp
    Created on : 2017/06/02, 14:17:42
    Author     : guest1Day
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int num = 10000;

while (num > 100){
    num = num / 2;
}
out.print(num);
%>