package com.bilgeadam.jdbc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collections;


class UserControllerTest {
    private UserController controller;

    @BeforeEach
    void setup(){
        controller = new UserController();
        controller.deleteUsers();
    }

    @AfterEach
    void tearDown() {
        controller.deleteUsers();
        Assertions.assertEquals(Collections.emptySet(),controller.getUsers());
    }

    @Test
    void addUser() {
        Assertions.assertDoesNotThrow(() -> controller.addUser(14875416L,"Someone Else"));
    }

    @Test
    void getUser(){
        Assertions.assertNotNull(controller.getUsers());
    }

    @Test
    void getUserID(){
        long ID = 1487;
        controller.addUser(ID,"Someone Else");

        Assertions.assertNotEquals(new User(ID,"Someone","Else"), controller.getUsers(ID));
    }

    @Test
    void deleteUsers(){
        long ID = 0;
        controller.addUser(ID,"Someone Else");
        Assertions.assertEquals(1, controller.deleteUsers());
    }

    @Test
    void testDeleteUsers(){
        long ID = 5;

        Assertions.assertFalse(controller.deleteUsers(ID));

        controller.addUser(ID,"Someone Else");
        Assertions.assertEquals(1, controller.deleteUsers());
    }

    @Test
    void updateUser(){
        long ID = 5;
        controller.addUser(ID,"Someone Else");
        System.out.println("User added!");

        Assertions.assertTrue(controller.updateUsers(5,"Hello", "World"));
        System.out.println("User updated!");

    }
}