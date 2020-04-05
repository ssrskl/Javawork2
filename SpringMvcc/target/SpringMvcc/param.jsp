<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2020/4/3
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--请求参数的绑定--%>
<a href="/param/testParam?username=maoyan" >请求参数的绑定</a>

<%--封装为一个JavaBean--%>
<form action="/param/saveUser" method="post">
    用户名：<input type="text" name="username"/><br/>
    密码：<input type="text" name="password"/><br/>
    生日：<input type="text" name="date"/><br/>
<%--    girlfriend的信息--%>
    女朋友名字：<input type="text" name="girlFriend.name"/><br/>
    女排年龄：<input type="text" name="girlFriend.age"/><br/>
    <input type="submit" value="提交"/>
</form>

</body>
</html>
