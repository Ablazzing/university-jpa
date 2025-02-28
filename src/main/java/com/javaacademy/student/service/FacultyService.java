package com.javaacademy.student.service;

import com.javaacademy.student.dto.FacultyDto;
import com.javaacademy.student.entity.Faculty;
import com.javaacademy.student.mapper.FacultyMapper;
import com.javaacademy.student.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacultyService {
    private final FacultyRepository facultyRepository;
    private final FacultyMapper facultyMapper;

    public void create(String facultyName) {
        Faculty faculty = new Faculty(facultyName);
        facultyRepository.save(faculty);
    }

    public void update(FacultyDto facultyDto) {
        Faculty newFaculty = facultyMapper.toEntity(facultyDto);
        Faculty oldFaculty = facultyRepository.findById(facultyDto.getId()).orElseThrow();

        facultyMapper.update(newFaculty, oldFaculty);
        facultyRepository.save(oldFaculty);
    }
}
