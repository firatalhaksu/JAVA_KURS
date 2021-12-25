package com.bilgeadam.animal_sims.animal;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BirthUtils {

    public static <T extends AbstractGenderedAnimal> List<Animal> gaveBirthGendered(List<T> candidates, int count, T parent, AnimalFactory factory) {
        Optional<T> spouse = candidates.stream().
                filter(f -> f.getGender() == Gender.Male && f.copulate(null) != null).
                findFirst();

        if (spouse.isPresent()) {
            parent.consumeCopulateEnergy();         //For female
            parent.resetCopulateTurn();
            spouse.get().consumeCopulateEnergy();   //For male
            spouse.get().resetCopulateTurn();

            return IntStream.range(0, count).
                    mapToObj(m -> factory.generateAnimal(parent.getClass(), parent.getCurrentLocation())).
                    collect(Collectors.toList());
        } else
            return null;
    }
}
