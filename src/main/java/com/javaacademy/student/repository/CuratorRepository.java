package com.javaacademy.student.repository;

import com.javaacademy.student.entity.Curator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuratorRepository extends JpaRepository<Curator, Integer> {
}
