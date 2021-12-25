package com.bilgeadam.threads.messenger;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsyncMessenger {
    private final Object writeLock, readLock;
    private final Deque<String> messages;
    private int messageCounter;


    public AsyncMessenger() {
        this.writeLock = new Object();
        this.readLock = new Object();
        messageCounter = 0;
        messages = new ArrayDeque<>();
    }

    public void acceptMessage(String message){
        messageCounter++;
        synchronized (this){
            //System.out.printf("%s is adding %s\n", Thread.currentThread().getName(), message );
            messages.add(message);
        }
    }

    public String processMessages(){
        synchronized (this) {
            return messages.isEmpty() ? "NO MESSAGE" : messages.pop();
        }
    }

    protected int waitingMessageSize(){
        return messages.size();
    }
}
