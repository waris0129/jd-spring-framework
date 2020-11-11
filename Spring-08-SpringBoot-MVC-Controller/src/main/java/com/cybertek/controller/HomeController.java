package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController { // create bean and form biz logic

    @RequestMapping("/") // localhost:8080
    public String getRequestMapping(){
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ozzy") // localhost:8080/ozzy
    public String getRequestMapping2(){
        return "home";
    }

    @RequestMapping("/cybertek") // localhost:8080/cybertek
    public String getRequestMapping3(){
        return "home";
    }

    @GetMapping("/spring")
    public String getMappingEx(){
        return "home";
    }

    @PostMapping("/spring")
    public String getPostMappingEx(){
        return "home";
    }

    @GetMapping("/home/{name}")
    public String getPathVaribelEX(@PathVariable("name") String name){
        System.out.println("name is " +name);
        return "home";
    }

    @GetMapping("/home/{name}/{email}")
    public String getPathVaribelEX2(@PathVariable("name") String name,@PathVariable("email") String email){
        System.out.println("name is " +name);
        System.out.println("email is " +email);
        return "home";
    }


    @GetMapping("/home/course")
    public String requestParamEx(@RequestParam("course") String course){
        System.out.println("course is "+course);
        return "home";
    }

    @GetMapping(value = "/course")
    public String requestParam2(@RequestParam(value = "course", required = false,defaultValue = "Cybertek") String name){
        System.out.println("name is "+name);
        return "home";
    }

}
