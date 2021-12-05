package com.bilgeadam.animal_sims.simulation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SimulationSettings {
    private static final Scanner scanner = new Scanner(System.in);

    public SimSettings acquireSettings() throws InterruptedException {
        SimSettings settings;
        try {
            System.out.print("\nPlease provide simulation width: ");
            int width = scanner.nextInt();

            System.out.print("\nPlease provide simulation length: ");
            int height = scanner.nextInt();

            System.out.print("\nPlease provide vegetation ratio: ");
            float ratio = scanner.nextFloat();

            System.out.print("\nPlease provide animal count: ");
            int count = scanner.nextInt();

            System.out.print("\nPlease provide turn count: ");
            int turn = scanner.nextInt();

            System.out.print("\nPlease provide iteration count: ");
            int iteration = scanner.nextInt();

            settings = new SimSettings(width, height, ratio, count, turn, iteration);
        } catch (InputMismatchException e) {
            System.out.printf("Given input '%s' is not valid!\n", scanner.next());
            settings = requestProperInputs();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            settings = requestProperInputs();
        }
        return settings;
    }

    private SimSettings requestProperInputs() throws InterruptedException {
        System.out.print("Do you want to try again ? '(Y)es' or '(N)o' : ");

        return switch (scanner.next()) {
            case "Y", "Yes", "y", "yes" -> acquireSettings();
            case "N", "No", "n", "no" -> {
                System.out.println("Ending simulation without running...");
                yield null;
            }
            default -> {
                System.out.println("Please provide proper inputs.");
                yield requestProperInputs();
            }
        };
    }
}