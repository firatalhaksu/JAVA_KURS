package com.bilgeadam.animal_sims;

import com.bilgeadam.animal_sims.simulation.*;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Coordinator {
    public void coordinateSimulation(SimSettings settings) throws InterruptedException{
        List<SumStatistics> stats = new Vector<>(settings.iterationCount());
        ExecutorService executors = Executors.newFixedThreadPool(10);

        for (int i = 0; i < settings.iterationCount(); i++)
            executors.submit(() -> stats.add(new GenerateSimulation(settings).startSimulation()));
        executors.shutdown();
        executors.awaitTermination(1, TimeUnit.DAYS);

        System.out.println(computeStatistics(stats));
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Starting Simulation ---");

        SimulationSettings settings = new SimulationSettings();
        SimSettings set = settings.acquireSettings();

        SumStatistics[] stats = new SumStatistics[set.iterationCount()];

        for (int i = 0; i < set.iterationCount(); i++) {
            GenerateSimulation simulation = new GenerateSimulation(set);
            stats[i] = simulation.startSimulation();
            System.out.printf("Current stats %s for iteration: %d\n",stats[i],i);
        }

        System.out.println(computeStatistics(List.of(stats)));
    }

    private static SumStatistics computeStatistics(List<SumStatistics> statistics){
        float totalCount = 0, birthCount = 0, deathCount = 0;
        for (SumStatistics stat : statistics) {
            totalCount += stat.totalAnimals();
            birthCount += stat.birthCount();
            deathCount += stat.deathCount();
        }

        return new SumStatistics(deathCount / statistics.size(),
                birthCount / statistics.size(),
                totalCount / statistics.size());
    }
}