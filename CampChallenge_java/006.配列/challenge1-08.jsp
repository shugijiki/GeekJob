<%-- 
    Document   : newjsp
    Created on : 2017/06/02, 14:17:42
    Author     : guest1Day
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<%
ArrayList<String> data = new ArrayList<String>();

data.add("10");
data.add("100");
data.add("soeda");
data.add("hayashi");
data.add("-20");
data.add("118");
data.add("END");
out.print(data);
%>