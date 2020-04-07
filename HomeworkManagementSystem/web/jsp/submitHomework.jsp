<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/3/12
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交作业</title>
</head>
<body>
<%
    String homeworkId = (String)request.getAttribute("homeworkId");
%>
<div align="center">
    <h2>为作业<%=homeworkId%>提交作业</h2>
    <form action="${pageContext.request.contextPath}/hms/submitHomework" method="get">
        <input value=<%=homeworkId%> name="homeworkId" type="hidden">
        <table style="line-height: 40px">
            <tr>
                <th>学号：</th>
                <td><input type="text" name="studentId" maxlength="20" size="40" style="font-family: 'Arial Black'" required>
                </td>
            </tr>
            <tr>
                <th>作业标题：</th>
                <td><input type="text" name="title" maxlength="20" size="40" style="font-family: 'Arial Black'"
                           required></input></td>
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
