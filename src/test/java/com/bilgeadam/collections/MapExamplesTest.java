package com.bilgeadam.collections;

import com.bilgeadam.collections.MapExamples;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MapExamplesTest {
    private static MapExamples examples;

    @BeforeAll
    static void beforeAll() {
        examples = new MapExamples();
    }

    static Stream<Arguments> generatePerson(){

        return Stream.of(
                Arguments.of("Test-1", 7),
                Arguments.of("Test-2", 28),
                Arguments.of("Test-3", 17),
                Arguments.of("Test-4", 214),
                Arguments.of("Test-5", 148),
                Arguments.of("Test-6", 93),
                Arguments.of("Test-7", 164)
        );
    }

    @ParameterizedTest
    @MethodSource("generatePerson")
    void addRecord(String name, int day) {

        Assertions.assertDoesNotThrow(() -> examples.addRecord(name, day));
    }

    @AfterAll
    static void afterAll() {
        Set<String> resultKey = new HashSet<>(){{
            add("Test-1");
            add("Test-2");
            add("Test-3");
            add("Test-4");
            add("Test-5");
            add("Test-6");
            add("Test-7");
        }};

        Set<String> keys = examples.getKeys();
        assertEquals(keys.size(), resultKey.size());
        resultKey.removeAll(keys);
        assertTrue(resultKey.isEmpty());

    }
}