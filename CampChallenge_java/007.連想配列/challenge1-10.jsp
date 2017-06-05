<%-- 
    Document   : newjsp
    Created on : 2017/06/02, 14:17:42
    Author     : guest1Day
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<%
HashMap<String, String> data = new HashMap<String,String>();
data.put("1","AAA"); data.put("Hello","World");
data.put("soeda","33"); data.put("20","20");

out.println(data.get("1"));
out.println(data.get("Hello"));
out.println(data.get("soeda"));
out.println(data.get("20"));
%>