package com.bilgeadam.oop.polymorphism.foods;

class Meal {
    private final String name;
    private final Long preparationTime;

    public Meal(String name, Long preparationTime) {
        this.name = name;
        this.preparationTime = preparationTime;
    }

    public String getName() {
        return name;
    }

    public Number getPreparationTime() {
        return preparationTime;
    }
}
