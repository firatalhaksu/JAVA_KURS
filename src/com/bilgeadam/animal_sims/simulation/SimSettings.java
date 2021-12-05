package com.bilgeadam.animal_sims.simulation;

import com.bilgeadam.animal_sims.utils.Numeric;

public record SimSettings(int width, int height, float ratio, int animalCount, int turn, int iterationCount) {
    public SimSettings {
        if (!Numeric.isInputPositive(width))
            throw new IllegalArgumentException("Width '" + width + "' is not positive!");
        if (!Numeric.isInputPositive(height))
            throw new IllegalArgumentException("Height '" + height + "' is not positive!");
        if (!Numeric.isInputBetween(ratio))
            throw new IllegalArgumentException("Ratio '" + ratio + "' is not in between 0 and 1 !");
        if (!Numeric.isInputPositive(animalCount))
            throw new IllegalArgumentException("Animal count '" + animalCount + "' is not positive!");
        if (!Numeric.isInputPositive(turn))
            throw new IllegalArgumentException("Turn limit '" + turn + "' is not positive!");
        if (!Numeric.isInputPositive(iterationCount))
            throw new IllegalArgumentException("Iteration count '" + iterationCount + "' is not positive!");
    }
}