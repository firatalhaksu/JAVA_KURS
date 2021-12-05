package com.bilgeadam.methods;

public class FailuresCalls {
    
    //field
    
    int counter; //primitive olduğundan default değer "0"
    
    public void increaseOne (int x){
        counter = x + 1;
        System.out.println("FailuresCalls.increaseOne");
        increaseTwo(counter);
    }
    public void increaseTwo (int x){
        counter = x + 1;
        System.out.println("FailuresCalls.increaseTwo");
        increaseThree(counter);
    }
    public void increaseThree (int x){
        x = x + 1;
        System.out.println("FailuresCalls.increaseThree");
        increaseOne(counter);                                   // bu satırdan dolayı döngüye giriyor
    }

    public static void main(String[] args) {
        FailuresCalls calls = new FailuresCalls();
        
        calls.increaseOne(calls.counter);

        System.out.println("calls.counter = " + calls.counter);
    }
}
