package com.bilgeadam.threads.messenger;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsyncMessenger {
    private final Object acceptLock, readLock;
    private final Deque<String> messages;
    private int messageCounter;


    public AsyncMessenger() {
        this.acceptLock = new Object();
        this.readLock = new Object();
        messageCounter = 0;
        messages = new ArrayDeque<>();
    }

    public void acceptMessage(String message){
        messageCounter++;
        synchronized (acceptLock){
            System.out.printf("%s is adding %s\n", Thread.currentThread().getName(), message );
            messages.add(message);
        }
    }

    public Runnable processMessages(){
        synchronized (readLock) {
            return (() -> System.out.printf("%s is processing message\n", Thread.currentThread().getName()));
        }
    }

    protected int waitingMessagesSize(){
        return messages.size();
    }
}
