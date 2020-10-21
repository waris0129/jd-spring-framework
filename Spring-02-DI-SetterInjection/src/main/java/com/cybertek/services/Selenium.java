package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import lombok.Data;
import lombok.Setter;

@Setter
public class Selenium implements Course {

    private ExtraSessions extraSessions; // this is time we use Interface ExtraSession


    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : 40");
    }
}
