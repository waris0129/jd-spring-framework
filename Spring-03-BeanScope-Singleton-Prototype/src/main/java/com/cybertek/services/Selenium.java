package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import lombok.Getter;
import lombok.Setter;


public class Selenium implements Course {

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : "+40);
    }
}
