package com.bilgeadam.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConnectorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getConnection() {
        Assertions.assertDoesNotThrow(Connector::getConnection);
    }
}