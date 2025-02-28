package com.javaacademy.student.repository;

import com.javaacademy.student.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Page<Student> findAllByName(String name, Pageable pageable);
}
