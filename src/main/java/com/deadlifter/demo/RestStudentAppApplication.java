package com.deadlifter.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.deadlifter.controller", "com.deadlifter.service"})
@EntityScan({"com.deadlifter.entity"})
@EnableJpaRepositories({"com.deadlifter.repository"})
public class RestStudentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestStudentAppApplication.class, args);
	}

}
