package com.cybertek.servcies;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;

public class Java implements Course {

    ExtraSessions extraSessions; // this is a denpendency class, it must inject object

    public Java(ExtraSessions extraSessions) { // Important , we implement Interface and abstract method
        this.extraSessions= extraSessions;
    }
    // java class dependencies for OfficeHours class


    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : "+ 20 + extraSessions.getHours());
    }
}
