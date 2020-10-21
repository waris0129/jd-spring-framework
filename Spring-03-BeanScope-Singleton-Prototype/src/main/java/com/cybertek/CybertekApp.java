package com.cybertek;

import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {


    public static void main(String[] args) {

        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Course selenium1 = container.getBean("selenium",Course.class);
        Course selenium2 = container.getBean("selenium",Course.class);

        // Singleton
        System.out.println(selenium1);
        // hashcode of object: com.cybertek.services.Selenium@11c20519
        System.out.println(selenium1==selenium2); // singleton
        // course 1 and course 2 are reference of one object


        // Prototype Java class
        Course java1 = container.getBean("java",Course.class);
        Course java2 = container.getBean("java",Course.class);

        System.out.println(java1);//com.cybertek.services.Java@70beb599
        System.out.println(java2);//com.cybertek.services.Java@4e41089d

        System.out.println(java1 == java2); // false
        // java1 and java2 are pointed out different object, so it is false statement

        /*
         Remark : most importantly there there are 3 beans
            - Selenium --> selenium1 and selenium2
            - Java --> java1
            - Java --> java2
         */


    }


}



