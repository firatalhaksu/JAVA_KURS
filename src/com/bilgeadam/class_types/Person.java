package com.bilgeadam.class_types;

public class Person {
    private final String firstName;
    private final String lastName;
    private final long governmentId;

    public Person(String firstName, String lastName, long governmentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.governmentId = governmentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getGovernmentId() {
        return governmentId;
    }
}
