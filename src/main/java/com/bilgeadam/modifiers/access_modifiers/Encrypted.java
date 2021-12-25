package com.bilgeadam.modifiers.access_modifiers;

class Encrypted {
    public String name = "Encrypted";
    private int counter;
    protected boolean isEncrypted;

    public void printer(){
        incrementer();
        System.out.println("Encrypted.printer called " + counter + " times." );
    }

    private void incrementer (){
        counter = counter + 1;
    }

    protected void publish(){
        System.out.println("Encrypted.publish " + counter + " times.");
    }
}