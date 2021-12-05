package com.bilgeadam.oop.inheritance;

public class Employee extends Person {

    public Employee(long ID, String firstName, String lastName) {
        super(ID, firstName, lastName);
    }

    protected void setSalary(long salary){
        super.salary = salary;
    }
}
