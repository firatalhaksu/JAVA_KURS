package com.bilgeadam.oop.polymorphism.foods;

public class Pizza extends Meal {


    public Pizza(String name, float preparationTime) {
        super(name, (long) (10 * preparationTime));
    }

    @Override
    public Number getPreparationTime() {
        return super.getPreparationTime().floatValue() / 10;
    }

    public void Dummy(){}
}
