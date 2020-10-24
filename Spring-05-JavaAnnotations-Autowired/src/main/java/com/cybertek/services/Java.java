package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    private OfficeHours officeHours;

    @Override
    public void getTeachingHours() {
        System.out.println("Java : Weekly teaching hours :" + 20 + officeHours.getHours());
    }
}
