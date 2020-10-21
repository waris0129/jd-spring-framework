package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Selenium implements Course {

    private ExtraSessions extraSessions; // this is time we use Interface ExtraSession


    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : "+40+getExtraSessions().getHours());
    }
}
