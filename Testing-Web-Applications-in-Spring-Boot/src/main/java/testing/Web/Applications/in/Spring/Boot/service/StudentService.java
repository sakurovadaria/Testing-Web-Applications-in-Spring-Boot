package testing.Web.Applications.in.Spring.Boot.service;

import testing.Web.Applications.in.Spring.Boot.model.Student;

import java.util.Collection;

public interface StudentService {
    Student getStudent(Long id);

    Student createStudent(Student student);

    Student updateStudent(Long id, Student student);

    void removeStudent(Long id);


    Collection<Student> getAllStudents();
}

