package se.iths.validations;

import se.iths.entity.Student;
import se.iths.exceptions.StudentException;

import java.util.List;

public abstract class StudentValidation {


    public static void checkEmailValidity(List<Student> students, String email) {
        for (Student s : students) {
            if (s.getEmail().equals(email)) {
                throw new StudentException("email already exists");
            }
        }
    }

    public static void checkIfStudentExist(Long id, Student studentToFind) {
        if (studentToFind == null) {
            throw new StudentException("Student with ID: " + id + " do not exist, please try another one!");
        }
    }

    public static void nullValidation(Student student) {
        if (student.getFirstname().isEmpty())
            throw new StudentException("Firstname is required and can not be empty!");
        else if (student.getLastname().isEmpty()) {
            throw new StudentException("Lastname is required and can not be empty!");
        } else if (student.getEmail().isEmpty()) {
            throw new StudentException("Email is required and can not be empty!");
        }

    }
}

