package com.addmission.server.controller;

import com.addmission.server.exception.ResourceAlreadyExistException;
import com.addmission.server.exception.ResourceNotFoundException;
import com.addmission.server.model.Student;
import com.addmission.server.repository.StudentRepository;
import com.addmission.server.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public ResponseEntity<List<Student>> findall() {
        List<Student> list = studentService.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Student> insert(@RequestBody Student student) {
        try {
            Student insertStudent = studentService.create(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(insertStudent);
        } catch (ResourceAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findBYid(@PathVariable long id) {
        try {
            Student student = studentService.findById(id);
            return ResponseEntity.ok(student);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student student) {

        try {
            Student updateStudent = studentService.updateStudent(id, student);
            return ResponseEntity.ok(student);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/findbyprogram/{program}")
    public ResponseEntity<List<Student>> findStudentByProgram(@PathVariable String program) {
        try {
            List<Student> studentslist = studentService.findDistinctByProgram(program);

            return ResponseEntity.ok(studentslist);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
