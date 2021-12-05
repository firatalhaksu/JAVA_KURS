package com.bilgeadam.threads.restaurant;

import java.util.Deque;
import java.util.List;
import java.util.concurrent.*;

public class Restaurant {
    private final Deque<OrderTypes> orderQueue;
    private final ExecutorService cooks;
    private int orderCounter;
    private boolean isClosing;

    public Restaurant(int cookSize) {
        this.orderQueue = new ConcurrentLinkedDeque<>();
        orderCounter = 0;
        isClosing = false;

        cooks = Executors.newFixedThreadPool(cookSize, new CustomThreadFactory("Cook"));

        ScheduledExecutorService organizer = Executors.newScheduledThreadPool(1, new CustomThreadFactory("Coordinator"));
        organizer.scheduleWithFixedDelay(this::processOrders, 1, 5, TimeUnit.MILLISECONDS);
        //organizer.awaitTermination(8,TimeUnit.HOURS);
    }

    private void processOrders(){
        while (!orderQueue.isEmpty()){
            OrderTypes order = orderQueue.pop();
            cooks.submit(() -> {
                try {
                    synchronized (this){
                        wait(order.getPrepareTime());
                    }
                    System.out.printf("Order %s is completed by %s\n",order, Thread.currentThread().getName());
                } catch (InterruptedException e){
                    System.out.printf("Not completed order: %s by %s\n",order, Thread.currentThread().getName());
                }
            });
        }
    }

    public boolean acceptOrder(String order) {
        if (!isClosing) {
            orderCounter++;
            try {
                return orderQueue.add(OrderTypes.valueOf(order));
            } catch (IllegalArgumentException e) {
                System.out.println("Unknown order!");
                return false;
            }
        } else
            return false;
    }

    public synchronized int closeShop() throws InterruptedException {
        isClosing = true;

        wait(15L);
        List<Runnable> cancelledOrders = cooks.shutdownNow();
        System.out.printf("\n\nTotal orders received: %d\nCompleted orders: %d\nRemaining orders: %d\nCancelled orders due to time: %d",
                orderCounter, orderCounter - cancelledOrders.size() - orderQueue.size(), orderQueue.size() + cancelledOrders.size(), cancelledOrders.size());
        return orderQueue.size() + cancelledOrders.size();
    }
}

enum OrderTypes {
    Pizza(15L),
    Hamburger(10L),
    Salad(7L);

    private final long prepareTime;


    OrderTypes(long prepareTime) {
        this.prepareTime = prepareTime;
    }

    public long getPrepareTime() {
        return prepareTime;
    }
}
