<%--
  Created by IntelliJ IDEA.7
  User: Lenovo
  Date: 2020/3/11
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加学生</title>
</head>
<body>
<div align="center">
    <h2>添加学生</h2>
    <form action="${pageContext.request.contextPath}/hms/addStudent" method="post">
        <table style="line-height: 40px">
            <tr>
                <th>学号：</th>
                <td><input type="text" name="id" maxlength="20" size="40" style="font-family: 'Arial Black'" required>
                </td>
            </tr>
            <tr>
                <th>姓名：</th>
                <td><input type="text" name="name" maxlength="20" size="40" style="font-family: 'Arial Black'"
                           required></input></td>
            </tr>
            <tr align="center">
                <th><input type="reset" value="清空"></th>
                <td><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
