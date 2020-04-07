package org.example.javaee.class01.servlet;

import org.example.javaee.class01.jdbc.HomeworkJDBC;
import org.example.javaee.class01.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Author CcQun
 * @Date 2020/3/11 15:29
 */
@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Student student = new Student();
        student.setId(Long.parseLong(req.getParameter("id")));
        student.setName(req.getParameter("name"));
        student.setCreateTime(new Date());

        boolean result = HomeworkJDBC.insertStudent(student);

        req.setAttribute("result",result);
        req.setAttribute("operationType","addStudent");
        req.getRequestDispatcher("operationResult.jsp").forward(req,resp);
    }
}
