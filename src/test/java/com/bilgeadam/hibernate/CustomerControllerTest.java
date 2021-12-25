package com.bilgeadam.hibernate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CustomerControllerTest {
    private CustomerController controller;

    @BeforeEach
    void setUp() {
        controller = new CustomerController();
    }

    @Test
    void addCustomer() {
        Customer customer = new Customer();
        customer.setName("Hibernate");

        controller.addCustomer(customer);
    }
}