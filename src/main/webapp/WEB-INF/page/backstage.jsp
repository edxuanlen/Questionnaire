<%--
  Created by IntelliJ IDEA.
  User: ruiyi
  Date: 2019/11/04
  Time: 08:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理</title>
    <style>
        body{
            background-color: #cde0e5;
            text-align:center;
        }
        u{
            font-size:20px;
        }
        .del_checkbox{
            zoom:150%;
        }
        #questionnaires_box{
            text-align:center;
            margin: 0 auto;
            height: 250px;
            width : 900px;
            background-color: white;
            opacity: 0.8;
            border-radius:10px;
            box-shadow: 5px 5px 5px 5px #969899;
        }
        #content{
            margin: 0 auto;
            width:800px;
        }

    </style>
    <script type="text/javascript" src = "../../js/backstage_control.js"></script>
</head>
<body>
    <div id="questionnaires_box">
        <div style="height: 14px;"></div>
        <div id="option_box" style="height:36px;">
            <input id="add_button" type="button" value="添加问卷" onclick="Add()">
            <input id="del_button" type="button" value="删除问卷">
        </div>
        <div id="content">
            <table id="questionnaires_table">
                <tr id="questionnaires1">
                    <td>
                        <input class="del_checkbox" type="checkbox">
                    </td>
                    <td>
                        <u>关于XXX该XXX的大学生调查问卷</u>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</body>
</html>
