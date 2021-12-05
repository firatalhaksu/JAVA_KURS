package com.bilgeadam.constructors;

public class Dummy {

    private int counter;
    /**
     * A method that is called for building class
     */
    public Dummy() {
        System.out.println("Creating Dummy!!");
    }

    protected Dummy(int x){
        System.out.println("x = " + x);
        counter = x;
    }

    public int getCounter(){
        return counter;
    }

    public void someMethod(){
        System.out.println("Dummy.someMethod");
    }
}
