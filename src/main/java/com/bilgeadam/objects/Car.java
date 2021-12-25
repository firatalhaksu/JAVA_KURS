package com.bilgeadam.objects;

public record Car(String brand) {

    public Car {
        CarFactory.COUNTER++;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }
}

/*
public  class Car{
    final String brand;

    public Car(String brand) {
        CarFactory.COUNTER++;
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }
}*/
