package com.aj.grade.gradeentries.services;

import com.aj.grade.gradeentries.model.Student;
import com.aj.grade.gradeentries.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StudentinfoService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> studentsinfo() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Student>> responseEntity = restTemplate.exchange(
                "http://localhost:8081/api/v1/students", HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Student>>() {
                });
        List<Student> students = responseEntity.getBody();
        students.stream().forEach(student -> studentRepository.save(new Student(student.getId(), student.getName())));
        return students;
    }
}
