package models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDAO {

    public void createStudent(Student student) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.persist(student);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            System.err.println("Error creating student: " + e.getMessage());
        }
    }

    public Student readStudent(int id) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                return session.get(Student.class, id);
            }
        } catch (Exception e) {
            System.err.println("Error reading student: " + e.getMessage());
            return null;
        }
    }

    public void updateStudent(int id, String name, String lastName, int age) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                Student student = session.get(Student.class, id);

                if (student != null) {
                    student.setName(name);
                    student.setLastname(lastName);
                    student.setAge(age);

                    session.beginTransaction();
                    session.update(student);
                    session.getTransaction().commit();
                    System.out.println("Student with ID " + id + " updated successfully.");
                } else {
                    System.out.println("Student with ID " + id + " not found. Update operation aborted.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error updating student: " + e.getMessage());
        }
    }

    public void deleteStudent(int id) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                Student student = session.get(Student.class, id);

                if (student != null) {
                    session.beginTransaction();
                    session.delete(student);
                    session.getTransaction().commit();
                    System.out.println("Student with ID " + id + " deleted successfully.");
                } else {
                    System.out.println("Student with ID " + id + " not found.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error deleting student: " + e.getMessage());
        }
    }
}
