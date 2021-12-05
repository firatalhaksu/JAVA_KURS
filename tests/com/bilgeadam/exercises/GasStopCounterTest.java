package com.bilgeadam.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


class GasStopCounterTest {
    private GasStopCounter stopCounter;

    @BeforeEach
    void setUp() {
        stopCounter = new GasStopCounter();
    }

    private static Stream<Arguments> gasStopArgs(){
        return Stream.of(
                Arguments.of(30,new ArrayList<>(){{
                    add(new int[]{2,5});
                    add(new int[]{5,18});
                    add(new int[]{8,5});
                    add(new int[]{12,1});
                }})
        );
    }

    @ParameterizedTest
    @MethodSource("gasStopArgs")
    void countGasStops(int destination, List<int []> stops, int result) {
        Assertions.assertEquals(result, stopCounter.countGasStops(destination,stops));
    }
}