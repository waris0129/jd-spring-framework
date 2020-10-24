package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.stereotype.Component;

@Component // add java annotation
public class Java implements Course {


    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : "+ 20);
    }



}
