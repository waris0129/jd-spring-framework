package com.cybertek.services;

import com.cybertek.interfaces.Course;

public class Java implements Course {


    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : "+ 20);
    }

    public void myInitMethod(){
        System.out.println("Executing my Init Method");
    }

    public void myDestroyMethod(){
        System.out.println("Executing my Destroy Method");
    }



}
