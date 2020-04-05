<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2020/4/3
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        //页面加载
        $(function () {
            $("#btn").click(function () {
                alert("hello ajax");
                //发送ajax请求
                $.ajax({
                    //编写json数据
                    url:"/main/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"猫颜","password":"123"}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        //data服务器响应的json数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                    }
                });
            })
        });
    </script>
</head>
<body>
<a href="/main/test">测试</a>
<a href="/main/testModelandView">modelandview测试</a>
<br/>
<button id="btn" >发送ajax请求</button>
</body>
</html>
