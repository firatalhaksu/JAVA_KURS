package com.bilgeadam.jdbc;

import com.bilgeadam.jdbc.User;
import com.bilgeadam.jdbc.UserController;
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
        Assertions.assertDoesNotThrow(() -> controller.addUser(216156161,"Someone Else"));
    }

    @Test
    void getUser(){
        Assertions.assertNotNull(controller.getUsers());
    }

    @Test
    void getUserID(){
        long ID = 14845437;
        controller.addUser(ID,"Some Users");
        Assertions.assertEquals(new User(ID,"Some","Users"), controller.getUser(ID));
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
        Assertions.assertTrue(controller.deleteUsers(ID));
    }

    @Test
    void updateUser(){
        long ID = 5;
        controller.addUser(ID,"Someone Else");

        Assertions.assertTrue(controller.updateUsers(ID,"Hello", "World"));
    }
}