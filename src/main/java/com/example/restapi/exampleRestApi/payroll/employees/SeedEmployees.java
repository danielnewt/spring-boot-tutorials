package com.example.restapi.exampleRestApi.payroll.employees;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SeedEmployees {

    private static final Logger log = LoggerFactory.getLogger(SeedEmployees.class);

    @Bean
    CommandLineRunner seedEmployeeData(EmployeeRepository repository) {
        return args -> {
            if(repository.count() > 0)
                return;

            repository.save(new Employee("Bilbo", "Baggins", "burglar"));
            repository.save(new Employee("Frodo", "Baggins", "thief"));

            repository.findAll().forEach(employee -> log.info("Preloaded " + employee));
        };
    }
}
