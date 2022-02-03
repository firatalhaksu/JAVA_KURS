package com.bilgeadam.threads.restaurant;

public class CookFactory extends Thread {
    private static final ThreadGroup cooks = new ThreadGroup("Cooks");
    private static int counter = 0;

    public CookFactory(String name) {
        super(cooks, String.format("Cooks-%d", counter++));
    }

    @Override
    public void run() {
        synchronized (this) {
        }
    }
}