package com.cybertek.services;


import com.cybertek.interfaces.Course;
import org.springframework.stereotype.Component;

public class Selenium implements Course {
    @Override
    public void getTeachingHours() {
        System.out.println("Selenium teaching" + 40);
    }
}
