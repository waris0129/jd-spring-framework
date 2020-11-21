package com.cybertek.controller;

import com.cybertek.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/welcome")
    public String homePage(Model model) {

        model.addAttribute("name", "Waris");

        model.addAttribute("course", "Java Developer");

        String subject = "Collection";

        model.addAttribute("subject", subject);

        // create some random studentId (0-100) and show it in your url

        int studentId = new Random().nextInt(1000);
        model.addAttribute("id", studentId);

        // try some collection

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        model.addAttribute("numbers", numbers);


        // print your birthday

        var birthYear = LocalDate.now().minusYears(36);

        model.addAttribute("birthYear", birthYear);


        // create Student class object
        Student student = new Student(1, "Mike", "Smith");
        model.addAttribute("student", student);


        return "student/welcome";
    }

    @GetMapping("/register")
    public String homePage2() {

        return "student/register";
    }

}
