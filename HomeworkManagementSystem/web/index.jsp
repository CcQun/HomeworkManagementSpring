<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/4/7
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业管理系统</title>
</head>
<body>
<h2 align="center">请选择以下操作</h2>
<div align="center">
    <ul style="line-height: 40px">
        <li><a href="${pageContext.request.contextPath}/hms/addHk">老师-添加作业</a></li>
        <li><a href="${pageContext.request.contextPath}/hms/addSt">老师-添加学生</a></li>
        <li><a href="${pageContext.request.contextPath}/hms/displayHomework">老师-查看作业提交情况</a></li>
        <li><a href="${pageContext.request.contextPath}/hms/displayAllHomework">学生-提交作业</a></li>
    </ul>
</div>
</body>
</html>
