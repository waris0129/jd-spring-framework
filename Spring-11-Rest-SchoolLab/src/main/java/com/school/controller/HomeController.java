package com.school.controller;

import com.school.Repository.AddressRepository;
import com.school.Repository.ParentRepository;
import com.school.Repository.StudentRepository;
import com.school.Repository.TeacherRepository;
import com.school.entity.Address;
import com.school.entity.ResponseWrapper;
import com.school.entity.Student;
import com.school.entity.Teacher;
import com.school.entity.config.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private RestTemplate restTemplate;

    private final String URI = "http://api.weatherstack.com/current?access_key=02a009b8e3922c395677a1e85406aca6&query=";




    @GetMapping("/teacher")
    public List<Teacher> readAllTeachers(){
        return teacherRepository.findAll();
    }

    @GetMapping("/student")
    public ResponseEntity<ResponseWrapper> readAllStudent(){

        return ResponseEntity
                .ok(
                        new ResponseWrapper(
                                "students are retrieved successful.",
                                studentRepository.findAll()));
    }



    @GetMapping("/parent")
    public ResponseEntity<ResponseWrapper> readAllParents(){
        ResponseWrapper responseWrapper = new ResponseWrapper(
                true,
                "Parents are successfully retrieved",
                HttpStatus.ACCEPTED.value(),
                parentRepository.findAll());

        return ResponseEntity.status(HttpStatus.CREATED).body(responseWrapper);
    }


    @GetMapping("/address")
    public ResponseEntity<List<Address>> readAllAddress(){

        List<Address> list = addressRepository.findAll();

        list.forEach(address -> {
            String city = address.getCity();
            Temperature temp = getTemperature(city);
            Integer _temp = temp.current.getTemperature();
            address.setCurrentTemperature(_temp);
        });

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{city}")
    public Temperature getTemperature(@PathVariable("city") String city){

        final String URL = URI+"/{city}";


        return restTemplate.getForObject(URL,Temperature.class,city);
    }






}



