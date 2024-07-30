package com.JpaRepo.practice.service;

import com.JpaRepo.practice.dto.StudentDTO;
import com.JpaRepo.practice.dto.TeacherDTO;
import com.JpaRepo.practice.model.Student;
import com.JpaRepo.practice.model.Teacher;
import com.JpaRepo.practice.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    public String addteacher(TeacherDTO teacherDTO){
        Teacher teacher = Teacher.builder()
                .tName(teacherDTO.getTName())
                .city(teacherDTO.getCity())
                .contact(teacherDTO.getContact())
                .build();
        teacherRepository.save(teacher);
        return "added successfully";
    }
    public Teacher getTeacher(Long id){
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.get();
    }


    public String updateTeacher(TeacherDTO teacherDTO) {
        Optional<Teacher> teacher = teacherRepository.findById(teacherDTO.getId());
        if(teacher.get() == null) {
            return "Teacher Not found";
        } else {
           teacherRepository.save(Teacher.builder()
                    .tid(teacherDTO.getId())
                    .tName(teacherDTO.getTName())
                    .city(teacherDTO.getCity())
                    .contact(teacherDTO.getContact())
                    .build());
            return "Saved";
        }
    }
}
