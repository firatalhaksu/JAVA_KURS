package com.bilgeadam.program_flow.decision_making;

import com.bilgeadam.program_flow.decision_making.Decisions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DecisionsTest {

    private Decisions decisions;

    @BeforeEach
    void setUp() {
        decisions = new Decisions();
    }


    @ParameterizedTest
    @ValueSource(floats = {2374, 649, Float.POSITIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY})
    void printOddOrEvenNumber(Float number) {
        Assertions.assertDoesNotThrow(() -> decisions.printOddOrEvenNumbers(number));
    }
}