<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/3/10
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%--该页面用于老师添加新作业--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加作业</title>
</head>
<body>
    <div align="center">
        <h2>添加作业</h2>
        <form action="${pageContext.request.contextPath}/hms/addHomework" method="post">
            <table style="line-height: 40px">
                <tr>
                    <th>作业标题：</th>
                    <td><input type="text" name="title" maxlength="20" size="40" style="font-family: 'Arial Black'" required></td>
                </tr>
                <tr>
                    <th>作业内容：</th>
                    <td><textarea name="content" rows="10" cols="42" style="font-family: 'Arial Black'" required></textarea></td>
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
