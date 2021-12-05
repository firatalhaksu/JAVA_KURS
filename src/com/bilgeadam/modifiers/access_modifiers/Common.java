package com.bilgeadam.modifiers.access_modifiers;

public class Common {
    public String name = "Common";
    private int counter;
    protected boolean isEncrypted;

    public void printer(){
        incrementer();
        System.out.println("Common.printer called " + counter + " times." );
    }

    private void incrementer (){
        counter = counter + 1;
    }

    protected void publish(){
        System.out.println("Encrypted.publish " + counter + " times.");
    }
}