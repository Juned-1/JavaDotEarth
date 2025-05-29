package com.SpringWithoutBootDemo.SpringApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	//Getting IoC container 
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    	
    	//Dev obj = context.getBean(Dev.class);
    	Dev obj = (Dev)context.getBean("dev");
    	//System.out.println(obj.getAge());
    	obj.build();
    }
}
