package com.sidintravel.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
@ComponentScan({ "com.sidintravel.controller" })
@EnableAutoConfiguration(exclude = { ErrorMvcAutoConfiguration.class })
public class SidinTravelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SidinTravelApplication.class, args);
	}

}
