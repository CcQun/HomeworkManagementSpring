package org.example.javaee.class01.servlet;

import org.example.javaee.class01.jdbc.HomeworkJDBC;
import org.example.javaee.class01.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Author CcQun
 * @Date 2020/3/12 16:23
 */
@WebServlet("/submitHomework")
public class SubmitHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        StudentHomework studentHomework = new StudentHomework();
        studentHomework.setHomeworkId(Long.parseLong(req.getParameter("homeworkId")));
        studentHomework.setStudentId(Long.parseLong(req.getParameter("studentId")));
        studentHomework.setHomeworkTitle(req.getParameter("title"));
        studentHomework.setHomeworkContent(req.getParameter("content"));
        studentHomework.setCreateTime(new Date());

        boolean result = HomeworkJDBC.insertStudentHomework(studentHomework);

        req.setAttribute("result",result);
        req.setAttribute("operationType","addStudentHomework");
        req.getRequestDispatcher("operationResult.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String homeworkId = req.getParameter("id");
        System.out.println(homeworkId);
        req.setAttribute("homeworkId",homeworkId);
        req.getRequestDispatcher("jsp/submitHomework.jsp").forward(req,resp);
    }
}
