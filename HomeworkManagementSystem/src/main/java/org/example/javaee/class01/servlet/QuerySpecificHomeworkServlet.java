package org.example.javaee.class01.servlet;

import org.example.javaee.class01.jdbc.HomeworkJDBC;
import org.example.javaee.class01.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author CcQun
 * @Date 2020/3/12 14:03
 */
@WebServlet("/querySpecificHomework")
public class QuerySpecificHomeworkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String homeworkId = req.getParameter("id");
        List<StudentHomework> result = HomeworkJDBC.selectSpecificHomework(homeworkId);
        req.setAttribute("resultList", result);
        req.getRequestDispatcher("jsp/specificHomeworkSubmission.jsp").forward(req, resp);
    }
}
