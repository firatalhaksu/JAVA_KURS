package com.bilgeadam.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SessionFactoryGeneratorTest {
    private SessionFactory generator;

    @ParameterizedTest
    @ValueSource(strings = {"XML", "PROP"})
    void acquireSession(String type) {
        generator = SessionFactoryGenerator.acquireSessionFactory(type);
        Assertions.assertDoesNotThrow(() -> {
            Session s = generator.openSession();
            s.close();
        });
    }
}