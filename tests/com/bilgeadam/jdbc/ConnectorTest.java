package com.bilgeadam.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class ConnectorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getConnection() {
        Assertions.assertDoesNotThrow(Connector::getConnection);
    }
}