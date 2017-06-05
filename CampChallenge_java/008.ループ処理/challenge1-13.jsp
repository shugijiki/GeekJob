<%-- 
    Document   : newjsp
    Created on : 2017/06/02, 14:17:42
    Author     : guest1Day
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
long num = 0;

for (int i = 0; i <= 100; i++){
    num = num + i;
}
out.print(num);
%>