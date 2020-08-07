package com.nagarro.nsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NsysApplication {

	public static void main(String[] args) {
		SpringApplication.run(NsysApplication.class, args);
	}

}
