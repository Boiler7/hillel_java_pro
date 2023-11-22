package hw30.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class HebernateMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateSession.class);
        SessionFactory sessionFactory = context.getBean(SessionFactory.class);

        var studentDao = new StudentDao(sessionFactory);

        studentDao.create();

        var studentsList1 = studentDao.getAllStudents();
        System.out.println(studentsList1);

        var student = Student.builder()
                .id(14L)
                .name("Kyr111")
                .email("kyr111@example.com")
                .build();

        studentDao.updateStudent(14L, student);

        studentDao.deleteStudent(16L);

        System.out.println(studentDao.findById(16L));
    }
}
