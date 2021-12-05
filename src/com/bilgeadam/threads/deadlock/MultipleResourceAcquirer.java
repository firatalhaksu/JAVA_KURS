package com.bilgeadam.threads.deadlock;

public class MultipleResourceAcquirer {
    private final Object left, right,lock;

    public MultipleResourceAcquirer(Object left, Object right) {
        this.left = new Object();
        this.right = new Object();
    }

    public void processObjects(Lock lock, Lock right){

        synchronized (lock){
            System.out.printf("%s acquired %s", Thread.currentThread().getName(),left);

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
        return super.toString();
    }

}