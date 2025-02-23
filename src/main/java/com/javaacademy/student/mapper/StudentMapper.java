package com.javaacademy.student.mapper;

import com.javaacademy.student.dto.StudentDto;
import com.javaacademy.student.entity.Course;
import com.javaacademy.student.entity.Curator;
import com.javaacademy.student.entity.Faculty;
import com.javaacademy.student.entity.Student;
import com.javaacademy.student.repository.CourseRepository;
import com.javaacademy.student.repository.CuratorRepository;
import com.javaacademy.student.repository.FacultyRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class StudentMapper {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CuratorRepository curatorRepository;
    @Autowired
    private FacultyRepository facultyRepository;

    //@Mapping(target = "faculty", source = "facultyId", qualifiedByName = "getFacultyById")
    //@Mapping(target = "curator", source = "curator")
    //@Mapping(target = "courses", source = "courseIds", qualifiedByName = "getCoursesByIds")
    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "name", source = "dto.name")
    public abstract Student toEntity(StudentDto dto, Curator curator, Faculty faculty, List<Course> courses);

    public abstract List<Student> toEntities(List<StudentDto> dtos);

    @Named("getFacultyById")
    protected Faculty getFacultyById(Integer id) {
        return facultyRepository.findById(id).orElseThrow();
    }

    @Named("getCuratorById")
    protected Curator getCuratorById(Integer id) {
        return curatorRepository.findById(id).orElseThrow();
    }

    @Named("getCoursesByIds")
    protected List<Course> getCoursesByIds(List<Integer> courseIds) {
        return courseRepository.findAllById(courseIds);
    }
}
