package se.iths.service;


import se.iths.entity.Student;
import se.iths.repositories.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StudentService implements StudentRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Student> getAllStudents() {
        return entityManager.createQuery("SELECT s from Student s", Student.class).getResultList();
    }

    @Override
    public Student findStudentById(Long id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public void createStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    public String deleteStudent(Long id) {
        Student findStudent = entityManager.find(Student.class, id);
        entityManager.remove(findStudent);
        return "Student with " + id + " is removed from the database!:)";
    }
}
