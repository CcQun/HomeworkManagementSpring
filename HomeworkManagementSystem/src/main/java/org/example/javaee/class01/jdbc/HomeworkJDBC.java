package org.example.javaee.class01.jdbc;

import org.example.javaee.class01.model.Homework;
import org.example.javaee.class01.model.Student;
import org.example.javaee.class01.model.StudentHomework;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author CcQun
 * @Date 2020/3/10 13:53<
 */
@Service
public class HomeworkJDBC {
    public static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    /**
     * 插入新作业
     * @param homework
     * @return boolean
     * @Author CcQun
     * @Date 2020/3/11 15:33
     */
    public static boolean insertHomework(Homework homework){
        String sqlString = "insert into s_homework(title,content,create_time) values(?,?,?)";

        int resultNum = 0;

        try(Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sqlString)) {
                statement.setString(1,homework.getTitle());
                statement.setString(2,homework.getContent());
                statement.setTimestamp(3,new Timestamp(homework.getCreateTime().getTime()));
                resultNum = statement.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultNum > 0;
    }

    /**
     * 插入新学生，插入数据之前先判断是否有该学生
     * @param student
     * @return boolean
     * @Author CcQun
     * @Date 2020/3/11 15:34
     */
    public static boolean insertStudent(Student student){
        String selectSql = "select * from s_student where id = " + student.getId();
        String insertSql = "insert into s_student(id,name,create_time) values(?,?,?)";

        int resultNum = 0;

        try(Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(selectSql)) {
                    resultSet.last();
                    if(resultSet.getRow() == 0){
                        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
                        preparedStatement.setLong(1,student.getId());
                        preparedStatement.setString(2,student.getName());
                        preparedStatement.setTimestamp(3,new Timestamp(student.getCreateTime().getTime()));
                        resultNum = preparedStatement.executeUpdate();
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return resultNum > 0;
    }

    /**
     * 获取所有作业
     * @param
     * @return java.util.List<code.model.Homework>
     * @Author CcQun
     * @Date 2020/3/11 17:40
     */
    public static List<Homework> displayHomework(){
        String sqlString = "select * from s_homework";

        List<Homework> result = new ArrayList<Homework>();
        try(Connection connection = DatabasePool.getHikariDataSource().getConnection()){
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    while(resultSet.next()){
                        Homework homework = (Homework)context.getBean("Homework");
                        homework.setId(resultSet.getLong("id"));
                        homework.setTitle(resultSet.getString("title"));
                        homework.setContent(resultSet.getString("content"));
                        homework.setCreateTime(resultSet.getTimestamp("create_time"));
                        homework.setUpdateTime(resultSet.getTimestamp("update_time"));
                        result.add(homework);
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取某一作业的提交情况
     * @param homeworkId
     * @return java.util.List<code.model.StudentHomework>
     * @author CcQun
     * @date 2020/3/10 14:39
     */
    public static List<StudentHomework> selectSpecificHomework(String homeworkId){
        String sqlString = "select * from s_student_homework where homework_id = " + homeworkId;
        System.out.println(sqlString);

        List<StudentHomework> result = new ArrayList<StudentHomework>();

        try(Connection connection = DatabasePool.getHikariDataSource().getConnection()){
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    while(resultSet.next()){
                        StudentHomework studentHomework = (StudentHomework)context.getBean("StudentHomework");
                        studentHomework.setId(resultSet.getLong("id"));
                        studentHomework.setStudentId(resultSet.getLong("student_id"));
                        studentHomework.setHomeworkId(resultSet.getLong("homework_id"));
                        studentHomework.setHomeworkTitle(resultSet.getString("homework_title"));
                        studentHomework.setHomeworkContent(resultSet.getString("homework_content"));
                        studentHomework.setCreateTime(resultSet.getDate("create_time"));
                        studentHomework.setUpdateTime(resultSet.getDate("update_time"));
                        result.add(studentHomework);
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 学生提交作业。插入数据之前先检查有无该学生
     * @param studentHomework
     * @return boolean
     * @Author CcQun
     * @Date 2020/3/12 18:10
     */
    public static boolean insertStudentHomework(StudentHomework studentHomework){
        String selectSql = "select * from s_student where id = " + studentHomework.getStudentId();
        String insertSql = "insert into s_student_homework(student_id,homework_id,homework_title,homework_content,create_time) values(?,?,?,?,?)";

        int resultNum = 0;

        try(Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(selectSql)) {
                    resultSet.last();
                    if(resultSet.getRow() != 0){
                        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
                        preparedStatement.setLong(1,studentHomework.getStudentId());
                        preparedStatement.setLong(2,studentHomework.getHomeworkId());
                        preparedStatement.setString(3,studentHomework.getHomeworkTitle());
                        preparedStatement.setString(4,studentHomework.getHomeworkContent());
                        preparedStatement.setTimestamp(5,new Timestamp(studentHomework.getCreateTime().getTime()));
                        resultNum = preparedStatement.executeUpdate();
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return resultNum > 0;
    }
}
