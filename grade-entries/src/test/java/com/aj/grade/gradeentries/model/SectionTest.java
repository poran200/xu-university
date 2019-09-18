package com.aj.grade.gradeentries.model;

import com.aj.grade.gradeentries.repository.ScetionRepository;
import com.aj.grade.gradeentries.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SectionTest {
    @Autowired
    private ScetionRepository scetionRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Test

    @Transactional
    public void addStudent() {
        Section section = scetionRepository.getOne("ACT102.8.50");
        //  Student student = new Student(102,"jalal");
        Student student1 = new Student(103, "poran");
//      section.addStudent(student);
//      section.addStudent(student1);
        section.addStudent(student1);
        // studentRepository.save(student);
        // studentRepository.save(student1);
        scetionRepository.save(section);
        assert section != null;
        System.out.println(section);

    }
}