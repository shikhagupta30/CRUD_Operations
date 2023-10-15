package com.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoProjectApplication.class, args);
		System.out.println("Server started at PORT 8088");
	}

}
