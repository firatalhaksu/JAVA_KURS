package com.bilgeadam.threads.messenger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

class AsyncMessengerTest {
    AsyncMessenger messenger;
    private ScheduledExecutorService messengers, processors;
    private int messengerCount = 5, processorCount = 5;

    @BeforeEach
    void setUp() {
        messenger = new AsyncMessenger();
        messengers = Executors.newScheduledThreadPool(5, new MyThreadFactory("Messengers"));
        processors = Executors.newScheduledThreadPool(5, new MyThreadFactory("Processors"));
    }

    @Test
    void acceptMessage() throws InterruptedException {
        for (int i = 0; i < messengerCount; i++) {
            messengers.scheduleAtFixedRate(() -> messenger.acceptMessage(Thread.currentThread().getName()),
                    0, 10, TimeUnit.MILLISECONDS);
        }

        for (int i = 0; i < processorCount; i++) {
            processors.scheduleAtFixedRate(() -> messenger.processMessages(),
                    0, 3, TimeUnit.MILLISECONDS);
        }

        messengers.awaitTermination(1, TimeUnit.SECONDS);
        processors.awaitTermination(1, TimeUnit.SECONDS);

        int size = messenger.waitingMessagesSize();
        System.out.printf("Waiting messages size is %d\n", size);
        Assertions.assertTrue(size > 0);

    }
}

class MyThreadFactory implements ThreadFactory{
    private final String name;
    private int counter;

    MyThreadFactory(String name) {
        this.name = name;
        this.counter = 0;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, name + counter++);
    }
}