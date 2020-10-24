package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component // add java annotation
public class Java implements Course {
    @Value("JD1")
    private String batch;

    @Value("${instructor}") // ${instructor} become a variable
    private String instructor;

    @Value("${days}") // filed to be injected as array
    private String[] days;



    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : "+ 20);
    }

    @Override
    public String toString() {
        return "Java{" +
                "batch='" + batch + '\'' +
                ", instructor='" + instructor + '\'' +
                ", days=" + Arrays.toString(days) +
                '}';
    }
}
