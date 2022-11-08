package com.example.restapi.exampleRestApi.payroll.orders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SeedOrders {

    private static final Logger log = LoggerFactory.getLogger(SeedOrders.class);

    @Bean
    CommandLineRunner seedOrderData(OrderRepository repository) {
        return args -> {
            if(repository.count() > 0)
                return;

            repository.save(new Order("MacBook Pro", Status.COMPLETED));
            repository.save(new Order("iPhone", Status.IN_PROGRESS));

            repository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });
        };
    }
}
