package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    @Autowired
    private ExtraSession extraSession;

    @Override
    public void getTeachingHours() {
        System.out.println("Java Teaching Hours: "+ (20+extraSession.getHour(20)));
    }
}
