package com.bilgeadam.animal_sims.utils;

public class Numeric {
    private Numeric() {}

    public static boolean isInputPositive(int n) {
        return n > 0;
    }

    public static boolean isInputBetween(float input, float min, float max) {
        return input >= min && input <= max;
    }

    public static boolean isInputBetween(float input) {
        return isInputBetween(input, 0, 1);
    }
    /**
     *
     * @param x1 Lower endpoint inclusive
     * @param x2 Higher endpoint inclusive
     * @return random value
     */
    public static double generateRandomNumber(int x1, int x2) {
        double f = Math.random() / Math.nextDown(1.0);
        return x1 * (1.0 - f) + x2 * f;
    }
}