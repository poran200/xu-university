package com.aj.grade.gradeentries.model;

import com.aj.grade.gradeentries.repository.CourseRepository;
import com.aj.grade.gradeentries.repository.ProgramRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProgramTest {
    @Autowired
    private ProgramRepository programRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Test
    //@Transactional
    public void save() {
        Program program = programRepository.getOne("EEE");
        System.out.println(program);
//        List<Course> courses = new ArrayList<>();
//
        Course course = new Course("ACT103", "introduction a c t", 3, "EEE");
        program.addCousrse(course);

        programRepository.save(program);
        courseRepository.save(course);
        System.out.println(programRepository.save(program));
    }

}