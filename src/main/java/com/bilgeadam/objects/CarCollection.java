package com.bilgeadam.objects;

public class CarCollection {
    private final static Car SPORT = new Car("LANCIA");
    private final static Car DAILY = new Car("DOBLO");
    private final static Car BUSINESS = new Car("Mercedes");
    private final static Car TRAVEL = new Car("Toyota");
    private final static Car FIKIRTEPE = new Car("Sahin");

    private CarCollection(){}

    public static Car getSPORT() {
        return SPORT;
    }

    public static Car getDAILY() {
        return DAILY;
    }

    public static Car getBUSINESS() {
        return BUSINESS;
    }

    public static Car getTRAVEL() {
        return TRAVEL;
    }

    public static Car getFIKIRTEPE() {
        return FIKIRTEPE;
    }
}
