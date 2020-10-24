package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class Api implements Course {
    @Override
    public void getTeachingHours() {
        System.out.println("API: Weekly Teaching Hours :" + 40);
    }
}
