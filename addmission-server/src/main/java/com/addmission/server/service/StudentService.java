package com.addmission.server.service;

import com.addmission.server.exception.ResourceAlreadyExistException;
import com.addmission.server.exception.ResourceNotFoundException;
import com.addmission.server.model.Student;
import com.addmission.server.repository.StudentRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RepositoryRestResource
public class StudentService {


    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student create(Student student) throws ResourceAlreadyExistException {
        Optional<Student> student1 = studentRepository.findById(student.getId());
        if (student1.isPresent()) {
            throw new ResourceAlreadyExistException(student.getId() + "");
        } else {
            return studentRepository.save(student);
        }
    }

    public void deleteStudent(long id) throws ResourceNotFoundException {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (!optionalStudent.isPresent()) {
            throw new ResourceNotFoundException(optionalStudent.get().getId() + "");
        } else {
            studentRepository.deleteById(id);
        }

    }

    public Student findById(long id) throws ResourceNotFoundException {
        Optional<Student> student = studentRepository.findById(id);
        if (!student.isPresent()) {
            throw new ResourceNotFoundException(student.get().getId() + "");
        }
        return student.get();
    }

    public List<Student> findbyname(String name) throws ResourceNotFoundException {
        List<Student> student = studentRepository.findByNameContains(name);
        if (student.isEmpty()) throw new ResourceNotFoundException(name + "");
        return student;
    }

    public Student updateStudent(long id, Student student) throws ResourceNotFoundException {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            student.setId(id);
            return studentRepository.save(student);
        } else {
            throw new ResourceNotFoundException(student.getId() + "");
        }
    }

    public List<Student> findDistinctByProgram(String program) throws ResourceNotFoundException {
        List<Student> list = studentRepository.findDistinctByProgram(program);
        if (list.isEmpty()) throw new ResourceNotFoundException(program);
        return list;
    }
}
