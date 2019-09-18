package com.aj.grade.gradeentries.repository;

import com.aj.grade.gradeentries.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {


}
