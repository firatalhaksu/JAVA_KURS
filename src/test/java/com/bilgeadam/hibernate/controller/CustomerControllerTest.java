package com.bilgeadam.hibernate.controller;

import com.bilgeadam.hibernate.entities.customers.Address;
import com.bilgeadam.hibernate.entities.customers.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

class CustomerControllerTest {
    CustomerController controller;

    private Customer c1;

    @BeforeEach
    void setUp() {
        controller = new CustomerController();
        c1 = generateCustomer();
        controller.addCustomer(c1);
    }

    @AfterEach
    void tearDown() {
        controller.deleteCustomer(c1.getID());
    }

    @Test
    void addCustomer() {

        Assertions.assertTrue(controller.addCustomer(c1));
    }

    @Test
    void testDeleteCustomer() {
        controller.deleteCustomer(c1.getID());
    }

    @Test
    void deleteCustomer() {
        controller.updateCustomerAddress(1,generateAddress());
        Assertions.assertTrue(controller.hardDeleteCustomer(c1.getID()));
        c1.getAddress();
    }

    @Test
    void updateCustomerAddress() {
        controller.updateCustomerAddress(1,generateAddress());
    }

    @ParameterizedTest
    @ValueSource (booleans = {true, false})
    void lazyAddressFetch(boolean includeAddress, boolean includeInactive){
        Address address = generateAddress();
        Assertions.assertTrue(controller.updateCustomerAddress(c1.getID(), address));

        Optional<Customer> response =  controller.getCustomer(c1.getID(), includeInactive, includeAddress);

        if (includeAddress)
            Assertions.assertNotNull(response.orElseThrow().getAddress());
        else {
//            Assertions.assertThrows(LazyInitializationException.class, () -> response.orElseThrow().getAddress());
//            Assertions.assertNull(response.orElseThrow().getAddress());
        }
    }


    private Customer generateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Bilge");
        customer.setLastName("Adam");

        return customer;
    }

    private Address generateAddress(){
        Address address = new Address();
        address.setCountry("Turkiye");
        address.setCity("Istanbul");
        address.setStreet("Kadikoy");
        address.setPostalCode(34999);

        return address;
    }


}