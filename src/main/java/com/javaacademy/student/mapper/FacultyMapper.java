package com.javaacademy.student.mapper;

import com.javaacademy.student.dto.FacultyDto;
import com.javaacademy.student.entity.Faculty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FacultyMapper {

    Faculty toEntity(FacultyDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "number", ignore = true)
    @Mapping(target = "students", ignore = true)
    void update(Faculty newFaculty, @MappingTarget Faculty oldFaculty);
}
