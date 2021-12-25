package com.bilgeadam.animal_sims.simulation;

import com.bilgeadam.animal_sims.animal.Animal;
import com.bilgeadam.animal_sims.animal.AnimalFactory;
import com.bilgeadam.animal_sims.factory.Factory;
import com.bilgeadam.animal_sims.food.Food;
import com.bilgeadam.animal_sims.food.FoodFactory;

import java.util.*;
import java.util.stream.Collectors;

public class GenerateSimulation {

    private final SimSettings settings;
    private final List[][] locations;
    private final Statistic[] statistics;

    public GenerateSimulation(SimSettings settings) {
        this.settings = settings;
        Objects.requireNonNull(settings, "Settings cannot be generated!");
        System.out.println("\n" + settings);

        statistics = new Statistic[settings.turn()];

        locations = new List[settings.width()][settings.height()];
        for (int i = 0; i < settings.width(); i++) {
            for (int j = 0; j < settings.height(); j++) {
                locations[i][j] = new LinkedList<>();
            }
        }

        Factory<Animal> animalFactory = new AnimalFactory(settings.width(), settings.height());
        animalFactory.generateEntities(settings.animalCount()).
                forEach(a -> locations[a.getCurrentLocation().getX()][a.getCurrentLocation().getY()].add(a));

        Factory<Food> foodFactory = new FoodFactory(settings.width(), settings.height());
        foodFactory.generateEntities(Math.round(settings.ratio() * settings.width() * settings.height())).
                forEach(f -> locations[f.location().x()][f.location().y()].add(f));
    }

    private void displayEnvironment(int currentTurn) {
        System.out.printf("\nTurn: %d with statistics: %s\n", currentTurn, statistics[currentTurn]);
        int maxLength = calculateMaxLength(currentTurn == 0 ? settings.animalCount() : statistics[currentTurn - 1].
                totalAnimals());

        for (List[] location : locations) {
            for (List list : location) {
                System.out.printf(" %s ", list.isEmpty() ? "-".repeat(maxLength) :
                        appendSpaces(list.get(0).toString(), maxLength));
            }
            System.out.print("\n");
        }
    }

    private int calculateMaxLength(int animalCount) {
        return String.valueOf(animalCount).length() + 1;
    }

    private String appendSpaces(String input, int desiredLength) {
        if (input.length() >= desiredLength) {
            return input;
        } else {
            int diff = desiredLength - input.length();
            int leftPadding = diff / 2;
            int rightPadding = diff - leftPadding;
            return String.format("%s%s%s", "-".repeat(leftPadding), input, "-".repeat(rightPadding));
        }
    }

    public SumStatistics startSimulation() {
        for (int t = 0; t < settings.turn(); t++) {
            int deathCount = 0, birthCount = 0;
            List<Animal> movedAnimals = new ArrayList<>();

            for (List[] location : locations)
                for (List list : location)
                    if (!list.isEmpty()) {
                        int totalFoodCalorie = 0;
                        List<Animal> candidates = new ArrayList<>();

                        // loop for every entity in here
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            Object o = it.next();
                            if (o instanceof Food f) {
                                totalFoodCalorie += f.foods().getCalorie();
                            } else if (o instanceof Animal a) {
                                if (!a.isAlive()) {
                                    it.remove();
                                    deathCount++;
                                } else if (totalFoodCalorie > 0 && a.isHungry()) {
                                    totalFoodCalorie = a.eat(totalFoodCalorie);
                                } else {
                                    candidates.add(a);
                                }
                            }
                        }

                        // Check for copulation or move
                        for (int i = 0; i < candidates.size(); i++) {
                            int finalI = i;
                            List<Animal> candidateSpouses = candidates.stream().
                                    filter(f -> !f.equals(candidates.get(finalI))).
                                    collect(Collectors.toList());

                            List<Animal> children = candidates.get(i).copulate(candidateSpouses);
                            if (children != null) {
                                birthCount += children.size();
                                list.addAll(children);
                            }
                        }

                        // Move animals
                        candidates.stream().filter(a -> !a.hadIntercourseThisTurn()).
                                forEach(f -> {
                                    f.move();
                                    movedAnimals.add(f);
                                    list.remove(f);
                                });
                    }

            // Change location of moved animals
            for (Animal a : movedAnimals) {
                locations[a.getCurrentLocation().getX()][a.getCurrentLocation().getY()].add(a);
            }
            statistics[t] = new Statistic(deathCount, birthCount,
                    (t == 0 ? settings.animalCount() : statistics[t - 1].totalAnimals()) - deathCount + birthCount);
            displayEnvironment(t);
        }

        System.out.println("Simulation finished!");
        return computeStatistics(statistics);
    }

    private SumStatistics computeStatistics (Statistic[] statistics) {
        float totalCount = 0, birthCount = 0, deathCount = 0;
        for (Statistic stat : statistics) {
            totalCount += stat.totalAnimals();
            birthCount += stat.birthCount();
            deathCount += stat.deathCount();
        }

        return new SumStatistics(deathCount / statistics.length,
                birthCount / statistics.length,
                deathCount / statistics.length);
    }
}