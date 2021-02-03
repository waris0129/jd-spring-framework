package com.school.controller;

import com.school.Repository.AddressRepository;
import com.school.Repository.ParentRepository;
import com.school.Repository.StudentRepository;
import com.school.entity.Address;
import com.school.entity.ResponseWrapper;
import com.school.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("rest")
public class RestTemplateController {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/address/{id}")
    public Address getAddress(@PathVariable("id") Integer id){

        Address address = addressRepository.findById(id).get();

        address.setCurrentTemperature(address.getTemperature());

        addressRepository.save(address);

        return address;

    }

    @GetMapping("address")
    public List<Address> readAllAddress(){
        List<Address> list = addressRepository.findAll();

        list.forEach(p->p.setCurrentTemperature(p.getTemperature()));

        return list;
    }

    @PostMapping("address/add")
    public ResponseEntity<ResponseWrapper> addAddress(@RequestBody Address address){

        address.setCurrentTemperature(address.getTemperature());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseWrapper("new address is added successfully",addressRepository.save(address)));
    }


    @PutMapping("updateTemp")
    public ResponseEntity<ResponseWrapper> updateTemp(){

        List<Address> list = addressRepository.findAll();

        list.forEach(p->{
            p.setCurrentTemperature(p.getTemperature());
            addressRepository.save(p);
        });



        return ResponseEntity.ok(new ResponseWrapper("temperature updated",list));
    }


    @GetMapping("parent")
    public ResponseEntity<ResponseWrapper> readAllParents(){
        return ResponseEntity.ok(new ResponseWrapper(parentRepository.findAll()));
    }


    @GetMapping("student")
    public ResponseEntity<List<Student>> readAllStudents(){

        List<Student> list = studentRepository.findAll();

        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity<ResponseWrapper> deleteAddress(@PathVariable("id") Integer id){

        addressRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseWrapper("sucessfully deleted"));
    }







}
