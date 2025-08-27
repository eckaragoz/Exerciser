package com.eck.exerciser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.eck.exerciser")
public class ExerciserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExerciserApplication.class, args);
	}

}
