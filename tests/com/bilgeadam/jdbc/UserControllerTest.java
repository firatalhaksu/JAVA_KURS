package com.bilgeadam.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class UserControllerTest {
    private UserController controller;

    @BeforeEach
    void setup(){
        controller = new UserController();
    }

    @Test
    void addUser() {
        controller.addUser(1487L,"Someone Else");
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
    void deleteTable(){
        controller.deleteUsers();
    }
}