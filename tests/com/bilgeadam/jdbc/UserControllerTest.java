package com.bilgeadam.jdbc;

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
        controller.addUser(2151651L, "Test Deneme");
    }
}