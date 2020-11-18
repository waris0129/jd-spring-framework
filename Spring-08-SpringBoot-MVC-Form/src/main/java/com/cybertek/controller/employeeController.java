package com.cybertek.controller;

import com.cybertek.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class employeeController {

    @GetMapping("/register")
    public String showForm(Model model){

        model.addAttribute("employee",new Employee());

        model.addAttribute("pageTitle","Employee Registration");

        model.addAttribute("pageName","Employee Registration Page");

        return "employee/employee-register";
    }

    @PostMapping("/new")
    public String addEmployee(@ModelAttribute("employee") Employee employee, Model model){

        model.addAttribute("pageTitle","Employee List");
        model.addAttribute("pageName","Employee List");



        System.out.println(employee.toString());

        return "employee/employee-list";
    }

}
