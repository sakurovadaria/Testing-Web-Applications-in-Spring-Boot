package testing.Web.Applications.in.Spring.Boot.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import testing.Web.Applications.in.Spring.Boot.exception.FacultyNotFoundException;
import testing.Web.Applications.in.Spring.Boot.model.Faculty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import testing.Web.Applications.in.Spring.Boot.service.FacultyService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FacultyController.class)
public class FacultyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private FacultyService facultyService;



    @Test
    public void testGetFacultyById() throws Exception {

        Faculty faculty = new Faculty("Slytherin", "green");
        when(facultyService.getFaculty(anyLong())).thenReturn(faculty);

        mockMvc.perform(MockMvcRequestBuilders.get("/faculty/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.name").value("Slytherin"))
                .andExpect(jsonPath("$.color").value("green"));
    }

    @Test
    public void testGetFacultyByIdWhenFacultyNotExist() throws Exception {

        when(facultyService.getFaculty(anyLong())).thenThrow(FacultyNotFoundException.class);

        mockMvc.perform(MockMvcRequestBuilders.get("/faculty/1"))
                .andDo(print())


                .andExpect(status().isNotFound());

    }

    @Test
    public void testCreateFaculty() throws Exception{
        Faculty faculty = new Faculty("Slytherin", "green");
        when(facultyService.createFaculty(any(Faculty.class))).thenReturn(faculty);

        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(MockMvcRequestBuilders.post("/faculty")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(faculty)))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void testUpdateFaculty() throws Exception{
        Faculty faculty = new Faculty("Slytherin", "green");
        when(facultyService.updateFaculty(any(Faculty.class))).thenReturn(faculty);

        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(MockMvcRequestBuilders.post("/faculty")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(faculty)))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void testDeleteFaculty() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/faculty/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
