package com.bilgeadam.animal_sims;

import com.bilgeadam.animal_sims.Coordinator;
import com.bilgeadam.animal_sims.simulation.SimSettings;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatorTest {
    private Coordinator coordinator;
    private SimSettings settings;

    @BeforeEach
    void setUp() {
        coordinator = new Coordinator();
        settings = new SimSettings(100, 100, 0.45F, 30, 12, 8);
    }

    @Disabled
    @RepeatedTest(10)
    void main() {
        Assertions.assertDoesNotThrow(() -> coordinator.coordinateSimulation(settings));
    }
}