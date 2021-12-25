package com.bilgeadam.oop.polymorphism;

public enum Colors {
    Red,
    Green,
    Blue;


    @Override
    public String toString() {
        return name().substring(0, 1).toUpperCase();
        //return "Red\t" + "Green\t" + "Blue";
    }
}
