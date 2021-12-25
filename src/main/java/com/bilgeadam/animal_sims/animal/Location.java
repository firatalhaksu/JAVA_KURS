package com.bilgeadam.animal_sims.animal;

import com.bilgeadam.animal_sims.utils.Numeric;

public final class Location {
    private final AnimalFactory factory;

    private int x, y;

    Location(int x, int y, AnimalFactory factory) {
        this.x = x;
        this.y = y;
        this.factory = factory;

    }

    void moveRandomly(int stepDistance) {
        x += (int) Math.round(Numeric.generateRandomNumber(
                x > stepDistance ? -stepDistance : -x,
                x < factory.getSimWidth() - 1 - stepDistance ? stepDistance : factory.getSimWidth() - 1 - x));
        y += (int) Math.round(Numeric.generateRandomNumber(
                y > stepDistance ? -stepDistance : -y,
                y < factory.getSimHeight() - 1 - stepDistance ? stepDistance : factory.getSimHeight() - 1 - y));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
