package com.bilgeadam.lambdas;

import java.util.List;

public class Worker {
    private final String name;
    private final List<String > works = List.of("Clean", "Shop", "Eat", "Iron", "Wash");

    public Worker(String name) {
        this.name = name;
    }

    public void executeWork(Runnable runnable){
        runnable.run();
    }

    public Runnable generateWork(){
        int i = (int) Math.round(Math.random() * (works.size() - 1));

        return () -> System.out.println(i);
    }


}
