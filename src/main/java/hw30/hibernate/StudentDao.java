package hw30.hibernate;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

@Slf4j
public class StudentDao {

    private final SessionFactory sessionFactory;

    public StudentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    void create() {
        try (var session = sessionFactory.openSession()) {
            var studentName = "Test_" + UUID.randomUUID().toString().substring(0, 5);
            var id = session.save(Student.builder()
                    .name(studentName)
                    .email(studentName + "@example.com")
                    .build());
        }
    }

    public void create(String name, String email) {
        try (var session = sessionFactory.openSession()) {
            var id = session.save(Student.builder()
                    .name(name)
                    .email(email)
                    .build());
        }
    }

    public List<Student> getAllStudents() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Student> cq = cb.createQuery(Student.class);
            Root<Student> rootEntry = cq.from(Student.class);
            CriteriaQuery<Student> all = cq.select(rootEntry);

            TypedQuery<Student> allQuery = session.createQuery(all);
            return allQuery.getResultList();
        }
    }

    public Student findById(Long id) {
        try (var session = sessionFactory.openSession()) {
            return session.find(Student.class, id);
        }
    }

    public void updateStudent(Long id, Student newStudent) {
        try (var session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            var student = session.find(Student.class, id);
            System.out.println(student);
            session.merge(newStudent);
            transaction.commit();
        }
    }

    public void deleteStudent(Long id) {
        try (var session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.remove(student);
            }
            transaction.commit();
        }
    }
}