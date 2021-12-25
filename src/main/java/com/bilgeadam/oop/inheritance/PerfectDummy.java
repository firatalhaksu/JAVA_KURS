package com.bilgeadam.oop.inheritance;

import com.bilgeadam.oop.inheritance.test.Dummy;

public class PerfectDummy extends Dummy {

    public PerfectDummy(String name, String surname) {
        super(name, surname);

        String name1 = super.name;
    }
}
