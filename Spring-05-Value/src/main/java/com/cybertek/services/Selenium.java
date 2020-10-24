package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.stereotype.Component;

@Component // the Annotation creates bean for me
public class Selenium implements Course {

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : "+40);
    }
}
