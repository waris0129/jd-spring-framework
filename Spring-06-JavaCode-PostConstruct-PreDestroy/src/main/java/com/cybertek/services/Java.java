package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Java implements Course {
    @Override
    public void getTeachingHours() {
        System.out.println("Java teaching hours :"+ 20);
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("executing post constructor");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("executing pre destroy");
    }


}
