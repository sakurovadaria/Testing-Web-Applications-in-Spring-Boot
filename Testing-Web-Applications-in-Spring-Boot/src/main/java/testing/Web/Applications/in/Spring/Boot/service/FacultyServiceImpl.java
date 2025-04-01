package testing.Web.Applications.in.Spring.Boot.service;

import testing.Web.Applications.in.Spring.Boot.exception.StudentNotFoundException;
import testing.Web.Applications.in.Spring.Boot.model.Faculty;
import org.springframework.stereotype.Service;
import testing.Web.Applications.in.Spring.Boot.repository.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService{


    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    @Override
    public Faculty getFaculty(Long id) {
        return facultyRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException("Факультет не найден"));
    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public void removeFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
}