package org.example.javaee.class01.servlet;

import org.example.javaee.class01.jdbc.HomeworkJDBC;
import org.example.javaee.class01.model.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author CcQun
 * @Date 2020/3/12 15:39
 */
@WebServlet("/displayAllHomework")
public class DisplayAllHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Homework> allHomework = HomeworkJDBC.displayHomework();
        req.setAttribute("allHomework",allHomework);
        req.getRequestDispatcher("jsp/displayAllHomework.jsp").forward(req,resp);
    }
}
