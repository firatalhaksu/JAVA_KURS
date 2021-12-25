package com.bilgeadam.animal_sims.animal;

import com.bilgeadam.animal_sims.utils.Numeric;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

abstract class AbstractGenderedAnimal extends AbstractAnimal {
    private final Gender gender;
    private final int coolDownPeriod;

    private int copulateTurn;

    public AbstractGenderedAnimal(Location location, String ID, DNA dna, Gender gender, int coolDownPeriod) {
        super(location, ID, dna);
        this.gender = gender;
        if (coolDownPeriod > 0) {
            this.coolDownPeriod = coolDownPeriod;
            this.copulateTurn = coolDownPeriod;
        } else {
            this.coolDownPeriod = 1;
            this.copulateTurn = 1;
        }
    }


    @Override
    public void move() {
        copulateTurn++;
        super.move();
    }

    @Override
    public int eat(int foodCalorie) {
        copulateTurn++;
        return super.eat(foodCalorie);
    }

    public void resetCopulateTurn() {
        this.copulateTurn = 0;
    }

    @Override
    boolean isReadyToCopulate() {
        return copulateTurn >= coolDownPeriod;
    }


    @Override
    List<Animal> generateOffspring(int childCount, List<Animal> candidates) {
        return switch (gender) {
            case Male -> new ArrayList<>();
            case Female ->
                    gaveBirth(
                            candidates.stream().
                                    filter(f -> f instanceof AbstractGenderedAnimal).
                                    map(m -> (AbstractGenderedAnimal) m).
                                    collect(Collectors.toList()),
                            childCount);
        };
    }

    @Override
    public boolean hadIntercourseThisTurn() {
        return copulateTurn == 0;
    }

    abstract List<Animal> gaveBirth(List<AbstractGenderedAnimal> candidates, int count);

    protected Gender getGender() {
        return gender;
    }
}

enum Gender {
    Male,
    Female;

    static Gender generateRandomGender() {
        return Gender.values()[Math.round((float) Numeric.generateRandomNumber(0, Gender.values().length - 1))];
    }
}
