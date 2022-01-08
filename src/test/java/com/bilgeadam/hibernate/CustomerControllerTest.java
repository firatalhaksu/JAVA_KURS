package com.bilgeadam.hibernate;

import com.bilgeadam.hibernate.entity.Address;
import com.bilgeadam.hibernate.entity.Customer;
import org.hibernate.exception.DataException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerControllerTest {
    private CustomerController controller;
    private Customer customer;

    @BeforeEach
    void setUp() {
        controller = new CustomerController();
        customer = new Customer();
        customer.setName("Hibernate");
    }

    @Test
    void addCustomer() {
        Customer customer2 = new Customer();
        customer2.setName("Java");
        Address address = generateAddress();
        customer2.setAddress(address);
        address.setCustomer(customer2);

        controller.addCustomers(customer,customer2);
    }

    @Test
    void testDeleteRelation(){
        Address address = generateAddress();
        address.setCustomer(customer);
        customer.setAddress(address);
        controller.addCustomers(customer);

        controller.deleteCustomer(customer.getID());
    }

    @Test
    void addEmails(){
        customer.addEmail("asb@abc.com");
        customer.addEmail("asd@abc.com");
        controller.addCustomers(customer);
    }

    @Test
    void addEmailSeparately(){
        controller.addCustomers(customer);
        customer.addEmail("asb@abc.com");
        customer.setAddress(generateAddress());

        controller.addCustomers(customer);

        Customer c = controller.getCustomer(customer.getID(), true);
        Assertions.assertNotNull(c.getAddress());

        Assertions.assertFalse(c.getEmails().isEmpty());
    }

    @Test
    void addCustomerInvalid(){
        Customer customer = new Customer();
        customer.setName("12".repeat(45));

        Assertions.assertThrows(DataException.class, () -> controller.addCustomers(customer));
    }

    @Test
    void deleteCustomer(){
        controller.addCustomers(customer);
        controller.deleteCustomer(customer.getID());
    }

    @Test
    void getCustomer(){
        Assertions.assertNull(controller.getCustomer(-5,false));

        controller.addCustomers(customer);
        Assertions.assertNotNull(controller.getCustomer(customer.getID(), false));
    }

    @Test
    void updateCustomer(){
        controller.addCustomers(customer);
        controller.updateCustomer(customer.getID(), "Bilgeadam");
    }

    private Address generateAddress(){
        Address address = new Address();
        address.setCountry("TURKEY");
        address.setCity("Istanbul");
        address.setStreet("Kadikoy");
        address.setPostalCode(34123);
        return address;
    }
}