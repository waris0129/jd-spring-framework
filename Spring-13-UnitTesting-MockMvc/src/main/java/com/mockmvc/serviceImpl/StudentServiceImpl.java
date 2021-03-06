package com.mockmvc.serviceImpl;

import com.mockmvc.entity.Student;
import com.mockmvc.repository.StudentRepository;
import com.mockmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getStudent_data() {
        return studentRepository.findAll();
    }
}
