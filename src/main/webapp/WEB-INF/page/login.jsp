<%--
  Created by IntelliJ IDEA.
  User: ruiyi
  Date: 2019/10/29
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <style>
        body{
            background-color: #cde0e5;
            text-align:center;
        }
        #login_box{
            margin: 0 auto;
            height: 250px;
            width : 350px;
            background-color: white;
            opacity: 0.8;
            border-radius:10px;
            box-shadow: 5px 5px 5px 5px #969899;
        }
    </style>
</head>
<body>
<form>
    <div style = "height:200px"></div>
    <div id = "login_box">
        <div style = "height:10px"></div>
        <h2>后台管理系统登陆</h2>
        <div style = "height:15px"></div>
        <input name = "username" class = "input_box" placeholder="请输入用户名"/>
        <div style ="height:20px"></div>
        <input name = "password" class = "input_box" placeholder="请输入密码" type = "password"/>
        <div style = "height:20px"></div>
        <input id = "submit_but" type = "submit" value = "登陆"/>
    </div>
</form>
</body>
</html>
