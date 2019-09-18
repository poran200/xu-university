package com.aj.grade.gradeentries.repository;

import com.aj.grade.gradeentries.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade,Long> {

    List<Grade> findAllByStudentIdContaining(long studentId);


}
