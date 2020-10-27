package com.cybertek.config;

import com.cybertek.interfaces.ExtraSession;
import com.cybertek.services.Java;
import com.cybertek.services.OfficeHours;
import com.cybertek.services.Selenium;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.cybertek")
@PropertySource("classpath:application.properties")
public class CybertekAppConfig {

    @Bean
    public Java java(){
        return new Java(extraSession(new OfficeHours()));
    }

    @Bean // method level to create Object
    public Selenium selenium(){
        return new Selenium();
    }


    public OfficeHours officeHours(){
        return new OfficeHours();
    }


    public ExtraSession extraSession(ExtraSession extraSession){
        return extraSession;
    }


}
