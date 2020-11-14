package com.cybertek.controller;

import com.cybertek.model.Gender;
import com.cybertek.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {


    @GetMapping("/list")
    public String test(Model model){

        List<Mentor> mentorList = new ArrayList<>();

        mentorList.add(new Mentor("Waris","Nigmat",36, Gender.MALE));
        mentorList.add(new Mentor("Gina","Mardan",36, Gender.FEMALE));
        mentorList.add(new Mentor("Sherlock","Waris",9, Gender.MALE));
        mentorList.add(new Mentor("Shahliye","Waris",4, Gender.FEMALE));
        model.addAttribute("mentorList",mentorList);



        return "mentor/mentor-list";
    }




}
