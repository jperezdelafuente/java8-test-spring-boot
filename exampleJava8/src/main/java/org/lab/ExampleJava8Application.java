package org.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "org.lab.service" })
public class ExampleJava8Application {

	public static void main(String[] args) {
		SpringApplication.run(ExampleJava8Application.class, args);
	}
}
