package com.bilgeadam.hibernate2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SessionGeneratorTest {

    @Test
    void generateSession() {
        Assertions.assertNotNull(SessionGenerator.generateSession());
    }
}