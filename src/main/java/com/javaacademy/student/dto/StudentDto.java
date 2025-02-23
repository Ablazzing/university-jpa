package com.javaacademy.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentDto {
    private Integer id;
    private String name;
    private Integer facultyId;
    private Integer curatorId;
    private List<Integer> courseIds;
}
