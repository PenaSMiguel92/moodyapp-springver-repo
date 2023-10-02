package com.moodyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.yml")
public class MoodyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoodyappApplication.class, args);
	}

}
