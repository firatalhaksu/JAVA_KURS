package com.bilgeadam.threads.deadlock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultipleResourceAcquirerTest {
    Lock left, right;
    MultipleResourceAcquirer one, two;

    @BeforeEach
    void setUp() {
        left = new Lock("left");
        right = new Lock("right");

        one = new MultipleResourceAcquirer(left, right);
        two = new MultipleResourceAcquirer(left, right);
    }

    @Test
    void processObjects() throws InterruptedException {
        Thread t1 = new Thread(() -> {
           try {
               one.processObjects(left);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        });
        Thread t2 = new Thread(() -> {
            try {
                two.processObjects(right);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}