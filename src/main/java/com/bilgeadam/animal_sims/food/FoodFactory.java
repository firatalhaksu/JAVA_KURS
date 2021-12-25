package com.bilgeadam.animal_sims.food;

import com.bilgeadam.animal_sims.factory.Factory;
import com.bilgeadam.animal_sims.utils.Numeric;

public class FoodFactory extends Factory<Food> {
    private final int simWidth, simHeight;

    public FoodFactory(int simWidth, int simHeight) {
        this.simWidth = simWidth;
        this.simHeight = simHeight;

    }

    @Override
    protected Food generateEntity() {
        return new Food(Foods.generateRandomFood(), generateLocation());
    }

    private Location generateLocation() {
        return new Location(
                (int) Math.round(Numeric.generateRandomNumber(0, simWidth - 1)),
                (int) Math.round(Numeric.generateRandomNumber(0, simHeight - 1))
        );
    }

}
