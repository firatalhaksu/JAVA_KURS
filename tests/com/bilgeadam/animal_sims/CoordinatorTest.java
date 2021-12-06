package com.bilgeadam.animal_sims;

import com.bilgeadam.animal_sims.simulation.SimSettings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatorTest {
    private Coordinator coordinator;
    private SimSettings settings;

    @BeforeEach
    void setUp() {
        coordinator = new Coordinator();
        settings = new SimSettings(100, 100, 0.45F, 30, 12, 8);
    }

    @RepeatedTest(10)
    void main() {
        Assertions.assertDoesNotThrow(() -> coordinator.coordinateSimulation(settings));
    }
}