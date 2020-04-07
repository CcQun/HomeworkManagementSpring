<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/3/11
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%--查看操作结果--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>操作结果</title>
    </head>
    <body>
        <div align="center">
            <%
                String operationType = (String)request.getAttribute("operationType");
                boolean result = (boolean) request.getAttribute("result");
                switch (operationType){
                    case "addHomework":
                        if(result){
            %>
            <p style="margin: 50px; font-family: 'Arial Black'; font-size: 45px; color: darkgreen">成功添加作业</p>
            <%
                        }else{
            %>
            <p style="margin: 50px; font-family: 'Arial Black'; font-size: 45px; color: darkred">添加作业失败</p>
            <%
                        }
                        break;
                    case "addStudent":
                        if(result){
            %>
            <p style="margin: 50px; font-family: 'Arial Black'; font-size: 45px; color: darkgreen">成功添加学生</p>
            <%
                        }else{
            %>
            <p style="margin: 50px; font-family: 'Arial Black'; font-size: 45px; color: darkred">已存在该学生，无需添加</p>
            <%
                        }
                        break;
                    case "addStudentHomework":
                        if(result){
            %>
            <p style="margin: 50px; font-family: 'Arial Black'; font-size: 45px; color: darkgreen">作业提交成功</p>
            <%
                        }else{
            %>
            <p style="margin: 50px; font-family: 'Arial Black'; font-size: 45px; color: darkred">该学生不存在，提交失败</p>
            <%
                        }
                        break;
                    default:
                        break;
                }
            %>

            <a href="../index.jsp">返回首页</a>
        </div>
    </body>
</html>