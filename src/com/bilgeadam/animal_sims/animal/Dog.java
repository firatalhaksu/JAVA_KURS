package com.bilgeadam.animal_sims.animal;

import java.util.List;
import java.util.stream.Collectors;

public class Dog extends AbstractGenderedAnimal {
    private static final DNA DNA = new DNA(200, 250, 500, 3, 250, 3);
    private final AnimalFactory factory;

    public Dog(Location location, String ID, Gender gender, AnimalFactory factory) {
        super(location, ID, DNA, gender, 2);
        this.factory = factory;
    }

    @Override
    List<Animal> gaveBirth(List<AbstractGenderedAnimal> candidates, int count) {
        return BirthUtils.gaveBirthGendered(
                candidates.stream().filter(f -> f instanceof Dog).map(m -> (Dog) m).collect(Collectors.toList()),
                count, this, factory);
    }
}
