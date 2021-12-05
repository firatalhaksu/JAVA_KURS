package com.bilgeadam.threads;

public class SimpleThread extends Thread {

    public SimpleThread(String name){ super(name); }

    public SimpleThread() {
        super("My Thread");
    }

    public SimpleThread(Runnable target) {
        super(target, "My Thread with Runnable");
    }

    @Override
    public void run() {
        Runnable customRunner = () -> {
            try {
                synchronized (this){
                    wait(10_000L);
                }
                System.out.printf("I, %s , is not interrupted.\n", Thread.currentThread().getName());
            } catch (InterruptedException e){
                System.out.printf("I, %s , is interrupted.\n", Thread.currentThread().getName());
            }
            System.out.printf("This is custom runner of %s\n",Thread.currentThread().getName());
        };
        customRunner.run();
    }
}
