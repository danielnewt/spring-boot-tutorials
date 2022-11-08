package com.example.restapi.exampleRestApi.payroll.orders;

class OrderNotFoundException extends RuntimeException {

    OrderNotFoundException(Long id) {
        super("Could not find order " + id);
    }
}