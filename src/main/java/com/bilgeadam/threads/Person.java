package com.bilgeadam.threads;

import java.util.Vector;

public class Person {
    private final Vector<People> persons = new Vector<>();

    protected boolean addPersonInfo(String name, String surname){
        return persons.add(new People(name, surname));
    }

    public Vector<People> getPeopleInfo(){
        return persons;
    }
}

record People (String name, String surname){}


//VECTOR ve HASHTABLE threadsafe olarak çalışır.

//Eğer bir collection threadsafe değil ise "Collections.synchronized()" metoduyla göndermek gerek. Ki threadsafe olsun.

