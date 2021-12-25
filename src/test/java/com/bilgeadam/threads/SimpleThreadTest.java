package com.bilgeadam.threads;

import com.bilgeadam.threads.SimpleThread;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SimpleThreadTest {
    private SimpleThread threadOne;
    private Thread threadTwo;

    private final SimpleThread[] threads = new SimpleThread[40];

    @BeforeEach
    void setUp() {
        threadOne = new SimpleThread();
        threadTwo = new Thread(() -> System.out.printf("This is unit test of %s\n", Thread.currentThread().getName()));

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new SimpleThread("Thread - " + i);
        }
    }

    @RepeatedTest(5)
    void run() throws InterruptedException {

    }

    @Test
    void parallelExecution(){
        Arrays.stream(threads).parallel().forEach(t -> {
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } );
    }
}