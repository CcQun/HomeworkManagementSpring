package org.example.javaee.class01.controller;

import org.example.javaee.class01.jdbc.HomeworkJDBC;
import org.example.javaee.class01.model.Homework;
import org.example.javaee.class01.model.Student;
import org.example.javaee.class01.model.StudentHomework;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Author CcQun
 * @Date 2020/4/7 14:45
 */
@Controller
@RequestMapping("/hms")
public class HMSController {
    @RequestMapping("/addHk")
    public String addHk() {
        return "addHomework";
    }

    @RequestMapping("/addHomework")
    public void addHomework(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Homework homework = new Homework();
        homework.setTitle(req.getParameter("title"));
        homework.setContent(req.getParameter("content"));
        homework.setCreateTime(new Date());

        boolean result = HomeworkJDBC.insertHomework(homework);

        req.setAttribute("result",result);
        req.setAttribute("operationType","addHomework");
        req.getRequestDispatcher("/jsp/operationResult.jsp").forward(req,resp);
    }

    @RequestMapping("/addSt")
    public String addSt() {
        return "addStudent";
    }

    @RequestMapping("/addStudent")
    public void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Student student = new Student();
        student.setId(Long.parseLong(req.getParameter("id")));
        student.setName(req.getParameter("name"));
        student.setCreateTime(new Date());

        boolean result = HomeworkJDBC.insertStudent(student);

        req.setAttribute("result",result);
        req.setAttribute("operationType","addStudent");
        req.getRequestDispatcher("/jsp/operationResult.jsp").forward(req,resp);
    }

    @RequestMapping("/displayHomework")
    public void displayHomework(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Homework> allHomework = HomeworkJDBC.displayHomework();
        req.setAttribute("allHomeworkList",allHomework);
        req.getRequestDispatcher("/jsp/queryAllHomework.jsp").forward(req,resp);
    }

    @RequestMapping("/querySpecificHomework")
    protected void querySpecificHomework(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String homeworkId = req.getParameter("id");
        List<StudentHomework> result = HomeworkJDBC.selectSpecificHomework(homeworkId);
        req.setAttribute("resultList", result);
        req.getRequestDispatcher("/jsp/specificHomeworkSubmission.jsp").forward(req, resp);
    }

    @RequestMapping("/displayAllHomework")
    protected void displayAllHomework(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Homework> allHomework = HomeworkJDBC.displayHomework();
        req.setAttribute("allHomework",allHomework);
        req.getRequestDispatcher("/jsp/displayAllHomework.jsp").forward(req,resp);
    }

    @RequestMapping(value = "/submitHomework",method = RequestMethod.GET)
    protected void submitHomework1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        req.getRequestDispatcher("/jsp/operationResult.jsp").forward(req,resp);
    }

    @RequestMapping(value = "/submitHomework",method = RequestMethod.POST)
    protected void submitHomework2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String homeworkId = req.getParameter("id");
        System.out.println(homeworkId);
        req.setAttribute("homeworkId",homeworkId);
        req.getRequestDispatcher("/jsp/submitHomework.jsp").forward(req,resp);
    }
}
