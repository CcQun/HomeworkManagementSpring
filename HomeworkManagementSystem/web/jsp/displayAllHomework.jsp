<%@ page import="java.util.List" %>
<%@ page import="org.example.javaee.class01.model.Homework" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/3/12
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看所有作业</title>
    <script>
        function display(id) {
            let homework = document.getElementById("homeworkId")
            homework.setAttribute("value", id)
            let submit = document.getElementById("submit")
            submit.submit()
        }
    </script>
</head>
<body>
<form id="submit" method="post" action="${pageContext.request.contextPath}/hms/submitHomework">
    <input id="homeworkId" name="id" type="hidden">
    <table align="center" width="960" border="1">
        <tr>
            <th width="10%">作业id</th>
            <th width="30%" style="word-break: break-all;word-wrap: break-word;">作业标题</th>
            <th width="50%" style="word-break: break-all;word-wrap: break-word;">作业内容</th>
            <th width="10%">作业提交信息</th>
        </tr>
        <%
            List<Homework> list = (List<Homework>) request.getAttribute("allHomework");
            if (list == null || list.size() <= 0) {

            } else {
                for (Homework homework : list) {
        %>
        <tr>
            <td><%=homework.getId()%>
            </td>
            <td><%=homework.getTitle()%>
            </td>
            <td><%=homework.getContent()%>
            </td>
            <td><input type="button" width="100%" value="前往提交作业" onclick="display(<%=homework.getId()%>)"></td>
        </tr>
        <%
                }
            }
        %>
    </table>
</form>
</body>
</html>
