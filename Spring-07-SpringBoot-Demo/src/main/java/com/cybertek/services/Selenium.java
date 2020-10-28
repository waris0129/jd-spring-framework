package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Selenium implements Course {

    private ExtraSession extraSession;

    public Selenium(ExtraSession extraSession) {
        this.extraSession = extraSession;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Selenium Teaching Hours: "+(10+extraSession.getHour(25)));
    }
}
