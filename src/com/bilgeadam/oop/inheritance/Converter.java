package com.bilgeadam.oop.inheritance;

public class Converter {
    private Converter(){}

    public static Manager convertManager(Object o){
        return (o instanceof Manager m) ? m : null;
    }

    public static Employee convertEmployee (Object o) {
        return (o instanceof Employee e) ? e : null;
    }
}
