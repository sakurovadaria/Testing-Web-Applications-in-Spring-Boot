package testing.Web.Applications.in.Spring.Boot.service;

import testing.Web.Applications.in.Spring.Boot.model.Faculty;

public interface FacultyService {
    Faculty getFaculty(Long id);

    Faculty createFaculty(Faculty faculty);

    Faculty updateFaculty(Faculty faculty);

    void removeFaculty(Long id);
}
