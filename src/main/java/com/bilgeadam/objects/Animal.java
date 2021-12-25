package com.bilgeadam.objects;

public class Animal {
    private static String KIND;

    private final Animal mother, father;
    private int age;

    /**
     * New animal to save after birth
     * @param mother Mother
     * @param father Father
     * @param kind Kind
     */

    public Animal(Animal mother, Animal father, String kind) {

        this.mother = mother;
        this.father = father;
        KIND = kind;
        this.age = 0;
    }

    public Animal getMother() {
        return mother;
    }

    public Animal getFather() {
        return father;
    }

    public int getAge() {
        return age;
    }

    public String getKind() {
        return KIND;
    }
}
