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
    <form action="name.action" method="get">
    	name:<input type="text" name="name"/><br/>
    	age&nbsp;:<input type="text" name="age"/><br/>
    	address:<input type="text" name="address"/>
    	<input type="submit" />
    </form>
    </fieldset>
    <%=new Date()%>
    
    <fieldset>
    	<legend>ajax</legend>
	   <form>
	   	<input type="text" name="value" id="ajaxInp" />
	   	<input type="button" value="ajax按钮" onclick="ajaxForm('ajaxInp')"/>
	   </form> 
	    <input type="text" id="forAjax" />
    </fieldset>
    
    <a href="dao.action" >dao.action</a>
     <fieldset>
    <form action="dao.action" method="get">
    	name:<input type="text" name="name"/><br/>
    	password&nbsp;:<input type="text" name="password"/><br/>
    	tel:<input type="text" name="tel"/>
    	<input type="submit" />
    </form>
    </fieldset>
</html>
