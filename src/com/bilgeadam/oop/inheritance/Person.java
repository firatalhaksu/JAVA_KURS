package com.bilgeadam.oop.inheritance;

public class Person {

    private Long ID;
    private final String firstName, lastName;

    int years;
    protected long salary;

    public Person(long ID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected long getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getSalary() {
        return salary;
    }
}
