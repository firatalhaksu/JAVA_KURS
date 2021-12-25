package com.bilgeadam.class_types;

import com.bilgeadam.objects.Car;

public enum CarCollection {

    SPORT(new Car("LANCIA"),700_000),
    DAILY(new Car("DOBLO"),120_000),
    BUSINESS(new Car("Mercedes"),1000_000),
    TRAVEL(new Car("Toyota"),2000_000),
    FIKIRTEPE(new Car("Sahin"),70_000);

    public static long getTotalCost(){
        long sum = 0;
        for (CarCollection c : CarCollection.values()
             ) {
            sum += c.getCost();
        }
        return sum;
    }

    private final Car car;
    private final int cost;

    CarCollection(Car car, int cost) {
        this.car = car;
        this.cost = cost;
    }

    public Car getCar() {
        return car;
    }

    public int getCost() {
        return cost;
    }
}
