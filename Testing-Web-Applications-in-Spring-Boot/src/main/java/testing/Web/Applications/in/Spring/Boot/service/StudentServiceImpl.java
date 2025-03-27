package testing.Web.Applications.in.Spring.Boot.service;

import testing.Web.Applications.in.Spring.Boot.exception.StudentNotFoundException;
import testing.Web.Applications.in.Spring.Boot.model.Student;
import org.springframework.stereotype.Service;
import testing.Web.Applications.in.Spring.Boot.repository.StudentRepository;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException("Студент не найден"));
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Студент не найден"));

        existingStudent.setAge(student.getAge());
        existingStudent.setName(student.getName());

        return studentRepository.save(existingStudent);
    }


    @Override
    public void removeStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
