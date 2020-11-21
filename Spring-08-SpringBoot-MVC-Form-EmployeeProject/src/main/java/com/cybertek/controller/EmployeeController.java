package com.cybertek.controller;


import com.cybertek.dataGenerator.DataGenerator;
import com.cybertek.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/register")
    public String employeeCreate(Model model){

        model.addAttribute("employee",new Employee());

        List<String>stateList = DataGenerator.getStateList();

        model.addAttribute("stateList",stateList);

        return "/employee/employee-register";
    }

    @PostMapping("/list")
    public String list(@ModelAttribute("employee") Employee employee, Model model){

        int birthYear = LocalDate.now().getYear()-LocalDate.parse(employee.getBirthday()).getYear();

        model.addAttribute("age",birthYear);


        model.addAttribute("employeeList",Arrays.asList(employee));

        return "/employee/employee-list";
    }

}
