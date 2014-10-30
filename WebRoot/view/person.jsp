<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<script type="text/javascript" src="js/form.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <fieldset>
    <form action="person.action" method="get">
    	<table>
    		<tr>
    			<td>name</td>
    			<td><input type="text" name="name" /></td>
    		</tr>
    		<tr>
    			<td>age</td>
    			<td><input type="text" name="age" /></td>
    		</tr>
    		<tr>
    			<td>money</td>
    			<td><input type="text" name="money" /></td>
    		</tr>
    		<tr>
    			<td>address</td>
    			<td><input type="text" name="address" /></td>
    		</tr>
    		<tr>
    			<td><input type="submit" /></td>
    			<td><input type="reset" /></td>
    		</tr>
    	</table>
    </form>
    </fieldset>
    
   
</html>
