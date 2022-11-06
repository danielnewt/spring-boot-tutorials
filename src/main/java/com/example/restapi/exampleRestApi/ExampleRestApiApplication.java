package com.example.restapi.exampleRestApi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ExampleRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleRestApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return args -> {
			System.out.println("Beans provided by Spring Boot:");

			var beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);

			for(var beanName : beanNames){
				System.out.println(beanName);
			}
		};
	}
}
