package com.bilgeadam.threads;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class SingleSupporterTest {

    SingleSupporter supporter;
    SingleSupporter[] supporters = new SingleSupporter[5];


    @RepeatedTest(3)
    void getSingleSupporter() {
        supporter = SingleSupporter.getInstance();
        System.out.println(supporter.getBirthday());

        Assertions.assertNotNull(supporter.getBirthday());
    }

    @Test
    void parallelCall() {
        Arrays.stream(supporters).parallel().forEach(f -> {
            f = SingleSupporter.getInstance();
            System.out.println(f.getBirthday());
        });
    }
}