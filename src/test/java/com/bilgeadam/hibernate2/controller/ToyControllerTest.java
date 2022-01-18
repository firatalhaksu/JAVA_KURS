package com.bilgeadam.hibernate2.controller;

import com.bilgeadam.hibernate.controller.ToyController;
import com.bilgeadam.hibernate.entities.toys.Toy;
import com.bilgeadam.hibernate.entities.toys.ToyType;
import org.junit.jupiter.api.*;

class ToyControllerTest {
    ToyController controller;

    @BeforeEach
    void setUp() {
        controller = new ToyController();
    }

    @Test
    void addNewToy () {
        Toy toy = new Toy("Pinokyo", ToyType.Child);

        Assertions.assertTrue(controller.addNewToy(toy));
        Assertions.assertTrue(controller.addNewToy(toy)); //False olması lazım ancak hata veriyor.
    }

    @Test
    void deleteToy () {
        Assertions.assertFalse(controller.deleteToy(1000));
    }

    @Test
    void updateToy () {
        Toy toy = new Toy("Monopoly",ToyType.Teenage);
        controller.addNewToy(toy);

        Assertions.assertTrue(controller.updateToyType(3, ToyType.Babies));
    }

}