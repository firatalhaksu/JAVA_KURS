package com.bilgeadam.jdbc;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    private UserController controller;

    @BeforeEach
    void setup(){
        controller = new UserController();
    }

    @Test
    void addUser() {
        controller.addUser(2151651L, "Muhammet KILIÇ");
    }
}