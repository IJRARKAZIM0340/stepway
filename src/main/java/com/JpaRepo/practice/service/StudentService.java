package com.JpaRepo.practice.service;

import com.JpaRepo.practice.dto.StudentDTO;
import com.JpaRepo.practice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.JpaRepo.practice.repository.StudentRepository;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public String addStudent(StudentDTO studentDTO){
        Student student = Student.builder()
                .name(studentDTO.getName())
                .city(studentDTO.getCity())
                .contact(studentDTO.getContact())
                .build();
        studentRepository.save(student);
        return "OK";
    }

    public Student getStudent(Long id){
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    public String updateStudent(StudentDTO studentDTO){
        Optional<Student> student = studentRepository.findById(studentDTO.getId());
        if(student.get() == null) {
            return "Student Not found";
        } else {
            studentRepository.save(Student.builder()
                    .id(studentDTO.getId())
                    .name(studentDTO.getName())
                    .city(studentDTO.getCity())
                    .contact(studentDTO.getContact())
                    .build());
            return "Saved";
        }
    }
}
