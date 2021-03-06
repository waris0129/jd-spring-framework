package com.mockmvc.controller;

import com.mockmvc.entity.Student;
import com.mockmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/student")
    List<Student> getStudent_data(){
        return studentService.getStudent_data();
    }

}
