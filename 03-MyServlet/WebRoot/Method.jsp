<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Method.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="req" method="get">
    	用户名: <input type="text" name="uname" value="" /><br />
    	密码: <input type="text" name="pwd" value="" /><br />
    	爱好：<br />
    	<input type="checkbox" name="fav" value="1"/>唱歌<br />
    	<input type="checkbox" name="fav" value="2"/>跳舞<br />
    	<input type="checkbox" name="fav" value="3"/>游泳<br />
    	
    	<input type="submit" value="登录" />
    	
    </form>
  </body>
</html>
