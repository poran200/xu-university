package com.addmission.server.repository;

import com.addmission.server.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByNameContains(String name);

    List<Student> findDistinctByProgram(String program);

}
