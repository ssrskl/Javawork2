package com.catjava.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.catjava.pojo.People;
import com.catjava.pojo.PeopleFactory;

public class Test {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		People people = applicationContext.getBean("people4",People.class);
		System.out.println(people);
		
		//People people2=PeopleFactory.newInstance2();
	}
}
