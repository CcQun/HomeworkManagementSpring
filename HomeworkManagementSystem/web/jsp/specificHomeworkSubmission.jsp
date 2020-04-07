<%@ page import="java.util.List" %>
<%@ page import="org.example.javaee.class01.model.StudentHomework" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/3/12
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业提交详情</title>
</head>
<body>
<h2 align="center" style="margin:50px">作业提交详情</h2>
<%
    List<StudentHomework> resultList = (List<StudentHomework>) request.getAttribute("resultList");
    if (resultList == null || resultList.size() == 0) {
%>
<p align="center" style="margin: 50px; font-family: 'Arial Black'; font-size: 45px; color: darkred">该作业暂时无人提交</p>
<%
} else {
%>
<table align="center" width="960" border="1">
    <tr bgcolor="#f0f8ff">
        <th width="10%">学号</th>
        <th width="10%">作业id</th>
        <th width="20%">作答标题</th>
        <th width="45%">作答内容</th>
        <th width="15%">提交时间</th>
    </tr>
    <%
        for (StudentHomework studentHomework : resultList) {
    %>
    <tr>
        <td width="10%"><%=studentHomework.getStudentId()%>
        </td>
        <td width="10%"><%=studentHomework.getHomeworkId()%>
        </td>
        <td width="20%"><%=studentHomework.getHomeworkTitle()%>
        </td>
        <td width="45%"><%=studentHomework.getHomeworkContent()%>
        </td>
        <td width="15%"><%=studentHomework.getCreateTime()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
<%
    }
%>
<p align="center"><a href="../index.jsp">返回首页</a></p>
</body>
</html>
