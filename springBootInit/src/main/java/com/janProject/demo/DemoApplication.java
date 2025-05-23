package com.janProject.demo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//run return IoC container
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		Dev d = context.getBean(Dev.class); //getting Dev object
		d.build();
	}

}
