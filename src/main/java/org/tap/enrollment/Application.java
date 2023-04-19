package org.tap.enrollment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication                                     // This annotation enables Swagger integration in the Spring Boot application
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}