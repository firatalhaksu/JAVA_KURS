package com.bilgeadam.animal_sims.animal;

import com.bilgeadam.animal_sims.factory.Factory;
import com.bilgeadam.animal_sims.utils.Numeric;

public class AnimalFactory extends Factory<Animal> {
    private final int simWidth, simHeight;

    private int index;

    public AnimalFactory(int simWidth, int simHeight) {
        this.simWidth = simWidth;
        this.simHeight = simHeight;
    }

    @Override
    protected Animal generateEntity() {
        return generateAnimal();
    }

    Animal generateAnimal() {
        if (Math.random() > 0.5)
            return new Cat(generateLocation(), String.format("CAT-%d", index++), Gender.generateRandomGender(), this);
        else
            return new Dog(generateLocation(), String.format("DOG-%d", index++), Gender.generateRandomGender(), this);
    }

    Animal generateAnimal(Class<?> animalClass, Location location) {
        if (animalClass.isAssignableFrom(Cat.class)) {
            return new Cat(location, String.format("CAT-%d", index++), Gender.generateRandomGender(), this);
        } else if (animalClass.isAssignableFrom(Dog.class)) {
            return new Dog(location, String.format("DOG-%d", index++), Gender.generateRandomGender(), this);
        } else
            return null;
    }

    int getSimWidth() {
        return simWidth;
    }

    int getSimHeight() {
        return simHeight;
    }

    private Location generateLocation() {
        return new Location(
                (int) Math.round(Numeric.generateRandomNumber(0, simWidth - 1)),
                (int) Math.round(Numeric.generateRandomNumber(0, simHeight - 1)),
                this);
    }
}