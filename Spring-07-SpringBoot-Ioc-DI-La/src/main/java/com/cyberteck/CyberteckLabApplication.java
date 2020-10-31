package com.cyberteck;

import com.cyberteck.calculator.Calculator;
import com.cyberteck.enums.City;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CyberteckLabApplication {

	public static void main(String[] args){

	  ApplicationContext context = SpringApplication.run(CyberteckLabApplication.class, args);

		Calculator calculator = context.getBean("calculator", Calculator.class);

		System.out.println(calculator.getTotalCarpetCost(City.AUSTIN));


	}

}
