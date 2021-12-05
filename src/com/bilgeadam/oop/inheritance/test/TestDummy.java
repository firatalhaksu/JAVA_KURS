package com.bilgeadam.oop.inheritance.test;

public class TestDummy extends Dummy{
    public TestDummy(String name, String surname) {
        super(name, surname);

        String name1 = super.name;
        String surname1 = super.surname;


    }
}
