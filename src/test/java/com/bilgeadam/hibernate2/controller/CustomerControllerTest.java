package com.bilgeadam.hibernate2.controller;

import com.bilgeadam.hibernate2.entities.*;
import org.junit.jupiter.api.*;

class CustomerControllerTest {
    CustomerController controller;
    ToyController toyController;

    @BeforeEach
    void setUp() {
        controller = new CustomerController();
        toyController = new ToyController();
    }

    @Test
    void addCustomer() {
        Customer c = generateCustomer();
        Assertions.assertTrue(controller.addCustomer(c));
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void updateCustomerAddress() {
        controller.updateCustomerAddress(1,generateAddress());
    }

    @Test
    void updateRelation(){
        //Setup kısmı (2 müşteri ve 2 oyuncak oluşturuyoruz)
        Customer c1 = new Customer("First","Customer");
        Customer c2 = new Customer("Second","Customer");
        controller.addCustomer(c1);
        controller.addCustomer(c2);

        Toy t1 = new Toy("Train", ToyType.Child);
        Toy t2 = new Toy("Train", ToyType.Teenage);
        toyController.addNewToy(t1);
        toyController.addNewToy(t2);

        //Test (Oyuncakları müşterilere ekleme test kısmı)
        controller.addCustomerToy(c1.getID(),t1.getID());
        controller.addCustomerToy(c1.getID(),t2.getID());

        controller.addCustomerToy(c2.getID(),t1.getID());

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