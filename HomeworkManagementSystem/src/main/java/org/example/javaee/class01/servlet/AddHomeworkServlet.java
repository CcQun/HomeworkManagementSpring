package org.example.javaee.class01.servlet;

import org.example.javaee.class01.jdbc.HomeworkJDBC;
import org.example.javaee.class01.model.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Author CcQun
 * @Date 2020/3/11 11:06
 */

@WebServlet("/addHomework")
public class AddHomeworkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Homework homework = new Homework();
        homework.setTitle(req.getParameter("title"));
        homework.setContent(req.getParameter("content"));
        homework.setCreateTime(new Date());

        boolean result = HomeworkJDBC.insertHomework(homework);

        req.setAttribute("result",result);
        req.setAttribute("operationType","addHomework");
        req.getRequestDispatcher("operationResult.jsp").forward(req,resp);
    }
}
