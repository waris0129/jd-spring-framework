package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    @Autowired // Feild injection
    private ExtraSessions extraSessions;

//    @Autowired  // anotation used for Constructor injection : OfficeHour object inject into Java class
//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }

//    @Autowired // annotation used for Setter Injection
//    public void setOfficeHours(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }

    @Override
    public void getTeachingHours() {
        System.out.println("Java : Weekly teaching hours :" + (20 + extraSessions.getHours()));
    }
}
