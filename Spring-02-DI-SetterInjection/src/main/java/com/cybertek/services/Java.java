package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;

public class Java implements Course {

    private OfficeHours officeHours;

    public OfficeHours getOfficeHours() {// getter constructor
        return officeHours;
    }

    // setter constructor
    public void setOfficeHours(OfficeHours officeHours){ // spring parse setOfficeHours as set + officeHours
        this.officeHours = officeHours;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : "+ 20+officeHours.getHours());
    }
}
