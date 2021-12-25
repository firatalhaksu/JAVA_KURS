package com.bilgeadam.oop.abstraction;

//interface'teki tüm field public, static ve final'dir.

public interface Company {

    String type = "Company";

    float yearlyProfit();

    default boolean isActive(){
        return true;
    }
}
