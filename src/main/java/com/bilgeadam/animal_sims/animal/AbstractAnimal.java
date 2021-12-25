package com.bilgeadam.animal_sims.animal;

import com.bilgeadam.animal_sims.utils.Numeric;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class AbstractAnimal implements Animal {
    private static final String ID_REGEX = "(\\p{L})\\p{L}*-(\\p{N}+)";
    private static final Pattern DISPLAY_PATTERN = Pattern.compile(ID_REGEX);

    private final Location location;
    private final String ID;
    private final DNA DNA;

    private int currentCalorie, lastFoodIntakeCalorie;

    AbstractAnimal(Location location, String ID, DNA dna) {
        if (!ID.matches(ID_REGEX))
            throw new IllegalArgumentException(String.format("Given ID %s do not satisfy criteria", ID));

        this.location = location;
        this.ID = ID;
        this.DNA = dna;
        this.currentCalorie = dna.birthCalorie();
    }

    @Override
    public void move() {
        currentCalorie -= DNA.movementCalorie();
        location.moveRandomly(DNA.stepLength());
    }

    @Override
    public int eat(int foodCalorie) {
        if (foodCalorie > DNA.calorieIntake()) {
            currentCalorie += DNA.calorieIntake();
            lastFoodIntakeCalorie = currentCalorie;
            return foodCalorie - DNA.calorieIntake();
        } else {
            currentCalorie += foodCalorie;
            lastFoodIntakeCalorie = currentCalorie;
            return 0;
        }
    }

    @Override
    public final List<Animal> copulate(List<Animal> candidates) {
        return isReadyToCopulate() && currentCalorie > DNA.copulateCalorie() ?
                generateOffspring((int) Numeric.generateRandomNumber(0, DNA.offspringCount()), candidates) :
                null;
    }

    abstract boolean isReadyToCopulate();

    abstract List<Animal> generateOffspring(int childCount, List<Animal> candidates);


    @Override
    public boolean isAlive() {
        return currentCalorie > 0;
    }

    @Override
    public boolean isHungry() {
        return currentCalorie < DNA.birthCalorie() / 2 || lastFoodIntakeCalorie - currentCalorie >= DNA.calorieIntake();
    }

    protected void consumeCopulateEnergy() {
        currentCalorie -= DNA.copulateCalorie();
    }

    @Override
    public String toString() {
        Matcher m = DISPLAY_PATTERN.matcher(this.ID);
        return m.find() ? String.format("%s%s", m.group(1), m.group(2)) : "";
    }

    @Override
    public Location getCurrentLocation() {
        return location;
    }
}