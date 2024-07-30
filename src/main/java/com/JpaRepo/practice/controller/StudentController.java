package com.JpaRepo.practice.controller;

import com.JpaRepo.practice.dto.StudentDTO;
import com.JpaRepo.practice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.JpaRepo.practice.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    //To Create
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentDTO studentDTO){
        String message = studentService.addStudent(studentDTO);
        return message;
    }

    @GetMapping("/get")
    public Student getStudent(@RequestParam("id") Long id){
        Student student = studentService.getStudent(id);
        return student;
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody StudentDTO studentDTO){
        String message = studentService.updateStudent(studentDTO);
        return message;
    }
}
