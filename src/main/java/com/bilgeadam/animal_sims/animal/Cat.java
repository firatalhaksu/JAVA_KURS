package com.bilgeadam.animal_sims.animal;

import java.util.List;
import java.util.stream.Collectors;

class Cat extends AbstractGenderedAnimal {
    private static final DNA DNA = new DNA(100, 300, 400, 2, 200, 5);
    private final AnimalFactory factory;

    public Cat(Location location, String ID, Gender gender, AnimalFactory factory) {
        super(location, ID, DNA, gender, 2);
        this.factory = factory;
    }


    @Override
    List<Animal> gaveBirth(List<AbstractGenderedAnimal> candidates, int count) {
        return BirthUtils.gaveBirthGendered(
                candidates.stream().filter(f -> f instanceof Cat).map(m -> (Cat) m).collect(Collectors.toList()),
                count, this, factory);
    }
}
