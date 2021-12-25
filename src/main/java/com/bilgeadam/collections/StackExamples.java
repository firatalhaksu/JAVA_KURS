package com.bilgeadam.collections;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Stack;

public class StackExamples {
    private final Stack <Car> carStack;                     //LIFO
    private final ArrayDeque<Car> carArrayDeque;            //FIFO Double ended
    private final PriorityQueue<Car> carPriorityQueue;

    public StackExamples(Stack<Car> carStack, ArrayDeque<Car> carArrayDeque, PriorityQueue<Car> carPriorityQueue) {
        this.carStack = new Stack<>();
        this.carArrayDeque = new ArrayDeque<>();
        this.carPriorityQueue = new PriorityQueue<>();
    }

    public void addCars(Car... cars){
        for (Car c : cars) {
            carStack.add(c);
            carArrayDeque.add(c);
            carPriorityQueue.add(c);

        }
    }

    public void printCars(){
        System.out.println("Cars Stack");
        while (!carStack.isEmpty())
            System.out.println(carStack.pop());

        System.out.println("Cars Deque");
        while (!carArrayDeque.isEmpty())
            System.out.println(carArrayDeque.pop());

        System.out.println("Cars Priority Queue");
        while (!carPriorityQueue.isEmpty())
            System.out.println(carPriorityQueue.remove());
    }
}

class Car implements Comparable<Car> {
    private final String name;
    private final int cost;

    public Car(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public int compareTo(Car o) {
        return this.cost == o.cost ? this.name.compareTo(o.name) : Integer.compare(this.cost, o.cost);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
