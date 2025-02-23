package com.javaacademy.student.service;

import com.javaacademy.student.dto.StudentDto;
import com.javaacademy.student.entity.Course;
import com.javaacademy.student.entity.Curator;
import com.javaacademy.student.entity.Faculty;
import com.javaacademy.student.entity.Student;
import com.javaacademy.student.mapper.StudentMapper;
import com.javaacademy.student.repository.CourseRepository;
import com.javaacademy.student.repository.CuratorRepository;
import com.javaacademy.student.repository.FacultyRepository;
import com.javaacademy.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final FacultyRepository facultyRepository;
    private final CourseRepository courseRepository;
    private final CuratorRepository curatorRepository;

//    public void save(StudentDto studentDto) {
//        Student student = studentRepository.save(
//                studentMapper.toEntity(studentDto)
//        );
//        System.out.println();
//    }

    public void saveAll(List<StudentDto> dtoList) {
        List<Integer> facultiesId = dtoList.stream().map(e -> e.getFacultyId()).toList();
        Map<Integer, Faculty> facultyMap = facultyRepository.findAllById(facultiesId).stream()
                .collect(Collectors.toMap(Faculty::getId, e -> e));

        List<Integer> curatorsIds = dtoList.stream().map(e -> e.getCuratorId()).toList();
        Map<Integer, Curator> curatorMap = curatorRepository.findAllById(curatorsIds).stream()
                .collect(Collectors.toMap(Curator::getId, e -> e));

        List<Integer> courseIdsAll = dtoList.stream().flatMap(e -> e.getCourseIds().stream()).toList();
        Map<Integer, Course> coursesMap = courseRepository.findAllById(courseIdsAll).stream()
                .collect(Collectors.toMap(Course::getId, e -> e));

        List<Student> students = dtoList.stream()
                .map(dto -> studentMapper.toEntity(
                        dto,
                        curatorMap.get(dto.getCuratorId()),
                        facultyMap.get(dto.getFacultyId()),
                        getCoursesForStudent(dto, coursesMap)
                        )
                )
                .toList();
        studentRepository.saveAll(students);
    }

    private List<Course> getCoursesForStudent(StudentDto dto, Map<Integer, Course> coursesMap) {
        return dto.getCourseIds()
                .stream()
                .map(coursesMap::get)
                .toList();
    }
}
