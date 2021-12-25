package com.bilgeadam.hibernate;

import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SessionFactoryGeneratorTest {
    private SessionFactoryGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new SessionFactoryGenerator();
    }

    @Test
    void acquireSession() {
        Assertions.assertDoesNotThrow(() -> {
            Session s = generator.acquireSession().openSession();
            s.close();
        });
    }
}