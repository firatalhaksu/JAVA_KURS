package com.bilgeadam.objects;

public class CarFactory {

    static int COUNTER;

    private CarFactory(){}

    public static Car buildCar(String brand){
        return new Car(brand);
    }

    public static int getCounter(){
        return COUNTER;
    }
}
