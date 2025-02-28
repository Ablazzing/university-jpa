package com.javaacademy.student.repository;

import com.javaacademy.student.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

    Optional<Faculty> findFirstByName(String name);


}
