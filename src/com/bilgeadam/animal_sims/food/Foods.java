package com.bilgeadam.animal_sims.food;

import com.bilgeadam.animal_sims.utils.Numeric;

public enum Foods {
    Meat(5000),
    Vegetable(1200);

    static Foods generateRandomFood() {
        Foods[] foods = Foods.values();
        return foods[(int) Math.round(Numeric.generateRandomNumber(0, foods.length - 1))];
    }

    private final int calorie;

    Foods(int calorie) {
        this.calorie = calorie;
    }

    public int getCalorie() {
        return calorie;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name().charAt(0));
    }
}
