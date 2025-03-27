package testing.Web.Applications.in.Spring.Boot.repository;

import testing.Web.Applications.in.Spring.Boot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByAgeBetween(Integer min, Integer max);
}
