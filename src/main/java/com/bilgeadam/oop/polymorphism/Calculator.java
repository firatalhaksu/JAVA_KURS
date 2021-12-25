package com.bilgeadam.oop.polymorphism;

public class Calculator {

    long sum(int x, int y) {
        return (long) x + y;
    }
    long sum(int x, long y) {
        return x + y;
    }
    long sum(long x, int y) {
        return x + y;
    }
    long sum(long x, long y) {
        return x + y;
    }

}