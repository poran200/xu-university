package com.addmission.server.controller;

import com.addmission.server.model.Student;
import com.addmission.server.repository.StudentRepository;
import com.addmission.server.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentControllerTest {

    public StudentControllerTest() {
    }

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void findstudentbyid() {
        Optional<Student> student = studentRepository.findById(20171L);
        System.out.println(student.get().getAddresses());
    }
}