package com.aj.grade.gradeentries.services;

import com.aj.grade.gradeentries.exception.ResourceAlreadyExistException;
import com.aj.grade.gradeentries.exception.ResourseNotFoundException;
import com.aj.grade.gradeentries.exception.ScetionFullException;
import com.aj.grade.gradeentries.model.Section;
import com.aj.grade.gradeentries.model.Student;
import com.aj.grade.gradeentries.repository.ScetionRepository;
import com.aj.grade.gradeentries.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentRegService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ScetionRepository scetionRepository;

    public List<Student> findallStudent() {
        return studentRepository.findAll();
    }


    public Student create(Student student) throws ResourceAlreadyExistException {
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        if (optionalStudent.isPresent()) {
            throw new ResourceAlreadyExistException(optionalStudent.get().getId() + "");
        }
        return studentRepository.save(student);
    }


    public List<Section> findById(long id) throws ResourseNotFoundException {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get().getSections();
        } else {
            throw new ResourseNotFoundException(id + "");
        }
    }

    public Student registrationStudent(String sectionId, Student student) throws ResourseNotFoundException, ScetionFullException, ResourceAlreadyExistException {

        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        Section section = this.scetionRepository.getOne(sectionId);
        if (section == null) throw new ResourseNotFoundException(sectionId + "");
        if (section.getStudents().size() <= section.getCapacity()) {
            if (!optionalStudent.isPresent()) {
                Student student1 = create(student);
                section.addStudent(student1);
                scetionRepository.save(section);
            } else {
                section.addStudent(optionalStudent.get());
                scetionRepository.save(section);
            }
        } else {
            throw new ScetionFullException(sectionId + "");
        }

        return studentRepository.findById(student.getId()).get();

//          student = new Student(student.getId(),student.getName());
//          Section section= this.scetionRepository.getOne(sectionId);
//          section.addStudent(student);
//          scetionRepository.save(section);

        // return   studentRepository.findById(student.getId()).get();


    }

    public String dropScetion(String scetionId, Student student) {
        student = studentRepository.getOne(student.getId());
        Section scetion = scetionRepository.getOne(scetionId);
        student.getSections().remove(scetion);
        return "section droped";
    }


}
