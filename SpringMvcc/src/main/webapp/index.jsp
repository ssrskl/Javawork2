<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2020/4/2
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>入门程序</h3>
<a href="/hello" >入门程序</a>
<a href="/remapping/mappingTest?user=maoyan" >测试注解</a>

<a href="/anno/annoTest?name=猫颜">RequestParam注解测试</a>

<form action="/anno/annoBody" method="post">
    用户名：<input type="text" name="username"/><br/>
    密码：<input type="text" name="password"/><br/>
    <input type="submit" value="提交"/>
</form>

<a href="/anno/annoSession">SessionAttributes测试</a>
<a href="/anno/getsession">获取session</a>
<a href="/anno/delsession">清除session</a>
</body>
</html>
