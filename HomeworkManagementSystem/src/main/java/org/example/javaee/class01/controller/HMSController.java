package org.example.javaee.class01.controller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.javaee.class01.aspect.JDBCAspect;
import org.example.javaee.class01.jdbc.HomeworkJDBC;
import org.example.javaee.class01.model.Homework;
import org.example.javaee.class01.model.Student;
import org.example.javaee.class01.model.StudentHomework;
import org.example.javaee.class01.service.HomeworkService;
import org.example.javaee.class01.service.StudentHomeworkService;
import org.example.javaee.class01.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Author CcQun
 * @Date 2020/4/7 14:45
 */
//@ComponentScan({"org.example.javaee.class01.aspect","org.example.javaee.class01.jdbc"})
//@EnableAspectJAutoProxy
@Controller
@RequestMapping("/hms")
public class HMSController {

    public ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    //public AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(HMSController.class);
    public HomeworkJDBC homeworkJDBC = (HomeworkJDBC)context.getBean(HomeworkJDBC.class);
    public HomeworkService homeworkService = context.getBean(HomeworkService.class);
    public StudentService studentService = context.getBean(StudentService.class);
    public StudentHomeworkService studentHomeworkService = context.getBean(StudentHomeworkService.class);

    public HMSController() throws IOException {
    }

    /**done**/
    @RequestMapping("/addHk")
    public String addHk() {
        return "addHomework";
    }

    /**done**/
    @RequestMapping("/addHomework")
    public void addHomework(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setCharacterEncoding("UTF-8");

        Homework homework = (Homework)context.getBean("Homework");
        homework.setTitle(req.getParameter("title"));
        homework.setContent(req.getParameter("content"));
        homework.setCreateTime(new Date());

        boolean result = homeworkService.insertHomework(homework);

        req.setAttribute("result",result);
        req.setAttribute("operationType","addHomework");
        req.getRequestDispatcher("/jsp/operationResult.jsp").forward(req,resp);
    }

    /**done**/
    @RequestMapping("/addSt")
    public String addSt() {
        return "addStudent";
    }

    /**done**/
    @RequestMapping("/addStudent")
    public void addStudent(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setCharacterEncoding("UTF-8");

        Student student = (Student)context.getBean("Student");
        student.setId(Long.parseLong(req.getParameter("id")));
        student.setName(req.getParameter("name"));
        student.setCreateTime(new Date());

        boolean result = false;

        List<Student> list = studentService.getStudentById(student.getId());
        if(list.size() == 0){
            result = studentService.addStudent(student);
        }

        req.setAttribute("result",result);
        req.setAttribute("operationType","addStudent");
        req.getRequestDispatcher("/jsp/operationResult.jsp").forward(req,resp);
    }

    /**done**/
    @RequestMapping("/displayHomework")
    public void displayHomework(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Homework> allHomework = homeworkService.displayHomework();
        req.setAttribute("allHomeworkList",allHomework);
        req.getRequestDispatcher("/jsp/queryAllHomework.jsp").forward(req,resp);
    }

    /**done**/
    @RequestMapping("/querySpecificHomework")
    protected void querySpecificHomework(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String homeworkId = req.getParameter("id");
        List<StudentHomework> result = studentHomeworkService.selectSpecificHomework(Long.parseLong(homeworkId));
        req.setAttribute("resultList", result);
        req.getRequestDispatcher("/jsp/specificHomeworkSubmission.jsp").forward(req, resp);
    }

    /**done**/
    @RequestMapping("/displayAllHomework")
    protected void displayAllHomework(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Homework> allHomework = homeworkService.displayHomework();
        req.setAttribute("allHomework",allHomework);
        req.getRequestDispatcher("/jsp/displayAllHomework.jsp").forward(req,resp);
    }


    @RequestMapping(value = "/submitHomework",method = RequestMethod.GET)
    protected void submitHomework1(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setCharacterEncoding("UTF-8");
        StudentHomework studentHomework = (StudentHomework)context.getBean("StudentHomework");
        studentHomework.setHomeworkId(Long.parseLong(req.getParameter("homeworkId")));
        studentHomework.setStudentId(Long.parseLong(req.getParameter("studentId")));
        studentHomework.setHomeworkTitle(req.getParameter("title"));
        studentHomework.setHomeworkContent(req.getParameter("content"));
        studentHomework.setCreateTime(new Date());


        boolean result = false;
        List<Student> list = studentService.getStudentById(studentHomework.getStudentId());
        if(list.size() != 0){
            result = studentHomeworkService.insertStudentHomework(studentHomework);
        }

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
