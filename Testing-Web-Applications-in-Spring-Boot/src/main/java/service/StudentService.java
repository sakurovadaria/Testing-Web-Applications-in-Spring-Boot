package service;

import model.Student;

import java.util.Collection;

public interface StudentService {
    Student getStudent(Long id);

    Student createStudent(Student student);

    Student updateStudent(Long id, Student student);

    void removeStudent(Long id);


    Collection<Student> getAllStudents();
}

