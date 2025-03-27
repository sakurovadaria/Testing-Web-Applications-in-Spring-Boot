package testing.Web.Applications.in.Spring.Boot.repository;

import testing.Web.Applications.in.Spring.Boot.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    List<Faculty> findByColorIgnoreCaseOrNameIgnoreCase(String color, String name);
}

