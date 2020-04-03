<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2020/3/26
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/Valid" method="post">
    验证码：<input type="text" size="1" name="code" /><img src="VolidServlet" width="80" height="40"/><a href="">看不清</a><br/>
    <input type="submit" value="登录"/><input type="reset" value="重置"/>
  </form>
  </body>
</html>
