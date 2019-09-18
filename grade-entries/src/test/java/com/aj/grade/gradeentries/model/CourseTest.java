//package com.aj.grade.gradeentries.model;
//
//import com.aj.grade.gradeentries.repository.CourseRepository;
//import com.aj.grade.gradeentries.repository.ProgramRepository;
//import com.aj.grade.gradeentries.repository.ScetionRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.transaction.Transactional;
//import java.util.Optional;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class CourseTest {
//    @Autowired
//    private CourseRepository courseRepository;
//    @Autowired
//    private ScetionRepository scetionRepository;
//    @Autowired
//    private ProgramRepository programRepository;
//
//    @Test
//    @Transactional
//    public  void save(){
//
//          //Program program = programRepository.getOne("EEE");
//          Course course = courseRepository.getOne("ACT102");
//          Section section = new Section(course,"ABC",2,25,51);
//          section.setSectionID(section.getCourse().getCode()+"."+section.getSection_number()+"."+section.getSemester_id());
////         program.addCousrse(course);
//         course.addSection(section);
//         courseRepository.save(course);
//         scetionRepository.save(section);
//         System.out.println(course);
//
//    }
//
//}