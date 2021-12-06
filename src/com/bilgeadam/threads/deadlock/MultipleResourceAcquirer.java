package com.bilgeadam.threads.deadlock;

public class MultipleResourceAcquirer {
    private final Lock left, right;

    public MultipleResourceAcquirer(Lock left, Lock right) {
        this.left = left;
        this.right = right;
    }

    public void processObjects(Lock lock) throws InterruptedException {
        synchronized (lock){
            System.out.printf("%s acquired %s", Thread.currentThread().getName(),lock);

            synchronized (this) {
                wait(50L);
            }

            Lock otherLock = lock == left ? right : left;
            synchronized (otherLock){
                System.out.printf("%s acquired %s", Thread.currentThread().getName(),right);
            }
        }
    }
}

class Lock{
    private final String name;

    Lock(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}