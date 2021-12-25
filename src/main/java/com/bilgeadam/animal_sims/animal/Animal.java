package com.bilgeadam.animal_sims.animal;

import java.util.List;

public interface Animal {

    void move();

    int eat(int foodCalorie);

    List<Animal> copulate(List<Animal> candidates);

    boolean hadIntercourseThisTurn();

    default boolean isAlive() {
        return true;
    }

    boolean isHungry();

    Location getCurrentLocation();
}