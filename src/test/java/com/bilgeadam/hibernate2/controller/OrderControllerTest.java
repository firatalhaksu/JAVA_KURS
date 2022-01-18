package com.bilgeadam.hibernate2.controller;

import com.bilgeadam.hibernate2.entities.customers.Customer;
import com.bilgeadam.hibernate2.entities.toys.Toy;
import com.bilgeadam.hibernate2.entities.toys.ToyType;
import org.junit.jupiter.api.*;

import java.util.Map;

class OrderControllerTest {
    private static OrderController controller;
    private static CustomerController customerController;
    private static ToyController toyController;

    private Customer c1, c2;
    private Toy t1, t2;

    @BeforeAll
    static void beforeAll() {
        controller = new OrderController();
        customerController = new CustomerController();
        toyController = new ToyController();

    }

    @BeforeEach
    void setUp() {
        c1 = new Customer("First","Customer");
        c2 = new Customer("Second","Customer");
        customerController.addCustomer(c1);
        customerController.addCustomer(c2);

        t1 = new Toy("Train", ToyType.Child);
        t2 = new Toy("Train", ToyType.Teenage);
        toyController.addNewToy(t1);
        toyController.addNewToy(t2);
    }

    @AfterEach
    void tearDown() {
        customerController.deleteCustomer(c1.getID());
        customerController.deleteCustomer(c2.getID());

        toyController.deleteToy(t1.getID());
        toyController.deleteToy(t2.getID());

        controller.deleteOrders();

    }

    @Test
    void addOrder() {
        Assertions.assertTrue(controller.addOrder(c1.getID(), Map.of(t1,458L)));
        Assertions.assertTrue(controller.addOrder(c2, Map.of(t1,783L,t2,315L)));
    }

    @Test
    void getOrders() {

    }
}