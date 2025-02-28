package com.javaacademy.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FacultyDto {
    private Integer id;
    private String name;
    private Integer number;
}
