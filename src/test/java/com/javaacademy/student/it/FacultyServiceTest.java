package com.javaacademy.student.it;

import com.javaacademy.student.dto.FacultyDto;
import com.javaacademy.student.entity.Faculty;
import com.javaacademy.student.repository.FacultyRepository;
import com.javaacademy.student.service.FacultyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

@Sql(value = "classpath:test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
@Sql(value = "classpath:clear-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_CLASS)
public class FacultyServiceTest extends AbstractIntegrationTest {
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private FacultyRepository facultyRepository;

    @Test
    public void createFaculty() {
        Assertions.assertEquals(1, facultyRepository.findAll().size());

        facultyService.create("Economic");
        Faculty faculty = facultyRepository.findFirstByName("Economic").orElseThrow();
        Assertions.assertEquals("Economic", faculty.getName());


        FacultyDto facultyDto = new FacultyDto(faculty.getId(), "Historic",1);
        facultyService.update(facultyDto);
    }
}
