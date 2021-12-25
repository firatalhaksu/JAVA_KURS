package com.bilgeadam.animal_sims.food;

public record Food(Foods foods, Location location) {

    @Override
    public String toString() {
        return foods.toString();
    }
}
