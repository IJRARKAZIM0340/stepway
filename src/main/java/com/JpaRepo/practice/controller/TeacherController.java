package com.JpaRepo.practice.controller;

import com.JpaRepo.practice.dto.TeacherDTO;
import com.JpaRepo.practice.model.Student;
import com.JpaRepo.practice.model.Teacher;
import com.JpaRepo.practice.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherservice;

    @PostMapping("/add")
    public ResponseEntity<String> addTeacher(@RequestBody TeacherDTO teacherDTO){
        String message = teacherservice.addteacher(teacherDTO);
        return ResponseEntity.ok(message);
    }
    @PutMapping("/update")
    public String updateTeacher(@RequestBody TeacherDTO teacherDTO){
        String message = teacherservice.updateTeacher(teacherDTO);
        return message;
    }
}

