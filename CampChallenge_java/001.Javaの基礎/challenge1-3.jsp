<%-- 
    Document   : newjsp
    Created on : 2017/06/02, 14:17:42
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    final int num1 = 1;
    int num2 = 2;
    out.print(num1+1);
    out.print(num1-1);
    out.print(num1/3);
    out.print(num1*3 + "<br>");
    
    out.print(num2+1);
    out.print(num2-1);
    out.print(num2/3);
    out.print(num2*3);
    
%>