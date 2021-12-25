package com.bilgeadam.threads.restaurant;

import java.util.concurrent.ThreadFactory;

class CustomThreadFactory implements ThreadFactory {
    private final ThreadGroup group;
    private int counter;

    public CustomThreadFactory(String name) {
        group = new ThreadGroup(name);
        counter = 0;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(group, r, String.format("%s-%d", group.getName(), counter));
    }
}
