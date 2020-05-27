package org.example.javaee.class01;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.javaee.class01.dao.HomeworkDao;
import org.example.javaee.class01.model.Homework;
import org.example.javaee.class01.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author CcQun
 * @Date 2020/5/25 13:01
 */
public class test {
    @Autowired
    HomeworkDao homeworkDao;

//    public void testaa() throws Exception {
////        List<Homework> listHomework = homeworkDao.selectAll();
//        for (Homework homework : homeworkDao.selectAll()) {
//            System.out.println("ID:" + homework.getId() + ",TITLE:" + homework.getTitle());
//        }
//    }
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();
        List<Homework> listHomework = session.selectList("displayHomework");
        for (Homework homework : listHomework) {
            System.out.println("ID:" + homework.getId() + ",TITLE:" + homework.getTitle());
        }
//        try {
//            test x = new test();
//            x.testaa();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
