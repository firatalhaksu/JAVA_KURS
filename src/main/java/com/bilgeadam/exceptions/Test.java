package com.bilgeadam.exceptions;

public class Test {

    public boolean checkString(String input){
        return input.contains("[") && input.contains("]");
    }

    public void addElement (int [] array, int i, int element){
        //if (i < array.length)
        try {
            array[i] = element;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Given index is not correct!");
        }
    }
}
