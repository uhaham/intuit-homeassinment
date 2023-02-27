package com.example.homeassignment.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.homeassignment.crm", "com.example.homeassignment.dataingestion"})
public class HomeassignmentApplication {

	public static void main(String[] args) {
//		System.setProperty("server.servlet.context-path", "/fakeurl");
		SpringApplication.run(HomeassignmentApplication.class, args);
	}

}
