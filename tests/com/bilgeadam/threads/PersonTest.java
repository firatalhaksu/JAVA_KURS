package com.bilgeadam.threads;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import java.util.Arrays;

class PersonTest {
    Person person;
    Object[] objects = new Object[3];

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @RepeatedTest(10_000)
    void addPersonInfo() {
        Arrays.stream(objects).parallel().forEach(f ->
                person.addPersonInfo("A" + Math.random(), "B" + Math.random()));

        Assertions.assertEquals(objects.length, person.getPeopleInfo().size());
        person.getPeopleInfo().forEach(System.out::println);
    }
}